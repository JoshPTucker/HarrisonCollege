package customtools;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Hcstudent;
public class StudentUtil {
	public static void insert(Hcstudent hcstudent) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(hcstudent);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Hcstudent hcstudent) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(hcstudent);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Hcstudent hcstudent) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(hcstudent));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static Hcstudent getStudentByUserId(long userid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Hcstudent u " + "where u.hcuser.userid= :userid";
		TypedQuery<Hcstudent> q = em.createQuery(qString, Hcstudent.class);
		q.setParameter("userid", userid);
		Hcstudent student = null;
		try {
			student = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return student;
	}
}
