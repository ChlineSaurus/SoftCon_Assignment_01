package Player.type;

import Grid.Column;
import Grid.CoordinatesTuple;
import Grid.Row;
import Player.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    private final Row[] rowEnum;
    private final int rowLength;
    private final Column[] columnEnum;
    private final int columnLength;
    private final Random random;

    public ComputerPlayer(boolean shouldBeDisplayed) {
        super(shouldBeDisplayed);
        random = new Random();
        rowEnum = Row.values();
        rowLength = rowEnum.length;
        columnEnum = Column.values();
        columnLength = rowEnum.length;
    }

    private CoordinatesTuple randomPosition() {
        int randomRowIndex = random.nextInt(rowLength);
        int randomColumnIndex = random.nextInt(columnLength);
        return new CoordinatesTuple(rowEnum[randomRowIndex], columnEnum[randomColumnIndex]);
    }

    @Override
    protected ArrayList<CoordinatesTuple> getBoatPosition() {
        ArrayList<CoordinatesTuple> boatCoordinates = new ArrayList<CoordinatesTuple>();
        int boatLength = ownFleet.BoatsToBePlaced().get(0).get(0);
        while(true){
            CoordinatesTuple firstBoatPosition = randomPosition();
            Column secondBoatColumn;
            Row secondBoatRow;
            int direction = random.nextInt(4);
            if (direction == 0) {
                secondBoatColumn = Column.valueOf(firstBoatPosition.column.value + (boatLength - 1));
                secondBoatRow = firstBoatPosition.row;
            } else if (direction == 1) {
                secondBoatColumn = Column.valueOf(firstBoatPosition.column.value - (boatLength - 1));
                secondBoatRow = firstBoatPosition.row;
            } else if (direction == 2) {
                secondBoatColumn = firstBoatPosition.column;
                secondBoatRow = Row.valueOf(firstBoatPosition.row.value + (boatLength - 1));
            } else {
                secondBoatColumn = firstBoatPosition.column;
                secondBoatRow = Row.valueOf(firstBoatPosition.row.value - (boatLength - 1));
            }
            if (secondBoatColumn == null || secondBoatRow == null) {
                continue;
            }
            boatCoordinates.add(firstBoatPosition);
            boatCoordinates.add(new CoordinatesTuple(secondBoatRow, secondBoatColumn));
            break;
        }
        return boatCoordinates;
    }

    @Override
     protected CoordinatesTuple getShotPosition() {
        return randomPosition();
    }
}
