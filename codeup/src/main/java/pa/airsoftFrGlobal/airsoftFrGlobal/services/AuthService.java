package pa.airsoftFrGlobal.airsoftFrGlobal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.UserDao;
import pa.airsoftFrGlobal.airsoftFrGlobal.repositories.AuthRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.repositories.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    @Autowired
    public AuthService(UserRepository userRepository, AuthRepository authRepository){
        this.userRepository = userRepository;
        this.authRepository = authRepository;
    }

    public UserDao getAuthUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return this.userRepository.findByUsername(username);
    }

    public String hasRight() {
        UserDao loggedUser = this.getAuthUser();
        if(loggedUser == null){
            return null;
        }
        return this.authRepository.getByUsername(loggedUser.getUsername()).getAuthority();
    }
}
