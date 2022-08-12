package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name="locker_id")
    private Locker locker;

    @ManyToOne(fetch = FetchType.LAZY) // 프록시로 조회
    @JoinColumn(name="team_id")
    private Team team;
    // 로직이 들어가면 getter, setter 사용 지양
}