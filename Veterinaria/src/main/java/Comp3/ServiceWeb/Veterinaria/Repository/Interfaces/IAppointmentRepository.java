package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import java.util.List;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.AppointmentEntity;

public interface IAppointmentRepository {
	public List<AppointmentEntity> findAllAppointmentOfPet(int idPet);
	public int deleteAppointmentByIdPet(int idPet);
	public int saveAppointment(AppointmentEntity ae);
}
