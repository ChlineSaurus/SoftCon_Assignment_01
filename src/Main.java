import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
    GameManager gameManager = GameManager.getInstance();
    gameManager.ManageGame();
    exit(0);
    }
}
