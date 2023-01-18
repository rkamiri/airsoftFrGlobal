package pa.airsoftFrGlobal.airsoftFrGlobal.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class AnnounceDao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "content", nullable = false)
	private String content;
	@Column(name = "date", nullable = false)
	private Date date;
	@Column(name = "location", nullable = false)
	private String location;
	@Column(name = "category_id", nullable = false)
	private Long category;
	@Column(name = "user_id", nullable = false)
	private Long user;
	@Column(name = "image")
	private String image;
	@Column(name = "price")
	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
