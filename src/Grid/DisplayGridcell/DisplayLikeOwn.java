package Grid.DisplayGridcell;

import Grid.GridCell;

public class DisplayLikeOwn implements GridCellDisplayer{
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\033[0;35m";

    @Override
    public String display(GridCell gridCell) {
        if (gridCell.isOccupied()) {
            if (gridCell.wasShot()) {
                if (gridCell.getBoat().isSunk()) {
                    return RED + gridCell.getBoat().getSunkLetter() + COLOR_RESET;
                } else {
                    return PURPLE + gridCell.getBoat().getSunkLetter() + COLOR_RESET;
                }
            } else {
                return GREEN + gridCell.getBoat().getSunkLetter() + COLOR_RESET;
            }
        } else {
            if (gridCell.wasShot()) {
                return BLUE + "o" + COLOR_RESET;
            } else {
                return " ";
            }
        }
    }
}
