package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders") // order 예약어
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime orderDate;

    // 이건 가치가 있음
    // 주문서를 뽑았을 때 주문 내역이 나오게
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
