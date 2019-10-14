package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import java.util.List;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;

public interface IPetRepository {
	public List<PetEntity> findAllPetsByIdUser(String idUser);
	public int deletePetById(int idPet);
	public int savePet(PetEntity pet);
}
