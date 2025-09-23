package models;

public abstract class Person {
    public String id;
    public String nom;
    public String prenom;
    public String email;

    public Person(String id, String nome, String prenom, String email) {
        this.id = id;
        this.nom = nome;
        this.prenom = prenom;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nom;
    }

    public void setNome(String nome) {
        this.nom = nome;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
