package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adres_klienta")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String panstwo;

    private String miasto;

    private String ulica;

    private String kodPocztowy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;
}
