package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.websocket.OnMessage;

@Data
@Entity
@Table(name = "produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tytul;

    private String opis;

    private String urlObrazka;

//    @ManyToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "kategoria_id")
    private Kategoria kategoria;

    private double cena;

    private TypProduktu typProduktu;

    private int stanMagazynowy;


}
