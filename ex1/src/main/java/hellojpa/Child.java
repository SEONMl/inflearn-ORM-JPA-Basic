package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Child {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Parent parent;
}
