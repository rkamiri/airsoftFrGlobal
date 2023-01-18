package pa.airsoftFrGlobal.airsoftFrGlobal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.AuthEntity;


public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    public AuthEntity getByUsername(String username);
}
