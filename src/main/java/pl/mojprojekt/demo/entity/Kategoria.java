package pl.mojprojekt.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "kategoria")
public class Kategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String opis;

    @OneToMany
    @OrderColumn
    @JoinColumn(name = "rodzic_id")
    private List<Kategoria> dzieciKategoria = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rodzic_id", insertable = false, updatable = false)
    private Kategoria rodzic;
}
