package UI;
import Grid.Grid;

import java.awt.*;
import java.util.Iterator;

/* How to use: call DisplayMaster with two GridList and a String, what you want to display.
Choose from:
    "boats" to display everything within the process of placing boats
    "game" whenever you need to display the current game state
    "won" when the UserPlayer has won
    "lost" when the UserPlayer has lost
 */
public class Display {
    int lengthOfField = 0;
    int row = 0;
    String field = "";
    final String targetTitle = "===== TARGET GRID =====\n";
    final String oceanTitle = "===== OCEAN GRID =====\n";
    final String letters = "A B C D E F G H I J \n";
    final String symbols = "+-+-+-+-+-+-+-+-+-+-+-+\n";
    final String line = "-----------------------\n";
    final String equals = "=======================\n";

    public void DisplayAsOwn(Iterator grid){
        System.out.println(targetTitle+letters+symbols);
        while(grid.hasNext()){
            if(lengthOfField == 0){
                field += Integer.toString(row)+"|";
            }
            field += grid.next().toString()+"|";
            if(lengthOfField==9){
                field += Integer.toString(row) +"\n";
                lengthOfField = 0;
            }
        }
        System.out.println(equals+line);
    }
    public void DisplayAsOpponent(){
        System.out.println(oceanTitle+letters+symbols);
        while(grid.hasNext()){
            if(lengthOfField == 0){
                field += Integer.toString(row)+"|";
            }
            field += grid.next().toString()+"|";
            if(lengthOfField==9){
                field += Integer.toString(row) +"\n";
                lengthOfField = 0;
            }
        }
        System.out.println(symbols+letters+equals);
    }
}

    /*
    public void DisplayMaster(int[] target, int[] ocean, String what){
        System.out.println("I am the display master");
        if(what == "boats"){
            DisplayBoats(target, ocean);
        } else if (what == "game") {
            DisplayGame(target, ocean);
        }
        else if(what == "won"){
            System.out.println("WOW congratulations, you have beaten the computer");
        }
        else if(what == "lost"){
            DisplayLoser(target);
        }

    }
    private void DisplayGrid(int []target, int [] ocean){
        String targetDeco = "===== TARGET GRID =====\n" +
                "A B C D E F G H I J \n" +
                "+-+-+-+-+-+-+-+-+-+-+-+";
        String DecoBottom = "+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "A B C D E F G H I J \n" +
                "=======================\n";
        String line = "-----------------------\n";
        String oceanDeco = "===== OCEAN GRID =====\n" +
                "A B C D E F G H I J \n" +
                "+-+-+-+-+-+-+-+-+-+-+-+";
        System.out.println(targetDeco);
        for(int i:target)
            System.out.println(i);
        System.out.println(DecoBottom);
        System.out.println(line);
        System.out.println(oceanDeco);
        for(int i:ocean)
            System.out.println(i);
        System.out.println(DecoBottom);
    }
    private void DisplayBoats(int[] target, int[] ocean){
        System.out.println("Please enter your disired Position of a boat in the following manner: \"A1,A4\"");
        DisplayGrid(target, ocean);
        System.out.println("You have the following Boats to choose from:");

    }
    private void DisplayGame(int[] target, int[] ocean){
        // how to update where shot??
        System.out.println("Please enter your desired field to shot at in the following manner: \"A1\"");
        // update shot
        DisplayGrid(target, ocean);
    }
    private void DisplayLoser(int[] GridComp){
        String TopDeco = "= TARGET GRID COMPUTER =\n" +
                "A B C D E F G H I J \n" +
                "+-+-+-+-+-+-+-+-+-+-+-+";

        String BottomDeco = "+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "A B C D E F G H I J \n" +
                "=======================\n";
        System.out.println("YOU LOST AGAINST THE COMPUTER. This would have been the Grid of your opponent");
        System.out.println(TopDeco);
        for(int i:GridComp)
            System.out.println(i);
        System.out.println(BottomDeco);
    }
}
interface Display {
    void DisplayGrid();
    void DisplayRecivedText(String message);

    void DisplayShipsToPlace(String ship);

    void DisplayWinner(String winner);
}
public class DisplayGrid implements Display {

    @Override
    public void DisplayGrid() {
        System.out.println("Grid is displayed");
    }

    @Override
    public void DisplayRecivedText(String message) {
        System.out.println(message);
    }

    @Override
    public void DisplayShipsToPlace(String ship) {
        String toDisplay = String.format("You have to place the following ships: %s",ship);
        System.out.println(toDisplay);
    }

    @Override
    public void DisplayWinner(String winner) {
        String toDisplay = String.format("And the winner is: %s",winner);
        System.out.println(toDisplay);
    }

}
*/