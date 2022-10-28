package Player;

import Grid.CoordinatesTuple;

public abstract class AbstractPlayer {
    //private Grid ownGrid() = new Grid;
    //private Grid targetGrid() = new Grid;
    //private fleet ownFleet() = new fleet;

    boolean validBoatPosition() {
        return true;
    }

    public void shoot() {
        while(true) {
            CoordinatesTuple coordinates = getPosition();
            //shoot at Grid or GridCell
            break;
        }

        }

    public void placeBoat(CoordinatesTuple A, CoordinatesTuple B) {

    }


    protected abstract CoordinatesTuple getPosition();

}
