package pl.mojprojekt.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mojprojekt.demo.dto.UzytkownikDto;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.repository.UzytkownikRepository;
import pl.mojprojekt.demo.util.DtoToObjectConverters;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UzytkownikService {

    private final DtoToObjectConverters myConverters;
    private final UzytkownikRepository uzytkownikRepository;

    public Uzytkownik createUzytkownik(UzytkownikDto uzytkownikDto){
        Uzytkownik uzytkownikEntity = myConverters.uzytkownikDtoToUzytkownikEntity(uzytkownikDto);
        return uzytkownikRepository.save(uzytkownikEntity);
    }
}
