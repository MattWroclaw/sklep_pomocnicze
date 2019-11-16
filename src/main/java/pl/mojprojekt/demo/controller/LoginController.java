package pl.mojprojekt.demo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mojprojekt.demo.dto.AdresDto;
import pl.mojprojekt.demo.dto.UzytkownikDto;
import pl.mojprojekt.demo.entity.Adres;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.service.AdresService;
import pl.mojprojekt.demo.service.UzytkownikService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UzytkownikService uzytkownikService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(Model model){
        model.addAttribute("nowyUzytkownik", new UzytkownikDto());
        return "register";
    }

    @RequestMapping(value = "/formularzRejestracji", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("nowyUzytkownik") UzytkownikDto uzytkownikDto){
       uzytkownikService.createUzytkownik(uzytkownikDto);
       return "redirect:login";
    }

    @GetMapping("/start")
    public String goStart(){
        return "sklep";
    }

    @GetMapping("/admin")
    public String goAdmin(){
        return "admin";
    }
}
