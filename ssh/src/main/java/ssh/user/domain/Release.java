package ssh.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_release")
public class Release {
	private int releaseId;
	private int userId;
	private int houseId;
	private String createtime;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
