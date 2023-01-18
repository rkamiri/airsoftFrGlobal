package pa.airsoftFrGlobal.airsoftFrGlobal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.AnnounceDao;


public interface AnnounceRepository extends JpaRepository<AnnounceDao, Long> {
	public AnnounceDao findByName(String name);
}
