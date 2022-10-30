package Boats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.abs;


public class FleetManager {
    private List<Boat> fleet=new ArrayList<>();
    private AllowedBoats allowedCarrier=AllowedBoats.One;
    private AllowedBoats allowedBattleships=AllowedBoats.Two;
    private AllowedBoats allowedSubmarines=AllowedBoats.Three;
    private AllowedBoats allowedPatrolBoats=AllowedBoats.Four;












    public void addBoat (Boat a){
         //check
        int max = 10;
        assert fleet.size()< max;
         fleet.add(a);
     }

     private List<AllowedBoats> requiredBoats=new ArrayList<>();


    public boolean isavailabe (int length){
        int len=abs(length);
        for (int i=0;i<requiredBoats.size();i++){
            Boat temp=fleet.get(i);
            if (!temp.isPlaced && temp.hitpoints.getHitpointValue()==length){
                return true;
            }
        }
        return false;
    }




    //list die sagt was man noch setzen muss

    public FleetManager(){
        for (BoatTypes boat: BoatTypes.values()){
            int allowed=boat.boatsAllowed;
            for (int i=0;i<allowed;i++){
                Boat temp=new Boat(boat.startingHitPoints, boat.representationCharacter);
                fleet.add(temp);
            }
        }
    }



    public boolean isFleetplaced(){
        return allowedCarrier == AllowedBoats.Zero && allowedBattleships == AllowedBoats.Zero && allowedSubmarines == AllowedBoats.Zero && allowedPatrolBoats == AllowedBoats.Zero;
    }




    public boolean isFleetDestroyed(){
        int i=0;

        while (fleet.size()>i){

            if (!fleet.get(i).isSunk()){
                return false;
            }
            i++;
        }
        return true;
    }


}
