package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOwn implements GridCellDisplayer{
    @Override
    public Character display(GridCell gridCell) {
        if (gridCell.isOccupied()) {
            if (gridCell.wasShot()) {
                return 'X';
            } else {
                return gridCell.getBoat().getSunkLetter();
            }
        } else {
            if (gridCell.wasShot()) {
                return 'o';
            } else {
                return ' ';
            }
        }
    }
}
