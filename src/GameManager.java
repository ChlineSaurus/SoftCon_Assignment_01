import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.CoordinatesTuple;
import Player.AbstractPlayer;
import Player.type.ComputerPlayer;
import Player.type.HumanPlayer;
import UI.Display;

import java.util.Random;

public class GameManager {
    private static GameManager uniqueInstance;
    private boolean player1turn;
    private final AbstractPlayer player1;
    private final AbstractPlayer player2;
    private final Display UI;

    private GameManager() {
        player1 = new HumanPlayer(true);
        player2 = new ComputerPlayer(false);
        UI = new Display();
        }


    public static synchronized GameManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameManager();
        }
        return uniqueInstance;
    }
    public void ManageGame(){
        StartGame();
        //GameFlow();
    }

    private boolean getStartingPlayer() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private AbstractPlayer currentTurn() {
        if (player1turn) {
            player1turn = false;
            return player1;
        }
        player1turn = true;
        return player2;
    }

    private AbstractPlayer currentOpponent() {
        if (player1turn) {
            return player1;
        }
        return player2;
    }

    private void StartGame(){
        for(int i = 0; i < 2; i++) {
            AbstractPlayer currentPlayer = currentTurn();
            while(currentPlayer.isFleetPlaced()) {
                try {
                    currentPlayer.placeBoat();
                } catch(IllegalBoatException e) {
                    if (currentPlayer.shouldBeDisplayed) {
                        //display with text e
                    }
                }
            }
        }

    }
    private void GameFlow(){
        while(true) {
            AbstractPlayer currentPlayer = currentTurn();
            AbstractPlayer currentOpponent = currentOpponent();
            if (currentPlayer.isFleetDestroyed()) {
                break;
            }
            while(true) {
                try {
                    CoordinatesTuple shotPosition = currentPlayer.shoot();
                    currentOpponent.hitOnOwnGrid(shotPosition);
                    break;
                } catch(IllegalShotException e) {
                    if (currentPlayer.shouldBeDisplayed) {
                        //display grids with the message e passed by the exception
                    }
                }
            }
        }
        //display in special way, the player that is the currentPlayer is the winner
    }
}
