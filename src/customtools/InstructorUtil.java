package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
