package Player;

import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.CoordinatesTuple;

import java.util.ArrayList;

public abstract class AbstractPlayer {
    //private Grid ownGrid() = new Grid;
    //private Grid targetGrid() = new Grid;
    //private fleet ownFleet() = new fleet;
    public boolean shouldBeDisplayed = true;

    public CoordinatesTuple shoot() throws IllegalShotException {
        return getShotPosition();
    }

    public void hitOnOwnGrid(CoordinatesTuple hitPosition) throws IllegalShotException {
        //shotAtGrid();
    }

    public void placeBoat() throws IllegalBoatException {
        ArrayList<CoordinatesTuple> boatPosition = getBoatPosition();
        //ownGrid.placeBoat(boatPosition)
    };

    protected abstract ArrayList<CoordinatesTuple> getBoatPosition();

    protected abstract CoordinatesTuple getShotPosition();

}
