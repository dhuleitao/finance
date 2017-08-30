package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Admins;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users u) {
		
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit(); 
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	@Override
	public boolean adminsLogin(Users u) {
		
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Admins where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit(); 
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	@Override
	public boolean updateUsers(Users u) {
		
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
	
	public Users queryUserInfo(Users u) {
		System.out.print("bbbbb");
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit(); 
			System.out.print("cccccc");
			if (list.size() > 0) {
				Users res=(Users)list.get(0);
				return res;
			} else {
				return u;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			System.out.print("aaaaaaaaa");
			return u;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
	@Override
public Admins queryAdminsInfo(Users u) {
		Admins uu=new Admins();
		uu.setDepartment(u.getDepartment());
		uu.setEmail(u.getEmail());
		uu.setJnum(u.getJnum());
		uu.setName(u.getName());
		uu.setPassword(u.getPassword());
		uu.setPhone(u.getPhone());
		uu.setUid(u.getUid());
		uu.setUsername(u.getUsername());
		uu.setGender(u.getGender());
		uu.setStatus(u.getStatus());
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Admins where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit(); 
			if (list.size() > 0) {
				Admins res=(Admins)list.get(0);
				return res;
			} else {
				return uu;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return uu;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}
}
