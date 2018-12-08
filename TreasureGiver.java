
/**
 * Write a description of class TreasureGiver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random; 

public class TreasureGiver
{
    // instance variables - replace the example below with your own
    private int x;
    private int randomPoint;
    
    
    Random rand = new Random();

    /**
     * Constructor for objects of class TreasureGiver
     */
    public TreasureGiver()
    {
        int treasureNumber = rand.nextInt(1);
        int treasureLocation[];
        int randomCoordinate = rand.nextInt(100);
        int treasures = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod()
    {
        for (int i; i < treasureLocation.length; i++)
        {
            treasureLocation[randomCoordinate] = treasureNumber;
        }
    }
}
