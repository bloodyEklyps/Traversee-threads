class Chevre extends Animal
{
  public Chevre( String nom , GestionAffichages aff )
  {
    super( nom, aff );
  }

  public void run()
  {
	
    approcherBateau(); // on s'approche du bateau
    
    //si on a token + bateau est la
    entrerBateau(); // on monte dans le bateau
    
    //wait que le bateau est arrivé
    descendreBateau(); // on descend du bateau
 }
}
