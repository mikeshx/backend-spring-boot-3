package com.bezkoder.spring.login.payload.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ActivityResponse {

    private Long id;

    private Long idOrganizzatore;
    private String nome;
    private String descrizione;

    private LocalDateTime dataInizio;

    private LocalDateTime dataFine;

    private String latitudine;

    private String longitudine;

    private Integer tipo;

    private Integer max_partecipanti;

    public ActivityResponse(Long id, Long idOrganizzatore, String nome, String descrizione,
                            LocalDateTime dataInizio, LocalDateTime dataFine,
                            String latitudine, String longitudine,
                            Integer tipo, Integer max_partecipanti) {
        this.id = id;
        this.idOrganizzatore = idOrganizzatore;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.tipo = tipo;
        this.max_partecipanti = max_partecipanti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

    public Long getIdOrganizzatore() {
        return idOrganizzatore;
    }

    public void setIdOrganizzatore(Long idOrganizzatore) {
        this.idOrganizzatore = idOrganizzatore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getMax_partecipanti() {
        return max_partecipanti;
    }

    public void setMax_partecipanti(Integer max_partecipanti) {
        this.max_partecipanti = max_partecipanti;
    }
}
