class Bateau extends MonThread
{
  private GestionAffichages _affichages; // objet gestion des affichages

  public Bateau( String nom, GestionAffichages aff )
  {
    super( nom );
    _affichages = aff;
  }

  public void run()
  {
    while(true)
    {
      //tant que bateau pas plein, on attend
      lockDonnees.askToken();
      
      if(nb_loup >= 3 || nb_chevre >=3 || (nb_chevre >= 2 && nb_loup == 1)){
    	  lockDonnees.freeToken();
    	  
    	  if(nb_loup >= 3){
        	  lockBateauPlaceLoup.freeToken();
        	  lockBateauPlaceLoup.freeToken();
        	  lockBateauPlaceLoup.freeToken();
    	  } else if (nb_chevre >=3) {
        	  lockBateauPlaceChevre.freeToken();
        	  lockBateauPlaceChevre.freeToken();
        	  lockBateauPlaceChevre.freeToken();
    	  } else if(nb_chevre >= 2 && nb_loup >= 1){
        	  lockBateauPlaceLoup.freeToken();
        	  lockBateauPlaceChevre.freeToken();
        	  lockBateauPlaceChevre.freeToken();
    	  }
    	  
    	  lockBateauPret.askToken();
    	  lockBateauPret.askToken();
    	  lockBateauPret.askToken();
	      voyageAller(); // le bateau fait le voyage aller
	      
	      lockBateauArrive.freeToken();
	      lockBateauArrive.freeToken();
	      lockBateauArrive.freeToken();
	      
	      //while bateau pas vide wait
	      voyageRetour(); // le bateau fait le voyage retour

	      //notify je suis arrivé
      } else {
    	  lockDonnees.freeToken();
      }
    }
  }
	
  private void voyageAller()
  { 
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Depart du bateau");	
    _affichages.voyageAller(); // voyage sur la fenetre graphique
    System.out.println("Fin du voyage");
  }
	
  private void voyageRetour()
  { 
    System.out.println("Retour du bateau");
    _affichages.voyageRetour(); // voyage sur la fenetre graphique
    System.out.println("Bateau pret");
    System.out.println("-----------------------------------------------------------------");
  }	
}
