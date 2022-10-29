package Grid;

import Boats.AbstractBoat;
import Boats.type.Battleship;


public class GridCell {
    private final Row row;
    private final Column column;

    //know if cell has a boat on it
    boolean wasShot = false;

    //know if boat is on it
    boolean isOccupied = false;



    public GridCell(Row a, Column b){
        this.row=a;
        this.column=b;
    }
    protected Integer GetRowIndex(){
        return row.value;
    }
    protected Integer GetColumnIndex(){
        return column.value;
    }

}
