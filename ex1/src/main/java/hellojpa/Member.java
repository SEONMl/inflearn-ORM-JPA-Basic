package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    // 일대다 양방향ㅎ
    @ManyToOne
    @JoinColumn(name="team_id",insertable = false, updatable = false)
    private Team team;
    // 로직이 들어가면 getter, setter 사용 지양
}