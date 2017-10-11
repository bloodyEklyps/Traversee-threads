// NE PAS TOUCHER A CETTE CLASSE
abstract class Animal extends MonThread
{
  private GestionAffichages _affichages;
	
  public Animal( String nom, GestionAffichages aff )
  {
    super( nom );
    _affichages = aff;
  }
	
  protected void approcherBateau()
  { 
    System.out.println( "" + Thread.currentThread().getName() + " approche du bateau" ); 
    _affichages.approcherBateau( Thread.currentThread().getName() );
  }
  
  protected void entrerBateau()
  {
    System.out.println( "" + Thread.currentThread().getName() + " monte dans le bateau" ); 
    _affichages.entrerBateau( Thread.currentThread().getName() );
  }
  
  protected void descendreBateau()
  { 
    System.out.println( "" + Thread.currentThread().getName() + " descend du bateau" ); 
    _affichages.descendreBateau( Thread.currentThread().getName() );
  }	
}
