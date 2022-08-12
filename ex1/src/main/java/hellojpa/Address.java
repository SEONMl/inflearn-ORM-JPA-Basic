package hellojpa;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter // Setter 생성 X: Immutable Instance
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
