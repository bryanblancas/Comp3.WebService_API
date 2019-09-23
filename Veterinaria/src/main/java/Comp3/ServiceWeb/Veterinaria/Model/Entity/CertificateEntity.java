package Comp3.ServiceWeb.Veterinaria.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "certificate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CertificateEntity {
	
	@Id
	@Column(name = "certificate")
	public String certificate;
	
	@Column(name = "user_data_idUser")
	public String user_data_idUser;
	
}
