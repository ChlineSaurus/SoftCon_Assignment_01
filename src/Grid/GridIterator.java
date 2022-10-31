package Grid;

import Grid.DisplayGridcell.GridCellDisplayer;

import java.util.ArrayList;

public class GridIterator implements Iterator{
    static final int totalRows = Row.values().length;
    static final int totalColumns = Column.values().length;
    private int currentRow;
    private int currentColumn;
    private final GridCellDisplayer gridCellDisplayer;
    private final ArrayList<ArrayList<GridCell>> grid;
    public GridIterator(ArrayList<ArrayList<GridCell>> grid, GridCellDisplayer gridCellDisplayer) {
        currentColumn = 0;
        currentRow = 0;
        this.gridCellDisplayer = gridCellDisplayer;
        this.grid = grid;
    }



    public GridCell next() {
        assert(hasNext());
        GridCell gridCell = grid.get(currentRow).get(currentColumn);
        if(currentColumn == (totalRows-1)) {
            currentColumn = 0;
            currentRow++;
        } else {
            currentColumn++;
        }
        return gridCell;
    }

    public boolean hasNext() {
        if (currentRow >= (totalRows-1) && currentColumn >= (totalColumns -1)) {
            return false;
        } else {
            return true;
        }
    }
}