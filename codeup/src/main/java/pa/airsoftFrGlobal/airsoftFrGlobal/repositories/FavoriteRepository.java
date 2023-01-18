package pa.airsoftFrGlobal.airsoftFrGlobal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.AnnounceDao;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.FavoriteDao;


public interface FavoriteRepository extends JpaRepository<FavoriteDao, Long> {}
