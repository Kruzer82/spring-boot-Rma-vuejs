package de.jonashackt.springbootvuejs.model.rmaitem;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue
        int id;
        String type;

}
