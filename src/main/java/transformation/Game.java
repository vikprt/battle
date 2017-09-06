package transformation;

/*
 * @Project AEqulibrium Code Challenge
 * @Author 	Vikas Grover
 * This class is the main business logic layer, where calculations are done 
 */
public class Game {

	protected static final String FACEOFF = "FACEOFF";
	private static final String DELIMITER = ",";
	private static final int TYPEINDEX = 1;
	private static final String DECEPTION = "D";
	private static final int COURAGEPOINTS = 4;
	private static final int STRENGTHPOINTS = 3;
	private static final int SKILLPOINTS = 3;
	private static final String OPTIMUS = "Optimus Prime";
	private static final String PREDAKING = "Predaking";
	private Teams teams;
	private Result result;
	
	public Game() {
		super();
		result = new Result();
	}

	public void play(String[] transformers) {
		teams = parseTeams(transformers);
		teams.sortTeams();
		
		Transformer[] deceptions = teams.getDecepticons().toArray(new Transformer[teams.getDecepticons().size()]);

		Transformer[] autobots = teams.getAutobots().toArray(new Transformer[teams.getAutobots().size()]);

		for (int i=0; i<deceptions.length && i<autobots.length; i++) {
			if (isFaceOff(deceptions[i].getName(), autobots[i].getName())) {
				result.setStatus(FACEOFF);
				break;
			}
			result.incrementNoOfBattles();
			if ( 	(deceptions[i].getName().equals(OPTIMUS)) 
					|| (deceptions[i].getName().equals(PREDAKING))
					|| ( (deceptions[i].getCourage() - autobots[i].getCourage() >= COURAGEPOINTS) 
							&& (deceptions[i].getStrength() - autobots[i].getStrength() >= STRENGTHPOINTS) ) 
					|| (deceptions[i].getSkill() - autobots[i].getSkill() >= SKILLPOINTS) 
					|| (deceptions[i].getOverallRating() > autobots[i].getOverallRating()) ) {
				result.incrementDeceptionScore();
				result.getDeceptionsLeft().add(deceptions[i]);
			} else if ( (autobots[i].getName().equals(OPTIMUS)) 
						|| (autobots[i].getName().equals(PREDAKING))
						|| ( (autobots[i].getCourage() - deceptions[i].getCourage() >= COURAGEPOINTS) 
							&& (autobots[i].getStrength() - deceptions[i].getStrength() >= STRENGTHPOINTS) )
						|| (autobots[i].getSkill() - deceptions[i].getSkill() >= SKILLPOINTS)
						|| (autobots[i].getOverallRating() > deceptions[i].getOverallRating()) ) {
				result.incrementAutobotScore();
				result.getAutobotsLeft().add(autobots[i]);
			} 
		}
	}
	
	public boolean isFaceOff(String deceptionName, String autobotName) {
		if ( (deceptionName.equals(OPTIMUS)) 
				&& ( (autobotName.equals(OPTIMUS)) || (autobotName.equals(PREDAKING)) ) || 
		     ( (autobotName.equals(PREDAKING)) 
				&& ( (deceptionName.equals(PREDAKING)) || (deceptionName.equals(OPTIMUS)) ) ) 
		     ) {
			return true;
		}
		return false;
	}
	
	public Teams parseTeams(String[] transformers) {
		Teams parseTeams = new Teams(); 
		for (String t: transformers) {
			String[] trans = t.split(DELIMITER);
			if (trans[TYPEINDEX].trim().equals(DECEPTION)) {
				parseTeams.getDecepticons().add(new Transformer(trans[0], trans[1], trans[2], trans[3], trans[4], trans[5], trans[6], trans[7], trans[8], trans[9]));
			} else {
				parseTeams.getAutobots().add(new Transformer(trans[0], trans[1], trans[2], trans[3], trans[4], trans[5], trans[6], trans[7], trans[8], trans[9]));
			}
		}
		return parseTeams;
	}

	public Teams getTeams() {
		return teams;
	}

	public Result getResult() {
		return result;
	}
	
	
}
