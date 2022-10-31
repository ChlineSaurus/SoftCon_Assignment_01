package Grid;

import java.util.ArrayList;

public class GridIterator implements Iterator {

    ArrayList<GridCell> rowList;

    int position = 0;

    public GridIterator(ArrayList<GridCell> rowList) {
        this.rowList = rowList;
    }

    public GridCell next() {
        GridCell gridCell = rowList.get(position);
        position++;
        return gridCell;
    }

    public boolean hasNext() {
        if (position >= rowList.size() || rowList.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
}