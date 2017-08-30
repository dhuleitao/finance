package service;

import entity.Admins;
import entity.Users;


public interface UsersDAO {

	
	public boolean usersLogin(Users u);
	public boolean adminsLogin(Users u);
	public boolean updateUsers(Users u);

	public Users queryUserInfo(Users u);
	public Admins queryAdminsInfo(Users u);
}
