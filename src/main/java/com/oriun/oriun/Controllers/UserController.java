package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.oriun.oriun.Models.ConfirmationTokenModel;
import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Repositories.ConfirmationTokenRepository;
import com.oriun.oriun.Security.Encoder;
import com.oriun.oriun.Services.EmailSenderService;
import com.oriun.oriun.Services.UserService;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.server.ResponseStatusException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.password.PasswordEncoder;

//OTH
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@RestController
public class UserController {
	@Autowired
    UserService userService;
	Encoder encoder; 

	@Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
    public String inicio(){
        return "Hola esta funcionando";
    }
	
	@GetMapping("/user")
    public ArrayList<UserModel> obtenerUsuarios(){
        return userService.getUsers();
    }

	@PostMapping("/modreg")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity registermod(@RequestParam("user") String user_name, @RequestParam("password") String password) {
		UserModel user= new UserModel();
		//user.setPASSWORD(passwordEncoder.encode(password));
		user.setPASSWORD((password));
		user.setENABLED(true);
		encoder= new Encoder();
		user.setPASSWORD((encoder.encode(password)));
		System.out.println(user.getPASSWORD());
		user.setUSER_NAME(user_name);
		user.setROL_NAME("Moderador");
		Optional<UserModel> us=userService.getUser(user_name);
		if(us.isPresent()){
			return new ResponseEntity<>(
			"your user name is alredy taken "+user.getUSER_NAME()+" role"+user.getROL_NAME(), 
			HttpStatus.UNPROCESSABLE_ENTITY);
		}else{
			UserModel res=userService.saveUser(user);
			return new ResponseEntity<>(
				"your user register is succesfull "+user.getUSER_NAME()+" role"+user.getROL_NAME(), 
				HttpStatus.OK);
		}
		
	}

	@PostMapping("/userreg")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity register(@RequestParam("user") String user_name, @RequestParam("password") String password,@RequestParam("email") String email) {
		UserModel user= new UserModel();
		//user.setPASSWORD(passwordEncoder.encode(password));
		encoder= new Encoder();
		user.setPASSWORD((encoder.encode(password)));
		user.setEMAIL(email);
		user.setENABLED(false);
		System.out.println(user.getPASSWORD());
		user.setUSER_NAME(user_name);
		user.setROL_NAME("Usuario");
		Optional<UserModel> us=userService.getUser(user_name);
		UserModel us2 = userService.getUserByEmail(email);
		if(us.isPresent()){
			return new ResponseEntity<>(
			"your user name is alredy taken "+user.getUSER_NAME()+" role"+user.getROL_NAME(), 
			HttpStatus.UNPROCESSABLE_ENTITY);
		}else{
			if(us2 != null){
				return new ResponseEntity<>(
			"your email is alredy registereg "+email+" role"+user.getROL_NAME(), 
			HttpStatus.UNPROCESSABLE_ENTITY);
			}else{
				UserModel res=userService.saveUser(user);
				ConfirmationTokenModel confirmationToken = new ConfirmationTokenModel(user.getUSER_NAME());
            	confirmationTokenRepository.save(confirmationToken);
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(user.getEMAIL());
				mailMessage.setSubject("Complete Registration!");
				mailMessage.setFrom("oriunmail@gmail.com");
				String url="https://oriun.herokuapp.com/confirm-account?token="+confirmationToken.getCONFIRMATION_TOKEN();
        		String content="< href='"+url+"'>"+url+"</a>";
				String html= ("To confirm your account, please click here : "
				+url);
				mailMessage.setText(html);
				//+"https://oriun.herokuapp.com/confirm-account?token="+confirmationToken.getCONFIRMATION_TOKEN());
				emailSenderService.sendEmail(mailMessage);
				return new ResponseEntity<>(
					"your user register is succesfull "+user.getUSER_NAME()+" role"+user.getROL_NAME(), 
					HttpStatus.OK);
			}
		}
		
	}
	
