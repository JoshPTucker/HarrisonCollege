package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Hcclass;

public class ClassUtil {
	public static void insertClass(Hcclass hcclass) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist( hcclass);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void updateInstructor(Hcclass hcclass) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(hcclass);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static void delete(Hcclass hcclass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(hcclass));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Hcclass getClassByClassId(long classid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hcclass c " + "where c.classid= :classid";
		TypedQuery<Hcclass> q = em.createQuery(qString, Hcclass.class);
		q.setParameter("classid", classid);
		Hcclass hcclass = null;
		try {
			hcclass = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hcclass;
	}
	public static List<Hcclass> getClassesByInstructor(long instructorid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hcclass c where c.hcinstructor.instructorid= :instructorid";
		TypedQuery<Hcclass> q = em.createQuery(qString, Hcclass.class);
		q.setParameter("instructorid", instructorid);
		List<Hcclass> hcclasses = null;
		try {
			hcclasses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hcclasses;
	}
	public static List<Hcclass> getClassesByCourseId(long courseid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hcclass c where c.hccours.courseid= :courseid";
		List<Hcclass> hcclasses = null;
		try {
			TypedQuery<Hcclass> q = em.createQuery(qString, Hcclass.class);
			q.setParameter("courseid", courseid);
			hcclasses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hcclasses;
	}
	public static List<Hcclass> getClasses() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hcclass c ";
		TypedQuery<Hcclass> q = em.createQuery(qString, Hcclass.class);
		List<Hcclass> hcclasses = null;
		try {
			hcclasses = q.getResultList();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return hcclasses;
	}
}
