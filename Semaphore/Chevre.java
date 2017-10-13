class Chevre extends Animal
{
  public Chevre( String nom , GestionAffichages aff )
  {
    super( nom, aff );
    lockDonnees.askToken();
    nb_chevre++;
    lockDonnees.freeToken();
  }

  public void run()
  {
	
    approcherBateau(); // on s'approche du bateau
    
    //si on a token + bateau est la
    lockBateauPlaceChevre.askToken();
    entrerBateau(); // on monte dans le bateau
    lockBateauPret.freeToken();
    
    lockBateauArrive.askToken();
    descendreBateau(); // on descend du bateau
    
    lockDonnees.askToken();
    nb_chevre--;
    lockDonnees.freeToken();
 }
}
