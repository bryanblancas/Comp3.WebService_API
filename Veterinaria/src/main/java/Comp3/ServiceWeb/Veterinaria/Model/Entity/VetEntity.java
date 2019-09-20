package Comp3.ServiceWeb.Veterinaria.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VetEntity {
	@Id
	@Column(name = "idUser_vet")
	public String idUser_vet;
	
	@Column(name = "password")
	public String password;
}
