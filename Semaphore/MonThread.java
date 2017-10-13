abstract class MonThread extends Thread
{
	static int nb_loup = 0;
	static int nb_chevre = 0;
	static Semaphore lockBateauPret = new Semaphore(0);
	static Semaphore lockBateauPlaceChevre = new Semaphore(0);
	static Semaphore lockBateauPlaceLoup = new Semaphore(0);
	static Semaphore lockDonnees = new Semaphore(1);
	static Semaphore lockBateauArrive = new Semaphore(0);
	
	
	
	public MonThread( String nom ){
	  super( nom );
	}
}
