package Boats;

import java.util.HashMap;
import java.util.Map;

public abstract class  AbstractBoat {
     protected enum hitpointmanager{
         ZEROHITPOINTS(0),
         ONEHITPOINT(1),
         TWOHITPOINTS(2),
         THREEHITPOINTS(3),
         FOURHITPOINTS(4),
         FIVEHITPOINTS(5);
         private final int value;
         private static Map map = new HashMap<>();
         hitpointmanager(int hitpoints){
             this.value=hitpoints;
         }

         static {
             for (hitpointmanager HITPOINTCLASS : hitpointmanager.values()) {
                 map.put(HITPOINTCLASS.value, HITPOINTCLASS);
             }

         }
         public static hitpointmanager valueOf(int hitpoints) {
             return (hitpointmanager) map.get(hitpoints);
         }
         int getHitpoints(){
             return value;
         }
    }
    public int currenthitpoints(){
         return hitpoints.getHitpoints();
    }

    protected hitpointmanager hitpoints;

    // I'm a
    // boat



    public boolean issunk(){
        return hitpoints == hitpointmanager.ZEROHITPOINTS;
    }
    //in order that ishit is called one first must recieve the information from the grid make this function private sothat the it isn't absued
    public void isHit(){
        assert issunk()!=true;

        hitpoints=hitpointmanager.valueOf(hitpoints.getHitpoints()-1);
    }

}
