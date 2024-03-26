package com.bezkoder.spring.login.payload.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ActivityResponse {

    private String nome;
    private Long id;

    private Long idOrganizzatore;
    private String nome_tipo_evento;
    private String descrizione;

    private LocalDateTime dataInizio;

    private LocalDateTime dataFine;

    private String latitudine;

    private String longitudine;

    private Integer tipo;

    private Integer max_partecipanti;

    public ActivityResponse(String nome, Long id, Long idOrganizzatore, String nome_tipo_evento, String descrizione,
                            LocalDateTime dataInizio, LocalDateTime dataFine,
                            String latitudine, String longitudine,
                            Integer tipo, Integer max_partecipanti) {
        this.nome = nome;
        this.id = id;
        this.idOrganizzatore = idOrganizzatore;
        this.nome_tipo_evento = nome_tipo_evento;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.tipo = tipo;
        this.max_partecipanti = max_partecipanti;
    }

    public String getNome_tipo_evento() {
        return nome_tipo_evento;
    }

    public void setNome_tipo_evento(String nome) {
        this.nome_tipo_evento = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
