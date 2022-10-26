package Player;

public abstract class AbstractPlayer {
    //private Grid ownGrid() = new Grid;
    //private Grid targetGrid() = new Grid;
    //private fleet ownFleet() = new fleet;

    boolean validBoatPosition() {
        return true;
    }

    void shoot() {

    }

    void placeBoat() {

    }

    protected abstract int getPosition();

}
