import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Bullet class is the object
 *  that comes out from the ship and
 *  is used to destroy asteroids.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class Bullet extends Actor
{
    //~ Fields ................................................................
    private int speed;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    
    /**
     * Creates a new Bullet object.
     * 
     * @param velocity The speed of the bullet.
     * @param angle The angle of the bullet.
     */
    public Bullet(int velocity, int angle)
    {
        speed = velocity;
        this.setRotation(angle);
    }

    //~ Methods ...............................................................
    
    /**
     * The act() method for the Bullet class.
     */
    public void act()
    {
        this.move(speed);
        if (this.onEdge())
        {
            this.remove();
            return;
        }
        Asteroid asteroid = getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            getWorld().remove(asteroid);
            this.remove();
            return;
        }
    }

    /**
     * The onEdge method.
     * 
     * @return true If on edge
     */
    public boolean onEdge()
    {
        return ((this.getGridX() == 0)
            || (this.getGridY() == 0)
            || (this.getGridX() == getWorld().getWidth() - 1)
            || (this.getGridY() == getWorld().getHeight() - 1));
    }

    /**
     * Gets the speed of the bullet
     * 
     * @return The speed
     */
    public int getSpeed()
    {
        return speed;
    }

}
