package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ElementCollection
    @CollectionTable(name="favorite_food", joinColumns =
        @JoinColumn(name="member_id")
    )
    @Column(name="food_name")
    private Set<String> favoriteFoods = new HashSet<>();
    @ElementCollection
    @CollectionTable(name="address", joinColumns =
        @JoinColumn(name="member_id")
    )
    private List<Address> addressHistory = new ArrayList<>();
    // 로직이 들어가면 getter, setter 사용 지양
}