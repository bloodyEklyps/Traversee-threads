class Loup extends Animal
{
  public Loup( String nom, GestionAffichages aff )
  {
    super( nom, aff );
  }

  public void run()
  {
    approcherBateau(); // on s'approche du bateau
    
    //si on a token + bateau est la
    entrerBateau(); // on monte dans le bateau
    
    //si bateau arrivé
    descendreBateau(); // on descend du bateau
  }
}
