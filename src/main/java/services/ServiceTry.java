package services;

import model.TryRepository;

import java.util.ArrayList;

public class ServiceTry extends ServiceAbstract {

    private TryRepository tryModel;

//Costruttore
    public ServiceTry(TryRepository tryModel) {
        this.tryModel = tryModel;
    }

    public void saveTry(ArrayList<Integer> utente, int tent, int[] pos)    {
        tryModel.creaTabellaTry();
        tryModel.inserisciTry(myArrayListToString(utente), tent, pos);

    }

    //Array list di tentativi con i dati del DTO
}
