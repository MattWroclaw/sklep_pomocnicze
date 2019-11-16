package pl.mojprojekt.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UzytkownikDto {

    private String loginMail;

    private String haslo;

    private String miasto;

    private List<AdresDto> adresDto;
}
