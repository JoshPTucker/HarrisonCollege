package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Hcclass;
import model.Hcclassroster;

public class RosterUtil {
	public static void insertRoster(Hcclassroster hcclassroster) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(hcclassroster);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void updateRoster(Hcclassroster hcclassroster) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(hcclassroster);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static void deleteRoster(Hcclassroster hcclassroster) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(hcclassroster));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static List<Hcclassroster> getRosterByCrn(long crn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select r from Hcclassroster r where r.hcclass.crn= :crn";
		List<Hcclassroster> roster = null;
		try {
			TypedQuery<Hcclassroster> q = em.createQuery(qString, Hcclassroster.class);
			q.setParameter("crn", crn);
			roster = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return roster;
	}
	public static List<Hcclassroster> getRosterByStudentId(long studentid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select r from Hcclassroster r where r.hcstudent.studentid= :studentid";
		List<Hcclassroster> roster = null;
		try {
			TypedQuery<Hcclassroster> q = em.createQuery(qString, Hcclassroster.class);
			q.setParameter("studentid", studentid);
			roster = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return roster;
	}
public static Hcclassroster getRosterByCrnAndStudentid(long studentid,long crn){
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select r from Hcclassroster r where r.hcstudent.studentid= :studentid and r.hcclass.crn= :crn";
	Hcclassroster roster = null;
	try {
		TypedQuery<Hcclassroster> q = em.createQuery(qString, Hcclassroster.class);
		q.setParameter("studentid", studentid);
		q.setParameter("crn", crn);
		roster = q.getSingleResult();
	} catch (NoResultException e) {
		System.out.println(e);
	} finally {
		em.close();
	}
	return roster;
}
}
