import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  The AsteroidTest test class testing different
 *  methods in the Asteroid class.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class AsteroidTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;
    private Asteroid asteroid;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    
    /**
     * Creates a new AsteroidTest test object.
     */
    public AsteroidTest()
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
        space = new Space();
        asteroid = new Asteroid(0, 0);

    }

    // ----------------------------------------------------------

    /**
     * Tests the act() method of the asteroid class.
     */
    public void testAct1()
    {
        asteroid = new Asteroid(10, 0);
        space.add(asteroid, 300, 300);

        asteroid.act();

        assertEquals(310, asteroid.getGridX());
        assertEquals(300, asteroid.getGridY());
    }

    /**
     * Tests another part of the act() method
     * of the asteroid class.
     */
    public void testAct2()
    {
        space.add(asteroid, 0, 300);

        asteroid.act();

        assertEquals(499, asteroid.getGridX());
    }

    /**
     * Tests the wrapAround() method of the asteroid class.
     */
    public void testWrapAround()
    {
        Asteroid a2 = new Asteroid(0, 0);
        Asteroid a3 = new Asteroid(0, 0);
        Asteroid a4 = new Asteroid(0, 0);

        space.add(asteroid, 0, 300);
        space.add(a2, 300, 0);
        space.add(a3, 499, 300);
        space.add(a4, 300, 499);

        asteroid.wrapAround();
        a2.wrapAround();
        a3.wrapAround();
        a4.wrapAround();

        assertEquals(499, asteroid.getGridX());
        assertEquals(499, a2.getGridY());
        assertEquals(0, a3.getGridX());
        assertEquals(0, a4.getGridY());
    }

    /**
     * Tests the getSpeed() method of the Asteroid class.
     */
    public void testGetSpeed()
    {
        assertEquals(0, asteroid.getSpeed());
    }

    /**
     * Tests when the ship and an asteroid would collide
     * and that both the collided asteroid and ship would
     * get removed from the space.
     */
    public void testShipHit()
    {
        run(space, 500);

        assertEquals(0, space.getObjects(Ship.class).size());
        assertEquals(4, space.getObjects(Asteroid.class).size());
    }

}
