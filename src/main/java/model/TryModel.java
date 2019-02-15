package model;

public class TryModel {

    private int id;
    private int fk_id;
    private int ten_num;
    private String tentativo;
    private int num_pos;
    private int num_ce;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_id() {
        return fk_id;
    }

    public void setFk_id(int fk_id) {
        this.fk_id = fk_id;
    }

    public int getTen_num() {
        return ten_num;
    }

    public void setTen_num(int ten_num) {
        this.ten_num = ten_num;
    }

    public String getTentativo() {
        return tentativo;
    }

    public void setTentativo(String tentativo) {
        this.tentativo = tentativo;
    }

    public int getNum_pos() {
        return num_pos;
    }

    public void setNum_pos(int num_pos) {
        this.num_pos = num_pos;
    }

    public int getNum_ce() {
        return num_ce;
    }

    public void setNum_ce(int num_ce) {
        this.num_ce = num_ce;
    }


}
