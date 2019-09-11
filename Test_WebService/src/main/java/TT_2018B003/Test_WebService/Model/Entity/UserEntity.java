package TT_2018B003.Test_WebService.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {
	
	@Id
	@Column(name = "idUser")
	public String idUser;
	
	@Column(name = "password")
	public String password;
	
	public UserEntity() {}
	
	public UserEntity(String idUser, String password) {
		this.idUser = idUser;
		this.password = password;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return "idUser: "+idUser+"\n"
				+"password: "+password;
	}
}
