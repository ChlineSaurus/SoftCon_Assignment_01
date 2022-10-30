package Boats;
//Das isch en Vorschlag, aber es chönt glaubs einigi vo eusne Problem Löse
public enum BoatTypes {

    Battleship(2, 4,'B'),
    Carrier(1, 6,'C'),
    PatrolBoat(4, 2,'P'),
    Submarine(3, 3,'S');

    public final Integer boatsAllowed;
    public final Integer startingHitPoints;
    public final Character representationCharacter;
    BoatTypes (Integer boatsAllowed, Integer startingHitPoints, Character representationCharacter) {
        this.boatsAllowed =boatsAllowed;
        this.startingHitPoints = startingHitPoints;
        this.representationCharacter = representationCharacter;
    }
}
