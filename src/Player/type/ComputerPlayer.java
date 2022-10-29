package Player.type;

import Grid.Column;
import Grid.CoordinatesTuple;
import Grid.Row;
import Player.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    private static final Row[] rowEnum = Row.values();
    private static final int rowLength = rowEnum.length;
    private static final Column[] columnEnum = Column.values();
    private static final int columnLength = rowEnum.length;
    public final boolean shouldBeDisplayed;

    public ComputerPlayer(boolean shouldBeDisplayed) {
        this.shouldBeDisplayed = shouldBeDisplayed;
    }

    private static CoordinatesTuple randomPosition() {
        int randomRowIndex = new Random().nextInt(rowLength);
        int randomColumnIndex = new Random().nextInt(columnLength);
        return new CoordinatesTuple(rowEnum[randomRowIndex], columnEnum[randomColumnIndex]);
    }
    @Override
    protected ArrayList<CoordinatesTuple> getBoatPosition() {
        ArrayList<CoordinatesTuple> boatCoordinates = new ArrayList<CoordinatesTuple>();

        boatCoordinates.add(randomPosition());

        return boatCoordinates;
    }
    @Override
     protected CoordinatesTuple getShotPosition() {
        return randomPosition();
    }
}
