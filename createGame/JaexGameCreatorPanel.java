package createGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public final class JaexGameCreatorPanel extends JPanel implements ActionListener {
	public final static byte PREDETERMINATED_NUMBER_OF_KEYWORDS = 6;
	public final static String[] imagesNames = {"[Select...]",
		"flechas-direccion",
		"flechas-direccion-secundarias-w-a-s-d",
		"flechas-direccion-tercciarias-i-j-k-l",
		"mouse",
		"mouse-click-derecho",
		"mouse-click-izquierdo",
		"rueda-del-mouse",
		"tecla-barra-espaciadora",
		"tecla-barra-espaciadora-90x35px",
		"tecla-borrar-backspace",
		"tecla-control-ctrl",
		"tecla-enter",
		"tecla-esc",
		"tecla-f11",
		"tecla-flecha-arriba",
		"tecla-flecha-abajo",
		"tecla-flecha-derecha",
		"tecla-flecha-izquierda",
		"tecla-letra-a",
		"tecla-letra-b",
		"tecla-letra-c",
		"tecla-letra-d",
		"tecla-letra-e",
		"tecla-letra-f",
		"tecla-letra-g",
		"tecla-letra-h",
		"tecla-letra-i",
		"tecla-letra-j",
		"tecla-letra-k",
		"tecla-letra-l",
		"tecla-letra-m",
		"tecla-letra-o",
		"tecla-letra-p",
		"tecla-letra-q",
		"tecla-letra-r",
		"tecla-letra-s",
		"tecla-letra-t",
		"tecla-letra-u",
		"tecla-letra-w",
		"tecla-letra-x",
		"tecla-letra-z",
		"tecla-numero-1",
		"tecla-numero-2",
		"tecla-numero-3",
		"tecla-numero-4",
		"tecla-numero-5",
		"tecla-numero-6",
		"tecla-numero-9",
		"tecla-shift",
		"tecla-tabulador-tab"};

	private final JaexGameCreator jgc;
	private final JFrame parent;
	private final JTextField name;
	private final JTextField width;
	private final JTextField height;
	private final JTextArea metaDescription;
	private final JTextArea gameDescription;
	private final JPanel keywordsPanel;
	private final JPanel pagesPanel;
	private final JPanel similarGamesPanel;
	private final JButton addKeywordButton;
	private final JButton showKeywordButton;
	private final JButton deleteKeywordButton;
	private final JButton addPageButton;
	private final JButton showPageButton;
	private final JButton deletePageButton;
	private final JButton addSimilarGameButton;
	private final JButton showSimilarGameButton;
	private final JButton deleteSimilarGameButton;
	private final JButton createButton;
	private final ArrayList< ElementPlusLabel< Page > > pagesAndLabels;
	private final ArrayList< ElementPlusLabel< String > > keywordsAndLabels;
	private final ArrayList< ElementPlusLabel< Game > > similarGamesAndLabels;

	public JaexGameCreatorPanel( final JFrame dialogsParent ) {
		jgc = new JaexGameCreator();
		parent = dialogsParent;
		name = new JTextField();
		width = new JTextField( 5 );
		height = new JTextField( 5 );
		metaDescription = new JTextArea( " gratis en l&iacute;nea en Jaexjuegos.com", 1, 10 );
		gameDescription = new JTextArea( 1, 10 );
		//test same gridlayout
		keywordsPanel = new JPanel();
		keywordsPanel.setLayout( new GridLayout( 0, 1, 5, 5 ) );
		pagesPanel = new JPanel();
		pagesPanel.setLayout( new GridLayout( 0, 1, 5, 5 ) );
		similarGamesPanel = new JPanel();
		similarGamesPanel.setLayout( new GridLayout( 0, 1, 5, 5 ) );
		addKeywordButton = new JButton( "Add keyword" );
		addKeywordButton.addActionListener( this );
		showKeywordButton = new JButton( "Show keyword" );
		showKeywordButton.addActionListener( this );
		deleteKeywordButton = new JButton( "Delete keyword" );
		deleteKeywordButton.addActionListener( this );
		addPageButton = new JButton( "Add page" );
		addPageButton.addActionListener( this );
		showPageButton = new JButton( "Show page" );
		showPageButton.addActionListener( this );
		deletePageButton = new JButton( "Delete page" );
		deletePageButton.addActionListener( this );
		addSimilarGameButton = new JButton( "Add similar game" );
		addSimilarGameButton.addActionListener( this );
		showSimilarGameButton = new JButton( "Show similar game" );
		showSimilarGameButton.addActionListener( this );
		deleteSimilarGameButton = new JButton( "Delete similar game" );
		deleteSimilarGameButton.addActionListener( this );
		createButton = new JButton( "Create game" );
		createButton.addActionListener( this );
		pagesAndLabels = new ArrayList< ElementPlusLabel< Page > >();
		keywordsAndLabels = new ArrayList< ElementPlusLabel< String > >();
		addKeywordToList( "juego divertido" );
		addKeywordToList( "funny game" );
		addKeywordToList( "en linea" );
		addKeywordToList( "online" );
		addKeywordToList( "gratis" );
		addKeywordToList( "free" );
		similarGamesAndLabels = new ArrayList< ElementPlusLabel< Game > >();

		JPanel top = new JPanel();
		top.setLayout( new BorderLayout() );
		JPanel panelTemp1 = new JPanel();
		GridLayout glTemp = new GridLayout( 2, 1, 5, 5 );
		panelTemp1.setLayout( glTemp );
		panelTemp1.add( new JLabel( "Name of the game" ) );
		panelTemp1.add( new JLabel( "Size of the game" ) );
		JPanel panelTemp2 = new JPanel();
		panelTemp2.setLayout( glTemp );
		panelTemp2.add( name );
		JPanel panelTemp3 = new JPanel();
		panelTemp3.add( width );
		panelTemp3.add( new JLabel( "x" ) );
		panelTemp3.add( height );
		panelTemp2.add( panelTemp3 );
		top.add( panelTemp1, BorderLayout.WEST );
		top.add( panelTemp2, BorderLayout.CENTER );

		JPanel center = new JPanel();
		center.setLayout( new BorderLayout() );
		JPanel panelTemp4 = new JPanel();
		panelTemp4.setLayout( glTemp );
		panelTemp4.add( new JLabel( "Meta description" ) );
		panelTemp4.add( new JLabel( "Game description" ) );
		JPanel panelTemp5 = new JPanel();
		panelTemp5.setLayout( glTemp );
		panelTemp5.add( new JScrollPane( metaDescription ) );
		panelTemp5.add( new JScrollPane( gameDescription ) );
		center.add( panelTemp4, BorderLayout.WEST );
		center.add( panelTemp5 );//center

		JPanel bottom = new JPanel();
		bottom.setLayout( new GridLayout( 1, 3, 10, 10 ) );
		JPanel panelTemp6 = new JPanel();
		panelTemp6.setLayout( new BorderLayout() );
		panelTemp6.add( keywordsPanel );
		JPanel panelTemp6_1 = new JPanel();
		glTemp = new GridLayout( 3, 1, 5, 5 );
		panelTemp6_1.setLayout( glTemp );
		panelTemp6_1.add( addKeywordButton );
		panelTemp6_1.add( showKeywordButton );
		panelTemp6_1.add( deleteKeywordButton );
		panelTemp6.add( panelTemp6_1, BorderLayout.SOUTH );
		JPanel panelTemp7 = new JPanel();
		panelTemp7.setLayout( new BorderLayout() );
		panelTemp7.add( pagesPanel );
		JPanel panelTemp7_1 = new JPanel();
		panelTemp7_1.setLayout( glTemp );
		panelTemp7_1.add( addPageButton );
		panelTemp7_1.add( showPageButton );
		panelTemp7_1.add( deletePageButton );
		panelTemp7.add( panelTemp7_1, BorderLayout.SOUTH );
		JPanel panelTemp8 = new JPanel();
		panelTemp8.setLayout( new BorderLayout() );
		panelTemp8.add( similarGamesPanel );
		JPanel panelTemp8_1 = new JPanel();
		panelTemp8_1.setLayout( glTemp );
		panelTemp8_1.add( addSimilarGameButton );
		panelTemp8_1.add( showSimilarGameButton );
		panelTemp8_1.add( deleteSimilarGameButton );
		panelTemp8.add( panelTemp8_1, BorderLayout.SOUTH );
		bottom.add( panelTemp6 );
		bottom.add( panelTemp7 );
		bottom.add( panelTemp8 );
		
		JPanel body = new JPanel();
		body.setLayout( glTemp );
		body.add( top );
		body.add( center );
		body.add( bottom );
	
		setLayout( new BorderLayout() );
		JLabel title = new JLabel( "Creating a game", JLabel.CENTER );
		title.setForeground( Color.RED );
		add( title, BorderLayout.NORTH );
		add( body );
		add( createButton, BorderLayout.SOUTH );
	}
	
	public void actionPerformed( ActionEvent ae ) {
		if( ae.getSource() == addKeywordButton ) {
			addKeywordToList( JOptionPane.showInputDialog( parent, "Insert the new keyword", "Adding keyword", JOptionPane.PLAIN_MESSAGE ) );
		} else if( ae.getSource() == showKeywordButton )
			showElement( keywordsAndLabels );
		else if( ae.getSource() == deleteKeywordButton )
			deleteElement( keywordsAndLabels, keywordsPanel );
		else if( ae.getSource() == addPageButton ) {
			JDialog wndw = new JDialog( parent, "Adding page" );
			wndw.setLayout( new BorderLayout() );
			JPanel panelTemp1 = new JPanel();
			panelTemp1.setLayout( new GridLayout( 4, 1, 5, 5 ) );
			panelTemp1.add( new JLabel( "First image" ) );
			panelTemp1.add( new JLabel( "Second image" ) );
			panelTemp1.add( new JLabel( "Third image" ) );
			panelTemp1.add( new JLabel( "Page description" ) );
			JPanel panelTemp2 = new JPanel();
			panelTemp2.setLayout( new GridLayout( 4, 1, 5, 5 ) );
			final JComboBox jcb1 = new JComboBox( imagesNames );
			final JComboBox jcb2 = new JComboBox( imagesNames );
			final JComboBox jcb3 = new JComboBox( imagesNames );
			panelTemp2.add( jcb1 );
			panelTemp2.add( jcb2 );
			panelTemp2.add( jcb3 );
			final JTextField pageDescription = new JTextField();
			panelTemp2.add( pageDescription );
			final JButton okButton = new JButton( "Ok" );
			okButton.addActionListener( new ActionListener() {
				public void actionPerformed( final ActionEvent ae ) {
					if( !jcb1.getSelectedItem().equals( "[Select...]" ) ) {
						Page newPage = null;
						
						try {
							if( jcb2.getSelectedItem().equals( "[Select...]" ) )
								newPage = new Page( pageDescription.getText(),
															new Img( jcb1.getSelectedItem().toString() ) );
							else if( jcb3.getSelectedItem().equals( "[Select...]" ) )
								newPage = new Page( pageDescription.getText(),
															new Img( jcb1.getSelectedItem().toString() ),
															new Img( jcb2.getSelectedItem().toString() ) );
							else
								newPage = new Page( pageDescription.getText(),
															new Img( jcb1.getSelectedItem().toString() ),
															new Img( jcb2.getSelectedItem().toString() ),
															new Img( jcb3.getSelectedItem().toString() ) );
						} catch( Exception ex ) {
							ex.printStackTrace();//Here is unreachable
						}

						JLabel jl = new JLabel( pagesAndLabels.size() + ". " + newPage );
						pagesAndLabels.add( new ElementPlusLabel( newPage, jl ) );
						pagesPanel.add( jl );
						pagesPanel.setVisible( false );
						pagesPanel.setVisible( true );
					}
				}
			} );
			wndw.add( panelTemp1, BorderLayout.WEST );
			wndw.add( panelTemp2 );
			wndw.add( okButton, BorderLayout.SOUTH );
			
			wndw.setSize( 350, 150 );
			wndw.setVisible( true );
		} else if( ae.getSource() == showPageButton )
			showElement( pagesAndLabels );
		else if( ae.getSource() == deletePageButton )
			deleteElement( pagesAndLabels, pagesPanel );
		else if( ae.getSource() == addSimilarGameButton ) {
			JDialog wndw = new JDialog( parent, "Adding page" );
			wndw.setLayout( new BorderLayout() );
			JPanel panelTemp = new JPanel();
			panelTemp.setLayout( new BorderLayout() );
			panelTemp.add( new JLabel( "Game name" ), BorderLayout.WEST );
			final JComboBox jcb = new JComboBox( getGamesNames() );
			panelTemp.add( jcb );
			JButton okSimilarGameButton = new JButton( "Ok" );
			okSimilarGameButton.addActionListener( new ActionListener() {
				public void actionPerformed( final ActionEvent ae ) {
					try {
						Game newSimilarGame = new Game( jcb.getSelectedItem().toString() );
						JLabel jl = new JLabel( similarGamesAndLabels.size() + ". " + newSimilarGame );
						similarGamesAndLabels.add( new ElementPlusLabel( newSimilarGame, jl ) );
						similarGamesPanel.add( jl );
						similarGamesPanel.setVisible( false );
						similarGamesPanel.setVisible( true );
					} catch( Exception ex ) {
						ex.printStackTrace();//unreachable statement
					}
				}
			} );
			wndw.add( panelTemp );
			wndw.add( okSimilarGameButton, BorderLayout.SOUTH );
			
			wndw.setSize( 500, 60 );
			wndw.setVisible( true );
		} else if( ae.getSource() == showSimilarGameButton )
			showElement( similarGamesAndLabels );
		else if( ae.getSource() == deleteSimilarGameButton )
			deleteElement( similarGamesAndLabels, similarGamesPanel );
		else if( ae.getSource() == createButton ) {
			try {
				jgc.setName( name.getText() );
				jgc.setSize( new Dimension( Integer.parseInt(width.getText()), Integer.parseInt(height.getText()) ) );
				jgc.setMetaDescription( metaDescription.getText() );
				jgc.setDescription( gameDescription.getText() );
				
				for( byte j = 0; j < keywordsAndLabels.size(); ++j )
					jgc.addKeyword( keywordsAndLabels.get( j ).element );
				
				for( byte j = 0; j < pagesAndLabels.size(); ++j )
					jgc.addPage( pagesAndLabels.get( j ).element );
				
				for( byte j = 0; j < similarGamesAndLabels.size(); ++j )
					jgc.addSimilarGame( similarGamesAndLabels.get( j ).element );

				jgc.create();
			} catch( NullPointerException nullPointerEx ) {
				System.out.println( "A required field is not filled" );
			}
		}
	}
	
	private void addKeywordToList( final String newKeyword ) {
		if( newKeyword != null ) {
			//( (GridLayout) keywordsPanel.getLayout() ).setRows( ( (GridLayout) keywordsPanel.getLayout() ).getRows() + 1 );
			JLabel jl = new JLabel( "x. " + newKeyword );//the x is temporally until refreshLabelNumeration call
			
			if( keywordsAndLabels.size() >= PREDETERMINATED_NUMBER_OF_KEYWORDS ) {
				keywordsPanel.add( jl, keywordsAndLabels.size() - PREDETERMINATED_NUMBER_OF_KEYWORDS );
				keywordsAndLabels.add( keywordsAndLabels.size() - PREDETERMINATED_NUMBER_OF_KEYWORDS, new ElementPlusLabel( newKeyword, jl ) );
			} else {
				keywordsPanel.add( jl );
				keywordsAndLabels.add( new ElementPlusLabel( newKeyword, jl ) );
			}

			refreshLabelNumeration( keywordsAndLabels, keywordsPanel );
		}
	}
	
	private String[] getGamesNames() {
		ArrayList< String > results = new ArrayList< String >();

		try {
			Scanner reader = new Scanner( new File( "games.txt" ) );
		
			reader.nextLine();//this ignores the first line (the header)
		
			while( reader.hasNext() ) {
				reader.next();//this ignores the code of the game
				results.add( reader.next() );
			}

			reader.close();
		} catch( FileNotFoundException fileNotFoundEx ) {
			System.out.println( "The file games.txt does not exist and we need it to work" );
			fileNotFoundEx.printStackTrace();
			System.exit( 1 );
		}
		
		String[] a = new String[ results.size() ];
		
		return results.toArray( a );
	}
	
	private void showElement( final ArrayList< ? extends ElementPlusLabel< ? > > al ) {
		byte index = Byte.parseByte( JOptionPane.showInputDialog( parent, "Insert the index of the element that you want to see", "Showing element", JOptionPane.PLAIN_MESSAGE ) );
		JOptionPane.showMessageDialog( parent, String.format( "This is the element in %d index:\n%s", index, index >= 0 && index < al.size() ? al.get( index ).element : "The index is not valid" ), "Showing element", JOptionPane.PLAIN_MESSAGE );
	}
	
	private void deleteElement( final ArrayList< ? extends ElementPlusLabel< ? > > al, final JPanel panelToDelete ) {
		byte index = Byte.parseByte( JOptionPane.showInputDialog( parent, "Insert the index of the element that you want to delete", "Deleting element", JOptionPane.PLAIN_MESSAGE ) );
		
		if( index >= 0 && index < al.size() ) {
			panelToDelete.remove( al.get( index ).label );
			al.remove( index );
			refreshLabelNumeration( al, panelToDelete );
		}
	}
	
	private void refreshLabelNumeration( final ArrayList< ? extends ElementPlusLabel< ? > > al, final JPanel panelToRefresh ) {
			for( byte j = 0; j < al.size(); ++j )
				( (JLabel) panelToRefresh.getComponent( j ) ).setText( j + ( (JLabel) panelToRefresh.getComponent( j ) ).getText().substring( 1 ) );
			
			panelToRefresh.setVisible( false );
			panelToRefresh.setVisible( true );
	}

	public static void main( String args[] ) {
		JFrame wndw = new JFrame( "Create a game" );
		wndw.add( new JaexGameCreatorPanel( wndw ) );
		wndw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		wndw.setSize( 500, 650 );
		wndw.setVisible( true );
	}
	
	public class ElementPlusLabel< E > {
		public final E element;
		public final JLabel label;
		
		public ElementPlusLabel( final E e, final JLabel jl ) {
			element = e;
			label = jl;
		}
	}
}
