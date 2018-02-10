import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EXIT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EXIT extends Button
{
    /**
     * Act - do whatever the EXIT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) {
            sound.play();
            CreditScreen world = new CreditScreen();
            Greenfoot.stop();
        }
    }    
}
