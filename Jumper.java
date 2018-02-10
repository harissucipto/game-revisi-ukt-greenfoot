import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jumper extends Actor
{
    protected int actorHeight;
    private int fallSpeed = 0;
    private boolean jumping = false;
    
    // Class Constants
    protected static final int GRAVITY = 1;
    protected static final int JUMPSTRENGTH = 12;
    
    
    
    public Jumper() {
        actorHeight = getImage().getHeight();
    }
    
    
    /**
     * Act - do whatever the Jumper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        handleKeyPresses();
        standOrFall();
    }
    
    protected void handleKeyPresses() {
        if (Greenfoot.isKeyDown("w") && !jumping) {
            jump();
        }
    }
    
    private void jump() {
        fallSpeed = -JUMPSTRENGTH;
        jumping = true;
        fall();
    }
    
    private void standOrFall() {
        if ( inAir() ) {
            checkHead();
            fall();
            checkLanding();
        } else {
            fallSpeed = 0;
            jumping = false;
        }
    }
    
    private void checkHead() {
        int actorHead = -actorHeight/2;
        int step = 0;
        while( fallSpeed < 0 && step > fallSpeed
            && getOneObjectAtOffset(0, actorHead + step, Platform.class) == null )
            {
                step--;
            }
        if (fallSpeed < 0) {
            fallSpeed = step;
        }
        
    }
    
    private void checkLanding() {
        int actorFeet = actorHeight / 2;
        int step = 0;
        while( fallSpeed > 0 && step < fallSpeed
            && getOneObjectAtOffset(0, actorFeet + step, Platform.class) == null )
            {
                step++;
            }
        if (fallSpeed > 0) {
            fallSpeed = step;
        }
    }
    
    private boolean inAir() {
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight() /2, Platform.class);
        return platform == null;
    }
    
    private void fall() {
        setLocation(getX(), getY() + fallSpeed);
        fallSpeed = fallSpeed + GRAVITY;
    }
}
