package de.jonashackt.springbootvuejs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String name;
    String person;
    @Pattern(regexp = "^[0-9]{9}$")
    String phoneNumber;
    @Email
    String eMail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="seller_id")
    Seller seller;

}
