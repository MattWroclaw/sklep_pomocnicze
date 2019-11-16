package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "linia_zamowienia")
public class LiniaZamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "produkt_id")
    private List<Produkt> produkt;

    private int iloscProduktow;

    private double cenaProduktu;
}
