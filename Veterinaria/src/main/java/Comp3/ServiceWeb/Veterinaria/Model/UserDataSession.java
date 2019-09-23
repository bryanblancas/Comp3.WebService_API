package Comp3.ServiceWeb.Veterinaria.Model;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDataSession{
	private User_dataEntity user;
	private int type;
}