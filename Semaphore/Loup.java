class Loup extends Animal
{
  public Loup( String nom, GestionAffichages aff )
  {
    super( nom, aff );
    lockDonnees.askToken();
    nb_loup++;
    lockDonnees.freeToken();
  }

  public void run()
  {
    approcherBateau(); // on s'approche du bateau
    
    //si on a token + bateau est la
    lockBateauPlaceLoup.askToken();
    entrerBateau(); // on monte dans le bateau
    lockBateauPret.freeToken();
    
    //si bateau arrivé
    lockBateauArrive.askToken();
    descendreBateau(); // on descend du bateau
    
    lockDonnees.askToken();
    nb_loup--;
    lockDonnees.freeToken();
  }
}
