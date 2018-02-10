import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.nio.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class  AdeventureWorld extends World
{
    private Counter score;
    private Turret turret;
    public int BCOUNT = 200;
    private int ballCounter = BCOUNT;
    public int FCOUNT = 400;
    private int fountainCounter = FCOUNT;
    private int level = 0;
    
    public AdeventureWorld() {
        super(600, 400, 1, false);
        setPaintOrder(Counter.class, Turret.class, Fountain.class, 
        Jumper.class, Enemy.class, Reward.class, Platform.class);
        prepare();
    }
    
    public void act() {
        
        checkLevel();
        
    }
    

    
    
    private void checkLevel() {
        if ( level > 1 ) generateBalls();
        if ( level > 4 ) generateFountains();
        if ( level % 3 == 0 ) {
            FCOUNT--;
            BCOUNT--;
            level++;
            
        }
        
    }
    
    private void generateFountains() {
        fountainCounter--;
        if ( fountainCounter < 0 ) {
            List<Brick> bricks = getObjects(Brick.class);
            int idx = Greenfoot.getRandomNumber(bricks.size());
            Fountain f = new Fountain();
            int top = f.getImage().getHeight() / 2 +
                bricks.get(idx).getImage().getHeight() /2;
           addObject(f, bricks.get(idx).getX(), bricks.get(idx).getY() - top);
           fountainCounter = FCOUNT;
            
        }
    }
    
    private void generateBalls() {
        ballCounter--;
        if ( ballCounter < 0 ) {

            Ball b = new Ball(level);
            
            turret.setRotation(15 * -b.getXVelocity());
            
            addObject(b, getWidth() /2, 0);
            
           
            ballCounter = BCOUNT;
        }
        
    }
    
    public void addBerkasCount(int num) {
        score.setValue(score.getValue() + num);
        level++;
        generateNewCupcake();
        
    }
    
    public void generateNewCupcake() {
        List<Brick> bricks = getObjects(Brick.class);
        int idx = Greenfoot.getRandomNumber(bricks.size());
        Berkas cake = new Berkas();
        int top = cake.getImage().getHeight() / 2 +
        bricks.get(idx).getImage().getHeight() / 2;
        
        addObject(cake, bricks.get(idx).getX(), bricks.get(idx).getY() - top);
    }
    
    public void prepare() {
        // Add Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa();
        addObject(mahasiswa, 43, 340);
        // Add flor
        BrickWall brickwall1 = new BrickWall();
        addObject(brickwall1, 184, 400);
        BrickWall brickwall2 =  new BrickWall();
        addObject(brickwall2, 567, 400);
        // Add Score
        score = new Counter("Berkas : ");
        addObject(score, 60, 27);
        // Add turret
        turret = new Turret();
        addObject(turret,getWidth()/2, 0);
        
        // Add Cupcake
        Berkas cupcake = new Berkas();
        addObject(cupcake, 450, 30);
        // Add platforms
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<6; j++) {
                int stagger = (i % 2 == 0) ? 24 : -24;
                Brick brick = new Brick();
                addObject(brick, stagger + (j + 1) * 85, (i+1) *62);
            }
            
        }
        
        
    }
    
    public void endGame() {
 
        
        

        EndingScreen endWorld = new EndingScreen();
        endWorld.setPlayerHighScore(score.getValue());
        
        Greenfoot.setWorld(endWorld);
        
    }
    

   
}
