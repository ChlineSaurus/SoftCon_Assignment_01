package Boats;

public  class Boat {


    protected HitpointManager hitpoints;
    private char sunkLetter;
    boolean isPlaced=false;


    public boolean isSunk(){
        return hitpoints == HitpointManager.ZeroHitPoints;
    }
    public void isHit(){
        assert !isSunk();
        hitpoints=HitpointManager.valueOf(hitpoints.getHitpointValue()-1);
    }

    public char getSunkLetter() {
        return sunkLetter;
    }
    public Boat(HitpointManager health,char sunk){
        sunkLetter=sunk;
        hitpoints=health;

    }

}
