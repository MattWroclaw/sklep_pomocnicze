package pl.mojprojekt.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mojprojekt.demo.dto.ProductDto;
import pl.mojprojekt.demo.entity.Kategoria;
import pl.mojprojekt.demo.entity.Produkt;
import pl.mojprojekt.demo.entity.TypProduktu;
import pl.mojprojekt.demo.repository.ProduktRepository;
import pl.mojprojekt.demo.service.ProduktService;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProduktService produktService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showFormular(Model model){
        List<Produkt> produkts = produktService.showProducts();
        model.addAttribute("nowyProdukt", new ProductDto());
        model.addAttribute("produkty", produkts);
        return "admin";
    }

    @RequestMapping(value = "/dodajProdukt" , method = RequestMethod.POST)
    public String processFormular(@ModelAttribute ProductDto productDto){
        produktService.createProdukt(productDto);
        return "redirect:/admin";
    }
}
