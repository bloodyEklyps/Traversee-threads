// NE PAS TOUCHER A CETTE CLASSE
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.math.*;

class GestionAffichages {
  private final int _NBANIMAUX = 51;
  
  private JFrame _fenetre;
  private JLabel _loups[];
  private JLabel _chevres[];
  private JLabel _bateau;
  private JLabel _fond;
  
  private Random _random;
  
  private int _nbPassagers;
  private JLabel _passagers[];
  
  public GestionAffichages()
  {
    _random = new Random();
    _nbPassagers = 0;
    _passagers = new JLabel[3];
    
    ImageIcon imageLoup = new ImageIcon("../Images/loup.gif");
    ImageIcon imageChevre = new ImageIcon("../Images/chevre.gif");
    ImageIcon imageBateau = new ImageIcon("../Images/bateau.gif");
    ImageIcon imageFond = new ImageIcon("../Images/fond.gif");
	
    _loups = new JLabel[_NBANIMAUX];
    for( int i = 0 ; i < _NBANIMAUX ; ++i )
    {
      _loups[i] = new JLabel( "L" + i, imageLoup, JLabel.CENTER );
      _loups[i].setVerticalTextPosition( JLabel.BOTTOM );
      _loups[i].setHorizontalTextPosition( JLabel.CENTER );
      _loups[i].setBounds( _random.nextInt( 350 ) + 10, -50, 25, 40 );
    }
		
    _chevres = new JLabel[ _NBANIMAUX ];
    for( int i = 0 ; i < _NBANIMAUX ; ++i ) {
      _chevres[i] = new JLabel( "C" + i, imageChevre, JLabel.CENTER );
      _chevres[i].setVerticalTextPosition( JLabel.BOTTOM );
      _chevres[i].setHorizontalTextPosition( JLabel.CENTER );
      _chevres[i].setBounds( _random.nextInt( 350 ) + 10, -50, 25, 40 );
    }
		
    _bateau = new JLabel( "Bateau", imageBateau, JLabel.CENTER );
    _bateau.setVerticalTextPosition( JLabel.BOTTOM );
    _bateau.setHorizontalTextPosition( JLabel.CENTER );
    _bateau.setBounds( 140, 80, 75, 60 );
		
    _fond = new JLabel( imageFond );
    _fond.setBounds( 0, 0, 400, 400 );
		
	
    try
    {
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    }
    catch( Exception e ) { }
		
    _fenetre = new JFrame( "Affichage Traversee de la Loire" );
		
    for( int i = 0 ; i < _NBANIMAUX ; ++i )
      _fenetre.getContentPane().add( _loups[i] );
    for( int i = 0 ; i < _NBANIMAUX ; ++i)
      _fenetre.getContentPane().add( _chevres[i] );
    _fenetre.getContentPane().add( _bateau );
    _fenetre.getContentPane().add( _fond );

    _fenetre.pack();
    _fenetre.setBounds( 30, 30, 400, 420 );
    _fenetre.setVisible( true );
		
    _fenetre.addWindowListener( new WindowAdapter() { public void windowClosing( WindowEvent e ) { System.exit( 0 ); } } );
  }
	
  public void approcherBateau( String string )
  {
    JLabel animal;
    int numero;
    if( string.startsWith( "Loup" ) )
    {
      numero = Integer.parseInt( string.substring( 4, string.length() ) );
      animal = _loups[ numero ];
    }
    else
    {
      numero = Integer.parseInt( string.substring(6, string.length() ) );
      animal = _chevres[ numero ];
    }
		
    int xorig = animal.getX();
    int yorig = animal.getY();
    int xfinal = 200 + _random.nextInt( 200 ) - 100;
    int yfinal = 30 + _random.nextInt( 30 );
		
    int xdecal = xfinal - xorig;
    int ydecal = yfinal - yorig;
		
    Date d = new Date();
    long temps = d.getTime();
    float avancement;
		
    while( animal.getY() < yfinal - 2)
    {
      d = new Date();
      avancement = (float)( d.getTime() - temps ) / 3000;
      animal.setLocation( xorig + (int)( avancement * xdecal ), yorig + (int)( avancement * ydecal ) );
      _fenetre.repaint();
    }
		
  }
	
