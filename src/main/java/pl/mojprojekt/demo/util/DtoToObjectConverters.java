package pl.mojprojekt.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.mojprojekt.demo.dto.AdresDto;
import pl.mojprojekt.demo.dto.ProductDto;
import pl.mojprojekt.demo.dto.UzytkownikDto;
import pl.mojprojekt.demo.entity.Adres;
import pl.mojprojekt.demo.entity.Produkt;
import pl.mojprojekt.demo.entity.Role;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.repository.RoleRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DtoToObjectConverters {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Adres adresDtoToAdresEntity(AdresDto adresDto){
        Adres adresEntity = new Adres();
        if(adresDto == null){
            return adresEntity;
        }
        adresEntity.setUlica(adresDto.getUlica());
        adresEntity.setKodPocztowy(adresDto.getKodPocztowy());
        adresEntity.setMiasto(adresDto.getMiasto());
        adresEntity.setPanstwo(adresDto.getPanstwo());
        adresEntity.setTypAdresu(adresDto.getTypAdresu());
        return adresEntity;
    }

    public Uzytkownik uzytkownikDtoToUzytkownikEntity(UzytkownikDto uzytkownikDto){
        Uzytkownik uzytkownikEntity = new Uzytkownik();

//        Role role = roleRepository.findByRole("USER");
        Role role = roleRepository.findByRole("ADMIN");

        uzytkownikEntity.setLoginMail(uzytkownikDto.getLoginMail());
        uzytkownikEntity.setMiasto(uzytkownikDto.getMiasto());

        uzytkownikEntity.setAdresDomowy(adresDtoToAdresEntity(uzytkownikDto.getAdresDtoDomowy()));
        uzytkownikEntity.setAdresFakturowania(adresDtoToAdresEntity(uzytkownikDto.getAdresDtoFaktura()));
        uzytkownikEntity.setAdresWysylki(adresDtoToAdresEntity(uzytkownikDto.getAdresDtoWysylka()));

        uzytkownikEntity.setHaslo(passwordEncoder.encode(uzytkownikDto.getHaslo()));
//        zwraca z encji role USER
        uzytkownikEntity.setRoles(Collections.singleton(role));

        return uzytkownikEntity;
    }

    public Produkt produktDtoToProductEntity(ProductDto productDto){
        Produkt produktEntity = new Produkt();
        produktEntity.setCena(productDto.getCena());
        produktEntity.setOpis(productDto.getOpis());
        produktEntity.setTytul(productDto.getTytul());
        produktEntity.setStanMagazynowy(productDto.getStanMagazynowy());
        productDto.setUrlObrazka(productDto.getUrlObrazka());

//        produktEntity.setKategoria(productDto.getKategoria());
        return produktEntity;
    }
}
