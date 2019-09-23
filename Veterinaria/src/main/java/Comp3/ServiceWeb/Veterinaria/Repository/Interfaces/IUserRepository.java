package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;

public interface IUserRepository {
	public int saveUser(UserEntity client);
	public UserEntity findUserById(String idUser_client);
	public int updateUserById(UserEntity client);
	public int deleteUserById(String idUser_client);
}
