import Exceptions.BoatPlacement.BoatPositionOccupiedException;
import Exceptions.IllegalShotException;
import Grid.*;
import UI.Display;


import java.awt.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){



    GameManager gameManager = GameManager.getInstance();
    gameManager.ManageGame();
    exit(0);
    }
}
