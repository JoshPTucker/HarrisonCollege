package customtools;

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
	public static Hcclass getlassByUserId(long classid) {
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
}
