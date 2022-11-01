package Grid;

//Container Class such that we are able to give coordinate in pairs
public class CoordinatesTuple {

    final public Row row;
    final public Column column;

    public CoordinatesTuple(Row row, Column column) {
        this.row = row;
        this.column = column;
    }
}
