package pa.airsoftFrGlobal.airsoftFrGlobal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pa.airsoftFrGlobal.airsoftFrGlobal.services.AuthService;
import pa.airsoftFrGlobal.airsoftFrGlobal.entities.User;
import pa.airsoftFrGlobal.airsoftFrGlobal.repositories.UserRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.services.UserService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("announce")
public class AnnounceController {

    private final UserRepository userRepo;
    private final AuthService authService;
    private final UserService userService;
    @Autowired
    public AnnounceController(UserRepository userRepo, AuthService authService, UserService userService) {
        this.userRepo = userRepo;
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> processRegister(@RequestBody @Valid User user) {
        try {
            return new ResponseEntity<>(this.userService.addUser(user), OK);
        }catch (Exception e) {
            throw new ResponseStatusException(NOT_ACCEPTABLE, "User exists");

        }
    }

}
