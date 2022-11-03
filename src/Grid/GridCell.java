package Grid;

import Boats.Boat;

public class GridCell {
    private Boat boat;
    private boolean wasShot;
    private boolean isOccupied;

    public GridCell(){
        isOccupied = false;
        wasShot = false;
    }

    public void takeBoat(Boat boat) {
        assert (!isOccupied);
        assert boat!=null;
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
}
