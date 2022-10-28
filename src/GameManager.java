import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.CoordinatesTuple;
import Player.AbstractPlayer;
import Player.type.ComputerPlayer;
import Player.type.HumanPlayer;

import java.util.Random;

public class GameManager {
    private static GameManager uniqueInstance;
    private boolean player1turn;
    AbstractPlayer player1;
    AbstractPlayer player2;

    private GameManager() {
        player1 = new HumanPlayer();
        player2 = new ComputerPlayer();
        }

    public static synchronized GameManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameManager();
        }
        return uniqueInstance;
    }
    public void ManageGame(){
        StartGame();
        GameFlow();
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
            while(currentPlayer.ownFleet.isFleetplaced()) {
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
            if (currentPlayer.ownFleet.isFleetDestroyed()) {
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
