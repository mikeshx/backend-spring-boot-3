package com.bezkoder.spring.login.payload.response;

import java.util.Date;

public class ActivityResponse {

    private Long id;

    private Long idOrganizzatore;
    private String nome;
    private String descrizione;

    private Date dataInizio;

    private Date dataFine;

    public ActivityResponse(Long id, Long idOrganizzatore, String nome, String descrizione, Date dataInizio, Date dataFine) {
        this.id = id;
        this.idOrganizzatore = idOrganizzatore;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
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

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
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
}
