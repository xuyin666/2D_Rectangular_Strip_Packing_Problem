package com.ensimag.Models;

/**
 * Created by solokwal on 2/20/20.
 */
public class PlateWithCoords extends Plate{
    private int x;
    private int y;

    public PlateWithCoords(Plate _plate,int _x, int _y) {
        super(_plate.getH(), _plate.getW());
        this.x = _x;
        this.y = _y;
    }

    public PlateWithCoords(int _h, int _w,int _x, int _y) {
        super(_h, _w);
        this.x = _x;
        this.y = _y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
