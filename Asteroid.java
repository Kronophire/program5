import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Asteroid class is the obstacle in space
 *  that destroys the ship and itself, when collided.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class Asteroid extends Actor
{
    //~ Fields ................................................................
    private int speed;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------

    /**
     * Creates a new Asteroid object.
     * 
     * @param speed The speed of asteroid.
     * @param angle The angle of the asteroid.
     */
    public Asteroid(int speed, int angle)
    {
        super();
        this.speed = speed;
        turn(angle);
    }

    //~ Methods ...............................................................
    /**
     * The act() for the Asteroid class.
     */
    public void act()
    {
        this.move(speed);
        this.wrapAround();
        Ship ship = getOneIntersectingObject(Ship.class);
        if (ship != null)
        {
            ship.remove();
            this.remove();
            return;
        }

    }

    /**
     * The wrapAround() method is executed when
     * the asteroid is at the edge of the world, then
     * the asteroid would appear on the other opposite
     * side of the space.
     */
    public void wrapAround()
    {        
        if (this.getGridX() == getWorld().getWidth() - 1)
        {
            this.setGridX(0);
        }
        else if (this.getGridY() == getWorld().getHeight() - 1)
        {
            this.setGridY(0);
        }
        else if (this.getGridY() == 0)
        {
            this.setGridY(getWorld().getHeight());
        }        
        else if (this.getGridX() == 0)
        {
            this.setGridX(getWorld().getWidth());
        }
    }

    /**
     * Gets the speed of the bullet
     * 
     * @return the speed
     */
    public int getSpeed()
    {
        return speed;
    }    

}
