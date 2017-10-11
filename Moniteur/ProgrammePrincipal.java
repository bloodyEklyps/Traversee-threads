// NE PAS TOUCHER A CETTE CLASSE
import java.util.*;
import java.io.*;
import java.text.*;

class ProgrammePrincipal
{
  public static void main( String args[] )
  {
    int nbLoups, nbChevres; // nombre de threads loups et de threads chevres a lancer
    int numLoup = 1, numChevre = 1; // numeros des animaux (chevre numero 1 et loup numero 1 au depart)

    final int CHOIXLOUP = 1; // constantes pour indiquer le choix du thread lance (loup ou chevre)
    final int CHOIXCHEVRE = 2;
    int choix = 0; // indique le choix du thread lance (loup ou chevre)

    Random random = new Random(); // objet permettant d'avoir des nombres aleatoires
	
    // on demande ces nombres a l'utilisateur
    do
    {
      System.out.print( "Nombre de loups (1-50): " );
      nbLoups = getInt();
    }
    while( ( nbLoups < 0 ) || ( nbLoups > 50 ) );
    
    do
    {
      System.out.print( "Nombre de chevres (1-50): " );
      nbChevres = getInt();
    }
    while( ( nbChevres < 0 ) || ( nbChevres > 50 ) );

    GestionAffichages affichages = new GestionAffichages();
    new Bateau( "Bateau" , affichages ).start(); // on lance le thread "bateau"

    // tant que on n'a pas cree tous les loups et toutes les chevres
    while( ( numLoup <= nbLoups ) || ( numChevre <= nbChevres ) )
    {		
      try
      {
	// on attend entre 2 et 3 secondes
	Thread.sleep( random.nextInt( 1000 ) + 2000);
      }
      catch( InterruptedException e ) { }
			
      if( numLoup > nbLoups )
	choix = CHOIXCHEVRE; // si on a cree tous les loups on va creer une chevre
      else 
	if( numChevre > nbChevres)
	  choix = CHOIXLOUP; // si on a cree toutes les chevres on va creer un loup
	else 
	  if( random.nextInt( 2 ) == 0)
	    choix = CHOIXLOUP;
	  else
	    choix = CHOIXCHEVRE;
			
      if( choix == CHOIXLOUP )
      { 
	new Loup( "Loup" + numLoup, affichages ).start(); // on cree un thread loup de nom "LoupN"
	System.out.print( "plop loup" );
	++numLoup; 
      }
      else
      { 
	new Chevre( "Chevre" + numChevre, affichages ).start(); // on cree un thread chevre de nom "ChevreN"
	System.out.print( "plop chevre" );
	++numChevre; 
      } 
    }
  }

  // lit un entier au clavier
  private static int getInt()
  {
    try
    {
      InputStreamReader conv = new InputStreamReader( System.in );
      BufferedReader entree = new BufferedReader( conv );
      String texte = entree.readLine();
      int i = NumberFormat.getInstance().parse( texte ).intValue();
      return i;
    } 
    catch(IOException e) { return 0; }
    catch(ParseException pe) { return 0; } 
  }
		
}
