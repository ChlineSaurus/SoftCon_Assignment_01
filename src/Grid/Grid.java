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
    ArrayList<GridCell> rowList = new ArrayList<GridCell>();
    ArrayList<ArrayList<GridCell>> gridList = new ArrayList<ArrayList<GridCell>>();

    //create 2D-List with 10 rows and GridCells in them
    public void newGrid() {
        for (Row row : Row.values()) {
            gridList.add(rowList = new ArrayList<GridCell>());
            for (Column column : Column.values()) {
                GridCell temp = new GridCell(row, column);
                rowList.add(temp);
            }
        }
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

