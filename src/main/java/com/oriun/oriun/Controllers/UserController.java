package com.oriun.oriun.Controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oriun.oriun.Models.UserModel;
import com.oriun.oriun.Services.UserService;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


//OTH
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@RestController
public class UserController {
	@Autowired
    UserService userService;

	@GetMapping("/user")
    public ArrayList<UserModel> obtenerUsuarios(){
        return userService.getUsers();
    }

	@PostMapping("user")
	public UserModel login(@RequestParam("user") String user_name,@RequestParam("rol_name") String rol_name, @RequestParam("password") String password) {
		
		String token = getJWTToken(user_name);
		UserModel user = new UserModel();
		user.setUSER_NAME(user_name);
		user.setTOKEN(token);		
		return user;
		
	}

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

