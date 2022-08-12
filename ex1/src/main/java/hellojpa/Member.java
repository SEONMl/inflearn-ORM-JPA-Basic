package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    //Period
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    @Embedded
    private Period period;

    //Address
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address address;
    // 로직이 들어가면 getter, setter 사용 지양
}