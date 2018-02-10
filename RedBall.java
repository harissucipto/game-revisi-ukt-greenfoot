import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBall extends Particles
{
    public RedBall(int tr, int s, int l, int scaleX, int scaleY) {
        super(tr, s, l);
        getImage().scale(scaleX, scaleY);
        
    }
}
