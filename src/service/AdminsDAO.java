package service;

import entity.Admins;
import entity.Users;

public interface AdminsDAO {

	

		public boolean adminsLogin(Admins u);
		public boolean updateAdmin(Admins u);

		public Users queryAdminInfo(Admins u);
		public Admins queryAdminsInfo(Admins u);
	
}
