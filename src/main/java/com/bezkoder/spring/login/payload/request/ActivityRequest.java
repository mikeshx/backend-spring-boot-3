package com.bezkoder.spring.login.payload.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.*;

public class ActivityRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String nome_tipo_evento;

    @NotBlank
    private String descrizione;

    @NotBlank
    private String dataInizio;

    @NotBlank
    private String dataFine;

    @NotNull
    private Double latitudine;

    @NotNull
    private Double longitudine;

    @NotNull
    @Min(1)
    private Integer max_partecipanti;

    //TODO: quando invio la richiesta da utente non loggato, ho problemi a causa di id_organizzatore,
    // ricordati di loggarti, e rimettici not null...
    @Min(1)
    private Integer id_organizzatore;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
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

    public Integer getId_organizzatore() {
        return id_organizzatore;
    }

    public void setId_organizzatore(Integer id_organizzatore) {
        this.id_organizzatore = id_organizzatore;
    }

    public String getNome_tipo_evento() {
        return nome_tipo_evento;
    }

    public void setNome_tipo_evento(String nome_tipo_evento) {
        this.nome_tipo_evento = nome_tipo_evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
