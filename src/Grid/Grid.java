package Grid;

import Boats.Boat;
import Boats.FleetManager;
import Exceptions.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.Coordinates.Column;
import Grid.Coordinates.CoordinatesTuple;
import Grid.Coordinates.Row;
import Grid.DisplayGridcell.DisplayLikeOpponent;
import Grid.DisplayGridcell.DisplayLikeOwn;
import Grid.DisplayGridcell.GridCellDisplayer;
import Grid.Iterator.GridIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid implements Iterable<String>{
    private GridCellDisplayer currentDisplayType;
    private final FleetManager fleet;
    private final ArrayList<ArrayList<GridCell>> gridList;

    public Grid() {
        fleet = new FleetManager();
        gridList = new ArrayList<ArrayList<GridCell>>();
        for (Row row : Row.values()) {
            ArrayList<GridCell> rowList = new ArrayList<GridCell>();
            for (Column column : Column.values()) {
                rowList.add(new GridCell());
            }
            gridList.add(rowList);
        }
        currentDisplayType = new DisplayLikeOpponent();
    }

    public void shoot(CoordinatesTuple c) throws IllegalShotException {
        ArrayList<GridCell> current_row = gridList.get(c.row.value);
        GridCell currentGridCell= current_row.get(c.column.value);
        if (currentGridCell.wasShot()){
            throw new IllegalShotException("You can't shoot at a field that you have already shot on");
        }
        else {
            currentGridCell.isShot();
        }
    }

    public void place(CoordinatesTuple c, CoordinatesTuple e) throws IllegalBoatException {
        if((c.row.value + c.column.value)> (e.row.value+e.column.value)){
            CoordinatesTuple temp = c;
            c=e;
            e = temp;
        }
        if(c.row.equals(e.row)){
            int difference = e.column.value - c.column.value + 1;
            checkFlat(c,difference);
            if(fleet.isAvailable(difference)) {
                Boat boat = fleet.placeBoat(difference);
                assert boat!=null;
                setFlat(c, difference, boat);
            }
            else {
                throw new IllegalBoatException("You do not have such a boat type");
            }
        }
        else {
            int difference = e.row.value - c.row.value + 1;
            checkDown(c,difference);
            if(fleet.isAvailable(difference)) {
                Boat boat = fleet.placeBoat(difference);
                assert boat!=null;
                setDown(c, difference, boat);
            }
            else{
                throw new IllegalBoatException("You do not have such a boat type");
            }
        }
    }

    private void setDown(CoordinatesTuple c, int range, Boat boat){
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            gridList.get(i).get(c.column.value).takeBoat(boat);
        }
    }

    private void setFlat(CoordinatesTuple c, int range,Boat boat){
        int col = c.column.value;
        int colRange = col + range;
        for(int i = col;i<colRange;i++){
            gridList.get(c.row.value).get(i).takeBoat(boat);
        }
    }

    private void checkDown(CoordinatesTuple c, int range) throws IllegalBoatException {
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            if(gridList.get(i).get(c.column.value).isOccupied()){
                throw new IllegalBoatException("You can't place a boat on cells that are already occupied.");
            }
        }
    }

    private  void checkFlat(CoordinatesTuple c, int range) throws IllegalBoatException {
        int col = c.column.value;
        int colRange = col + range;
        for(int i = col;i<colRange;i++){
            if(gridList.get(c.row.value).get(i).isOccupied()){
                throw new IllegalBoatException("You can't place a boat on cells that are already occupied.");
            }
        }
    }

    public void setDisplayLikeOpponent() {
        if (currentDisplayType.getClass() != DisplayLikeOpponent.class) {
            currentDisplayType = new DisplayLikeOpponent();
        }
    }

    public void setDisplayLikeOwn() {
        if (currentDisplayType.getClass() != DisplayLikeOwn.class) {
            currentDisplayType = new DisplayLikeOwn();
        }
    }

    public Iterator<String> iterator(){
        return new GridIterator(gridList, currentDisplayType);
    }

    public boolean isFleetPlaced() {
        return fleet.isFleetPlaced();
    }

    public boolean isFleetDestroyed() {
        return fleet.isFleetDestroyed();
    }

    public List<List<Integer>> boatsToPlace() {
        return fleet.BoatsToBePlaced();
    }
}

