package com.ensimag.Models;

import java.util.Comparator;

/**
 * Created by solokwal on 2/21/20.
 */
public class SortByCoords implements Comparator<PlateWithCoords> {
    public int compare(PlateWithCoords p1, PlateWithCoords p2) {
        if(p1.getX()>p2.getX()) {
            return 1;
        }
        else if(p1.getX() == p2.getX() && p1.getY()>p2.getY()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}