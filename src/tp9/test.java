package tp9;

public class test {

	public static void main(String[] args) {
		epreuve e1=new epreuve("master",3);
		Candidat c1=new Candidat(1,"yassmine");
		Candidat c2=new Candidat(2,"yamamah");
		Candidat c3=new Candidat(3,"jihen");
		
		e1.ajoutCandidat(c1);
		try {
			e1.fixeResultat(1, new ResultatOral('B'));}
		catch(IllegalUpdateException e) {
			System.out.println(e.getMessage());
		}

		e1.ajoutCandidat(c2);
		try {
			e1.fixeResultat(2, new ResultatPoints(85));}
		catch(IllegalUpdateException e) {
			System.out.println(e.getMessage());
		}
		e1.ajoutCandidat(c3);
		try {
			
			e1.fixeResultat(3, new ResultatPoints(90));}
		catch(IllegalUpdateException e) {
			System.out.println(e.getMessage());
		}
		e1.terminer();
		System.out.println(e1);
		System.out.println("Vainqueur : " + e1.getVinqueur());
		System.out.println("Meilleur Résultat : " + e1.getRecord());	
	}


}

