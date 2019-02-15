package DTO;

public class UserDTO implements Comparable<UserDTO> {

    private int idUtente;
    private String nomeUtente;
    private double punteggio;

    @Override
    public int compareTo(UserDTO o) {
        if (this.punteggio > o.getPunteggio()) {
            return 1;
        } else if (this.punteggio < o.getPunteggio()) {
            return -1;
        } else return 0;
    }

    public String getUtente() {
        return nomeUtente;
    }

    public void setUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setidUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(double punteggio) {
        this.punteggio = punteggio;
    }


}