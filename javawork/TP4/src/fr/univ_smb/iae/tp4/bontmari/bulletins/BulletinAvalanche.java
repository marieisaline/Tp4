package fr.univ_smb.iae.tp4.bontmari.bulletins;

public class BulletinAvalanche extends BulletinMeteo {

    // Attributs spécifiques à BulletinAvalanche
    private int hauteurNeigeFraiche;  // Hauteur de neige fraîche en cm
    private int niveauRisque = 3;  // Niveau de risque d'avalanche (valeur par défaut : 3)

    // Constructeur de la classe BulletinAvalanche
    public BulletinAvalanche(String avis, String zone, int hauteurNeigeFraiche) {
        super(avis);  // Appel au constructeur de BulletinMeteo
        this.setZone_geo(zone);  // Spécifie la zone géographique
        this.hauteurNeigeFraiche = hauteurNeigeFraiche;  // Spécificité : hauteur de neige
    }
    
    // Méthodes pour obtenir et modifier la hauteur de neige et le niveau de risque
    public int getHauteurNeigeFraiche() {
        return this.hauteurNeigeFraiche;
    }

    public void setHauteurNeigeFraiche(int hauteurNeigeFraiche) {
        this.hauteurNeigeFraiche = hauteurNeigeFraiche;
    }

    public int getNiveauRisque() {
        return this.niveauRisque;
    }

    public void setNiveauRisque(int niveauRisque) {
        this.niveauRisque = niveauRisque;
    }
    
    
    //Question9=>Redefinition de la methode toString() pour la classe BulletinAvalancce
    
    @Override
    public String toString() {
        // Appel à la méthode toString() de BulletinMeteo (qui elle-même fait appel à toString() de Bulletin)
        return super.toString() + 
               " - Neige fraîche : " + hauteurNeigeFraiche + " cm - Niveau de risque : " + niveauRisque;
    }
}
    
    

