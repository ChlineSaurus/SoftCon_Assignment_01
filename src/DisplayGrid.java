
interface Display {
    void DisplayGrid();
    void DisplayRecivedText();
}
public class DisplayGrid implements Display {

    @Override
    public void DisplayGrid() {
        System.out.println("Grid is displayed");
    }

    @Override
    public void DisplayRecivedText() {
        System.out.println("Your text is displayed");
    }

}
