package services;

import model.ModelAbstract;
import model.ModelTry;

import java.util.ArrayList;

public class ServiceTry extends ServiceAbstract {

    private ModelTry tryModel;

//Costruttore
    public ServiceTry(ModelTry tryModel) {
        this.tryModel = tryModel;
    }


    public void saveTry(ArrayList<Integer> utente, int tent, int[] pos)    {
        tryModel.creaTabellaTry();
        tryModel.inserisciTry(myArrayListToString(utente), tent, pos);

    }
}
