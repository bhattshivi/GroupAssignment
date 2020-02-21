/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.utils;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author shivibhatt
 */
public class AscendingMapComparator implements Comparator {

    Map map;

    public AscendingMapComparator(Map map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {

        return ((Integer) map.get(o1)).compareTo((Integer) map.get(o2));

    }
}
