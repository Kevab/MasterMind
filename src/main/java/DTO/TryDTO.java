package DTO;

public class TryDTO implements Comparable<TryDTO> {

    private int fk_comb;
    private int ten_numero;
    private int num_pos;

    //Logica inversa del compareTo(ModelDTO)
    //Se ten_numero è alto perde altrimenti sta vincendo
    @Override
    public int compareTo(TryDTO o) {
        if (this.ten_numero < o.getTen_numero()) {
            return 1;
        } else if (this.ten_numero > o.getTen_numero()) {
            return -1;
        } else return 0;
    }

    public int getFk_comb() {
        return fk_comb;
    }

    public void setFk_comb(int fk_comb) {
        this.fk_comb = fk_comb;
    }

    public int getTen_numero() {
        return ten_numero;
    }

    public void setTen_numero(int ten_numero) {
        this.ten_numero = ten_numero;
    }

    public int getNum_pos() {
        return num_pos;
    }

    public void setNum_pos(int num_pos) {
        this.num_pos = num_pos;
    }


}
