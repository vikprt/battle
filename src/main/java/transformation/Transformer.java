package transformation;

/*
 * @Project AEqulibrium Code Challenge
 * @Author 	Vikas Grover
 * Transformer Entity 
 */
public class Transformer implements Comparable<Transformer> {
	
	private String name;
	private String type;
	private int strength;
	private int intelligence; 
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;
	private int overallRating;
	
	public Transformer() { 
		super();
	}
	
	public Transformer(String name, String type, String strength, String intelligence, String speed, 
						String endurance, String rank, String courage, String firepower, String skill) {
		super();
		this.name = name;
		this.type = type;
		this.strength = Integer.valueOf(strength);
		this.intelligence = Integer.valueOf(intelligence);
		this.speed = Integer.valueOf(speed);
		this.endurance = Integer.valueOf(endurance);
		this.rank = Integer.valueOf(rank);
		this.courage = Integer.valueOf(courage);
		this.firepower = Integer.valueOf(firepower);
		this.skill = Integer.valueOf(skill);
		overallRating = this.strength+this.intelligence+this.speed+this.endurance+this.firepower;
	} 

	@Override
	public String toString() {
		return "Transformer [name=" + name + ", type=" + type + ", strength=" + strength + ", intelligence="
				+ intelligence + ", speed=" + speed + ", endurance=" + endurance + ", rank=" + rank + ", courage="
				+ courage + ", firepower=" + firepower + ", skill=" + skill + ", overallRating=" + overallRating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transformer other = (Transformer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

	@Override
	public int compareTo(Transformer o) {
		return this.rank - o.getRank();
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getStrength() {
		return strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public int getEndurance() {
		return endurance;
	}

	public int getRank() {
		return rank;
	}

	public int getCourage() {
		return courage;
	}

	public int getFirepower() {
		return firepower;
	}

	public int getSkill() {
		return skill;
	}

	public int getOverallRating() {
		return overallRating;
	}
	

}
