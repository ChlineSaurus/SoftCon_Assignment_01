package Grid;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Grid {

    public Grid() {

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
    public void shoot(CoordinatesTuple c){
        ArrayList<GridCell> a=gridList.get(c.row.value);
        GridCell temp= a.get(c.column.value);
        if (temp.WasShot()){
            //create Error
        }
        else{
            //to do wasshot to false

        }
    }
    public void arraylistMatrix() {
        for (Row row : Row.values()) {
            gridList.add(rowList = new ArrayList<GridCell>());
            for (Column column : Column.values()) {
                GridCell temp = new GridCell();
                rowList.add(temp);
            }
        }
    }

    //create enum Matrix with GridCells in them






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

