package Player;

import Boats.FleetManager;
import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.CoordinatesTuple;

import java.util.ArrayList;

public abstract class AbstractPlayer {
    //private Grid ownGrid() = new Grid;
    //private Grid targetGrid() = new Grid;
    public FleetManager ownFleet = new FleetManager();
    public final boolean shouldBeDisplayed = false;

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

    protected abstract ArrayList<CoordinatesTuple> getBoatPosition() throws IllegalBoatException;

    protected abstract CoordinatesTuple getShotPosition() throws IllegalShotException;
}
