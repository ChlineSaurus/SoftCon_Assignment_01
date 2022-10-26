
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
