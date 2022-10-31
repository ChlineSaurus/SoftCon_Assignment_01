package Grid;

import Boats.FleetManager;
import Boats.FleetManager;
import Exceptions.BoatPlacement.BoatPositionOccupiedException;
import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;

import java.util.ArrayList;
import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Grid {
    protected final FleetManager Fleet;

    public Grid() {
        this.Fleet = new FleetManager();


        for (Row row : Row.values()) {
            gridList.add(rowList = new ArrayList<GridCell>());
            for (Column column : Column.values()) {
                rowList.add(new GridCell());
            }
        }
    }


    /*
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],
            [A,B,C,D,E,F,G,H,I,J],

     */
    static ArrayList<GridCell> rowList = new ArrayList<GridCell>();
    static ArrayList<ArrayList<GridCell>> gridList = new ArrayList<ArrayList<GridCell>>();

    //create ArrayList Matrix with GridCells in them
    public void shoot(CoordinatesTuple c) throws IllegalShotException {
        ArrayList<GridCell> a=gridList.get(c.row.value);
        GridCell temp= a.get(c.column.value);
        if (temp.wasShot()){
            throw new IllegalShotException("You can't shoot twice on a field");
        }
        else{
            temp.isShot();

        }
    }
    public void place(CoordinatesTuple c, CoordinatesTuple e) throws IllegalBoatException {

        if(c.row.equals(e.row)){
            int difference = Math.abs(c.column.value-e.column.value);
            if(c.column.value-e.column.value<0){
                checkDown(c,difference);
                if(Fleet.isAvailable(difference)) {
                    setDown(c, difference);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
            else{
                checkDown(e,difference);
                if(Fleet.isAvailable(difference)) {
                    setDown(c, difference);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
        }
        else{
            int difference = Math.abs(c.row.value-e.row.value);
            if(c.row.value-e.row.value<0){
                checkFlat(c,difference);
                if(Fleet.isAvailable(difference)) {
                    setFlat(c,difference);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
            else{
                checkFlat(e,difference);
                if(Fleet.isAvailable(difference)) {
                    setFlat(c,difference);
                }
                else{
                    throw new IllegalBoatException("You do not have such a boat type");
                }
            }
        }

        // implement set boat
    }
    private void setDown(CoordinatesTuple c, int range){
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            gridList.get(c.column.value).get(i).getBoat();
        }
    }
    private void setFlat(CoordinatesTuple c, int range){
        int col = c.column.value;
        int colRange = col + range;
        for(int i = col;i<colRange;i++){
            gridList.get(c.row.value).get(i).getBoat();
        }

    }

    private void checkDown(CoordinatesTuple c, int range) throws BoatPositionOccupiedException {
        int row = c.row.value;
        int rowRange = row + range;
        for(int i = row;i<rowRange;i++){
            if(gridList.get(c.row.value).get(i).isOccupied()){
                throw new BoatPositionOccupiedException("Sorry your boat place is occupied");
            }
        }
    }
    private  void checkFlat(CoordinatesTuple c, int range) throws BoatPositionOccupiedException {
        int col = c.column.value;
        int colRange = col + range;
        for(int i = col;i<colRange;i++){
            if(gridList.get(c.row.value).get(i).isOccupied()){
                throw new BoatPositionOccupiedException("Sorry your boat place is occupied");
            }

        }
    }


    public Iterator createIterator(){
        return new GridIterator(rowList);
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

