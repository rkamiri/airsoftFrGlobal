package pa.airsoftFrGlobal.airsoftFrGlobal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.TokenDao;


public interface TokenRepository extends JpaRepository<TokenDao, Long> {

    public TokenDao getTokenByTokenEquals(@Param("token") String token);
}
