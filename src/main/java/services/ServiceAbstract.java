package services;

import java.util.ArrayList;

public abstract class ServiceAbstract {

    public String myArrayListToString(ArrayList<Integer> master) {
        try {
            String str = "";
            for (int n : master)
                str += n;
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "NOPE";
        }
    }
}
