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
    // le bateau ne s'arrete jamais
    while( true )
    {
      voyageAller(); // le bateau fait le voyage aller
      voyageRetour(); // le bateau fait le voyage retour
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
