package Comp3.ServiceWeb.Veterinaria.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "idPet")
	public int idPet;
	
	@Column(name = "name")
	public String name;

	@Column(name = "day_birth")
	public int day_birth;
	
	@Column(name = "month_birth")
	public int month_birth;
	
	@Column(name = "year_birth")
	public int year_birth;
	
	@Column(name = "user_idUser_client")
	public String user_idUser_client;
	
	@Column(name = "is_alive")
	public int is_alive;
	
	@Column(name = "type")
	public String type;
	
}
