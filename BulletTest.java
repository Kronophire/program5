import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  The BulletTest test class testing different
 *  methods in the Bullet class.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class BulletTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;
    private Bullet bullet;
    private Asteroid asteroid;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BulletTest test object.
     */
    public BulletTest()
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
        bullet = new Bullet(0, 0);
        asteroid = new Asteroid(0, 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests the act in the bullet to check if the
     * bullet moved forward once with a speed of 2.
     */
    public void testAct1()
    {
        bullet = new Bullet(2, 0);
        space.add(bullet, 250, 250);

        bullet.act();

        assertEquals(252, bullet.getGridX());
        assertEquals(250, bullet.getGridY());
    }

    /**
     * Tests that the asteroid gets removed by
     * a bullet in the act() method of 
     * the bullet class.
     */
    public void testAct2()
    {
        space.add(bullet, 250, 250);
        space.add(asteroid, 250, 250);

        bullet.act();

        assertEquals(space.numberOfObjects(), 6);        
    }

    /**
     * Tests the bullets being removed at the 
     * edge of the space, using the act method
     * of the bullet class.
     */
    public void testAct3()
    {
        space.add(bullet, 0, 100);

        bullet.act();

        assertEquals(space.numberOfObjects(), 6);
    }

    /**
     * Tests the onEdge() method of the bullet class.
     */
    public void testOnEdge()
    {
        Bullet b2 = new Bullet(0, 0);

        space.add(bullet, 0, 100);
        space.add(b2, 210, 210);

        assertTrue(bullet.onEdge());
        assertFalse(b2.onEdge());
    }
    
    /**
     * Tests the getSpeed() method of the Asteroid class.
     */
    public void testGetSpeed()
    {
        assertEquals(0, bullet.getSpeed());
    }

}
