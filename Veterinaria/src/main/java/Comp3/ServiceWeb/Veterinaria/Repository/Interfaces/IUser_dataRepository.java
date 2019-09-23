package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;

public interface IUser_dataRepository {
	public User_dataEntity findUserById(String idUser);
	public int saveUser_data(User_dataEntity user);
	public int updateUser_dataById(User_dataEntity user);
	public int deleteUser_dataById(String idUser);
}
