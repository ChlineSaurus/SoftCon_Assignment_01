package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOpponent implements GridCellDisplayer{
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\033[0;35m";

    @Override
    public String display(GridCell gridCell) {
        if (!gridCell.wasShot()) {
            return " ";
        } else if (gridCell.isOccupied()) {
            if (gridCell.getBoat().isSunk()) {
                return RED + gridCell.getBoat().getSunkLetter() + COLOR_RESET;
            } else {
                return PURPLE + "X" + COLOR_RESET;
            }
        } else {
            return BLUE + "o" + COLOR_RESET;
        }
    }
}