  public void entrerBateau( String string )
  {
    JLabel animal;
    int numero;
    if( string.startsWith( "Loup" ) )
    {
      numero = Integer.parseInt( string.substring( 4, string.length() ) );
      animal = _loups[ numero ];
    } else {
      numero = Integer.parseInt( string.substring(6, string.length() ) );
      animal = _chevres[ numero ];
    }
		
    int xorig = animal.getX();
    int yorig = animal.getY();
    _passagers[ _nbPassagers ] = animal;
    ++_nbPassagers;
    int xfinal = 110 + ( _nbPassagers * 25 );
    int yfinal = 75;
		
    int xdecal = xfinal - xorig;
    int ydecal = yfinal - yorig;
		
    Date d = new Date();
    long temps = d.getTime();
    float avancement;
		
    while( animal.getY() < yfinal - 2 )
    {
      d = new Date();
      avancement = (float)( d.getTime() - temps ) / 3000;
      animal.setLocation( xorig + (int)( avancement * xdecal ), yorig + (int)( avancement * ydecal ) );
      _fenetre.repaint();
    }
		
  }
	
	
  public void descendreBateau( String string )
  {
    JLabel animal;
    int numero;
    if( string.startsWith( "Loup" ) )
    {
      numero = Integer.parseInt( string.substring( 4, string.length() ) );
      animal = _loups[ numero ];
    }
    else
    {
      numero = Integer.parseInt( string.substring( 6, string.length() ) );
      animal = _chevres[ numero ];
    }
		
    int xorig = animal.getX();
    int yorig = animal.getY();
    --_nbPassagers;
    int xfinal = _random.nextInt( 100 ) + 150;
    int yfinal = 340;
		
    int xdecal = xfinal - xorig;
    int ydecal = yfinal - yorig;
		
    Date d = new Date();
    long temps = d.getTime();
    float avancement;
		
    while( animal.getY() < yfinal - 2 )
    {
      d = new Date();
      avancement = (float)( d.getTime() - temps ) / 3000;
      animal.setLocation( xorig + (int)( avancement * xdecal ), yorig + (int)( avancement * ydecal ) );
      _fenetre.repaint();
    }
    animal.setLocation( 0, 410 );	
    _fenetre.repaint();	
  }
		
  public void voyageAller()
  {		
    int xorig = 140;
    int yorig = 80;
    int yfinal = 250;
		
    int ydecal = yfinal - yorig;
		
    Date d = new Date();
    long temps = d.getTime();
    float avancement;
		
    int nx, ny;
		
    while( _bateau.getY() < yfinal - 2 )
    {
      d = new Date();
      avancement = (float)( d.getTime() - temps ) / 5000;
      nx = xorig + (int)( Math.sin( avancement * 3.1415 * 2 ) * 30 );
      ny = yorig + (int)( avancement * ydecal );
      _bateau.setLocation( nx, ny );
      for( int i = 0 ; i < 3 ; ++i )
	_passagers[i].setLocation( nx + 25 * i, ny - 5 );
      _fenetre.repaint();
    }
    _bateau.setLocation( 140, 250 );
    _fenetre.repaint();		
  }
	
  public void voyageRetour()
  {
    int xorig = 140;
    int yorig = 250;
    int yfinal = 80;
		
    int ydecal = yfinal - yorig;
		
    Date d = new Date();
    long temps = d.getTime();
    float avancement;
		
    int nx, ny;
		
    while( _bateau.getY() > yfinal + 2 )
    {
      d = new Date();
      avancement = (float)( d.getTime() - temps ) / 5000;
      nx = xorig + (int)( Math.sin( avancement * 3.1415 * 2 ) * 30 );
      ny = yorig + (int)( avancement * ydecal );
      _bateau.setLocation( nx, ny );
      _fenetre.repaint();
    }
    _bateau.setLocation( 140, 80 );
    _fenetre.repaint();
  }
}
