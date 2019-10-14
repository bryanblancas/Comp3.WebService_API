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
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "idAppointment")
	public int idAppointment;

	@Column(name = "day")
	public int day;
	
	@Column(name = "month")
	public int month;
	
	@Column(name = "year")
	public int year;
	
	@Column(name = "vet_idUser_vet")
	public String vet_idUser_vet;
	
	@Column(name = "pet_idPet")
	public int pet_idPet;
	
	@Column(name = "prescription")
	public String prescription;
	
}
