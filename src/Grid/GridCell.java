package Grid;

import Boats.Boat;
import org.apache.avro.JsonProperties;

public class GridCell {
    private Boat boat;
    private boolean wasShot = false;

    //know if boat is on it
    private boolean isOccupied = false;

    public void takeBoat(Boat boat) {
        assert (!isOccupied);
        isOccupied = true;
        this.boat = boat;
    }

    public Boat getBoat() {
        return boat;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean wasShot() {
        return wasShot;
    }
    public void isShot(){
        wasShot = true;
        if (wasShot()){
            if (boat!= null){
                boat.isHit();

            }

        }
    }


    public GridCell(){

    }




}
