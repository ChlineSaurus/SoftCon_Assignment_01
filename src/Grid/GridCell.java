package Grid;

import Boats.Boat;
import org.apache.avro.JsonProperties;

public class GridCell {



    //know if cell has a boat on it
    public Boat t;
    private boolean wasShot = false;

    //know if boat is on it
    private boolean isOccupied = false;

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean WasShot() {
        return wasShot;
    }
    public void isShot(){
        if (WasShot()){
            if (t!= null){
                t.isHit();
            }

        }
    }


    public GridCell(){

    }




}
