package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOwn implements GridCellDisplayer{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public String display(GridCell gridCell) {
        if (gridCell.isOccupied()) {
            if (gridCell.wasShot()) {
                return ANSI_RED + gridCell.getBoat().getSunkLetter() + ANSI_RESET;
            } else {
                return ANSI_GREEN + gridCell.getBoat().getSunkLetter() + ANSI_RESET;
            }
        } else {
            if (gridCell.wasShot()) {
                return ANSI_BLUE + "o" + ANSI_RESET;
            } else {
                return " ";
            }
        }
    }
}
