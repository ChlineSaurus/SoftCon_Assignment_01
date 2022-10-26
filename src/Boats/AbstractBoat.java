package Boats;

import java.util.HashMap;
import java.util.Map;

public abstract class  AbstractBoat {


    protected HitpointManager hitpoints;


    public boolean isSunk(){
        return hitpoints == HitpointManager.ZeroHitPoints;
    }
    public void isHit(){
        assert !isSunk();
        hitpoints=HitpointManager.valueOf(hitpoints.getHitpointValue()-1);
    }

}
