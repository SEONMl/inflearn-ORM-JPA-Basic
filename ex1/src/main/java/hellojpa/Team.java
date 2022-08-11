package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue
    @Column(name="team_id")
    private Long id;
    private String name;

    //
    @OneToMany
    @JoinColumn(name="team_id")
    private List<Member> members = new ArrayList<>();

    // Member에서 넣을건지 Team에서 넣을건지 기준을 정하기
    // 양쪽에 연관관계 있으면 문제 발생 확률 UP
    // 이런 식으로도 가능
//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }

//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>(); // ArrayList로 초기화 해 주는 것이 관례
}
