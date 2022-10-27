package Player.type;

import Grid.Column;
import Grid.CoordinatesTuple;
import Grid.Row;
import Player.AbstractPlayer;
import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    private static final Row[] rowEnum = Row.values();
    private static final int rowLength = rowEnum.length;
    private static final Column[] columnEnum = Column.values();
    private static final int columnLength = rowEnum.length;

    private static CoordinatesTuple randomPosition() {
        int randomRowIndex = new Random().nextInt(rowLength);
        int randomColumnIndex = new Random().nextInt(columnLength);
        return new CoordinatesTuple(rowEnum[randomRowIndex], columnEnum[randomColumnIndex]);
    }
    @Override
     protected CoordinatesTuple getPosition() {
        return randomPosition();
    }
}
