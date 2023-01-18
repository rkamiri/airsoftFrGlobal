package pa.airsoftFrGlobal.airsoftFrGlobal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pa.airsoftFrGlobal.airsoftFrGlobal.dto.SearchDao;


public interface SearchRepository extends JpaRepository<SearchDao, Long> {}
