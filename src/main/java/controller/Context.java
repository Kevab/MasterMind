package controller;

import model.CombinationRepository;
import model.TryRepository;
import services.ServiceCombination;
import services.ServiceTry;

public class Context {
//TUTTO OK

    //Variabile per singleton
    private static Context istanzaContesto;
    private GameController gameController;
    private ClassificaController classificaController;

    public static Context getInstance() {
        if (istanzaContesto == null) {
            istanzaContesto = new Context();

        }
        return istanzaContesto;
    }



    private Context() {
        CombinationRepository combinationRepository = new CombinationRepository();
        TryRepository tryRepository = new TryRepository();
        ServiceCombination serviceCombination = new ServiceCombination(combinationRepository);
        ServiceTry tryService=new ServiceTry(tryRepository);
        this.gameController = new GameController(serviceCombination, tryService);
        this.classificaController = new ClassificaController(serviceCombination,tryService);
    }

    public GameController getGameController(){
        return this.gameController;
    }

    public ClassificaController getClassificaController() {
        return classificaController;
    }
}
