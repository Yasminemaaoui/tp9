package tp9;

import java.util.Arrays;

public class epreuve {
    private String denomination;
    private Candidat[] tab;
    private int max;
    private int nbeffectif;
    private boolean etat; // true si l'épreuve est terminée

    // Constructeur
    public epreuve(String denomination, int max) {
        this.denomination = denomination;
        this.max = max;
        this.nbeffectif = 0;
        this.tab = new Candidat[max];
        this.etat = false;
    }

    @Override
    public String toString() {
        return "epreuve [denomination=" + denomination + ", tab=" + Arrays.toString(tab) + ", max=" + max
                + ", nbeffectif=" + nbeffectif + ", etat=" + etat + "]";
    }

    // Ajouter un candidat
    public void ajoutCandidat(Candidat c) {
        if (nbeffectif < max) {
            tab[nbeffectif] = c;
            nbeffectif++;
        } else {
            System.out.println("Pas d'espace possible dans le tableau.");
        }
    }

    // Terminer l'épreuve
    public void terminer() {
        etat = true;
    }

    // Vérifier si l'épreuve est terminée
    public boolean estTerminee() {
        return etat;
    }

    // Obtenir le meilleur résultat
    public Resultat getRecord() {
        if (nbeffectif == 0) return null; // Aucun candidat

        Resultat meilleurResultat = null;

        for (int i = 0; i < nbeffectif; i++) {
            Resultat current = tab[i].getResultat();
            if (current != null) {
                if (meilleurResultat == null || (meilleurResultat.getClass() == current.getClass() &&
                                                 current.compareTo(meilleurResultat) > 0)) {
                    meilleurResultat = current;
                }
            }
        }
        return meilleurResultat;
    }

    // Obtenir le vainqueur
    public Candidat getVinqueur() {
        if (!estTerminee()) {
            System.out.println("L'épreuve n'est pas encore terminée.");
            return null;
        }
        Resultat meilleurResultat = getRecord();
        for (int i = 0; i < nbeffectif; i++) {
            if (meilleurResultat != null && meilleurResultat.equals(tab[i].getResultat())) {
                return tab[i];
            }
        }
        return null;
    }

    // Fixer un résultat pour un candidat donné
    public void fixeResultat(int id, Resultat r) throws IllegalUpdateException {
        if (etat) { // Si l'épreuve est terminée, interdiction de modifier les résultats
            throw new IllegalUpdateException("L'épreuve est terminée, impossible de fixer un résultat.");
        }
        boolean candidatTrouve = false;
        for (int i = 0; i < nbeffectif; i++) {
            if (tab[i].getId() == id) {
                tab[i].setResultat(r);
                candidatTrouve = true;
                break;
            }
        }
        if (!candidatTrouve) {
            System.out.println("Candidat introuvable pour l'ID : " + id);
        }
    }

    // Obtenir le résultat d'un candidat par son ID
    public Resultat getResultat(int id) {
        for (int i = 0; i < nbeffectif; i++) {
            if (tab[i].getId() == id) {
                return tab[i].getResultat();
            }
        }
        return null;
    }
}
