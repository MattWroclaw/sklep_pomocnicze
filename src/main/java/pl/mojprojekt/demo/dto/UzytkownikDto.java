package pl.mojprojekt.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UzytkownikDto {

    private String loginMail;

    private String haslo;

    private String miasto;

    private AdresDto adresDtoDomowy;

    private AdresDto adresDtoFaktura;

    private AdresDto adresDtoWysylka;
}
