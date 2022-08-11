package hellojpa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {
    @Id
    private Long id;
    private String name;

    private Integer age;

//    @Column(name="Team_id")
//    private Long teamId;

    @ManyToOne // 멤버 입장에서 many
    @JoinColumn(name="team_id") // 관계할 때 조인할 칼럼
    private Team team;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // varchar를 넘어서는 큰 필드
    private String description;

    public Member() {
    }
}