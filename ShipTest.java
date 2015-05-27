import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  The ShipTest test class testing different
 *  methods in the ship class.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class ShipTest extends TestCase
{
    //~ Fields ................................................................
    private Ship ship;
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    
    /**
     * Creates a new testShip test object.
     */
    public ShipTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        ship = new Ship();
        space = new Space();

        space.add(ship, 250, 250);
    }

    // ----------------------------------------------------------
    /**
     * Tests the setSpeed() and getSpeed() method.
     */
    public void testSetSpeed()
    {
        ship.setSpeed(5);

        assertEquals(ship.getSpeed(), 5);
    }

    /**
     * Tests the dpadNorthIsDown() method to check
     * if the ship is moving or accelerating ahead
     * by speed 1.
     */
    public void testDpadNorthIsDown()
    {
        ship.dpadNorthIsDown();

        assertEquals(ship.getSpeed(), 1);
    }

    /**
     * Tests the dpadEastIsDown() method to check
     * if the ship is rotating to the right by
     * +5 degrees.
     */
    public void testDpadEastIsDown()
    {
        ship.dpadEastIsDown();

        assertEquals((int) ship.getRotation(), -85);
    }

    /**
     * Tests the dpadSouthIsDown() method to check
     * if the ship is de-accelerating
     * by speed 1.
     */
    public void testDpadSouthIsDown()
    {
        ship.setSpeed(1);
        ship.dpadSouthIsDown();

        assertEquals(ship.getSpeed(), 0);
    }

    /**
     * Tests the dpadWestIsDown() method to check
     * if the ship is rotating to the left by
     * -5 degrees.
     */
    public void testDpadWestIsDown()
    {
        ship.dpadWestIsDown();

        assertEquals((int) ship.getRotation(), -95);
    }

    /**
     * Tests the onScreenTouchDown() method to check
     * if the ship is shooting Bullets by
     * left-clicking on the screen.
     */
    public void testOnScreenTouchDown()
    {
        ship.onScreenTouchDown();

        assertEquals(1, space.getObjects(Bullet.class).size());
    }

    /**
     * Tests the act() method in the ship to check
     * if the ship is going to move with a speed of 5
     * and rotating back to its original position (facing
     * east). 
     */
    public void testActShip()
    {
        ship.setSpeed(5);
        ship.setRotation(0);
        ship.act();

        assertEquals(ship.getGridX(), 255);

    }

    /**
     * Tests the wrapAround() method of the asteroid class.
     */
    public void testWrapAround()
    {
        Ship s1 = new Ship();
        Ship s2 = new Ship();
        Ship s3 = new Ship();
        Ship s4 = new Ship();
        
        space.add(s1, 0, 300);
        space.add(s2, 300, 0);
        space.add(s3, 499, 300);
        space.add(s4, 300, 499);
        
        s1.wrapAround();
        s2.wrapAround();
        s3.wrapAround();
        s4.wrapAround();
        
        assertEquals(499, s1.getGridX());
        assertEquals(499, s2.getGridY());
        assertEquals(0, s3.getGridX());
        assertEquals(0, s4.getGridY());
    }

}
