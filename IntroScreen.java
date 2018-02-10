import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroScreen extends World
{

    /**
     * Constructor for objects of class IntroScreen.
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public void act() {
        // if ( Greenfoot.mouseClicked(this) ) {
        //   AdeventureWorld world = new AdeventureWorld();
        //   Greenfoot.setWorld(world);
        // }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start,311,189);
        CREDIT credit = new CREDIT();
        addObject(credit,326,269);
        removeObject(credit);
        CREDIT credit2 = new CREDIT();
        addObject(credit2,323,273);
        EXIT exit = new EXIT();
        addObject(exit,335,360);
        removeObject(credit2);
        removeObject(exit);
        CREDIT credit3 = new CREDIT();
        addObject(credit3,322,243);
        removeObject(credit3);
        CREDIT credit4 = new CREDIT();
        addObject(credit4,320,245);
        removeObject(credit4);
        CREDIT credit5 = new CREDIT();
        addObject(credit5,318,251);
        EXIT exit2 = new EXIT();
        addObject(exit2,335,320);
        credit5.setLocation(310,246);
        exit2.setLocation(314,305);
    }
}
