package Grid;

public class GridCell {
    private final Row row;
    private final Column column;

    public GridCell(Row a, Column b){
        this.row=a;
        this.column=b;
    }
    protected Integer GetRowIndex(){
        return row.getValue();
    }
    protected Integer GetColumnIndex(){
        return column.getValue();
    }



}
