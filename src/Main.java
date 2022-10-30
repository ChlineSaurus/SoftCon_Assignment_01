import Boats.FleetManager;
import UI.Display;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {


        FleetManager fleet=new FleetManager();
        System.out.println(fleet.BoatsToBePlaced());
        fleet.placeBoat(2);
        System.out.println(fleet.BoatsToBePlaced());
        fleet.placeBoat(6);
        System.out.println(fleet.BoatsToBePlaced());
    }
}
