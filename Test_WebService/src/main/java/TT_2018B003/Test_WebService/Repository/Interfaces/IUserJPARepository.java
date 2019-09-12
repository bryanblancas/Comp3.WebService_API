package TT_2018B003.Test_WebService.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;

@Repository
public interface IUserJPARepository extends JpaRepository<UserEntity, String>{

}
