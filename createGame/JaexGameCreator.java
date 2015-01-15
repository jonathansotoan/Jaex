package createGame;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Formatter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JaexGameCreator {
	public static final short MAX_WIDTH = 640;
	public static final short MAX_HEIGHT = 480;

	private String name;
	private Dimension size;
	private String metaDescription;
	private String description;
	private PriorityQueue< String > keywords;
	private PriorityQueue< Page > descriptionPages;
	private PriorityQueue< Game > similarGames;

	/**
	 *
	 */
	public JaexGameCreator( final String gameName, final short originalWidth, final short originalHeight, final String metaLabelDescription, final String gameDescription ) {
		name = gameName;
		size = getSize( originalWidth, originalHeight );
		metaDescription = metaLabelDescription;
		description = gameDescription;
		keywords = new PriorityQueue< String >();
		descriptionPages = new PriorityQueue< Page >();
		similarGames = new PriorityQueue< Game >();
	}
	
	/**
	 *
	 */
	public JaexGameCreator() {
		keywords = new PriorityQueue< String >();
		descriptionPages = new PriorityQueue< Page >();
		similarGames = new PriorityQueue< Game >();
	}
	
	/**
	 *
	 */
	public final void setName( final String gameName ) {
		name = gameName;
	}
	
	/**
	 *
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 *
	 */
	public final void setSize( final Dimension newSize ) {
		size = newSize;
	}
	
	/**
	 *
	 */
	public final Dimension getSize() {
		return size;
	}
	
	/**
	 *
	 */
	public final void setMetaDescription( final String newMetaDescription ) {
		metaDescription = newMetaDescription;
	}
	
	/**
	 *
	 */
	public final String getMetaDescription() {
		return metaDescription;
	}
	
	/**
	 *
	 */
	public final void setDescription( final String newDescription ) {
		description = newDescription;
	}
	
	/**
	 *
	 */
	public final String getDescription() {
		return description;
	}

	private final Dimension getSize( final short originalWidth, final short originalHeight ) {
		if( originalWidth > MAX_WIDTH ) {
			byte porcent = (byte) Math.round( MAX_WIDTH * 100 / originalWidth );
			short possibleHeight = (short) Math.round( originalHeight * porcent / 100 );

			if( possibleHeight > MAX_HEIGHT )
				return getSize( MAX_WIDTH, possibleHeight );
			else
				return new Dimension( MAX_WIDTH, possibleHeight );
		} else if( originalHeight > MAX_WIDTH ) {
			byte porcent = (byte) Math.round( MAX_HEIGHT * 100 / originalHeight );
			short possibleWidth = (short) Math.round( originalWidth * porcent / 100 );

			if( possibleWidth > MAX_WIDTH )
				return getSize( possibleWidth, MAX_HEIGHT );
			else
				return new Dimension( possibleWidth, MAX_HEIGHT );
		} else
			return null;
	}
	
	/**
	 *
	 *
	 */
	public final void addKeyword( final String newKeyword ) {
		keywords.add( newKeyword );
	}
	
	/**
	 *
	 *
	 */
	public final void addPage( final Page nextPage ) {
		descriptionPages.add( nextPage );
	}
	
	/**
	 *
	 *
	 */
	public final void addSimilarGame( final Game nextSimilarGame ) {
		similarGames.add( nextSimilarGame );
	}
	
	/**
	 *
	 * This method makes two file (one more readable and the other more light) with the specified name and parameters.
	 */
	public void create() {
		try {
			//The most readable file
			final Formatter out = new Formatter( getFileName() );
		
			addHead( out );
			addBody( out );
			addGameToList();
			out.close();
		} catch( FileNotFoundException fileNotFoundEx ) {
			System.out.println( "File not found" );
			fileNotFoundEx.printStackTrace();
			System.exit( 1 );
		}
	}
	
	/* Begin create method helpers */
	private final void addHead( final Formatter out ) {
		out.format( "%s\n%s\n\t%s\n\t\t%s%s%s\n\t\t%s%s\n",
			"<!doctype html>",
			"<html>",
				"<head>",
					"<title>", name, " | Jaex - Juegos online gratis</title>",
					"<meta name=\"description\" content=\"", metaDescription, "\">" );
		
		addKeywords( out );
		out.format( "\n\n" );
		addVarsScript( out );
		out.format( "\n\n" );
		addPhpHeader( out );
	}
	
	//addHead method helper
	private final void addKeywords( final Formatter out ) {
		String firstKeyword = keywords.poll();
		
		if( firstKeyword == null )
			throw new NullPointerException( "There is not keywords to add and it must be at least 1" );

		out.format( "\t\t%s%s", "<meta name=\"keywords\" content=\"", firstKeyword );
		
		while( !keywords.isEmpty() )
			out.format( ", %s", keywords.poll() );
		
		//out.format( "%s\n\n", ", juego divertido, funny game, en linea, online, gratis, free\">" );
		out.format( "\">\n\n" );
	}
	
	//addHead method helper
	private final void addVarsScript( final Formatter out ) {
		out.format( "\t\t%s\n\t\t\t%s\n\t\t\t\t%s",
			"<script type=\"text/javascript\">",
				"var pagina = [''" );

		if( descriptionPages.peek() == null ) {
			System.out.printf( "%s\n%s\n", "There is not images to add and it must be at least 1.",
										"Insert 1 to continue normally or 0 to stop the program" );
			
			if( new Scanner( System.in ).nextInt() == 0 )
				System.exit( 0 );
			else
				out.format( "];" );
		}
		
		ArrayList< Img > imgs = new ArrayList();

		while( !descriptionPages.isEmpty() ) {
			imgs.addAll( descriptionPages.peek().getImagesNamesList() );

			out.format( "\n\t\t\t\t%s%s",
							descriptionPages.poll(), descriptionPages.isEmpty() ? "];" : "," );
		}
		
		out.format( "var imgs = [%s", imgs.get( 0 ) );

		for( byte j = 1; j < imgs.size(); ++j )
			out.format( ",\n\t\t\t\t%s,", imgs.get( j ) );

		out.format( "];\n\t\t\t%s = %d;\n\t\t\t%s = %d;\n\t\t\t%s = %d;\n\t\t\t%s = \"%dpx\";\n\t\t\t%s = \"%dpx\";\n\t\t%s",
						"codigo", getLastCode() + 1,
						"ancho", size.width,
						"alto", size.height,
						"mtpCentrar", Math.round( (480 - size.height) / 2.0 ),
						"mlpCentrar", Math.round( (640 - size.width) / 2.0 ),
						"</script>" );
	}
	
	//addHead method helper
	private final void addPhpHeader( final Formatter out ) {
		out.format( "\t\t%s\n\t\t\t%s = %d;\n\t\t\t%s = %s",
						"<?php",
							"$codigo", getLastCode() + 1,
							"$juegos", "array (" );
		
		while( !similarGames.isEmpty() )
			out.format( "%s%s%s%s%s\t\t\t", "array (\"", similarGames.peek().getName(), "\", ", similarGames.poll().getCode(), similarGames.isEmpty() ? "));\n\n" : "),\n\t" );

		out.format( "%s\n\t\t\t\t%s\n\t\t\t\t%s\n\n\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t%s\n\t\t\t%s",
						"function comprobar () {",
							"global $r;",
							"global $cods;",
							"if ($r == 89 || $r == 84 || $r == 74 || $r == 53 || $r == 30 || $r == 34 || $r == 12) {",
								"$r++;",
								"comprobar ();",
							"}",
						"}" );
		
		out.format( "\n\n\t\t\t%s\n\t\t\t%s\n\t\t%s",
						"include (\"../PHP/obtencionDatosBD.php\");",
						"include (\"../PHP/reproduccionExt1.php\");",
						"?>" );
	}
	
	private final void addBody( final Formatter out ) {
		out.format( "\n\t\t\t\t\t\t\t%s\n\t\t\t\t\t\t%s\n\t\t\t\t\t\t%s\n\t\t\t\t\t\t\t%s\n\n\t\t\t\t\t\t\t%s\n\n",
							name,
						"</h4>",
						"<div id=\"descripcionCuerpo\">",
							description,
							"<?php include (\"../PHP/reproduccionExt2.php\"); ?>" );
		
		addCentroDiv( out );
		out.format( "\n\n\t\t%s\n%s", "<?php include (\"../PHP/reproduccionExt3.php\");?>", "</html>" );
	}
	
	private final void addCentroDiv( final Formatter out ) {
		String basics = String.format( "\n\t\t\t\t\t%s%d %s%d ", "<object id=\"juego\" width=\"", size.width, "height=\"", size.height );
		
		if( !( size.width == 640 && size.height == 480 ) )//if it is not necessary to use margin left or margin top
			if( size.width == 640 )//if it isn't necessary to use margin left
				basics += String.format( "%s%d%s", "style=\"margin-top: ", Math.round( (480 - size.height) / 2.0 ), "px;\" " );
			else//if it isn't necessary to use margin top
				basics += String.format( "%s%d%s", "style=\"margin-left: ", Math.round( (640 - size.width) / 2.0 ), "px;\" " );

		out.format( "\t\t\t%s\n\t\t\t\t%s%s%s%s%s\n\t\t\t\t%s\n\t\t\t\t%s%s%s\n\t\t\t\t\t\t%s\n\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t\t%s\n\t\t\t\t%s\n\t\t\t%s",
						"<div id=\"centro\">",
							"<!--[if !IE]> -->",
								basics,
								"data=\"", getFileName(), ".swf\" type=\"application/x-shockwave-flash\">",
							"<!-- <![endif]-->",
							"<!--[if IE]>",
								basics,
								"classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0\">",
								"<param name=\"movie\" value=\"", getFileName(), ".swf\">",
							"<!--><!--dgx-->",
								"<param name=\"quality\" value=\"high\">",
								"<param name=\"wmode\" value=\"opaque\">",
								"<a href=\"http://get.adobe.com/es/flashplayer/\" target=\"_blank\">",
									"<img id=\"noFlash\" class=\"atraccionPrincipal\" src=\"../imagen/noFlash640x480.png\" alt=\"Instale el complemento Flash para visualizar correctamente la p&aacute;gina\">",
								"</a>",
								"</object>",
							"<!-- <![endif]-->",
						"</div>" );
	}
	/* End create method helpers */
	
	private String getFileName() {
		return name.replaceAll( " ", "_" ).toLowerCase();
	}
	
	private final int getLastCode() {
		int code = -1;
		
		try {
			final Scanner existGames = new Scanner( new File( "games.txt" ) );
		
			while( existGames.hasNext() ) {
				existGames.nextLine();
				code = existGames.nextInt();
			}
		
			existGames.close();
		} catch( FileNotFoundException fileNotFoundEx ) {
			System.out.println( "The file such are the games and their codes does not exist" );
			fileNotFoundEx.printStackTrace();
			System.exit( 1 );
		}

		return code;
	}
	
	private final void addGameToList() {
		try {
			FileWriter writer = new FileWriter( "games.txt", true );
			writer.write( String.format( "\n%d %s", getLastCode() + 1, getFileName() ) );
			writer.close();
		} catch( IOException ioEx) {
			System.out.println( "There is a problem writting the game in games.txt file" );
			ioEx.printStackTrace();
			System.exit( 1 );
		}
	}
}

