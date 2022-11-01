package Boats;

public enum BoatTypes {

    Carrier(1, 6,'C'),
    Battleship(2, 4,'B'),
    Submarine(3, 3,'S'),
    PatrolBoat(4, 2,'P');

    public final Integer boatsAllowed;
    public final Integer startingHitPoints;
    public final Character representationCharacter;

    BoatTypes (Integer boatsAllowed, Integer startingHitPoints, Character representationCharacter) {
        this.boatsAllowed =boatsAllowed;
        this.startingHitPoints = startingHitPoints;
        this.representationCharacter = representationCharacter;
    }
}
