package Boats.type;

import Boats.AbstractBoat;
import Boats.HitpointManager;

public class Carrier extends AbstractBoat {
    public Carrier(){
        hitpoints= HitpointManager.FiveHitPoints;
    }
}
