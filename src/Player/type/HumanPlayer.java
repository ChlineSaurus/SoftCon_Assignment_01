package Player.type;

import Exceptions.IllegalUserInputException;
import Grid.Column;
import Grid.CoordinatesTuple;
import Grid.Row;
import Player.AbstractPlayer;

import java.util.ArrayList;

public class HumanPlayer extends AbstractPlayer {
    public boolean shouldBeDisplayed = true;
    
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
                row = Row.valueOf("R" + uppercaseInput.charAt(0));
                column = Column.valueOf(Character.toString(uppercaseInput.charAt(0)));
            } catch (IllegalArgumentException e2) {
                throw new IllegalUserInputException("Your input was not in the right form: Please give the game a " +
                        "Uppercase Letter from A-J and a Number from 0-1");
            }
        }
        return new CoordinatesTuple(row, column);
    } 

    @Override
    protected ArrayList<CoordinatesTuple> getBoatPosition() {
        ArrayList<CoordinatesTuple> boatCoordinates = new ArrayList<CoordinatesTuple>();
        boatCoordinates.add(new CoordinatesTuple(Row.R0, Column.C));

        return boatCoordinates;
    }

    @Override
    protected CoordinatesTuple getShotPosition() {
        //throws IllegalUserInputException
        return new CoordinatesTuple(Row.R0, Column.C);
        //inputToCoordinatesTuple(s);
    }

}
