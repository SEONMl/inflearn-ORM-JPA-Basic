package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // JPA는 트랜잭션이 중요
            tx.begin();
            // code

            Member member = new Member();
            member.setUsername("adfsdf");
            member.setAge(10);
            em.persist(member);

            // 파라미터 바인딩은 그냥 쓰지 마세요
            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username=:username", Member.class);
            query.setParameter("username","kim");

            List<Member> resultList = query.getResultList();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
