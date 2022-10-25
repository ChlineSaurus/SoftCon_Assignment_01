package Boats;

public class fleetmanager {
    private int allowed_carriers;
    private int allowed_subs;
    private int allowed_battleships;
    private int allowed_patrol_boats;

    private int fleetsize;
    public fleetmanager(int allowed_carriers,int allowed_battleships, int allowed_subs, int allowed_patrol_boats){
        assert allowed_battleships>=0 && allowed_carriers>=0 && allowed_subs>=0 && allowed_patrol_boats>=0;
        this.allowed_carriers=allowed_carriers;
        this.allowed_battleships=allowed_battleships;
        this.allowed_subs=allowed_subs;
        this.allowed_patrol_boats=allowed_patrol_boats;
        get_fleetsize();
    }
    private void get_fleetsize(){
        fleetsize=allowed_carriers+allowed_battleships+allowed_subs+allowed_patrol_boats;
        assert fleetsize>0;
    }

    boolean isFleetplaced(){
        return true;
    }

    private int boats_not_sunk = 6;
    boolean isFleetDestroyed(){return true;}


}
