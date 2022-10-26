package Boats;

public class fleetmanager {
    private int allowed_carriers=1;
    private int allowed_battleships=2;
    private int allowed_subs=3;
    private int allowed_patrol_boats=4;

    private int fleetsize;
    public fleetmanager(){

    }
    private void get_fleetsize(){
        fleetsize=allowed_carriers+allowed_battleships+allowed_subs+allowed_patrol_boats;}


    boolean isFleetplaced(){
        return true;
    }

    private int boats_not_sunk = 6;
    boolean isFleetDestroyed(){return true;}


}
