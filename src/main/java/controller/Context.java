package controller;

import model.ModelCombination;
import model.ModelTry;
import services.ServiceCombination;
import services.ServiceTry;

public class Context {
//TUTTO OK

    //Variabile per singleton
    private static Context istanzaContesto;
    private GameController controller;

    public static Context getInstance() {
        if (istanzaContesto == null) {
            istanzaContesto = new Context();

        }
        return istanzaContesto;
    }

    private Context() {
        ModelCombination modelCombination = new ModelCombination();
        ModelTry modelTry= new ModelTry();
        ServiceCombination serviceCombination = new ServiceCombination(modelCombination);
        ServiceTry tryService=new ServiceTry(modelTry);
        this.controller = new GameController(serviceCombination, tryService);
    }

    public GameController getGameController(){
        return this.controller;
    }

}
