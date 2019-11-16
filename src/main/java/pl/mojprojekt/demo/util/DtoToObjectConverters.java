package pl.mojprojekt.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.mojprojekt.demo.dto.AdresDto;
import pl.mojprojekt.demo.dto.UzytkownikDto;
import pl.mojprojekt.demo.entity.Adres;
import pl.mojprojekt.demo.entity.Role;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.repository.RoleRepository;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DtoToObjectConverters {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Adres adresDtoToAdresEntity(AdresDto adresDto){
        Adres adresEntity = new Adres();
        adresEntity.setUlica(adresDto.getUlica());
        adresEntity.setKodPocztowy(adresDto.getKodPocztowy());
        adresEntity.setMiasto(adresDto.getMiasto());
        adresEntity.setPanstwo(adresDto.getPanstwo());
        adresEntity.setUzytkownik(
                uzytkownikDtoToUzytkownikEntity(adresDto.getUzytkownikDto())
        ); //TODO zrobić użtykownika
        return adresEntity;
    }

    public Uzytkownik uzytkownikDtoToUzytkownikEntity(UzytkownikDto uzytkownikDto){
        Uzytkownik uzytkownikEntity = new Uzytkownik();

        Role role = roleRepository.findByRole("USER");

        uzytkownikEntity.setLoginMail(uzytkownikDto.getLoginMail());
        uzytkownikEntity.setMiasto(uzytkownikDto.getMiasto());
        uzytkownikEntity.setHaslo(passwordEncoder.encode(uzytkownikDto.getHaslo()));
//        zwraca z encji role USER
        uzytkownikEntity.setRoles(Collections.singleton(role));

        return uzytkownikEntity;
    }
}
