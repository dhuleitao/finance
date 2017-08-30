package service.impl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Finance;
import entity.Financing;
import entity.Fincanceled;
import entity.Finfailed;
import entity.Finsuccess;
import service.FinanceDAO;

enum moveType {
	financing2canceled, canceled2financing, failed2financing
}

public class FinanceDAOImpl implements FinanceDAO {

	@Override
	public boolean addFinance(Financing f) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(f);
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

	public Object query(String hql) {
		Transaction tx = null;
		Object res = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			res = query.list();
			tx.commit();
			return res;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	public boolean move(Object delF, Object addF) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.delete(delF);
			session.save(addF);
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

}
