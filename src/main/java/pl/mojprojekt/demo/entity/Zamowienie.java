package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "zamowienie")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    private double cenaTotal;

    @OneToOne
    @JoinColumn(name = "adres_dostawy")
    private Adres adres;

    private LocalDate dataZlozenia;

    @OneToOne
    @JoinColumn(name = "koszyk_id")
    private Koszyk koszyk;

    private StatusZamowienia statusZamowienia;

}
