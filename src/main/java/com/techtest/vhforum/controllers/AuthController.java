package com.techtest.vhforum.controllers;

import com.techtest.vhforum.dao.UserDAO;
import com.techtest.vhforum.models.User;
import com.techtest.vhforum.security.JwtTokenUtil;
import com.techtest.vhforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private JwtTokenUtil jwt;

    @Autowired
    private UserService service;

    @RequestMapping(value = "auth/${api.authentication.login}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> payload)
            throws AuthenticationException {

//        logger.logInfo("Authenticating user");

        final User user = userDao.findUserByUsername(payload.get("username"));
        try {
            Map<String, String> response = new HashMap<>();

            if (service.checkHash(payload.get("password"), user.getPassword())) {
//                logger.logInfo("User authenticated with success");
                String token = jwt.generateToken(user);
                response.put("username", user.getUsername());
                response.put("token", token);
            }

            return ResponseEntity.ok(response);


        } catch (UnsupportedEncodingException e) {
//            logger.logError(e.getMessage());
            return (ResponseEntity<?>) ResponseEntity.status(500);
        }


    }

    @PostMapping(value = "auth/${api.endpoints.register}")
    public ResponseEntity<User> create(@RequestBody User entity) {
        return service.create(entity);
    }


}