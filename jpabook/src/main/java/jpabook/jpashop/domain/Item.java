package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long id;
    private String name;
    private String price;
    private int StockQuantity;

    @ManyToMany(mappedBy = "items") // 쓰지 말자
    private List<Category> categories = new ArrayList<>();
}
