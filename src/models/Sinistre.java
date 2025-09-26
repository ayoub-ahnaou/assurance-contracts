package models;

import enums.TypeSinistre;

import java.time.LocalDate;

public class Sinistre {
    private String id;
    private LocalDate dateDebut;
    private double montant;
    private String contratId;
    private Enum<TypeSinistre> typeSinistreEnum;

    public Sinistre(String id, LocalDate dateDebut, double montant, TypeSinistre typeSinistreEnum, String contratId) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.montant = montant;
        this.typeSinistreEnum = typeSinistreEnum;
        this.contratId = contratId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getContratId() {
        return contratId;
    }

    public void setContratId(String contratId) {
        this.contratId = contratId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