	@RequestMapping(value="/confirm-account", method= {RequestMethod.POST})
    public ResponseEntity confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        ConfirmationTokenModel token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
			System.out.println(token.getUSER_NAME());
            userService.updateUserState(token.getUSER_NAME());
            return new ResponseEntity<>(
					"your user register is succesfull "+token.getUSER_NAME(), 
					HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(
			"error invalid token", 
			HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

	@PostMapping("/userlog")
	public ResponseEntity login(@RequestBody HashMap<String,Object> user){
                // Note: The parameters are user_name and password
		System.out.println("user"+user.get("user_name").toString()+"password"+user.get("password").toString());
		Optional<UserModel> us=userService.getUser(user.get("user_name").toString());
		//return us.get();
		encoder= new Encoder();
		String pass=((encoder.encode(user.get("password").toString())));
		System.out.println(pass);
		if(us.isPresent()){
			if(us.get().isENABLED()){
				String token = getJWTToken(user.get("user_name").toString());
				if(us.get().getPASSWORD().equals(pass)){ 
									HashMap <String,Object> result= new HashMap();
									result.put("TOKEN",token);
									result.put("USER_NAME",us.get().getUSER_NAME()); 
									result.put("ROL_NAME",us.get().getROL_NAME());
					return new ResponseEntity<>(
											result, HttpStatus.OK);
					//return us.get();
				}else{
					//throw new MyException("wrong password");
					throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "invalid password");
				}
			}else{
				throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "User is Not authenticated");
			}
		}
		else{
			throw new ResponseStatusException(
				HttpStatus.NOT_ACCEPTABLE, "User Not Found");
		}
		
	}
	
	@RequestMapping(value="/userstate", method= {RequestMethod.GET})
    public ResponseEntity Userstate(@RequestParam("user")String username)
    {

		Optional<UserModel>user=userService.getUser(username);
        if(user.isPresent())
        {
            return new ResponseEntity<>(
					user.get().isENABLED(), 
					HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(
			"error user not found", 
			HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @PutMapping("/disuser")
	public ResponseEntity  Stopuser(@RequestParam("user")String username){
		if(userService.disUser(username)){
			return new ResponseEntity<>("Usuario desactivado",
					HttpStatus.OK );
		}
		else{
			return new ResponseEntity<>("Usuario no encontrado",
					HttpStatus.NOT_FOUND );
		}
	}
	@PutMapping("/banuser")
	public ResponseEntity  banuser(@RequestParam("user")String username){
		if(userService.banUser(username)){
			return new ResponseEntity<>(username+" recibio un baneo",
					HttpStatus.OK );
		}
		else{
			return new ResponseEntity<>("Usuario no encontrado",
					HttpStatus.NOT_FOUND );
		}
	}
	@PutMapping("/opuuser")
	public ResponseEntity  chanceuser(@RequestParam("user")String username){
		if(userService.chanceUser(username)){
			return new ResponseEntity<>(username+" tiene un strike menos",
					HttpStatus.OK );
		}
		else{
			return new ResponseEntity<>("Usuario no encontrado",
					HttpStatus.NOT_FOUND );
		}
	}
	@GetMapping("/Usersba")
	public List<String> UsersBanned(@RequestParam("init") int init, @RequestParam("size")int size){
		return userService.UsersBanned(init,size);
	}


	//aca el mio
	/*@ResponseStatus(HttpStatus.OK)
	public ResponseEntity login(@RequestParam("user") String user_name, @RequestParam("password") String password) {
		Optional<UserModel> us=userService.getUser(user_name);
		//return us.get();
		System.out.println("user"+user_name+"password"+password);
		if(us.isPresent()){
			String token = getJWTToken(user_name);
			if(us.get().getPASSWORD().equals(password)){
				//us.get().setUSER_NAME(user_name);
				//us.get().setTOKEN(token);
				return new ResponseEntity<>(
				token + "your user is"+us.get().getUSER_NAME()+" role"+us.get().getROL_NAME(), 
				HttpStatus.OK);
				//return us.get();
			}else{
				//throw new MyException("wrong password");
				throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "invalid user or password");
			}
		}
		else{
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "User Not Found");
		}
		
	}
	/*@PostMapping("user")
	@ResponseStatus(HttpStatus.OK)
	public UserModel login(@RequestParam("user") String user_name, @RequestParam("password") String password) {
		System.out.println(user_name);
		
		Optional<UserModel> us=userService.getUser(user_name);
		if(us.isPresent()){
			String token = getJWTToken(user_name);
			if(us.get().getPASSWORD()==password){
				us.get().setUSER_NAME(user_name);
				us.get().setTOKEN(token);
				return us.get();
			}else{
				//throw new MyException("wrong password");
				throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "invalid user or password");
			}
		}
		else{
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "User Not Found");
		}
		
	}*/

	private String getJWTToken(String user_name) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(user_name)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

