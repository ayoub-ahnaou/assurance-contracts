package models;

import enums.TypeSinistre;

import java.time.LocalDate;

public class Sinistre {
    private int id;
    private LocalDate dateDebut;
    private Enum<TypeSinistre> typeSinistreEnum;

    public Sinistre(int id, LocalDate dateDebut, TypeSinistre typeSinistreEnum) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.typeSinistreEnum = typeSinistreEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Enum<TypeSinistre> getTypeSinistreEnum() {
        return typeSinistreEnum;
    }

    public void setTypeSinistreEnum(Enum<TypeSinistre> typeSinistreEnum) {
        this.typeSinistreEnum = typeSinistreEnum;
    }
}
