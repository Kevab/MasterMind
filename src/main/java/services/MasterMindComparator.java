package services;

import java.util.Comparator;

public class MasterMindComparator <T extends Comparable<T>> implements  Comparator<T>  {

    //Richiamabile tramite Collection.sort()
    @Override
    public int compare(T o1, T o2) {
        return(o1.compareTo(o2))*(-1);
    }
}
