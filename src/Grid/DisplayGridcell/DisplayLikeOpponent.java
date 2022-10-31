package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOpponent implements GridCellDisplayer{
    @Override
    public Character display(GridCell gridCell) {
        if (!gridCell.wasShot()) {
            return ' ';
        } else if (gridCell.isOccupied()) {
            if (gridCell.getBoat().isSunk()) {
                return gridCell.getBoat().getSunkLetter();
            } else {
                return 'X';
            }
        } else {
            return 'o';
        }
    }
}
