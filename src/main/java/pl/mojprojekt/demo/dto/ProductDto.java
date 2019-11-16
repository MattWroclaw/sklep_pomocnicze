package pl.mojprojekt.demo.dto;

import lombok.Data;
import pl.mojprojekt.demo.entity.Kategoria;
import pl.mojprojekt.demo.entity.TypProduktu;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ProductDto {

    private String tytul;

    private String opis;

    private String urlObrazka;

    private Kategoria kategoria;

    private double cena;

    private TypProduktu typProduktu;

    private int stanMagazynowy;
}