class Game {
	final String name;
	final int code;
	
	Game( final String name ) throws Exception {
		this( name, getCode( name ) );
	}
	
	Game( final String name, final int code ) {
		this.name = name;
		this.code = code;
	}
	
	static int getCode( final String name ) throws Exception {
		Scanner reader;
		
		try {
			reader = new Scanner( new File( "games.txt" ) );
			reader.nextLine();//it ignores the first line (because that is not important)
		
			while( reader.hasNext() ) {
				int code = reader.nextInt();
			
				if( reader.next().equals( name ) )
					return code;
			}
		} catch( FileNotFoundException fileNotFoundEx ) {
			System.out.println( "The file games.txt (it must content the names of the games and their codes) does not exist" );
			fileNotFoundEx.printStackTrace();
			System.exit( 1 );
		}
		
		throw new Exception( "The specified name of the game does not exist" );
	}
	
	String getName() {
		return name;
	}
	
	int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return String.format( "(%d) %s", code, name );
	}
}

class Page {
	final Img[] imgs;
	final String imagesDescription;

	Page( String description, Img... images ) {
		imagesDescription = description;
		imgs = images;
	}
	
	@Override
	public String toString() {
		String firstImageClass;
		
		if( imgs.length > 1 || imgs[ 0 ].getName().startsWith( "flechas-direccion" ) )
			firstImageClass = "ml3";
		else if( imgs[ 0 ].getName().equals( "tecla-barra-espaciadora" ) )
			firstImageClass = null;
		else
			firstImageClass = "ml2";
		
		StringBuilder results = new StringBuilder( "'" );
		imgs[ 0 ].setClass( firstImageClass );
		results.append( imgs[ 0 ] );
		
		for( byte j = 1; j < imgs.length; ++j )
			results.append( imgs[ j ] );
		
		return results.append( "<div class=\"base\">" + imagesDescription + "</div>'" ).toString();
	}
	
