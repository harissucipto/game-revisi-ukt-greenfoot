import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowScreen extends World
{

    /**
     * Constructor for objects of class HowScreen.
     * 
     */
    public HowScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PLAY play = new PLAY();
        addObject(play,504,381);
        play.setLocation(474,370);
    }
}
