package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customtools.DBUtil;
import model.Hccourse;

public class CourseUtil {
	public static void insertCourse(Hccourse course) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(course);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void updateCourse(Hccourse course) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(course);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static void delete(Hccourse course) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(course));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Hccourse getCourseById(long courseid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from Hccourse c " + "where c.courseid= :courseid";
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		
		Hccourse course = null;
		try {
			q.setParameter("courseid", courseid);
			course = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return course;
	}
	 public static List<Hccourse> allCourses (){
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        String qString = "select c from Hccourse c";
	        List<Hccourse> courses = null;
	        try{
	            TypedQuery<Hccourse> query = em.createQuery(qString,Hccourse.class);
	            courses = query.getResultList();

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return courses;
	    }
}
