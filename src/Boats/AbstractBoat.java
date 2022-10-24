package Boats;

public class AbstractBoat {
    // I'm a boat
    private int hitpoints;
    public boolean issunk(){
        return hitpoints == 0;
    }
    //in order that ishit is called one first must recieve the information from the grid make this function private sothat the it isn't absued
    public void isHit(){
        assert !issunk();
        hitpoints--;
    }

    static void toot() {

        System.out.println("Toooooooot");
    }
}
