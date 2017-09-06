package transformation;

/*
 * @Project AEqulibrium Code Challenge
 * @Author 	Vikas Grover
 * Main driving class to execute program
 */
public class Play {
	
	public static void main(String[] args) {
		String[] transformers = {
				"Soundwave,D,8,9,2,6,7,5,6,10",
				"Bluestreak,A,6,6,7,9,5,2,9,7",
				"Hubcap,A,4,6,4,4,4,4,4,4"
		};		
		Game game = new Game();
		game.play(transformers);
		game.getResult().printResult();
	}
}
