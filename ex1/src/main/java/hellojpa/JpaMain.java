package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // JPA는 트랜잭션이 중요
            tx.begin();
            // code
            /*
            Member member = new Member();
            member.setId(1L);
            member.setName("test");

            등록 : em.persist(member);
            조회 : Member find = em.find(Member.class, 1L);
            수정 : member.setName("Hi");
            삭제 : em.remove(member);

            JPQL : 엔티티 객체를 대상으로 쿼리
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
            .setFirstResult(5)
            .setMaxResults(0)
            .getResultList();
             */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
