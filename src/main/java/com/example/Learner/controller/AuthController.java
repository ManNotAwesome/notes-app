package com.example.Learner.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Learner.model.User;
import com.example.Learner.repository.UserRepository;
import com.example.Learner.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserRepository userRepository;
	private final JwtService jwtService;

	public AuthController(UserRepository userRepository, JwtService jwtService) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
		String username = body.get("username");
		String password = body.get("password");

		if (username == null || password == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing username or password");
		}

		User user = userRepository.findByUsername(username);
		if (user == null || !password.equals(user.getPassword())) {
			// invalid credentials
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
		}

		// generate token
		String token = jwtService.generateToken(username);
		Map<String, String> res = new HashMap<>();
		res.put("token", token);
		return ResponseEntity.ok(res);
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
		String username = body.get("username");
		String password = body.get("password");
		if (username == null || password == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing fields");
		}
		if (userRepository.findByUsername(username) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "User exists"));
		}
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		userRepository.save(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "User created"));
	}

	@PostMapping("/reset")
	public ResponseEntity<?> reset(@RequestBody Map<String, String> body) {
		String username = body.get("username");
		String password = body.get("password");
		User user = userRepository.findByUsername(username);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
		}
		user.setPassword(password);
		userRepository.save(user);
		return ResponseEntity.ok(Map.of("message", "Password updated"));
	}

	@PostMapping("/change")
	public ResponseEntity<?> changePassword(@RequestBody Map<String, String> body) {

		String oldPassword = body.get("oldPassword");
		String newPassword = body.get("newPassword");
		String username = body.get("username");

		User user = userRepository.findByUsername(username);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
		}

		if (!oldPassword.equals(user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Wrong old password"));
		}

		user.setPassword(newPassword);
		userRepository.save(user);

		return ResponseEntity.ok(Map.of("message", "Password changed"));
	}

}
