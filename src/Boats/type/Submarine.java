package Boats.type;

import Boats.AbstractBoat;
import Boats.HitpointManager;


public class Submarine extends AbstractBoat {
    public Submarine(){
        hitpoints= HitpointManager.ThreeHitPoints;
        sunkLetter='S';
    }
}

