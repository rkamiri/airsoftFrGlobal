package pa.airsoftFrGlobal.airsoftFrGlobal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pa.airsoftFrGlobal.airsoftFrGlobal.entities.CustomUserDetails;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.UserDao;
import pa.airsoftFrGlobal.airsoftFrGlobal.repositories.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
