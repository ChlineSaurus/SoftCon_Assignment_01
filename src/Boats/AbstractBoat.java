package Boats;

public abstract class  AbstractBoat {


    // I'm a boat
     protected int hitpoints;


    public boolean issunk(){
        assert hitpoints<=0;
        return hitpoints == 0;
    }
    //in order that ishit is called one first must recieve the information from the grid make this function private sothat the it isn't absued
    public void isHit(){
        assert !issunk();
        hitpoints--;
    }

}
