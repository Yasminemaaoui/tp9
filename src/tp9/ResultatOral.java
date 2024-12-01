package tp9;

public class ResultatOral implements Resultat{
	private char appreciation;



	public ResultatOral(char x) {
		if(x <'A' || x>'c') {
			throw new IllegalArgumentException("Appréciation invalide");
	}
		this.appreciation=x;
	}

	public char getAppreciation() {
		return appreciation;
	}

	@Override
	public String toString() {
		return "ResultatOral [appreciation=" + appreciation + "]";
	}

	@Override
	public int compareTo(Resultat r) {
		if(! (r instanceof ResultatOral)) {
			throw new IllegalArgumentException("impossible de faire compaaraison de type différent");
		}
		if(((ResultatOral)r).appreciation==appreciation) {
			return 0;
		}
		else if(((ResultatOral)r).appreciation>appreciation) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	
}
