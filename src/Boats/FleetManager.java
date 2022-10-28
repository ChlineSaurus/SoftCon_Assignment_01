package Boats;

import Boats.type.Carrier;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {
     private List<AbstractBoat> fleet=new ArrayList<>();

    public void addBoat (AbstractBoat a){
         //check
        int max = 10;
        assert fleet.size()< max;
         fleet.add(a);
     }


    private AllowedBoats allowedCarrier=AllowedBoats.One;
    private AllowedBoats allowedBattleships=AllowedBoats.Two;
    private AllowedBoats allowedSubmarines=AllowedBoats.Three;
    private AllowedBoats allowedPatrolBoats=AllowedBoats.Four;


    public FleetManager(){
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
