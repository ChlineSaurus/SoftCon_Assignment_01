package Grid;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Grid {
    public int getDistance(GridCell a, GridCell b){
        int columDelta=abs(a.GetColumnIndex()-b.GetColumnIndex());
        int rowDelta=abs(a.GetRowIndex()-b.GetRowIndex());
        //this function to check if the distance of the user is valid for instance
        if (columDelta!=0 && rowDelta!=0){
            //error Message
        }
        return max(columDelta,rowDelta);

    }


}
