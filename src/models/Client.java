package models;

public class Client extends Person {
    private String conseiller_id;

    public String getConseiller_id() {
        return conseiller_id;
    }

    public void setConseiller_id(String conseiller_id) {
        this.conseiller_id = conseiller_id;
    }

    public Client(String id, String nom, String prenom, String email, String conseiller_id) {
        super(id, nom, prenom, email);
        this.conseiller_id = conseiller_id;
    }
}
