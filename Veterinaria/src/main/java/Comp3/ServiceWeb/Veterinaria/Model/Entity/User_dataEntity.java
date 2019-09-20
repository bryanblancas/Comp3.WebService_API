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
@Table(name = "user_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User_dataEntity {
	
	@Id
	@Column(name = "idUser")
	public String idUser;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "first_lastname")
	public String first_lastname;
	
	@Column(name = "second_lastname")
	public String second_lastname;
	
	@Column(name = "day_birth")
	public int day_birth;
	
	@Column(name = "month_birth")
	public int month_birth;
	
	@Column(name = "year_birth")
	public int year_birth;
	
	@Column(name = "email")
	public String email;
}
