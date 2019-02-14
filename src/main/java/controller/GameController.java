package controller;

import services.ServiceCombination;
import services.ServiceTry;

import java.util.ArrayList;

public class GameController {

    private ServiceCombination combServ;
    private ServiceTry tryServ;
    private String nomeUser;
    public ArrayList<Integer> masterArrList;
    public int[] risultato;
    private int tentativi = 10;

    //Costruttore
    public GameController(ServiceCombination combServ, ServiceTry tryServ) {
        this.combServ = combServ;
        this.tryServ = tryServ;

    }

    //Nome Utente SET/GET
    public void nomeUtenteSET(String str) {
        this.nomeUser = combServ.setUsername(str);
    }

    public String nomeUtenteGET() {
        return this.nomeUser = combServ.getUsername();
    }

    //Chiama il metodo che crea il master
    public void creaMaster() {
        this.masterArrList = combServ.generaMaster();
    }

//    public void creaMasterColori() {
//        this.masterArrList = combServ.generaMasterColor();
//    }

    public int getTentativi() {
        return tentativi;
    }

    public void setTentativi(int tentativi) {
        this.tentativi = tentativi;
    }

    public int[] checker(ArrayList<Integer> tempArray, ArrayList<Integer> temp2Array) {
        return this.risultato = combServ.doCheck(tempArray, temp2Array);
    }

    public void saveCombination()
    {
        combServ.saveComb(masterArrList,nomeUser);
    }

    public void saveTentativo(ArrayList<Integer> utente)
    {
        tryServ.saveTry(utente,tentativi,risultato);
    }

}