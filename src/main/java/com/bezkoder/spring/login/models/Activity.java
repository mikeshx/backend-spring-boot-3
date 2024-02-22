package com.bezkoder.spring.login.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

// This tells Hibernate to make a table out of this class
@Entity
@Table(name = "attivita")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // ID attività
    private Long id;

    // Più attività associate a un singolo utente
    //
    @ManyToOne
    @JoinColumn(name = "id_organizzatore")
    private User organizzatore;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Column(name = "tipo")
    private String tipo;

    // Nome attività
    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    //TODO: per l'immagine di copertina, per il momento assumo che si usi un link esterno ad un altra risorsa
    @Column(name = "img_copertina")
    private String imgCopertina;

    @Column(name = "latitudine")
    private String latitudine;

    @Column(name = "longitudine")
    private String longitudine;

    public Activity (String nome, String descrizione, LocalDateTime dataInizio, LocalDateTime dataFine) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Activity() {

    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(User organizzatore) {
        this.organizzatore = organizzatore;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImgCopertina() {
        return imgCopertina;
    }

    public void setImgCopertina(String imgCopertina) {
        this.imgCopertina = imgCopertina;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
}
