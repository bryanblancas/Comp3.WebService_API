package TT_2018B003.Test_WebService.Repository.Interfaces;

import java.util.List;
import java.util.Optional;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;

public interface IUserRepository {
	public UserEntity getUserById(String idUser);
	public List<UserEntity> getAllUsers();
}
