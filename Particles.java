import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Particles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particles extends Enemy
{
    private int turnRate = 2;
    private int speed = 5;
    private int lifeSpan = 50;
    
    public Particles(int tr, int s, int l) {
        turnRate = tr;
        speed  = s;
        lifeSpan = 1;
        setRotation(-95);
    }
    
    public void act() {
        move();
        remove();
    }
    
    public void move() {
        move(speed);
        turn(turnRate);
    }
    
    private void remove() {
        lifeSpan--;
        if ( lifeSpan < 0 ) {
           getWorld().removeObject(this);
        }
    }
}
