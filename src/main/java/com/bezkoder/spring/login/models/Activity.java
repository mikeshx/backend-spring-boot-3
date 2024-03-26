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
    @ManyToOne
    @JoinColumn(name = "id_organizzatore")
    private User organizzatore;

    // Nome attività
    @Column(name = "nome")
    private String nome;

    // Nome tipo evento
    @Column(name = "nome_tipo_evento")
    private String nome_tipo_evento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Column(name = "latitudine")
    private Double latitudine;

    @Column(name = "longitudine")
    private Double longitudine;

    @Column(name = "max_partecipanti")
    private Integer max_partecipanti;

    //TODO: per l'immagine di copertina, per il momento assumo che si usi un link esterno ad un altra risorsa
    @Column(name = "img_copertina")
    private String imgCopertina;

    public Activity (String nome, User organizzatore, String nome_tipo_evento, String descrizione,
                     LocalDateTime dataInizio, LocalDateTime dataFine,
                     Double latitudine, Double longitudine, Integer max_partecipanti) {
        this.nome = nome;
        this.organizzatore = organizzatore;
        this.nome_tipo_evento = nome_tipo_evento;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.max_partecipanti = max_partecipanti;
    }

    public Activity() {

    }

    public String getNome_tipo_evento() {
        return nome_tipo_evento;
    }

    public void setNome_tipo_evento(String name) {
        this.nome_tipo_evento = name;
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

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public Integer getMax_partecipanti() {
        return max_partecipanti;
    }

    public void setMax_partecipanti(Integer max_partecipanti) {
        this.max_partecipanti = max_partecipanti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
