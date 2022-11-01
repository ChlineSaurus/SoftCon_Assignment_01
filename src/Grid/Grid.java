package Grid;

import Boats.Boat;
import Boats.FleetManager;
import Exceptions.BoatPlacement.BoatPositionOccupiedException;
import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.DisplayGridcell.GridCellDisplayer;
import java.util.ArrayList;

public class Grid{
    private final FleetManager fleet;
    private final ArrayList<ArrayList<GridCell>> gridList;

    public Grid(FleetManager fleet) {
        this.fleet = fleet;
        this.gridList = new ArrayList<ArrayList<GridCell>>();
        for (Row row : Row.values()) {
            ArrayList<GridCell> rowList = new ArrayList<GridCell>();
            for (Column column : Column.values()) {
                rowList.add(new GridCell());
            }
            gridList.add(rowList);
        }
    }


    //create ArrayList Matrix with GridCells in them
    public void shoot(CoordinatesTuple c) throws IllegalShotException {
        ArrayList<GridCell> current_row = gridList.get(c.row.value);
        GridCell currentGridCell= current_row.get(c.column.value);
        if (currentGridCell.wasShot()){
            throw new IllegalShotException("You can't shoot twice on a field");
        }
        else{
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
            int difference = Math.abs(c.column.value-e.column.value)+1;
            if(c.column.value-e.column.value<0){
                checkFlat(c,difference);
                if(fleet.isAvailable(difference)) {
                    Boat boat = fleet.placeBoat(difference);
                    setFlat(c, difference, boat);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
        }
        else{
            int difference = Math.abs((c.row.value-e.row.value));
            checkFlat(c,difference);
            if(fleet.isAvailable(difference)) {
                Boat boat = fleet.placeBoat(difference);
                setFlat(c, difference, boat);
            }
            else{
                throw new IllegalBoatException("You do not have such a boat type");
            }
        }
        /*
        else{
            int difference = Math.abs(c.row.value-e.row.value)+1;
            if(c.row.value-e.row.value<0){
                checkDown(c,difference);
                if(fleet.isAvailable(difference)) {
                    Boat boat = fleet.placeBoat(difference);
                    setDown(c, difference, boat);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
            else{
                checkDown(e,difference);
                if(fleet.isAvailable(difference)) {
                    Boat boat = fleet.placeBoat(difference);
                    setDown(e, difference, boat);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
        }*/

    }
    private void setDown(CoordinatesTuple c, int range, Boat boat){
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            System.out.println(i);
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

    private void checkDown(CoordinatesTuple c, int range) throws BoatPositionOccupiedException {
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            if(gridList.get(i).get(c.column.value).isOccupied()){
                throw new BoatPositionOccupiedException("Sorry, your boat place is occupied");
            }
        }
    }
    private  void checkFlat(CoordinatesTuple c, int range) throws BoatPositionOccupiedException {
        int col = c.column.value;
        int colRange = col + range;
        for(int i = col;i<colRange;i++){
            if(gridList.get(c.row.value).get(i).isOccupied()){
                throw new BoatPositionOccupiedException("Sorry, your boat place is occupied");
            }

        }
    }


    public Iterator iterator(GridCellDisplayer gridCellDisplayer){
        return new GridIterator(gridList, gridCellDisplayer);
    }

        /*public int getDistance (GridCell a, GridCell b){
            int columDelta = abs(a.GetColumnIndex() - b.GetColumnIndex());
            int rowDelta = abs(a.GetRowIndex() - b.GetRowIndex());
            //this function to check if the distance of the user is valid for instance
            if (columDelta != 0 && rowDelta != 0) {
                //error Message
            }
            return max(columDelta, rowDelta);

         */


}

