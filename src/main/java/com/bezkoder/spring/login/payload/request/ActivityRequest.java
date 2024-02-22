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

}
