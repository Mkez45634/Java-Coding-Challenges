package q1;

public class BirdDetails {
	private String latinName;
	private String avgLifespan;
	
	public BirdDetails(String n, String l) {
		setLatinName(n);
		setAvgLifespan(l);
	}

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

	public String getAvgLifespan() {
		return avgLifespan;
	}

	public void setAvgLifespan(String avgLifespan) {
		this.avgLifespan = avgLifespan;
	}

}
