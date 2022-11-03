package UI;

import Grid.Coordinates.Row;

import java.util.Iterator;

public class Display {
    private static final String targetTitle = "===== TARGET GRID =====\n";
    private static final String oceanTitle = "===== OCEAN GRID =====\n";
    private static final String letters = "  A B C D E F G H I J \n";
    private static final String symbols = "+-+-+-+-+-+-+-+-+-+-+-+\n";
    private static final String line = "-----------------------\n";
    private static final String equals = "=======================\n";

    private final int totalLengthOfField;

    public Display() {
        this.totalLengthOfField = Row.values().length;
    }

    public void display(Iterator<String> oceanGrid, Iterator<String> targetGrid, String message) {
        //next line of Code because the IDE doesn't clear the Terminal
        clearScreen();
        displayGrid(targetGrid, targetTitle);
        System.out.print(line);
        displayGrid(oceanGrid, oceanTitle);
        System.out.println(message);
    }

    private void displayGrid(Iterator<String> gridIterator, String title){
        int lengthOfField = 0;
        int row = 0;
        String field = "";
        System.out.print(title+letters+symbols);
        while(gridIterator.hasNext()){
            if(lengthOfField == 0){
                field = field.concat(Integer.toString(row)+"|");
            }
            field =field.concat(gridIterator.next()+"|");
            lengthOfField++;
            if(lengthOfField== (totalLengthOfField)){
                field = field.concat(Integer.toString(row) +"\n");
                lengthOfField = 0;
                row++;
            }
        }
        System.out.print(field);
        System.out.print(symbols+letters+equals);
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}