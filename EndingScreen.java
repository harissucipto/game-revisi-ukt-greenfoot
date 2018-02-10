import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndingScreen extends World
{

    /**
     * Constructor for objects of class EndingScreen.
     * 
     */
    public EndingScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {

            AdeventureWorld world = new AdeventureWorld();
            Greenfoot.setWorld(world);
        }
    }

    public void setPlayerHighScore(int s) {
        // ukt 4 = 20;
        // ukt 3 = 40;
        // ukt 2 = 60
        // ukt 1 = 80
        // beasiswa => 80o

        String ukt = "0";
        int beasiswa = 0;
        if (s > 80) {
            ukt = "1";
            beasiswa = (s % 80) * 1000;
        } else if (s >= 60) {
            ukt = "2";
        } else if  (s >= 40) {
            ukt = "3";
        } else if (s >= 20) {
            ukt = "2";
        }

        String berkas = Integer.toString(s);

        Label scoreBoardMsg = new Label("Bekas Terkumpul: " + berkas, 35);
        Label uktDispensi = new Label("UKT kamu jadi UKT " + ukt, 30);

      
        addObject(scoreBoardMsg, getWidth() /2, getHeight() * 2/3);
        if (ukt != "0") {
            addObject(uktDispensi, getWidth() /2, (getHeight() * 2/3) + 35);
            if (beasiswa != 0) {
                Label msgBeasiswa = new Label("Dapat tambahan beasiswa Rp." + Integer.toString(beasiswa), 20);
                addObject(msgBeasiswa, getWidth() /2, (getHeight() * 2/3) + 65);
            }
        } else {
             Label uktNggakBerubah = new Label("UKT kamu tetap UKT 5 ", 30);
              addObject(uktNggakBerubah, getWidth() /2, (getHeight() * 2/3) + 35);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PLAY play = new PLAY();
        addObject(play,508,367);
        EXIT exit3 = new EXIT();
        addObject(exit3,315,382);
        removeObject(play);
        removeObject(exit3);
        PLAY play2 = new PLAY();
        addObject(play2,100,379);
        EXIT exit4 = new EXIT();
        addObject(exit4,518,383);
    }
}
