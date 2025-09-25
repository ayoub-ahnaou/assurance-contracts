package models;

import enums.TypeContrat;

import java.time.LocalDate;

public class Contrat {
    private String id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montant;
    private String description;
    private Enum<TypeContrat> typeContratEnum;

    public Contrat(String id, LocalDate dateDebut, LocalDate dateFin, double montant, String description, TypeContrat typeContratEnum) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montant = montant;
        this.description = description;
        this.typeContratEnum = typeContratEnum;
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

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum<TypeContrat> getTypeContratEnum() {
        return typeContratEnum;
    }

    public void setTypeContratEnum(Enum<TypeContrat> typeContratEnum) {
        this.typeContratEnum = typeContratEnum;
    }
}
