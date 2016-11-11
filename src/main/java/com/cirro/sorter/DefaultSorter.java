package com.cirro.sorter;

import com.cirro.pojos.T3;
import java.util.Comparator;

/**
 *
 * @author diegoromero
 */
public class DefaultSorter implements Comparator<T3>{

    @Override
    public int compare(T3 x, T3 y) {
        int startComparison = compare(x.getT2y(), y.getT2y());
        return startComparison != 0 ? startComparison : compare(x.getT2y(), y.getT2y());
    }
    
    private static int compare(Double a, Double b) {
        return a < b ? 1: a > b ? -1: 0;
    }
}
