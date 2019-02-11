package model;

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class ModelAbstract {
//TUTTO OK
    private Dao instanceDao = Dao.newIstance();

    public Dao getInstanceDao() {
        return instanceDao;
    }

    public Statement statementMetodo() {
        try {

            Statement stmt = instanceDao.getConnection().createStatement();
            return stmt;

        } catch (Exception sqlEx)
        {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public boolean resultMetodo(String sql)    {
        try {
            this.statementMetodo().execute(sql);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pulisciAmbiente(Statement stmp) {
        try {
            stmp.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pulisciAmbiente(Statement stmp, ResultSet rs) {
        try {
            stmp.close();
            rs.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