	List< Img > getImagesNamesList() {
		return Arrays.asList( imgs );
	}
}

class Img {
	final String fileName;
	final String alt;
	String imgClass;

	Img( final String fileName ) throws Exception {
		this( fileName, getAlt( fileName ), null );
	}

	Img( final String fileName, final String imgClass ) throws Exception {
		this( fileName, getAlt( fileName ), imgClass );
	}

	Img( final String fileName, final String alt, final String imgClass ) {
		this.fileName = fileName;
		this.alt = alt;
		this.imgClass = imgClass;
	}
	
	void setClass( final String newClass ) {
		imgClass = newClass;
	}
	
	static final String getAlt( final String fileName ) throws Exception {
		StringTokenizer name = new StringTokenizer( fileName, "-" );
		String currentToken = realNextToken( name.nextToken() );
		
		if( currentToken.equals( "flechas" ) ) {
			name.nextToken();//it ignores "direccion" word
			
			if( name.hasMoreTokens() )
				return "Flechas de direcci&oacute;n ".concat( realNextToken( name.nextToken() ) );
			else
				return "Flechas de direcci&oacute;n primarias";
		} else if( currentToken.equals( "tecla" ) ) {
			currentToken = realNextToken( name.nextToken() );
		
			if( currentToken.equals( "barra" ) )//spacebar
				return "Tecla barra espaciadora";
			else if( currentToken.equals( "borrar" ) )
				return "Tecla borrar/backspace";
			else if( currentToken.equals( "control" ) )
				return "Tecla control";
			else if( currentToken.equals( "enter.png" ) )
				return "Tecla enter/intro";
			else if( currentToken.equals( "esc.png" ) )
				return "Tecla escape/esc";
			else if( currentToken.equals( "f11.png" ) )
				return "Tecla F11";
			else if( currentToken.equals( "letra" ) )
				return "Tecla de la letra ".concat( realNextToken( name.nextToken() ).toUpperCase() );
			else if( currentToken.equals( "numero" ) )
				return "Tecla del n&uacute;mero ".concat( realNextToken( name.nextToken() ) );
			else if( currentToken.equals( "tabulador" ) )
				return "Tecla Tab/tabulador";
			else if( currentToken.equals( "flecha" ) ) {
				currentToken = realNextToken( name.nextToken() );
			
				return String.format( "%s %s%s",
					"Tecla de la flecha hacia",
					currentToken.equals( "derecha" ) || currentToken.equals( "izquierda" ) ? "la " : "",
					currentToken );
			} else// this is the shift case
				return "Tecla ".concat( realNextToken( name.nextToken() ) );
		} else if( currentToken.equals( "mouse" ) ) {
			if( name.hasMoreTokens() ) {
				name.nextToken();//this ignores "click" word
				return "Click " + realNextToken( name.nextToken() ) + " del mouse";
			} else
				return "Mouse";
		} else if( currentToken.equals( "rueda" ) )
			return "Rueda del mouse/Scroll wheel";
		
		throw new Exception( "The alt of the image name " + fileName + " is not supported" );
	}
	
	@Override
	public String toString() {
		return String.format( "%s%s%s%s%s%s%s",
									"<img ",
									imgClass == null ? "" : "class=\"" + imgClass + "\" ",
									"src=\"../imagen/", fileName, ".png\" alt=\"", alt, "\">" );
	}
	
	String getName() {
		return fileName;
	}
	
	static final String realNextToken( final String fakeToken ) {
		return fakeToken.replaceAll( ".png", "" );
	}
}
