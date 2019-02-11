package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class ModelCombination extends ModelAbstract {
    //Salva la combinazione MASTER nel Database
    //Controllo se la tabella Combinazione esiste
//Se non esiste la creo (id_comb, username, data, master_comb)
    public void creaTabellaComb() {
        try {
            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS Combinazione (id_comb int PRIMARY KEY auto_increment, username varchar(20),data DATETIME, master_comb varchar(3));";
            super.statementMetodo();
            super.resultMetodo(sql);
            pulisciAmbiente(super.statementMetodo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Si differenzia per la query INSERT che agisce sulla tabella Combinazione
    public void inserisciComb(String vett_master, String username) {
        try {
            // SQL statement for creating a new table
            String sql = "INSERT INTO Combinazione (username, data, master_comb) VALUES ('" + username + "',now(),'" + vett_master + "');";
            super.statementMetodo();
            super.resultMetodo(sql);
            pulisciAmbiente(super.statementMetodo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Fa una semplice SELECT di tutto ciò che è in tabella
    public void leggiComb() {
        try {
            // SQL statement for creating a new table
            String sql = "SELECT * FROM Combinazione;";

            Statement stmp = super.statementMetodo();
            ResultSet rs = stmp.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next())
            {
                //Retrieve by column name
                int id = rs.getInt("id_comb");
                String username1 = rs.getString("username");
                String data = rs.getString("data");
                String vett_master = rs.getString("master_comb");


                //Display values
                System.out.println("\nCombinazione:\n");
                System.out.print("ID: " + id);
                System.out.print(", username1: " + username1);
                System.out.print(", data: " + data);
                System.out.print(", master_comb: " + vett_master + "\n\n");
            }
            super.pulisciAmbiente(stmp, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

