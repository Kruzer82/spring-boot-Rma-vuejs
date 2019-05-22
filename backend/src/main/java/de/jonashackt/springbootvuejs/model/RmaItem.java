package de.jonashackt.springbootvuejs.model;


import de.jonashackt.springbootvuejs.model.rmaitem.Manufacture;
import de.jonashackt.springbootvuejs.model.rmaitem.Model;
import de.jonashackt.springbootvuejs.model.rmaitem.Type;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RmaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    Type type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id")
    Manufacture manufacture;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    Model model;
    String serialNumber;

}
