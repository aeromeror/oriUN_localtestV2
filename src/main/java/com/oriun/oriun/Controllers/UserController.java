package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Security.Encoder;
import com.oriun.oriun.Services.UserService;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	PasswordEncoder passwordEncoder;

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
	public ResponseEntity register(@RequestParam("user") String user_name, @RequestParam("password") String password) {
		UserModel user= new UserModel();
		//user.setPASSWORD(passwordEncoder.encode(password));
		encoder= new Encoder();
		user.setPASSWORD((encoder.encode(password)));
		System.out.println(user.getPASSWORD());
		user.setUSER_NAME(user_name);
		user.setROL_NAME("Usuario");
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
	
	@PostMapping("/userlog")
	public ResponseEntity login(@RequestBody HashMap<String,Object> user){
                // Note: The parameters are user_name and password
		System.out.println("user"+user.get("user_name").toString()+"password"+user.get("password").toString());
		Optional<UserModel> us=userService.getUser(user.get("user_name").toString());
		//return us.get();
		encoder= new Encoder();
		String pass=((encoder.encode(user.get("password").toString())));
		if(us.isPresent()){
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
		}
		else{
			throw new ResponseStatusException(
				HttpStatus.NOT_ACCEPTABLE, "User Not Found");
		}
		
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

