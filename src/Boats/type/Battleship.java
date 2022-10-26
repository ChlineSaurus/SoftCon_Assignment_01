package Boats.type;

import Boats.AbstractBoat;
import Boats.HitpointManager;

public class Battleship extends AbstractBoat {

    public Battleship(){
        hitpoints= HitpointManager.FourHitPoints;
    }

}
