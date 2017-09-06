package transformation;

/*
 * @Project AEqulibrium Code Challenge
 * @Author 	Vikas Grover
 * This class is storing Result
 */
import java.util.ArrayList;
import java.util.List;

public class Result {

	private int noOfBattles;
	private int deceptionScore;
	private int autobotScore;
	private List<Transformer> deceptionsLeft;
	private List<Transformer> autobotsLeft;
	private List<Transformer> survivors;
	private String status;
	
	public Result () {
		super();
		deceptionsLeft = new ArrayList<>();
		autobotsLeft = new ArrayList<>();
		survivors = new ArrayList<>();
		status = "";
	}
	
	public int getNoOfBattles() {
		return noOfBattles;
	}
	public void setNoOfBattles(int noOfBattles) {
		this.noOfBattles = noOfBattles;
	}
	public void incrementNoOfBattles() {
		this.noOfBattles++;
	}

	public int getDeceptionScore() {
		return deceptionScore;
	}

	public int getAutobotScore() {
		return autobotScore;
	}

	public List<Transformer> getDeceptionsLeft() {
		return deceptionsLeft;
	}

	public List<Transformer> getAutobotsLeft() {
		return autobotsLeft;
	}

	public List<Transformer> getSurvivors() {
		return survivors;
	}

	public void setDeceptionScore(int deceptionScore) {
		this.deceptionScore = deceptionScore;
	}

	public void setAutobotScore(int autobotScore) {
		this.autobotScore = autobotScore;
	}

	public void setDeceptionsLeft(List<Transformer> deceptionsLeft) {
		this.deceptionsLeft = deceptionsLeft;
	}

	public void setAutobotsLeft(List<Transformer> autobotsLeft) {
		this.autobotsLeft = autobotsLeft;
	}

	public void setSurvivors(List<Transformer> survivors) {
		this.survivors = survivors;
	}		
	
	public void incrementDeceptionScore() {
		this.deceptionScore++;
	}

	public void incrementAutobotScore() {
		this.autobotScore++;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void printResult() {
		if (status.equals(Game.FACEOFF)) {
			System.out.println("Face-off between special players, game destroyed");
		} else {
			System.out.println(noOfBattles + " battle");
			if (deceptionScore > autobotScore) {
				System.out.print("Winning team (Decepticons): ");
				for (Transformer t: deceptionsLeft) {
					System.out.print(t.getName() + ", ");
				}
				System.out.println();
				System.out.println("Survivors from the losing team (Autobots): 	");
				System.out.println();
			} else if (autobotScore > deceptionScore) {
				System.out.print("Winning team (Autobots): ");
				for (Transformer t: autobotsLeft) {
					System.out.print(t.getName() + ", ");
				}
				System.out.println();
				System.out.println("Survivors from the losing team (Decepticons): ");
			} else {
				System.out.println("Battle ends in Tie");
			}
			
		}
	}
}
