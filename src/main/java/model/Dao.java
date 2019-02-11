package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
//TUTTO OK

    private static Dao instance;
    //Uso singleton per gestire 1 sola connessione al DB
    private String driver;
    private String url;
    private String username;
    private String password;

    private Connection connection;

    //Costruttore che richiama il metodo di connessione al DB
    private Dao(){
        this.connessioneDb();
    }

    //La prima volta creo un instanza con newIstance
    public static Dao newIstance()    {
        if(instance==null)
        {
            instance = new Dao();
        }
        return instance;
    }

    //Con questo metodo richiamo sempre la stessa connessione
    public Connection getConnection() {
        return this.connection;
    }

    //Prova a creare la connessione al DB e la ritorna
    private Connection connessioneDb() {
        try {

            driver = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver);

            url = "jdbc:mysql://localhost:3306/MasterMind";
            username = "DANIEL";
            password = "Fottiti";

            //APRE LA CONNESSIONE
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connesso al database");
            return connection;

        } catch (Exception e) {
            System.out.println("Model.Dao.connessioneDb Errore -->" + e);
            return connection = null;
        }
    }
}
