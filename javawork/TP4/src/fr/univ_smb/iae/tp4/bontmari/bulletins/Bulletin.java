package fr.univ_smb.iae.tp4.bontmari.bulletins;

import java.util.Date;

//Question8
public class Bulletin {
	    protected String avis; // Représente l'avis météo
	    protected String date_avis; // Date à laquelle l'avis a été généré
	 
	    // Constructeur qui initialise l'avis météo et enregistre la date actuelle
	    public Bulletin(String avis) {
	        this.avis = avis;
	        this.date_avis = new Date().toString(); // Date actuelle
	    }

	    public String getAvis() {
	        return avis;
	    }

	    public String getDate_avis() {
	        return date_avis;
	    }

	    @Override
	    public String toString() {
	        return "Bulletin du " + this.date_avis.toString() + " - Avis : " + this.getAvis();
	    }
	}
