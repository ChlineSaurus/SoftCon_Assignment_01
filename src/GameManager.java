public class GameManager {
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
