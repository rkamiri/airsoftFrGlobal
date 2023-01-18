package pa.airsoftFrGlobal.airsoftFrGlobal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.UserDao;
import pa.airsoftFrGlobal.airsoftFrGlobal.entities.User;
import pa.airsoftFrGlobal.airsoftFrGlobal.services.AuthService;
import pa.airsoftFrGlobal.airsoftFrGlobal.services.UserService;
import pa.airsoftFrGlobal.airsoftFrGlobal.repositories.UserRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepo;
    private final AuthService authService;
    private final UserService userService;
    @Autowired
    public UserController(UserRepository userRepo, AuthService authService, UserService userService) {
        this.userRepo = userRepo;
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> processRegister(@RequestBody @Valid User user) {
        try {
            return new ResponseEntity<>(this.userService.addUser(user), OK);
        }catch (Exception e) {
            throw new ResponseStatusException(NOT_ACCEPTABLE, "User exists");

        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers() {
        return new ResponseEntity<>(this.userService.findAll(), OK);
    }

    @GetMapping("/current")
    public ResponseEntity<User> getLoggedUser() {
        UserDao user = this.authService.getAuthUser();
        return new ResponseEntity<>(user != null ? user.toEntity() : null, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable @Valid Long id) {
        User user = this.userService.getUserById(id);

        if(user == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
        return new ResponseEntity<>(user, OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable @Valid Long id, @RequestBody @Valid User updatedUser) {
        User toUpdate = this.userService.getUserById(id);
        UserDao loggedUser = this.authService.getAuthUser();
        if(loggedUser == null || !toUpdate.getId().equals(loggedUser.getId())){
            throw new ResponseStatusException(UNAUTHORIZED, "Cannot access this user");
        }
        return new ResponseEntity<>(this.userService.updateUser(updatedUser), OK);
    }

    @GetMapping("/test")
    public String test() {
        return "<p>Bonjour c'est le endpoint de test JEE si vous voulez faire des modifs c'est ici :)" +
                "<br>" +
                "<img src=\"https://en.meming.world/images/en/4/4a/Modern_Problems_Require_Modern_Solutions.jpg\" alt=\"\" /></p>";
    }

    @GetMapping("/username-exists/{username}")
    public boolean usernameExists(@PathVariable @Valid String username) {
        return this.userService.findAllByUsernameLike(username).size() > 0;
    }
    @GetMapping("/email-exists/{email}")
    public boolean emailExists(@PathVariable @Valid String email) {
        return this.userService.findAllByEmailLike(email).size() > 0;
    }
    @PostMapping("/send-password-edit")
    public boolean sendPasswordEditMail() {
        UserDao user = this.authService.getAuthUser();
        if(user == null) {
            throw new ResponseStatusException(UNAUTHORIZED, "User not logged in");
        }
        return this.userService.sendPasswordChangeEmail(user);
    }
    @PostMapping("/change-password/{password}/token/{token}")
    public boolean changePassword(@PathVariable @Valid String password, @PathVariable @Valid String token) {
        boolean isOK = this.userService.changePassword(password, token);
        if(!isOK) {
            throw new ResponseStatusException(UNAUTHORIZED, "bad token");
        }
        return true;
    }

    @GetMapping("/token/{token}")
    public boolean isTokenActive(@PathVariable @Valid String token) {
        return this.userService.isTokenActive(token);
    }

    @PostMapping("/lost-password/{email}")
    public boolean userLostPassword(@PathVariable @Valid String email) {
        return this.userService.emailUserLostPassword(email);
    }

    @PostMapping("/profile-picture")
    public ResponseEntity<String> uploadUserImage(MultipartHttpServletRequest request) throws IOException {
        UserDao user = this.authService.getAuthUser();
        Iterator<String> itr = request.getFileNames();
        MultipartFile file = request.getFile(itr.next());
        if(file != null) {
            String link = this.userService.uploadImage(file, user);
            return new ResponseEntity<>(link, HttpStatus.OK);
        }
        return new ResponseEntity<>("false", HttpStatus.OK);

    }
}
