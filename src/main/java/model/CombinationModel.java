package model;

import java.util.Date;

//TRANSFERT OBJECT
public class CombinationModel  {

    private  int id;
    private String nome;
    private String master;
    private Date data;

    //private CombinationRepository combRepo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    //comparable

}