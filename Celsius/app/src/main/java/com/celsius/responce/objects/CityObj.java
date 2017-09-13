package com.celsius.responce.objects;

/**
 * Created by dennisshar on 30/08/2017.
 */

public class CityObj {

    NameObj name;
    CoordObj coord;

    public CityObj(NameObj name, CoordObj coord) {
        this.name = name;
        this.coord = coord;
    }

    public NameObj getName() {
        return name;
    }

    public void setName(NameObj name) {
        this.name = name;
    }

    public CoordObj getCoord() {
        return coord;
    }

    public void setCoord(CoordObj coord) {
        this.coord = coord;
    }
}
