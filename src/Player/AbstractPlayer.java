package Player;

import Exceptions.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.Coordinates.CoordinatesTuple;
import Grid.DisplayGridcell.DisplayLikeOpponent;
import Grid.DisplayGridcell.DisplayLikeOwn;
import Grid.DisplayGridcell.GridCellDisplayer;
import Grid.Grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractPlayer {
    protected static GridCellDisplayer displayLikeOwn = new DisplayLikeOwn();
    protected static GridCellDisplayer displayLikeOpponent = new DisplayLikeOpponent();
    public final boolean shouldBeDisplayed;
    protected final Grid ownGrid;

    protected AbstractPlayer(boolean shouldBeDisplay) {
        this.shouldBeDisplayed = shouldBeDisplay;
        this.ownGrid = new Grid();

    }

    public CoordinatesTuple shoot() throws IllegalShotException {
        return getShotPosition();
    }

    public void hitOnOwnGrid(CoordinatesTuple hitPosition) throws IllegalShotException {
        ownGrid.shoot(hitPosition);
    }

    public void placeBoat() throws IllegalBoatException {
        ArrayList<CoordinatesTuple> boatPosition = getBoatPosition();
        ownGrid.place(boatPosition.get(0), boatPosition.get(1));
    }

    public boolean isFleetPlaced() {
        return ownGrid.isFleetPlaced();
    }

    public List<List<Integer>> boatsToPlace() {
        return ownGrid.boatsToPlace();
    }

    public boolean isFleetDestroyed() {
        return ownGrid.isFleetDestroyed();
    }

    protected abstract ArrayList<CoordinatesTuple> getBoatPosition() throws IllegalBoatException;

    protected abstract CoordinatesTuple getShotPosition() throws IllegalShotException;

    public Iterator<String> DisplayLikeOpponent() {
        return ownGrid.iterator(displayLikeOpponent);
    }

    public Iterator<String> DisplayLikeOwn() {
        return ownGrid.iterator(displayLikeOwn);
    }
}
