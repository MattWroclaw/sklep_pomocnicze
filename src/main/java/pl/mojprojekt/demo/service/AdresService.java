package pl.mojprojekt.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mojprojekt.demo.dto.AdresDto;
import pl.mojprojekt.demo.entity.Adres;
import pl.mojprojekt.demo.entity.Role;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.repository.AdresRepository;
import pl.mojprojekt.demo.repository.RoleRepository;
import pl.mojprojekt.demo.repository.UzytkownikRepository;
import pl.mojprojekt.demo.util.DtoToObjectConverters;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class AdresService {

    private final AdresRepository adresRepository;
    private final UzytkownikRepository uzytkownikRepository;
    private final RoleRepository roleRepository;
    private final DtoToObjectConverters myConverters;


    public Adres createAdres(AdresDto adresDto) {
        Adres adresEntity = myConverters.adresDtoToAdresEntity(adresDto);
//        *********************************************************
//        Uzytkownik uzytkownikEntity = adresEntity.getUzytkownik();
//        uzytkownikRepository.save(uzytkownikEntity);
//         *********************************************************
        return adresRepository.save(adresEntity);
    }
}
