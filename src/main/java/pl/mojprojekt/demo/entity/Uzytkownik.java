package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "uzytkownik")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String loginMail;

    private String haslo;

    private String miasto;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "uzytkownik_role", joinColumns = @JoinColumn(name = "uzytkownik_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adres_id")
//    private List<Adres> adres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresDomowy_id")
    private Adres adresDomowy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresWysylki_id")
    private Adres adresWysylki;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresFakturowania_id")
    private Adres adresFakturowania;


}
