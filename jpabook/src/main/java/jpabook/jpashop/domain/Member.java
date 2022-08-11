package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    // Member에 Orders를 넣는 것은 좋지 않다
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
