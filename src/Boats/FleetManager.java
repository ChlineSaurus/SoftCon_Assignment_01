package Boats;


import java.util.*;

import static java.lang.Math.abs;


public class FleetManager {
    private List<Boat> fleet=new ArrayList<>();




    public FleetManager(){
        for (BoatTypes boat: BoatTypes.values()){
            int allowed=boat.boatsAllowed;
            HitpointManager hitpoints=HitpointManager.valueOf(boat.startingHitPoints);
            for (int i=0;i<allowed;i++){
                Boat temp=new Boat(hitpoints, boat.representationCharacter);
                fleet.add(temp);
            }
        }
    }
    public Boat placeBoat(int length){
        assert isAvailable(length);
        for (Boat boat:fleet){
            if (!boat.isPlaced &&boat.hitpoints.getHitpointValue()==length){
                boat.place();
                return boat;
            }
        }
        return null;
    }

    public boolean isAvailable(int length){
        int len=abs(length);
        for (Boat temp : fleet) {
            if (!temp.isPlaced && temp.hitpoints.getHitpointValue() == length) {
                return true;
            }
        }
        return false;
    }

    //list die sagt was man noch setzen muss


    public List<List<Integer>> BoatsToBePlaced(){


        List<List<Integer>> required=new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Boat boat:fleet){
            if (!boat.isPlaced){
                int length=boat.gethitpoints();
                if (map.containsKey(length)){
                    map.put(length, map.get(length) + 1);
                }
                else{
                    map.put(length,1);
                }
            }
        }
        List<Integer> keys=new ArrayList<Integer>(map.keySet());
        List<Integer> values=new ArrayList<Integer>(map.values());
        for (int i=0;i< keys.size();i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(keys.get(i));
            temp.add(values.get(i));
            required.add(temp);
        }
        return required;


    }

    public boolean isFleetplaced(){
        for (Boat boat : fleet) {
            if (!boat.isPlaced) {
                return false;
            }
        }
        return true;
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
