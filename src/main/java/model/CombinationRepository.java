package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//BUSINESS OBJECT
public class CombinationRepository extends ModelAbstract {
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
    public ArrayList<CombinationModel> findAllCombinationComb() {
        try {
            // SQL statement for creating a new table
            String sql = "SELECT * FROM Combinazione;";

            Statement stmp = super.statementMetodo();
            ResultSet rs = stmp.executeQuery(sql);
            return converToModel(rs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Mette la tabella in un ArrayList
    private ArrayList<CombinationModel> converToModel(ResultSet resultSet) {

        try {
            ArrayList<CombinationModel> listaModelli = new ArrayList<>();

            while (resultSet.next()) {
                CombinationModel modello = new CombinationModel();
                modello.setId(resultSet.getInt(0));
                modello.setNome(resultSet.getString(1));
                modello.setData(resultSet.getDate(2));
                modello.setMaster(resultSet.getString(3));
                listaModelli.add(modello);
            }
            return listaModelli;
        } catch (SQLException exSQL) {
            exSQL.getErrorCode();
            return null;
        }
    }
}
