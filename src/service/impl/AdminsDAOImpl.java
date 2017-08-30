package service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Admins;
import entity.Users;
import service.AdminsDAO;

public class AdminsDAOImpl implements AdminsDAO {

	

	@Override
	public boolean adminsLogin(Admins u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAdmin(Admins u) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
			tx.commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null)
				tx = null;
		}
	}

	@Override
	public Users queryAdminInfo(Admins u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admins queryAdminsInfo(Admins u) {
		// TODO Auto-generated method stub
		return null;
	}

}
