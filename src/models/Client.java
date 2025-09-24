package models;

public class Client extends Person {
    private String conseillerId;

    public String getConseillerId() {
        return conseillerId;
    }

    public void setConseiller_id(String conseillerId) {
        this.conseillerId = conseillerId;
    }

    public Client(String id, String nom, String prenom, String email, String conseillerId) {
        super(id, nom, prenom, email);
        this.conseillerId = conseillerId;
    }
}
