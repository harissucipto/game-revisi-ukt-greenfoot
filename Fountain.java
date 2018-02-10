import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fountain extends Actor
{
    private int lifespan = 150;
    private int startDelay = 50;
    private GreenfootImage img;
    
    public Fountain() {
        img = new GreenfootImage(20, 20);
        img.setColor(Color.BLUE);
        img.setTransparency(100);
        img.fill();
        setImage(img);
    }
    
    public void act() {
        if ( --startDelay == 0) wipeView();
        if ( startDelay < 0 ) createRedBallShower();
    }
    
    
   private void wipeView() {
       img.clear();
    }
    
    private void createRedBallShower() {
        lifespan--;
        if (lifespan < 0) {
            getWorld().removeObject(this);
        } else {
            int tr = Greenfoot.getRandomNumber(30) - 15;
            int s = Greenfoot.getRandomNumber(4) + 2;
            int l = Greenfoot.getRandomNumber(15) + 5;
            getWorld() .addObject(new RedBall(tr, s, l, 10, 10), getX(), getY());
        }
    }
    
    
}
