package com.bezkoder.spring.login.payload.request;

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
    private Date dataFine;

    @NotBlank
    private Date dataInizio;

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
}
