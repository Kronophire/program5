import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  The SpaceTest test class testing different
 *  methods in the Space class.
 *
 *  @author Christopher Aska Toda (aska192)
 *  @version 2.2.1-14 (2013.11.17)
 */
public class SpaceTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    
    /**
     * Creates a new SpaceTest test object.
     */
    public SpaceTest()
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
    }

    // ----------------------------------------------------------
    
    /**
     * Tests the populate method of the Space class.
     */
    public void testPopulate()
    {
        space = new Space();

        assertEquals(space.numberOfObjects(), 6);
    }

}
