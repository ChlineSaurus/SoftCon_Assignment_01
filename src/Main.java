import Exceptions.BoatPlacement.BoatPositionOccupiedException;
import Exceptions.IllegalShotException;
import Grid.*;
import Boats.FleetManager;
import UI.Display;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {


        FleetManager fleet=new FleetManager();
        System.out.println(fleet.BoatsToBePlaced());

    GameManager gameManager = GameManager.getInstance();
    gameManager.ManageGame();
    exit(0);
    }
}
