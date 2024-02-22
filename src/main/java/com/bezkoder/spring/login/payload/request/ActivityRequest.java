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
}
