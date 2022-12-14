package Grid.Iterator;

import Grid.Coordinates.Column;
import Grid.Coordinates.Row;
import Grid.DisplayGridcell.GridCellDisplayer;
import Grid.GridCell;

import java.util.ArrayList;
import java.util.Iterator;

public class GridIterator implements Iterator<String> {
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

    public String next() {
        assert(hasNext());
        GridCell currentGridCell = grid.get(currentRow).get(currentColumn);
        if(currentColumn == (totalColumns-1)) {
            currentColumn = 0;
            currentRow++;
        } else {
            currentColumn++;
        }
        return gridCellDisplayer.display(currentGridCell);
    }

    public boolean hasNext() {
        if (currentRow >= totalRows) {
            return false;
        } else {
            return true;
        }
    }
}