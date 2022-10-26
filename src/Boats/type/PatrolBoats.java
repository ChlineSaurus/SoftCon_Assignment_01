package Boats.type;

import Boats.AbstractBoat;
import Boats.HitpointManager;

public class PatrolBoats extends AbstractBoat {
    public PatrolBoats(){
        hitpoints= HitpointManager.TwoHitPoints;
    }
}
