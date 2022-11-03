package Boats;

import java.util.*;

public class FleetManager {
    private final List<Boat> fleet;

    public FleetManager(){
        fleet = new ArrayList<Boat>();
        for (BoatTypes currentBoatType: BoatTypes.values()){
            int allowed = currentBoatType.boatsAllowed;
            HitpointManager hitPoints = HitpointManager.valueOf(currentBoatType.startingHitPoints);
            for (int i=0;i<allowed;i++){
                Boat temp = new Boat(hitPoints, currentBoatType.representationCharacter);
                fleet.add(temp);
            }
        }
    }

    public Boat placeBoat(int length) {
        assert isAvailable(length);
        for (Boat boat:fleet){
            if (!boat.isPlaced && boat.hitPoints.getHitpointValue()==length) {
                boat.place();
                return boat;
            }
        }
        //the function is never going to return null because of the assertion
        //however it needs to return null or else it won't compile
        return null;
    }

    public boolean isAvailable(int length) {
        for (Boat temp : fleet) {
            if (!temp.isPlaced && temp.hitPoints.getHitpointValue() == length) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> BoatsToBePlaced() {
        List<List<Integer>> required=new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Boat boat:fleet){
            if (!boat.isPlaced){
                int length=boat.getHitPoints();
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

    public boolean isFleetPlaced() {
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