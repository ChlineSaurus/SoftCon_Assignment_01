package Exceptions.BoatPlacement;

public class BoatPositionOccupiedException extends IllegalBoatException{
    public BoatPositionOccupiedException(String errorMessage) {
        super(errorMessage);
    }
}
