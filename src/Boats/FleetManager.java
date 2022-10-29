package Boats;

import Boats.type.Carrier;
import Exceptions.IllegalUserInputException;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FleetManager {
     private List<AbstractBoat> fleet=new ArrayList<>();
    private AllowedBoats allowedCarrier=AllowedBoats.One;
    private AllowedBoats allowedBattleships=AllowedBoats.Two;
    private AllowedBoats allowedSubmarines=AllowedBoats.Three;
    private AllowedBoats allowedPatrolBoats=AllowedBoats.Four;
     HashMap<Integer,AllowedBoats> legalCheckerMap=new HashMap<>();
    HashMap<Integer, String> hash_map = new HashMap<Integer, String>();


    // Add keys and values (Country, City)

     public boolean isLegalSize(int length){
         assert length>=0;
         if (legalCheckerMap.get(length)!=AllowedBoats.Zero){
             return true;
         }
         return false;


     }


    public void addBoat (AbstractBoat a){
         //check
        int max = 10;
        assert fleet.size()< max;
         fleet.add(a);
     }

     private List<AllowedBoats> requiredBoats=new ArrayList<>();






    //list die sagt was man noch setzen muss

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
