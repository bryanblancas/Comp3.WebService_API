package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import java.util.List;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;

public interface IVetRepository {
	public int saveVet(VetEntity vet);
	public VetEntity findVetById(String idUser_vet);
	public int updateVetById(VetEntity vet);
	public int deleteVetById(String idUser_vet);
	public List<VetEntity> getAllVets();
}
