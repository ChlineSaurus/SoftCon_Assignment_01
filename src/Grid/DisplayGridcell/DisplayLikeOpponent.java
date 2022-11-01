package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOpponent implements GridCellDisplayer{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public String display(GridCell gridCell) {
        if (!gridCell.wasShot()) {
            return " ";
        } else if (gridCell.isOccupied()) {
            if (gridCell.getBoat().isSunk()) {
                return ANSI_RED + gridCell.getBoat().getSunkLetter() + ANSI_RESET;
            } else {
                return ANSI_GREEN + "X" + ANSI_RESET;
            }
        } else {
            return ANSI_BLUE + "o" + ANSI_RESET;
        }
    }
}
