package Boats;

import java.util.HashMap;
import java.util.Map;

public abstract class  AbstractBoat {
     protected enum HitpointManager{
         ZeroHitPoints(0),

         OneHitPoint(1),
         TwoHitPoints(2),
         ThreeHitPoints(3),
         FourHitPoints(4),
         FiveHitPoints(5);
         private final int value;
         private static Map map = new HashMap<>();
         HitpointManager(int value){
             this.value=value;
         }

         static {
             for (HitpointManager HITPOINTCLASS : HitpointManager.values()) {
                 map.put(HITPOINTCLASS.value, HITPOINTCLASS);
             }

         }
         public static HitpointManager valueOf(int value) {
             return (HitpointManager) map.get(value);
         }
         private int getHitpointValue(){
             return value;
         }
    }

    protected HitpointManager hitpoints;


    public boolean isSunk(){
        return hitpoints == HitpointManager.ZeroHitPoints;
    }
    public void isHit(){
        assert !isSunk();
        hitpoints=HitpointManager.valueOf(hitpoints.getHitpointValue()-1);
    }

}
