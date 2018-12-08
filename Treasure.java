
/**
 * Write a description of class Treasure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random; 

public class Treasure
{
    // instance variables - replace the example below with your own
    private int treasuresLeft; 
    private int treasuresFound;
    private int triesLeft;
    private boolean gameOver = false;
    protected int treasuresBuried;
    protected boolean[] treasureStatus = new boolean[100];
    
    Random rand = new Random();

    /**
     * Constructor for objects of class Treasure
     */
    public Treasure()
    {
        treasuresLeft = 20;
        treasuresFound = 0;
        triesLeft = 50;
        treasuresBuried = 0;
        
    }

    /**
     * getTreasuresLeft method.
     * @return The treasures left in the game.
     */
    public int getTreasuresLeft()
    {
        return treasuresLeft;
    }
    
    /**
     * getTreasuresLeft method.
     * @return The treasures left in the game.
     */
    public int getTreasuresFound()
    {
        return treasuresFound;
    }
    
    /**
     * getTreasuresLeft method.
     * @return The treasures left in the game.
     */
    public int getTriesLeft()
    {
        return triesLeft;
    }
    
    /**
     * treasuresFound method.
     * adds 1 to treasures found.
     */
    public void found()
    {
        treasuresFound += 1;
        
        treasuresLeft -= 1;
        
        triesLeft -= 1;
    }
    
    public void buttonClicked()
    {
        triesLeft -= 1;
    }
    
    public boolean isGameOver()
    {
        if (treasuresLeft == 0 || treasuresFound == 0)
        {
            gameOver = true;
        }
        return gameOver;
    }
    
    public void TreasureHoarder()
    {
        int randomPoint;
        
        do 
        {
            randomPoint = rand.nextInt(10);
            for (int i = 0; i < treasureStatus.length; i++)
            {
                if (randomPoint == 5)
                {
                    
                    treasureStatus[i] = true;
                    
                    treasuresBuried += 1;
                }
            }
            
        }
        while (treasuresBuried < 20);
    }
}
