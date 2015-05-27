import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  The Space class is the background of
 *  the asteroid game.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class Space extends World
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    /**
     * Creates a new Space object.
     * 
     * @param x The width of the world
     * @param y The height of the world
     */
    public Space(int x, int y)
    {
        super(x, y, 1);
    }

    // ----------------------------------------------------------
    /**
     * Creates a new Space object with a fixed size.
     * In this case it is 500 height and width
     * by 1 pixel.
     * 
     */
    public Space()
    {
        this(500, 500);
        populate();
    }

    //~ Methods ...............................................................
    /**
     * Add five asteroid randomly in the space
     * with random x and y values.
     */
    public void populate()
    {
        this.add(new Ship(), 250, 250);
        for (int i = 0; i < 10; i++)
        {
            int xVal = Random.generator().nextInt(getWidth());
            int yVal = Random.generator().nextInt(getHeight());
            int angle = Random.generator().nextInt(360);
            int speed = Random.generator().nextInt(1, 5);

            Asteroid asteroid = new Asteroid(speed, angle);
            this.add(asteroid, xVal, yVal);

        }

    }
}
