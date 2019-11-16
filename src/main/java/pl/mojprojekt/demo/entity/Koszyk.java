package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "koszyk")
public class Koszyk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    @OneToMany
    @JoinColumn(name = "liniaZamowienia_id")
    private List<LiniaZamowienia> linieZamowienia = new ArrayList<>();
}
