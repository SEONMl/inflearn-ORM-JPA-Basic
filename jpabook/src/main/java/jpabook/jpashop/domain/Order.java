package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="orders") // order 예약어
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long id;
    @Column(name="member_id")
    private Long memberId;
    @Enumerated(EnumType.STRING)
    private LocalDateTime orderDate;
    private OrderStatus status;
}
