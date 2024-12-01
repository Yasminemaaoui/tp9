package tp9;

public class ResultatPoints implements Resultat {

	private int point ;

	public ResultatPoints(int point) {
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	@Override
	public String toString() {
		return "ResultatPoints [point=" + point + "]";
	}

	@Override
	public int compareTo(Resultat r) {
		if(!(r instanceof ResultatPoints )) {
			throw new IllegalArgumentException("impossible de faire compaaraison de type différent");
		}
		if (((ResultatPoints)r).point==point) {
			return 0;
		}
		else if (((ResultatPoints)r).point>point) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
