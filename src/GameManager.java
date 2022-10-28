import Player.AbstractPlayer;
import Player.type.ComputerPlayer;
import Player.type.HumanPlayer;

public class GameManager {

    private static GameManager uniqueInstance;
    private GameManager() {
        AbstractPlayer player1 = new HumanPlayer();
        AbstractPlayer player2 = new ComputerPlayer();
    }

    public static synchronized GameManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameManager();
        }
        return uniqueInstance;
    }
    public void ManageGame(){
        StartGame();
        GameFlow();
    }
    private void StartGame(){
        // Call ComputerPlayer to set its boats
        // Call HumanPlayer to set its boats
        System.out.println("Job done, game can start");
    }
    private void GameFlow(){
        boolean fleet = true;
        int counter = 0;
        //!player.fleet.isDestroyed || !computer.fleet.isDestroyed

        while(fleet == true){
            System.out.println(("battle is going"));
            counter ++;
            if(counter == 5) {
                fleet = false;
            }
        }
        System.out.println("somebody must have won");
    }
}
