package pl.mojprojekt.demo.dto;

import lombok.Data;
import pl.mojprojekt.demo.entity.TypAdresu;
import pl.mojprojekt.demo.entity.Uzytkownik;

@Data
public class AdresDto {
    private String panstwo;

    private String miasto;

    private String ulica;

    private String kodPocztowy;

    private TypAdresu typAdresu;
}
