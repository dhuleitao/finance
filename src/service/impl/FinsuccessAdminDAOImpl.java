package service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Financing;
import entity.Fincanceled;
import entity.Finfailed;
import entity.Finsuccess;
import entity.Users;
import service.FinsuccessAdminDAO;

public class FinsuccessAdminDAOImpl implements FinsuccessAdminDAO {

	@Override
	public List<Finsuccess> queryAllFinsuccess() {

		Transaction tx = null;
		List<Finsuccess> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Finsuccess";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Finfailed> queryAllFinfail() {
		System.out.print("ddadadadadada");
		Transaction tx = null;
		List<Finfailed> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Finfailed";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Finfailed> queryAllFining() {

		Transaction tx = null;
		List<Finfailed> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Financing";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public Finsuccess queryFinsuccessBySid(String sid) {
		Transaction tx = null;
		Finsuccess s = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Finsuccess) session.get(Finsuccess.class, sid);
			tx.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return s;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean addFinsuccess(Finsuccess s) {
		s.setFid("2");
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean move(String srcTbl, String fid, String desTbl) {
		String nextFid = getNextFid("Finsuccess");
		System.out.println("move excute.");
		Transaction tx = null;
		try {
			FinanceDAOImpl fdao = new FinanceDAOImpl();
			Object rec = null;
			@SuppressWarnings("rawtypes")
			List res = (List) fdao.query("from " + srcTbl + " where fid='" + fid + "'");
			rec = res.get(0);
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Financing financing = (Financing) rec;
			// Finsuccess finsuccess=Convertor.financing2finsuccess(financing);
			Finsuccess finsuccess = new Finsuccess(nextFid, financing.getFnum(), financing.getType(),
					financing.getSerial(), financing.getApplyname(), financing.getJnum(), financing.getProjectname(),
					financing.getStatus(), financing.getMoney(), financing.getCardnum(), financing.getCardname(),
					financing.getCardtype(), financing.getApplydate(), financing.getComment(),financing.getImgPath());
			session.delete(financing);
			session.save(finsuccess);
			tx.commit();
			// savesuccess(finsuccess);

			return true;
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean finIt(String srcTbl, String fid, String desTbl) {
		String nextFid = getNextFid("Finsuccess");
		Transaction tx = null;
		try {
			FinanceDAOImpl fdao = new FinanceDAOImpl();
			List res = (List) fdao.query("from " + srcTbl + " where fid='" + fid + "'");
			Financing financing = (Financing) res.get(0);
			Finsuccess finsuccess = new Finsuccess(nextFid, financing.getFnum(), financing.getType(),
					financing.getSerial(), financing.getApplyname(), financing.getJnum(), financing.getProjectname(),
					financing.getStatus(), financing.getMoney(), financing.getCardnum(), financing.getCardname(),
					financing.getCardtype(), financing.getApplydate(), financing.getComment(),financing.getImgPath());
			res = (List) fdao.query("from  Users where jnum='" + financing.getJnum() + "'");
			Users u = (Users) res.get(0);
			u.setMoney(u.getMoney().add(financing.getMoney()));
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.delete(financing);
			session.save(finsuccess);
			session.update(u);
			tx.commit();
			return true;
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
	public boolean savesuccess(Finsuccess s) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean movee(String srcTbl, String fid, String comment, String desTbl) {
		String nextFid = getNextFid("Finfailed");
		System.out.println("move excute.");
		Transaction tx = null;
		try {
			FinanceDAOImpl fdao = new FinanceDAOImpl();
			@SuppressWarnings("rawtypes")
			Object rec = ((List) fdao.query("from " + srcTbl + " where fid='" + fid + "'")).get(0);
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Financing financing = (Financing) rec;
			// Finfailed finfailed=Convertor.financing2finfailed(financing);
			Finfailed finfailed = new Finfailed(nextFid, financing.getFnum(), financing.getType(),
					financing.getSerial(), financing.getApplyname(), financing.getJnum(), financing.getProjectname(),
					financing.getStatus(), financing.getMoney(), financing.getCardnum(), financing.getCardname(),
					financing.getCardtype(), financing.getApplydate(), financing.getComment(),financing.getImgPath());
			finfailed.setComment(comment);
			session.delete(financing);
			session.save(finfailed);
			tx.commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updateFinsuccess(Finsuccess s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private String getNextFid(String table) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(cast(fid as int)) from " + table;
			Query query = session.createQuery(hql);
			Object res = query.uniqueResult();
			res=res!=null?res:0;
			Integer nextFid = ((Integer) res) + 1;
			tx.commit();
			return nextFid.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null)
				tx = null;
		}
	}

}
