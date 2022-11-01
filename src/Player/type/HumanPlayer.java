package Player.type;

import Exceptions.BoatPlacement.IllegalBoatException;
import Exceptions.IllegalShotException;
import Exceptions.IllegalUserInputException;
import Grid.Coordinates.Column;
import Grid.Coordinates.CoordinatesTuple;
import Grid.Coordinates.Row;
import Player.AbstractPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    private final Scanner scanner;

    public HumanPlayer(boolean shouldBeDisplayed) {
        super(shouldBeDisplayed);
        scanner = new Scanner(System.in);
    }

    private String takeInput() {
        return scanner.nextLine();
    }

    private CoordinatesTuple inputToCoordinatesTuple(String input) throws IllegalUserInputException {
        if (input.length() != 2) {
            throw new IllegalUserInputException("Your input hasn't had the right length!");
        }
        String uppercaseInput = input.toUpperCase();
        Row row;
        Column column;
        try {
            row = Row.valueOf("R" + uppercaseInput.charAt(0));
            column = Column.valueOf(Character.toString(uppercaseInput.charAt(1)));
        } catch (IllegalArgumentException e1) {
            try {
                row = Row.valueOf("R" + uppercaseInput.charAt(1));
                column = Column.valueOf(Character.toString(uppercaseInput.charAt(0)));
            } catch (IllegalArgumentException e2) {
                throw new IllegalUserInputException("Your input was not in the right form: Please give the game a " +
                        "Letter from A-J and a Number from 0-1");
            }
        }
        return new CoordinatesTuple(row, column);
    }

    @Override
    protected ArrayList<CoordinatesTuple> getBoatPosition() throws IllegalBoatException {
        ArrayList<CoordinatesTuple> boatCoordinates = new ArrayList<CoordinatesTuple>();
        String input = takeInput();
        input = input.replaceAll("\\s", "");
        input = input.replaceAll(",", "");
        if(input.length() != 4) {
            throw new IllegalBoatException("Your Input for the Boat had a strange length, please give two Positions");
        }
        try {
            boatCoordinates.add(inputToCoordinatesTuple(input.substring(0,2)));
            boatCoordinates.add(inputToCoordinatesTuple(input.substring(2,4)));
        } catch (IllegalUserInputException e) {
            throw new IllegalBoatException("Your input was not in the right form: Please give the game two pairs of " +
                    "a Uppercase Letter from A-J and a Number from 0-1");
        }
        if (boatCoordinates.get(0).column != boatCoordinates.get(1).column &&
                boatCoordinates.get(0).row != boatCoordinates.get(1).row) {
            throw new IllegalBoatException("Your Boat was less straight than Freddie Mercury: Please give the game" +
                    "Coordinates that are in a line.");
        }
        return boatCoordinates;
    }

    @Override
    protected CoordinatesTuple getShotPosition() throws IllegalShotException {
        try {
            return inputToCoordinatesTuple(takeInput());
        } catch (IllegalUserInputException e) {
            throw new IllegalShotException(e.getMessage());
        }
    }
}
