package fr.univ_smb.iae.tp4.bontmari.bulletins;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class BulletinMeteo extends Bulletin {

	    private String zone_geo;  // Zone géographique concernée, par exemple "Paris"

	    public BulletinMeteo(String avis) {//Constreur question8
	        super(avis); // Appel du constructeur de la classe mère
	    }

	    
	  // Partie 2 Question 5
	 // Déclaration d'une constante (constante) de classe(static) pour le nombre maximum de bulletins
	    private static final int MAX_BULLETINS = 10;

	    
	    // Méthode pour définir la zone géographique associée au bulletin météo
	    public void setZone_geo(String zone) {
	        this.zone_geo = zone;
	    }

	    // Méthode pour obtenir la zone géographique associée au bulletin météo
	    public String getZone_geo() {
	        return this.zone_geo;
	    }   

	    // Méthode toString pour représenter l'objet BulletinMeteo sous forme de chaîne de caractères
	    @Override
	    //Question8
	    public String toString() {
	        return super.toString() + " (" + this.zone_geo + ")"; // Appel de toString() de Bulletin
	    }

   
	    //Question 6 
	    public static BulletinMeteo randomBulletinMeteo() {
	        String[] tempsQuilFait = {"Grand beau temps", "Pluie", "Quelques averses", "Brouillard givrant", "Vent fort", "Nuageux"};
	        String[] temperatures = {"Doux", "Chaud", "Froid", "De saison"};
	        String[] geoZones = {"Annecy", "Paris", "Lyon", "Chambery"};

	        // Sélection aléatoire des indices pour les tableaux
	        int randomTempsQuilFaitNum = ThreadLocalRandom.current().nextInt(0, tempsQuilFait.length);
	        int randomTemperaturesNum = ThreadLocalRandom.current().nextInt(0, temperatures.length);
	        int randomGeoZonesNum = ThreadLocalRandom.current().nextInt(0, geoZones.length);

	        // Création d'un avis aléatoire
	        String avis = tempsQuilFait[randomTempsQuilFaitNum] + " - " + temperatures[randomTemperaturesNum];

	        // Création d'un nouveau bulletin météo avec les informations aléatoires
	        BulletinMeteo bulletin = new BulletinMeteo(avis);
	        bulletin.setZone_geo(geoZones[randomGeoZonesNum]);

	        return bulletin;
	    }

	    //Question 6 pour utiliser randomBulletinMeteo
	    public static ArrayList<BulletinMeteo> genererUnHistorique() {
	        ArrayList<BulletinMeteo> bulletins = new ArrayList<>();
	        for (int i = 0; i < MAX_BULLETINS; i++) {
	            bulletins.add(randomBulletinMeteo());
	        }
	        return bulletins;
	    }

	    
	    // Méthode statique pour générer un historique de 10 bulletins météo
	    //public static ArrayList<BulletinMeteo> genererUnHistorique() {
	    	//Méthode statique : Elle appartient à la classe. Tu l'appelles sans avoir besoin de créer un objet de cette classe.
	        // Création d'une liste pour stocker les bulletins météo générés
	        // ArrayList<BulletinMeteo> bulletins = new ArrayList<>();
	        
	        
	        //Partie 1 : genererUnHistorique de bulletin meteo sans la methode randomBulletinMeteo :methode statique pour geerner un histoque de 10 bulleitns meteo alétaoire 
	        // Tableau de chaînes de caractères représentant différents types de météo
	        //String[] tempsQuilFait = {"Grand beau temps", "Pluie", "Quelques averses", "Brouillard givrant", "Vent fort", "Nuageux"};
	        // Tableau pour les températures possibles
	        //String[] temperatures = {"Doux", "Chaud", "Froid", "De saison"};
	        // Tableau pour les zones géographiques disponibles
	        //String[] geoZones = {"Annecy", "Paris", "Lyon", "Chambery"};

	        // Partie 1 : Boucle pour générer 10 bulletins météo
	        //for (int i = 0; i < 10; i++) {
	        
	        //partie 2 : Question 5
	        //for (int i = 0; i < MAX_BULLETINS; i++) {
	        	
	        	
	            // Sélection aléatoire d'un temps, d'une température et d'une zone géographique
	            //int randomTempsQuilFaitNum = ThreadLocalRandom.current().nextInt(0, tempsQuilFait.length);
	            //int randomTemperaturesNum = ThreadLocalRandom.current().nextInt(0, temperatures.length);
	            //int randomGeoZonesNum = ThreadLocalRandom.current().nextInt(0, geoZones.length);

	            // Création de l'avis météo en combinant le temps et la température
	            //String avis = tempsQuilFait[randomTempsQuilFaitNum] + " - " + temperatures[randomTemperaturesNum];

	            // Création d'un objet BulletinMeteo avec l'avis généré
	            //BulletinMeteo bulletin = new BulletinMeteo(avis);

	            // Définition de la zone géographique associée au bulletin
	            //bulletin.setZone_geo(geoZones[randomGeoZonesNum]);

	            // Ajout du bulletin généré à la liste des bulletins
	            //bulletins.add(bulletin);
	        //}

	        // Retourne la liste des 10 bulletins météo générés
	        //return bulletins;
	    }
	
