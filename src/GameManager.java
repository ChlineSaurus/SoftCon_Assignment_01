import Exceptions.IllegalBoatException;
import Exceptions.IllegalShotException;
import Grid.Coordinates.CoordinatesTuple;
import Player.AbstractPlayer;
import Player.type.ComputerPlayer;
import Player.type.HumanPlayer;
import UI.Display;

import java.util.List;
import java.util.Random;

public class GameManager {
    private static GameManager uniqueInstance;
    private boolean player1turn;
    private final AbstractPlayer player1;
    private final AbstractPlayer player2;
    private final Display ui;

    private GameManager() {
        player1turn = getStartingPlayer();
        player1 = new HumanPlayer(true);
        player2 = new ComputerPlayer(false);
        ui = new Display();
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
        EndGame();
    }

    private void StartGame(){
        for(int i = 0; i < 2; i++) {
            AbstractPlayer currentPlayer = currentTurn();
            AbstractPlayer currentOpponent = currentOpponent();
            boolean standartDisplay = true;
            while(!currentPlayer.isFleetPlaced()) {
                if(currentPlayer.shouldBeDisplayed && standartDisplay) {
                    String boatsToPlace = boatsNeededToPlace(currentPlayer);
                    String message = boatsToPlace + "Please enter two Coordinates (a Letter and a number) " +
                            "to place a Boat:";
                    ui.display(currentPlayer.DisplayLikeOwn(), currentOpponent.DisplayLikeOpponent(), message);
                }
                try {
                    currentPlayer.placeBoat();
                    standartDisplay = true;
                } catch(IllegalBoatException e) {
                    if (currentPlayer.shouldBeDisplayed) {
                        ui.display(currentPlayer.DisplayLikeOwn(), currentOpponent.DisplayLikeOpponent(),
                                boatsNeededToPlace(currentPlayer) + e.getMessage());
                    }
                    standartDisplay = false;
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
            boolean firstIteration = true;
            while(true) {
                if(currentPlayer.shouldBeDisplayed && firstIteration) {
                    firstIteration = false;
                    String message = "Please enter a Coordinate (a Letter and a number) you want to shoot at:";
                    ui.display(currentPlayer.DisplayLikeOwn(), currentOpponent.DisplayLikeOpponent(), message);
                }
                try {
                    CoordinatesTuple shotPosition = currentPlayer.shoot();
                    currentOpponent.hitOnOwnGrid(shotPosition);
                    break;
                } catch(IllegalShotException e) {
                    if (currentPlayer.shouldBeDisplayed) {
                        ui.display(currentPlayer.DisplayLikeOwn(), currentOpponent.DisplayLikeOpponent(), e.getMessage());
                    }
                }
            }
        }
    }

    private void EndGame(){
        AbstractPlayer winner = currentTurn();
        AbstractPlayer loser = currentOpponent();
        if(winner == player1){
            ui.display(winner.DisplayLikeOwn(), loser.DisplayLikeOwn(),"Player1 has won the game!");
        }
        else {
            ui.display(winner.DisplayLikeOwn(), loser.DisplayLikeOwn(),"Player2 has won the game!");
        }
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

    private String boatsNeededToPlace (AbstractPlayer currentPlayer) {
        String boatsToPlace = "You still need to place:\n";
        for (List<Integer> boatsNotPlaced : currentPlayer.boatsToPlace()){
            boatsToPlace = boatsToPlace.concat(Integer.toString(boatsNotPlaced.get(1)));
            if (boatsNotPlaced.get(1) == 1) {
                boatsToPlace = boatsToPlace.concat(" Boat of length ");
            } else {
                boatsToPlace = boatsToPlace.concat(" Boats of length ");
            }
            boatsToPlace = boatsToPlace.concat(Integer.toString(boatsNotPlaced.get(0))+"\n");
        }
        return boatsToPlace;
    }
}
