package Boats;

public  class Boat {
    protected HitpointManager hitPoints;
    private final char sunkLetter;
    boolean isPlaced = false;

    public Boat(HitpointManager health,char sunk){
        assert health!=null;

        sunkLetter=sunk;
        hitPoints=health;

    }

    protected int getHitPoints(){
        return hitPoints.getHitpointValue();
    }

    void place(){
        isPlaced=true;
    }

    public boolean isSunk(){
        return hitPoints == HitpointManager.ZeroHitPoints;
    }
    public void isHit(){
        assert !isSunk();
        hitPoints=HitpointManager.valueOf(hitPoints.getHitpointValue()-1);
    }

    public char getSunkLetter() {
        return sunkLetter;
    }
}
