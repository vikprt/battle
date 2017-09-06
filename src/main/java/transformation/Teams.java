package transformation;

/*
 * @Project AEqulibrium Code Challenge
 * @Author 	Vikas Grover
 * Teams
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teams {
	
	private List<Transformer> decepticons;
	private List<Transformer> autobots;
	
	public Teams() {
		super();
		decepticons = new ArrayList<>();
		autobots = new ArrayList<>();
	}

	public List<Transformer> getDecepticons() {
		return decepticons;
	}

	public void setDecepticons(List<Transformer> decepticons) {
		this.decepticons = decepticons;
	}

	public List<Transformer> getAutobots() {
		return autobots;
	}

	public void setAutobots(List<Transformer> autobots) {
		this.autobots = autobots;
	}
	
	public void sortTeams() {
		Collections.sort(getDecepticons());
		Collections.sort(getAutobots());		
	}
	
}
