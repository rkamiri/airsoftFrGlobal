package pa.airsoftFrGlobal.airsoftFrGlobal.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "favorite")
public class FavoriteDao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column(name = "announce_id", nullable = false)
	private String AnnounceId;
	@Column(name = "date", nullable = false)
	private Date date;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAnnounceId() {
		return AnnounceId;
	}

	public void setAnnounceId(String announceId) {
		AnnounceId = announceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
