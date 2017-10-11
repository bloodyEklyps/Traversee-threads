class Chevre extends Animal
{
  public Chevre( String nom , GestionAffichages aff )
  {
    super( nom, aff );
  }

  public void run()
  {
    approcherBateau(); // on s'approche du bateau
    entrerBateau(); // on monte dans le bateau
    descendreBateau(); // on descend du bateau
 }
}
