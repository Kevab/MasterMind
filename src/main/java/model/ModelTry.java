package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class ModelTry extends ModelAbstract {

    //Salva la combinazione UTENTE nel Database
    //Controllo se la tabella Tentativo esiste
    //Se non esiste la creo (id_try, fk_comb, ten_numero, tentativo, num_pos, num_ce)
    public void creaTabellaTry() {
        try {
            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS Tentativi (id_try int PRIMARY KEY auto_increment,fk_comb int,ten_numero int, tentativo varchar(3),num_pos int,num_ce int, FOREIGN KEY (fk_comb) REFERENCES Combinazione(id_comb));";
            super.statementMetodo();
            super.resultMetodo(sql);
            super.pulisciAmbiente(super.statementMetodo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    Metodo di inserimento (utilizza l'interfaccia CRUD per stabilire le regole
//Si differenzia per la query INSERT che agisce sulla tabella Tentativi
    public void inserisciTry(String vett_utente, int tentativo, int[] pos_giusta)    {
        try {
            String fk_recupero = "SELECT id_comb FROM Combinazione ORDER BY id_comb DESC LIMIT 1;";
            Statement stmp = super.statementMetodo();
            ResultSet rs = stmp.executeQuery(fk_recupero);
            int n = 0;
            while(rs.next())
            {
                n = rs.getInt("id_comb");
            }
            System.out.print("ID: " + n);
            pulisciAmbiente(super.statementMetodo(), rs);


            // SQL statement for creating a new table
            String sql = "INSERT INTO Tentativi (fk_comb, ten_numero, tentativo, num_pos, num_ce) VALUES ('" + n + "','" + tentativo + "','"+ vett_utente + "','" + pos_giusta[0] + "','"+pos_giusta[1]+"');";
            super.statementMetodo();
            super.resultMetodo(sql);
            pulisciAmbiente(super.statementMetodo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leggiTry() {
        try {
            // SQL statement for creating a new table
            String sql = "SELECT * FROM Tentativi;";

            Statement stmp = super.statementMetodo();
            ResultSet rs = stmp.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next())
            {
                //Retrieve by column name
                int id = rs.getInt("id_try");
                int fk = rs.getInt("fk_comb");
                int ten_num = rs.getInt("ten_numero");
                String tentativo = rs.getString("tentativo");
                int num_pos = rs.getInt("num_pos");
                int num_ce = rs.getInt("num_ce");


                //Display values
                System.out.println("\nTentativo:\n");
                System.out.print("ID: " + id);
                System.out.print(", FK_ID: " + fk);
                System.out.print(", ten_numero: " + ten_num);
                System.out.print(", tentativo: " + tentativo);
                System.out.print(", num_pos: " + num_pos);
                System.out.print(", num_ce: " + num_ce);
            }
            super.pulisciAmbiente(stmp, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
