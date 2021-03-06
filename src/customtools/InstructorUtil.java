package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Hcinstructor;




public class InstructorUtil {
	public static void insertInstructor(Hcinstructor instructor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(instructor);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void updateInstructor(Hcinstructor instructor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(instructor);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static void delete(Hcinstructor instructor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(instructor));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Hcinstructor getInstructorByUserId(long userid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hcinstructor u " + "where u.hcuser.userid= :userid";
		TypedQuery<Hcinstructor> q = em.createQuery(qString, Hcinstructor.class);
		q.setParameter("userid", userid);
		Hcinstructor instructor = null;
		try {
			instructor = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return instructor;
	}
}
