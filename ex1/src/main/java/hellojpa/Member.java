package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    private Long id;
    private String name;

    private Integer age;

//    @Column(name="Team_id")
//    private Long teamId;

    @ManyToOne // 멤버 입장에서 many
    @JoinColumn(name = "team_id") // 관계할 때 조인할 칼럼
    private Team team;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // varchar를 넘어서는 큰 필드
    private String description;

    // 로직이 들어가면 getter, setter 사용 지양
    public void changeTeam(Team team) {
        this.team = team;
        // 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자
        team.getMembers().add(this);
    }

}