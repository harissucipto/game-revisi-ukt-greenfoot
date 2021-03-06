import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Enemy
{

    private int kecepatan = 0;
    protected int actorHeight;
    private int speedX = 0;
    private int fallSpeed = 0;
    private static final int GRAVITY = 1;
    
   
    
    
    public Ball(int cepat) {
        actorHeight = getImage().getHeight();
        speedX = Greenfoot.getRandomNumber(8) - 4;
        if (speedX == 0) {
            speedX = Greenfoot.getRandomNumber(100) < 50  ? -1 : 1;
        }
        setRotation(0);
        kecepatan = cepat;
        
    }
    
    
    
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        
       setRotation(15 * -getXVelocity() + 90);
       move(kecepatan);
        // System.out.println("ini dari bola");
        // System.out.println(getRotation());
        
        fallOrBounce();
        checkOffScreen();
    }    
    
    public int getXVelocity() {
        return speedX;
    }
    
    private void fallOrBounce() {
        if (fallSpeed <= 0) {
            checkHead();
        } else {
            checkLanding();
        }
    }
    
    private void checkHead() {
        int actorHead = -actorHeight / 2;
        int step = 0;
        int oldFallSpeed;
        while (fallSpeed < 0 && step > fallSpeed &&
        getOneObjectAtOffset(0, actorHead + step,
        Platform.class) == null ) {
            step--;
        }
        if (step > fallSpeed) {
            if ( fallSpeed < 0) {
                handleBounce(step);
            } else {
                fall(speedX);
            }
        }
    }
    
    private void handleBounce(int step) {
        int oldFallSpeed = fallSpeed;
        fallSpeed = step;
        fall(0);
        oldFallSpeed = (int) (oldFallSpeed * 0.7);
        fallSpeed = step - oldFallSpeed;
        fall(0);
        fallSpeed = -oldFallSpeed;
    }
    
    private void fall(int dx) {
        setLocation(getX() + dx, getY() + fallSpeed);
        fallSpeed = fallSpeed + GRAVITY;
    }

    
    private void checkOffScreen() {
        if ( getX() < - 20 || getX() > getWorld().getWidth() + 20) {
            getWorld().removeObject(this);
        } else if ( getY() > getWorld().getHeight() + 20) {
            getWorld().removeObject(this);
        }
    }
    
    private void checkLanding() {
        int actorFeet = actorHeight / 2;
        int step = 0;
        int oldFallSpeed;
        while( fallSpeed > 0 && step < fallSpeed &&
        getOneObjectAtOffset(0, actorFeet + step,
        Platform.class) == null ) {
            step++;
        }
        if (step < fallSpeed) {
            if (fallSpeed > 0) {
                handleBounce(step);
            }
        } else {
            fall(speedX);
        }
        
    }
   
        
}
