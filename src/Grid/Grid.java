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
    public void arraylistMatrix() {
        for (Row row : Row.values()) {
            gridList.add(rowList = new ArrayList<GridCell>());
            for (Column column : Column.values()) {
                GridCell temp = new GridCell(row, column);
                rowList.add(temp);
            }
        }
    }

    //create enum Matrix with GridCells in them
    public void enumMatrix(){
        enum grid{
            gridList[0],
            gridList[1],
            gridList[2],
            gridList[3],
            gridList[4],
            gridList[5],
            gridList[6],
            gridList[7],
            gridList[8],
            gridList[9];
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

