package Player.type;

import Grid.Column;
import Grid.CoordinatesTuple;
import Grid.Row;
import Player.AbstractPlayer;

public class HumanPlayer extends AbstractPlayer {
    @Override
    protected CoordinatesTuple getPosition(){
        return new CoordinatesTuple(Row.A, Column.B);
    }
}
