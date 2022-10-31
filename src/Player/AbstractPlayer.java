package Player;

import Boats.FleetManager;
import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.CoordinatesTuple;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer {
    //private Grid ownGrid() = new Grid;
    //private Grid targetGrid() = new Grid;


    public final boolean shouldBeDisplayed;
    protected final FleetManager ownFleet;
    protected AbstractPlayer(boolean shouldBeDisplay) {
        this.shouldBeDisplayed = shouldBeDisplay;
        this.ownFleet = new FleetManager();
    }
    public CoordinatesTuple shoot() throws IllegalShotException {
        return getShotPosition();
    }

    public void hitOnOwnGrid(CoordinatesTuple hitPosition) throws IllegalShotException {
        //shotAtGrid();
    }

    public void placeBoat() throws IllegalBoatException {
        ArrayList<CoordinatesTuple> boatPosition = getBoatPosition();
        //ownGrid.placeBoat(boatPosition)
    }

    public boolean isFleetPlaced() {
        return ownFleet.isFleetplaced();
    }

    public List<List<Integer>> boatsToPlace() {
        return ownFleet.BoatsToBePlaced();
    }

    public boolean isFleetDestroyed() {
        return ownFleet.isFleetDestroyed();
    }

    protected abstract ArrayList<CoordinatesTuple> getBoatPosition() throws IllegalBoatException;

    protected abstract CoordinatesTuple getShotPosition() throws IllegalShotException;

}
