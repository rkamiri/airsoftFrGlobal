package pa.airsoftFrGlobal.airsoftFrGlobal.entities;

import pa.airsoftFrGlobal.airsoftFrGlobal.dto.AnnounceDao;

import javax.validation.constraints.NotNull;
import java.util.Date;


public class Announce {

	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String content;
	@NotNull
	private Date date;
	@NotNull
	private String location;
	@NotNull
	private Long category;
	@NotNull
	private Long user;
	@NotNull
	private String image;
	private String price;

	public Announce(Long id, String name, String content, Date date, String location, Long category, Long user, String image, String price) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.date = date;
		this.location = location;
		this.category = category;
		this.user = user;
		this.image = image;
		this.price = price;
	}

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

	public AnnounceDao createDao() {
		AnnounceDao dao = new AnnounceDao();
		dao.setName(this.name);
		dao.setContent(this.content);
		dao.setDate(this.date);
		dao.setLocation(this.location);
		dao.setCategory(this.category);
		dao.setUser(this.user);
		dao.setImage(this.image);
		dao.setPrice(this.price);
		return dao;
		}
}
