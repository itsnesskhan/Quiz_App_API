package com.quiz.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.config.MyUserDetailsService;

@CrossOrigin("*")
@RestController
public class JwtController {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(path = "/login")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					jwtRequest.getUsername(), jwtRequest.getPassword());
			authenticationManager.authenticate(authenticationToken);
		} catch (UsernameNotFoundException e) {
			throw new Exception(String.format("User with %s doesn't exist", jwtRequest.getUsername()));
		} catch (BadCredentialsException e) {

			throw new Exception("Bad Credintials");
		}
		catch (Exception e) {
			System.out.println(e);
		}

		UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

}
