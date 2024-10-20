package fr.univ_smb.iae.tp4.bontmari;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import fr.univ_smb.iae.tp4.bontmari.bulletins.BulletinMeteo;
public class ServeurMeteo {
	//Question 1 associer BulletinMeteo
	    private ArrayList<BulletinMeteo> bulletinsMeteo;
	    private int port = 9090;
	    private ServerSocket serveurSocket;
	   
	  
	    //question2
	    // Constructeur qui génère un historique automatiquement question2
	    //Associer les bulletins au serveur météo
	    public ServeurMeteo() {
	    	// Un historique est genere automatiquement des la creation du serveur
	    	this.setBulletinsMeteo(BulletinMeteo.genererUnHistorique());
	    }
	    public ArrayList<BulletinMeteo> getBulletinsMeteo() {
	        return this.bulletinsMeteo;
	    }
	    //Modifcateur question 1
	    public void setBulletinsMeteo(ArrayList<BulletinMeteo> bulletinsMeteo) {
	        this.bulletinsMeteo = bulletinsMeteo;
	    }
	    public void ouvrirConnexion() throws IOException {
	        ServerSocket serveurSocket = new ServerSocket(this.port);
	        System.out.println("Serveur prêt sur le port " + this.port);
	    }// c'est qui permet de faire la connexion entre les deux serveurs
	   
	   
	    //Question7
	    public void donnerMeteo() throws IOException {
	        // Initialisation d'un compteur pour suivre le nombre de requêtes traitées
	        int nbRequetesTraitees = 0;
	        ServerSocket serveurSocket = new ServerSocket(this.port);  // Ouvrir une connexion serveur
	       
	        while (true) {
	            // Le serveur accepte une nouvelle connexion (requête client)
	            Socket socket = serveurSocket.accept();  // Accepter une nouvelle requête client
	           
	            // Incrémentation du compteur à chaque nouvelle requête
	            nbRequetesTraitees++;
	           
	            // Toutes les 5 requêtes (si le compteur est un multiple de 5)
	            if (nbRequetesTraitees % 5 == 0) {
	                // Afficher l'historique des bulletins météo
	                System.out.println("===== Affichage de l'historique des bulletins après " + nbRequetesTraitees + " requêtes =====");
	                ServeurMeteo.afficherBulletins(this.getBulletinsMeteo());
	               
	                // Générer et ajouter un nouveau bulletin météo aléatoire à l'historique
	                BulletinMeteo nouveauBulletin = BulletinMeteo.randomBulletinMeteo();
	                this.bulletinsMeteo.add(nouveauBulletin);
	                System.out.println("Nouveau bulletin météo ajouté à l'historique : " + nouveauBulletin.toString());
	            }
	            // Ici, vous pouvez envoyer la météo au client (ce code existe probablement déjà)
	            // Utiliser la méthode pour répondre au client avec les bulletins météo
	            // ...
	        }
	    }
	   
	    //question4
	    // Méthode pour afficher tous les bulletins dans l'historique
	    public static void afficherBulletins(ArrayList<BulletinMeteo> bulletins) {
	        System.out.println("===== Affichage des bulletins meteo =====\n");
	        for (BulletinMeteo bulletin : bulletins) {
	            System.out.println(bulletin.toString());
	        }
	    }
	   
	   
	   
	   
	    //Question 3
	 // TP4 Elle permet de retourner TOUS les bulletins trouves
	    // dans l'historique dont la zone geo correspond a celle
	    // passee en parametre.
	    public ArrayList<BulletinMeteo> rechercherBulletins(String zoneG) {
	        ArrayList<BulletinMeteo> bulletins = new ArrayList<BulletinMeteo>();  // Liste pour stocker les bulletins trouvés
	     // Vérification si la zone géographique du bulletin correspond à la zone recherchée
	        for (BulletinMeteo bulletin : this.getBulletinsMeteo()) { 
	            if (bulletin.getZone_geo().equals(zoneG)) { 
	            	// Vérification si la zone géographique correspond
	            	// Si oui, on ajoute ce bulletin à la liste des résultats
	                bulletins.add(bulletin);  // Si correspondance, ajout du bulletin à la liste
	            }
	        }
	     // Retourne la liste des bulletins trouvés
	        return bulletins; 
	    }
	   
	   
	    public static void main(String[] args) throws IOException {
	        // Création du serveur et génération de l'historique automatiquement
	        ServeurMeteo serveur = new ServeurMeteo();
	        //serveur.ouvrirConnexion();
	       
	        // Affiche les bulletins générés
	        ServeurMeteo.afficherBulletins(serveur.getBulletinsMeteo());
	       
	       
	       
	        //Question 3
	       // Test de la méthode rechercherBulletins
	       
	        String zoneRecherchee = "Paris";  // Exemple de zone géographique à rechercher
	        System.out.println("\nRecherche des bulletins pour la zone : " + zoneRecherchee);
	       
	        ArrayList<BulletinMeteo> bulletinsTrouves = serveur.rechercherBulletins(zoneRecherchee);
	       
	        if (bulletinsTrouves.isEmpty()) {
	            System.out.println("Aucun bulletin trouvé pour la zone " + zoneRecherchee);
	        } else {
	            ServeurMeteo.afficherBulletins(bulletinsTrouves);
	           
	        }
	 
	        // revoir la différence
	     // Question 4
	        // Affiche uniquement les bulletins météo de la zone "Paris"
	        System.out.println("\nBulletins météo trouvés pour la zone Paris :");
	        ServeurMeteo.afficherBulletins(serveur.rechercherBulletins("Paris"));
		   
	  
	    }
	}

