package Boats;

public  class Boat {


    protected HitpointManager hitpoints;
    private char sunkLetter;
    boolean isPlaced=false;
    protected int gethitpoints(){
        return hitpoints.getHitpointValue();
    }

    public Boat(HitpointManager health,char sunk){
        assert health!=null;

        sunkLetter=sunk;
        hitpoints=health;

    }
    void place(){
        isPlaced=true;
    }


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


}
