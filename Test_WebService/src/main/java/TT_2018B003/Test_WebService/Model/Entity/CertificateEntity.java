package TT_2018B003.Test_WebService.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "certificate")
public class CertificateEntity {

	@Id
	@Column(name = "idUser_User")
	public String idUser_User;
	
	@Column(name = "certificate")
	public String certificate;
	
	@Column(name = "statusCertificate")
	public int statusCertificate;
	
	public CertificateEntity() {}
	
	public CertificateEntity(String idUser_User, String certificate, int statusCertificate) {
		this.idUser_User = idUser_User;
		this.certificate = certificate;
		this.statusCertificate = statusCertificate;
	}
	
	public void setIdUser_User(String idUser_User) {
		this.idUser_User = idUser_User;
	}
	
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public void setStatusCertificate(int statusCertificate) {
		this.statusCertificate = statusCertificate;
	}
	
	public String getIdUser_User() {
		return idUser_User;
	}
	
	public String getCertificate() {
		return certificate;
	}
	
	public int getStatusCertificate() {
		return statusCertificate;
	}
	
	public String toString() {
		return "idUser_User: "+idUser_User+"\n"
				+"Certificate: "+certificate+"\n"
				+"statusCertificate: "+statusCertificate;
	}
	
}
