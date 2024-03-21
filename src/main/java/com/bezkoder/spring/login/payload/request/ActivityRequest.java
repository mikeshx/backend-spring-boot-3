package com.bezkoder.spring.login.payload.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.*;

public class ActivityRequest {
    @NotBlank
    @Size(min = 3, max = 40)
    private String nome;

    @NotBlank
    private String descrizione;

    @NotBlank
    private String dataInizio;

    @NotBlank
    private String dataFine;

    @NotBlank
    private String latitudine;

    @NotBlank
    private String longitudine;

    @NotNull
    @Min(1)
    private Integer tipo;

    @NotNull
    @Min(1)
    private Integer max_partecipanti;

    //TODO: quando invio la richiesta da utente non loggato, ho problemi a causa di id_organizzatore,
    // ricordati di loggarti, e rimettici not null...
    @Min(1)
    private Integer id_organizzatore;

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

    public Integer getMax_partecipanti() {
        return max_partecipanti;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getId_organizzatore() {
        return id_organizzatore;
    }

    public void setId_organizzatore(Integer id_organizzatore) {
        this.id_organizzatore = id_organizzatore;
    }
}
