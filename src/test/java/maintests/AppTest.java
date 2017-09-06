package maintests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import transformation.Game;

public class AppTest 
    extends TestCase
{
		
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test Case as per requirement to determine winner
     */
    public void testBattleOne() {
       	String[] transformers = {
    			"Soundwave,D,8,9,2,6,7,5,6,10",
    			"Bluestreak,A,6,6,7,9,5,2,9,7",
    			"Hubcap,A,4,6,4,4,4,4,4,4"
    	};   	
		Game game = new Game();
		game.play(transformers);
        assertEquals("There should be only one battle", game.getResult().getNoOfBattles(), 1);
        assertEquals("There should be one Deception Winner", game.getResult().getDeceptionScore(), 1);
        assertEquals("Winner team name is Soundwave", game.getResult().getDeceptionsLeft().get(0).getName(), "Soundwave");
    }
    
    /**
     * Test Special rule of faceoff
     */    
    public void testFaceOff() {
    	String[] transformers = {
    			"Optimus Prime,D,8,9,2,6,7,5,6,10",
    			"Predaking,A,6,6,7,9,5,2,9,7"
    	};      	
		Game game = new Game();
		game.play(transformers);
        assertEquals("No Battle took place due to Face-Off", game.getResult().getNoOfBattles(), 0);
        assertEquals("Status should be FACEOFF", game.getResult().getStatus(), "FACEOFF");
    }   
    
    /**
     * Test Special rule of faceoff in case of duplicate Transformers
     */     
    public void testFaceOffDuplicate() {
    	String[] transformers = {
    			"Optimus Prime,D,8,9,2,6,7,5,6,10",
    			"Optimus Prime,A,6,6,7,9,5,2,9,7"
    	};      	
		Game game = new Game();
		game.play(transformers);
        assertEquals("No Battle took place due to Face-Off", game.getResult().getNoOfBattles(), 0);
        assertEquals("Status should be FACEOFF", game.getResult().getStatus(), "FACEOFF");
    } 
}
