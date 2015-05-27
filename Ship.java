import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  The Ship class contains methods
 *  that will make the ship be able to
 *  shoot bullets and destroy asteroids.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class Ship extends Actor
{
    //~ Fields ................................................................
    private int speed = 0;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Ship object and
     * making the ship face north by turning 
     * left 90 degrees as default.
     */
    public Ship()
    {
        this.setRotation(-90);

    }

    //~ Methods ...............................................................

    /**
     * The getSpeed() method, also a getter.
     * 
     * @return this.speed Which is getting and storing the
     * speed.
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * The setSpeed() method, also a setter.
     * 
     * @param velocity The speed that is being set.
     */
    public void setSpeed(int velocity)
    {
        this.speed = velocity;
    }

    /**
     * The dpadNorthIsDown() method uses
     * the up-arrow key to move or accelerate
     * the asteroid forward.
     */
    public void dpadNorthIsDown()
    {
        this.setSpeed(this.getSpeed() + 1);
    }

    /**
     * The dpadEastIsDown() method uses
     * the right-arrow key to rotate 5 degrees right.
     */
    public void dpadEastIsDown()
    {
        this.setRotation(this.getRotation() + 5);
    }

    /**
     * The dpadSouthIsDown() method uses
     * the down-arrow key to de-accelerate the ship.
     */
    public void dpadSouthIsDown()
    {
        if (this.getSpeed() > 0)
        {
            this.setSpeed(this.getSpeed() - 1);
        }  
    }

    /**
     * The dpadWestIsDown() method uses
     * the left-arrow key to rotate 5 degrees left.
     */
    public void dpadWestIsDown()
    {
        this.setRotation(this.getRotation() - 5);
    }

    /**
     * The onScreenTouchDown() method uses the
     * left-click of a mouse to shoot bullets from
     * the ship.
     */
    public void onScreenTouchDown()
    {
        Bullet bullet = new Bullet(10, (int) this.getRotation());
        this.getWorld().add(bullet, this.getGridX(), this.getGridY());
    }

    /**
     * The act method for the ship.
     */
    public void act()
    {
        this.move(speed);
        this.wrapAround();

    }   

    /**
     * The wrapAround() method is executed when
     * the ship is at the edge of the world, then
     * the ship would appear on the other opposite
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
}
