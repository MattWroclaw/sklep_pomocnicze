package pl.mojprojekt.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mojprojekt.demo.dto.ProductDto;
import pl.mojprojekt.demo.entity.Produkt;
import pl.mojprojekt.demo.repository.ProduktRepository;
import pl.mojprojekt.demo.util.DtoToObjectConverters;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduktService {

    private final ProduktRepository produktRepository;
    private final DtoToObjectConverters dtoToObjectConverters;

    public Produkt createProdukt(ProductDto productDto){
        Produkt nowyProdukt = dtoToObjectConverters.produktDtoToProductEntity(productDto);
        return produktRepository.save(nowyProdukt);
    }

    public List<Produkt> showProducts(){
       return produktRepository.findAll();
    }
}
