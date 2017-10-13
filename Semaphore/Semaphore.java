class Semaphore
{
	 private int _counter;
	    
	  public Semaphore( int counter )
	  {
	    _counter = counter;
	  }

	  synchronized public void askToken()
	  {
	    // System.out.println( Thread.currentThread().getId() + " asked for a token" );
	    while( _counter <= 0 )
	    {
	      try
	      {
			// When no tokens are free,
			// the thread is put on hold.
			//System.out.println( "======> Thread put on hold <======" );
			wait();
	      }
	      catch(InterruptedException e)
	      {
	    	  System.out.println( e );
	      }
	    }
	    
	    --_counter; // Token consumption
	  }
	    
	  synchronized public void freeToken()
	  {
	    // The thread releases his token
	    // System.out.println( Thread.currentThread().getId() + " releases a token" );
	    ++_counter;
	    notifyAll();
	  }
	  
	  synchronized public int getTokens(){
		  return _counter;
	  }
}

