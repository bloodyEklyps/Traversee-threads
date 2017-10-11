class Loup extends Animal
{
  public Loup( String nom, GestionAffichages aff )
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
