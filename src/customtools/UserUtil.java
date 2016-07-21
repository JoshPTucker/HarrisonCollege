package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customtools.DBUtil;
import model.Hcuser;

public class UserUtil {
	public static void insert(Hcuser hcuser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(hcuser);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Hcuser hcuser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(hcuser);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Hcuser hcuser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(hcuser));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static Hcuser getUserByEmail(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hcuser u " + "where u.email= :email";
		TypedQuery<Hcuser> q = em.createQuery(qString, Hcuser.class);
		q.setParameter("email", email);
		Hcuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static boolean isValidUser(Hcuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.userid) from Hcuser b" + " where b.email= :email "
				+ "and b.password = :password";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		try {
			q.setParameter("email", user.getEmail());
			q.setParameter("password", user.getPassword());
		} catch (Exception e) {
			result = false;
		}
		try {
			long userId = q.getSingleResult();
			if (userId > 0) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
