package Boats;
//Das isch en Vorschlag, aber es chönt glaubs einigi vo eusne Problem Löse
public enum BoatTypes {

    Battleship(2, HitpointManager.FourHitPoints,'B'),
    Carrier(1, HitpointManager.FiveHitPoints,'C'), //müest 6 Hitpoints ha
    PatrolBoat(4, HitpointManager.TwoHitPoints,'P'),
    Submarine(3, HitpointManager.ThreeHitPoints,'S');

    public final Integer boatsAllowed;
    public final HitpointManager startingHitPoints;
    public final Character representationCharacter;
    BoatTypes (Integer boatsAllowed, HitpointManager startingHitPoints, Character representationCharacter) {
        this.boatsAllowed =boatsAllowed;
        this.startingHitPoints = startingHitPoints;
        this.representationCharacter = representationCharacter;
    }
}
