package Exceptions.BoatPlacement;

public class IllegalBoatPositionException extends IllegalBoatException{
    public IllegalBoatPositionException(String errorMessage) {
        super(errorMessage);
    }
}
