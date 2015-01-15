import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que proporciona los m\u00e9todos necesarios para generar un archivo html con un juego para la p\u00e1gina http://JaexJuegos.com
 *
 * @author Jonathan Alexander Soto Montoya
 * @version 1.011 05/05/2013
 */
public class CrearJuego {

	private Queue<String> paginasDescripcion, nombreImagenes;
	private int ancho, alto;
	public int codigo;
	public String titulo, descripcionMeta, descripcion, palabrasClave;
	public String[][] juegosSimilares;
	
	/**
	 * Constructor vac\u00edo que inicializa solo la cola en la que se guardar\u00e1n las p\u00e1ginas de la descripci\u00f3n visible al usuario y en la que se guardar\u00e1n los nombres de las im\u00e1genes de la descripci\u00f3n para que se precarguen en la p\u00e1gina. Este constructor se hace principalmente por si se desea darle valor a los atributos directamente (ejemplo: CrearJuego1.titulo = "Este es el t\u00edtulo").
	 */
	public CrearJuego () {
		paginasDescripcion = new LinkedList<String> ();
		nombreImagenes = new LinkedList<String> ();
	}
	
	/**
	 * Constructor que inicializa los atributos de la clase.
	 *
	 * @param tituloDelJuego como <code><b>cadena</b></code> que define el t\u00edtulo del juego y el nombre del archivo.
	 * @param descripcionEtiquetaMeta como <code><b>cadena</b></code> que define la descripci\u00f3n que quedar\u00e1 entre las etiquetas meta del juego.
	 * @param descripcionDelJuego como <code><b>cadena</b></code> que define la descripci\u00f3n que se le mostrar\u00e1 al usuario en el marco verde mientras est\u00e9 jugando.
	 * @param palabrasClave como <code><b>cadena</b></code> que define las palabras clave del juego que quedar\u00e1n entre las etiquetas meta.
	 * @param codigoJuego como <code><b>entero</b></code> que define el c\u00f3digo del juego que tomar\u00e1 en la base de datos.
	 * @param anchoJuego como <code><b>entero</b></code> que define el ancho original de la pel\u00edcula flash del juego. Si es mayor a 640, se redimensionar\u00e1.
	 * @param altoJuego como <code><b>entero</b></code> que define el alto original de la pel\u00edcula flash del juego. Si es mayor a 480, se redimensionar\u00e1.
	 * @param juegosSimilares como arreglo bidimensional tipo <code><b>cadena (String[][])</b></code> que define los juegos similares y su respectivo c\u00f3digo.
	 */
	public CrearJuego (String tituloDelJuego, String descripcionEtiquetaMeta, String descripcionDelJuego, String palabrasClave, int codigoJuego, int anchoJuego, int altoJuego, String[][] juegosSimilares) {
		titulo = tituloDelJuego;
		descripcionMeta = descripcionEtiquetaMeta;
		descripcion = descripcionDelJuego;
		this.palabrasClave = palabrasClave;
		codigo = codigoJuego;
		this.juegosSimilares = juegosSimilares;
		paginasDescripcion = new LinkedList<String> ();
		nombreImagenes = new LinkedList<String> ();
		ajustarDimensiones (ancho, alto);
	}
	
	/**
	 * Ajusta las dimensiones del juego dentro del rango 640x480 calculando porcentajes para que el aspecto del
	 		juego no cambie.
	 *
	 * @param ancho como <code><b>entero</b></code> que define el ancho original del juego, si es mayor a 640 se
	 		redimensionar\u00e1.
	 * @param alto como <code><b>entero</b></code> que define el alto original del juego, si es mayor a 480 se
	 		redimensionar\u00e1.
	 */
	private void ajustarDimensiones (int ancho, int alto) {
	
		float porcentaje;
	
		if (ancho > 640) {
			porcentaje = 64000 / ancho;
			this.ancho = 640;
			this.alto = (int) alto * porcentaje / 100;
		} else if (alto > 480) {
			porcentaje = 48000 / alto;
			this.ancho = (int) ancho * porcentaje / 100;
			this.alto = 480;
		}
	}
	
	/**
	 * Agrega una p\u00e1gina al cuadro de descrici\u00f3n.
	 *
	 * @param tipo como <code><b>caracter</b></code> que define el tipo de p\u00e1gina que ser\u00e1; los tipos
	 		pueden ser:<br><b> 'u' </b>que significa que habr\u00e1 una sola tecla en la p\u00e1gina.<br><b> 'd'
	 		</b>que significa que habr\u00e1n 2 teclas en la p\u00e1gina.<br><b> 't' </b>que significa que
	 		habr\u00e1n 3 teclas en la p\u00e1gina.<br><b> 'b' </b>que significa que se pondr\u00e1 la tecla de
	 		la barra espaciadora.<br><b> 'm' </b>que significa que se pondr\u00e1 el mouse (sin ning\u00fan click
	 		seleccionado).<br><b> 'h' </b>que significa que se pondr\u00e1 el mouse con la ruedita
	 		seleccionada.<br><b> 'q' </b>que significa que se pondr\u00e1 el mouse con el click izquierdo
	 		seleccionado.<br><b> 'r' </b>que significa que se pondr\u00e1 el mouse con el click derecho
	 		seleccionado.<br><b> 'p' </b>que significa que se pondr\u00e1n las teclas de movimiento primarias del
	 		teclado (izquierda, arriba, derecha y abajo).<br><b> 's' </b>que significa que se pondr\u00e1n las
	 		teclas de movimientos secundarias del teclado (a, w, d y s).<br><b> 'j' </b>que significa que se
	 		pondr\u00e1n las teclas de movimientos terciarias del teclado (j, i, l y k).<br><b> 'e' </b>que
	 		significa que se pondr\u00e1 la tecla enter.
	 *
	 * @param args como <code><b>array de cadenas o String[]</b></code> que define los par\u00e1metros necesarios
		 	para agregar una p\u00e1gina de descripci\u00f3n; si se quieren establecer los valores predeterminados,
		 	basta con enviar en este par\u00e1metro el valor null; seg\u00fan el tipo enviado como par\u00e1metro
		 	puede ser:<br><b> 'u' </b>{nombre de la imagen sin la extensi\u00f3n, texto alternativo,
		 	descripci\u00f3n de la p\u00e1gina} - valores predeterminados: {tecla-letra-p, Tecla de la letra P
		 	del teclado, Pausar}<br><b> 'd' </b>{nombre de la primera imagen sin la extensi\u00f3n, texto
		 	alternativo de la primera imagen, nombre de la segunda imagen sin la extensi\u00f3n, texto alternativo
		 	de la segunda imagen, descripci\u00f3n de la p\u00e1gina} - valores predeterminados:
		 	{tecla-flecha-izquierda, Tecla de la flecha hacia la izquierda, tecla-flecha-derecha, Tecla de la
		 	flecha hacia la derecha, Inclinarse}<br><b> 't' </b>{nombre de la primera imagen sin la extensi\u00f3n,
		 	texto alternativo de la primera imagen, nombre de la segunda imagen sin la extensi\u00f3n, texto
		 	alternativo de la segunda imagen, nombre de la tercera imagen sin la extensi\u00f3n, texto alternativo
		 	de la tercera imagen, descripci\u00f3n de la p\u00e1gina} - valores predeterminados:
		 	{tecla-flecha-izquierda, Tecla de la flecha hacia la izquierda, tecla-flecha-arriba, Tecla de la flecha
		 	hacia arriba, tecla-flecha-derecha, Tecla de la flecha hacia la derecha, Moverse}<br><b> 'b'
		 	</b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado: {Saltar}<br><b> 'm'
		 	</b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado {Mover para[nueva
		 	l\u00ednea]apuntar}<br><b> 'h' </b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado
		 	{Cambiar[nueva l\u00ednea]arma}<br><b> 'q' </b>{descripci\u00f3n de la p\u00e1gina} - valor
		 	predeterminado: {Disparar}<br><b> 'r' </b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado:
		 	{Apuntar}<br><b> 'p', 's' y 'j' </b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado:
		 	{Moverse}<br><b> 'e' </b>{descripci\u00f3n de la p\u00e1gina} - valor predeterminado: {Acci&oacute;n}
	 */
	public void agregarPagina (char tipo, String[] args) {
		switch (tipo) {
			case 'u':
				if (args == null) {
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-letra-p.png\" "
						+ "alt=\"Tecla de la letra P del teclado\"><div class=\"base\">Pausar</div>'");
					nombreImagenes.add ("tecla-letra-p");
				} else {
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/" + args[0]
						+ ".png\" alt=\"" + args[1] + "\"><div class=\"base\">" + args[2] + "</div>'");
					nombreImagenes.add (args[0]);
				}
			break;

			case 'd':
				if (args == null) {
					paginasDescripcion.add (",\n\t\t\t\t'<br><img class=\"ml3\" src=\"../imagen/tecla-flecha-"
						+ "izquierda.png\" alt=\"Tecla de la flecha hacia la izquierda\"> <img src=\"../imagen/tecla-"
						+ "flecha-derecha.png\" alt=\"Tecla de la flecha hacia la derecha\"><div class=\""
						+ "tac\">Inclinarse</div>'");
					nombreImagenes.add ("tecla-flecha-izquierda");
					nombreImagenes.add ("tecla-flecha-derecha");
				} else {
					paginasDescripcion.add (",\n\t\t\t\t'<br><img class=\"ml3\" src=\"../imagen/" + args[0]
						+ ".png\" alt=\"" + args[1] + "\"> <img src=\"../imagen/" + args[2] + ".png\" alt=\""
						+ args[3] + "\"><div class=\"tac\">" + args[4] + "</div>'");
					nombreImagenes.add (args[0]);
					nombreImagenes.add (args[2]);
				}
			break;

			case 't':
				if (args == null) {
					paginasDescripcion.add (",\n\t\t\t\t'<img src=\"../imagen/tecla-flecha-izquierda.png\" alt=\""
						+ "Tecla de la flecha hacia la izquierda\"> <img src=\"../imagen/tecla-flecha-arriba.png\""
						+ " alt=\"Tecla de la flecha hacia arriba\"> <img src=\"../imagen/tecla-flecha-derecha.png\""
						+ " alt=\"Tecla de la flecha hacia la derecha\"><div class=\"tac\">Moverse</div>'");
					nombreImagenes.add ("tecla-flecha-izquierda");
					nombreImagenes.add ("tecla-flecha-arriba");
					nombreImagenes.add ("tecla-flecha-derecha");
				} else {
					paginasDescripcion.add (",\n\t\t\t\t'<img src=\"../imagen/" + args[0]
						+ ".png\" alt=\"" + args[1] + "\"> <img src=\"../imagen/" + args[2] + ".png\" alt=\"" + args[3]
						+ "\"> <img src=\"../imagen/" + args[4] + ".png\" alt=\"" + args[5] + "\"><div class=\"tac\">"
						+ args[6] + "</div>'");
					nombreImagenes.add (args[0]);
					nombreImagenes.add (args[2]);
					nombreImagenes.add (args[4]);
				}
			break;
			
			case 'b':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<br><img src=\"../imagen/tecla-barra-espaciadora.png\" "
						+ "alt=\"Tecla barra espaciadora del teclado\"><div class=\"tac\">Saltar</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<br><img src=\"../imagen/tecla-barra-espaciadora.png\" "
						+ "alt=\"Tecla barra espaciadora del teclado\"><div class=\"tac\">" + args[0] + "</div>'");

				nombreImagenes.add ("tecla-barra-espaciadora");
			break;
			
			case 'm':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/mouse.png\" "
						+ "alt=\"Mouse\"><div class=\"base t5\">Mover para<br>apuntar</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/mouse.png\" "
						+ "alt=\"Mouse\"><div class=\"base t5\">" + args[0] + "</div>'");

				nombreImagenes.add ("mouse");
			break;
			
			case 'h':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/rueda-del-mouse.png\" "
						+ "alt=\"Rueda del mouse\"><div class=\"base\">Cambiar<br>arma</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/rueda-del-mouse.png\" "
						+ "alt=\"Rueda del mouse\"><div class=\"base\">" + args[0] + "</div>'");

				nombreImagenes.add ("rueda-del-mouse");
			break;
			
			case 'q':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-izquierdo"
						+ ".png\" alt=\"Click izquierdo del mouse\"><div class=\"base t5\">Disparar</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-izquierdo"
						+ ".png\" alt=\"Click izquierdo del mouse\"><div class=\"base t5\">" + args[0] + "</div>'");

				nombreImagenes.add ("mouse-click-izquierdo");
			break;
			
			case 'r':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-derecho"
						+ ".png\" alt=\"Click derecho del mouse\"><div class=\"base t5\">Apuntar</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-derecho"
						+ ".png\" alt=\"Click derecho del mouse\"><div class=\"base t5\">" + args[0] + "</div>'");

				nombreImagenes.add ("mouse-click-derecho");
			break;
			
			case 'p':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion"
						+ ".png\" alt=\"Botones de direcci&oacute;n\"><div class=\"tac\">Moverse</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion"
						+ ".png\" alt=\"Botones de direcci&oacute;n\"><div class=\"tac\">" + args[0] + "</div>'");

				nombreImagenes.add ("flechas-direccion");
			break;
			
			case 's':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion-"
						+ "secundarias-w-a-s-d.png\" alt=\"Botones de direcci&oacute;n secundarios\"><div "
						+ "class=\"tac\">Moverse</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion"
						+ "-secundarias-w-a-s-d.png\" alt=\"Botones de direcci&oacute;n secundarios\"><div "
						+ "class=\"tac\">" + args[0] + "</div>'");

				nombreImagenes.add ("flechas-direccion-secundarias-w-a-s-d");
			break;
			
			case 'j':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion-"
						+ "terciarias-i-j-k-l.png\" alt=\"Botones de direcci&oacute;n terciarios\"><div "
						+ "class=\"tac\">Moverse</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion-"
						+ "terciarias-i-j-k-l.png\" alt=\"Botones de direcci&oacute;n terciarios\"><div "
						+ "class=\"tac\">" + args[0] + "</div>'");

				nombreImagenes.add ("flechas-direccion-terciarias-i-j-k-l");
			break;
			
			case 'e':
				if (args == null)
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-enter.png\" "
						+ "alt=\"Tecla Enter\"><div class=\"base ml1\">Acci&oacute;n</div>'");
				else
					paginasDescripcion.add (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-enter.png\" "
						+ "alt=\"Tecla Enter\"><div class=\"base ml1\">" + args[0] + "</div>'");

				nombreImagenes.add ("tecla-enter");
			break;
		}
	}
	
	/**
	 * M\u00e9todo que genera el archivo php listo para publicar; siempre y cuando se hayan asignado todos los valores a los atributos de la clase y las p\u00e1ginas que se usar\u00e1n en la descripci\u00f3n.
	 *
	 * @throws IOException
	 */
	public void generarArchivo () {
		
		PrintWriter archivoMin, archivoMax;//para generar un archivo lo mas liviano posible y otro lo mas legible posible
		
		try {
			archivoMin = new PrintWriter (new FileWriter(convertirAnombreArchivo (titulo) + ".php"));
			archivoMax = new PrintWriter (new FileWriter(convertirAnombreArchivo (titulo) + ".max.php"));
		
			archivoMin.print ("<!doctype html><html><head><title>"
				+ titulo + " | JaexJuegos.com - Juegos online gratis</title><meta name=\"description\" content=\""
				+ descripcionMeta + " gratis en l&iacute;nea en Jaexjuegos.com\"><meta name=\"keywords\" content=\""
				+ palabrasClave + ", en linea, online, gratis, free\"><script type=\"text/javascript\">"
				+ "var pagina = [''");
			
			archivoMax.print ("<!doctype html>\n<html>\n\t<head>\n\t\t<title>"
				+ titulo
				+ " | JaexJuegos.com - Juegos online gratis</title>\n\t\t<meta name=\"description\" content=\""
				+ descripcionMeta + " gratis en l&iacute;nea en Jaexjuegos.com\">\n\t\t<meta "
				+ "name=\"keywords\" content=\"" + palabrasClave + ", en linea, online, gratis, free\">"
				+ "\n\n\t\t<script type=\"text/javascript\">\n\t\t\tvar pagina = [''");
				
				agregarPaginasDescripcion (archivoMin, archivoMax);
				
				archivoMin.print ("];var imgs = [");
				archivoMax.print ("];\n\t\t\tvar imgs = [");
				
				agregarImagenesPrecargadas (archivoMin, archivoMax);
				
				archivoMin.print ("];codigo=" + codigo + ";ancho=" + ancho + ";alto=" + alto + ";mtpCentrar=\""
					+ (480 - alto) / 2 + "px\";mlpCentrar=\"" + (640 - ancho) / 2 + "px\";</script><?php $codigo="
					+ codigo + ";$juegos=");

				archivoMax.print ("];\n\t\t\tcodigo = " + codigo + ";\n\t\t\tancho = " + ancho + ";\n\t\t\talto = "
					+ alto + ";\n\t\t\tmtpCentrar = \"" + (480 - alto) / 2
					+ "px\";\n\t\t\tmlpCentrar = \"" + (640 - ancho) / 2
					+ "px\";\n\t\t</script>\n\n\t\t<?php\n\t\t\t$codigo = " + codigo
					+ ";\n\t\t\t$juegos = ");
					
				agregarJuegosSimilares (archivoMin, archivoMax);
				
				archivoMin.print ("include(\"../PHP/obtencionDatosBD.php\");include(\"../PHP/reproduccionExt1.php\""
					+ ");?>" + titulo + "</h4><div id=\"descripcionCuerpo\">" + descripcion + "<?php include(\".."
					+ "/PHP/reproduccionExt2.php\");?><div id=\"centro\"><!--[if !IE]> --><object id=\"juego\" "
					+ "width=\"" + ancho + "\" height=\"" + alto + "\" ");

				archivoMax.print ("\n\n\t\t\tinclude (\"../PHP/obtencionDatosBD.php\");\n\t\t\tinclude "
					+ "(\"../PHP/reproduccionExt1.php\");\n\t\t?>\n\t\t\t\t\t\t\t" + titulo
					+ "\n\t\t\t\t\t\t</h4>\n\t\t\t\t\t\t<div id=\"descripcionCuerpo\">\n\t\t\t\t\t\t\t"
					+ descripcion + "\n\n\t\t\t\t\t\t\t<?php include (\"../PHP/reproduccionExt2.php\"); ?>"
					+ "\n\n\t\t\t<div id=\"centro\">\n\t\t\t\t<!--[if !IE]> -->\n\t\t\t\t\t<object id=\"juego\" "
					+ "width=\"" + ancho + "\" height=\"" + alto + "\" ");
				
				agregarCentrado (archivoMin, archivoMax);
				
				archivoMin.print ("classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\""
					+ "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0\">"
					+ "<param name=\"movie\" value=\"../SWF/" + convertirAnombreArchivo (titulo)
					+ ".swf\"><!--><!--dgx--><param name=\"quality\" value=\"high\"><param name=\"wmode\" "
					+ "value=\"opaque\"><a href=\"http://get.adobe.com/es/flashplayer/\" target=\"_blank\">"
					+ "<img id=\"noFlash\" class=\"atraccionPrincipal\" src=\"../imagen/noFlash640x480.png\" alt"
					+ "=\"Instale el complemento Flash para visualizar correctamente la p&aacute;gina\"></a>"
					+ "</object><!-- <![endif]--></div><?php include (\"../PHP/reproduccionExt3.php\");?></html>");
					
				archivoMax.print ("classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\""
					+ "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0\">"
					+ "\n\t\t\t\t\t\t<param name=\"movie\" value=\"../SWF/" + convertirAnombreArchivo (titulo)
					+ ".swf\">\n\t\t\t\t<!--><!--dgx-->\n\t\t\t\t\t<param name=\"quality\" value=\"high\">"
					+ "\n\t\t\t\t\t<param name=\"wmode\" value=\"opaque\">\n\t\t\t\t\t<a href=\""
					+ "http://get.adobe.com/es/flashplayer/\" target=\"_blank\">\n\t\t\t\t\t\t<img id=\"noFlash\""
					+ " class=\"atraccionPrincipal\" src=\"../imagen/noFlash640x480.png\" alt"
					+ "=\"Instale el complemento Flash para visualizar correctamente la p&aacute;gina\">"
					+ "\n\t\t\t\t\t</a>\n\t\t\t\t\t</object>\n\t\t\t\t<!-- <![endif]-->\n\t\t\t</div>\n\n\t\t"
					+ "<?php include (\"../PHP/reproduccionExt3.php\");?>\n</html>");
		} catch (IOException ioe) {
			System.out.println ("Error: " + ioe.toString ());
		}
	}
	
	/**
	 * M\u00e9todo para convertir un string con may\u00fasculas y tildes en un nombre de archivo est\u00e1ndar y reemplazando los espacios por una raya al piso (_). Por ejemplo, convierte de algo como "Este Es Un T\u00edtulo Con caracteres propios del idioma espa\u00f1ol" a "este_es_un_titulo_con_caracteres_propios_del_idioma_espanol"
	 *
	 * @param cad como <code><b>cadena</b></code> que define la cadena que se va a transformar.
	 * @return el texto transformado a un formato m\u00e1s est\u00e1ndar, este es de tipo <code><b>cadena</b></code>
	 */
	private String convertirAnombreArchivo (String cad) {
		cad = cad.toLowerCase ();
		cad = cad.replace (' ', '_');
		cad = cad.replace ('\u00e1', 'a');
		cad = cad.replace ('\u00e9', 'e');
		cad = cad.replace ('\u00ed', 'i');
		cad = cad.replace ('\u00f3', 'o');
		cad = cad.replace ('\u00fa', 'u');
		cad = cad.replace ('\u00f1', 'n');

		return cad;
	}
	
	/**
	 * M\u00e9todo que agrega la descripci\u00f3n de cada una de las p&aacute;ginas del marco de descripci\u00f3n.
	 *
	 * @param min como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n las p\u00e1ginas del marco de descripci\u00f3n (en este se pondr\u00e1 una cantidad reducida de caracteres).
	 * @param max como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n las p\u00e1ginas del marco de descripci\u00f3n (en este se pondr\u00e1 la cantidad necesaria de caracteres para que sea m\u00e1s legible para humanos).
	 */
	private void agregarPaginasDescripcion (PrintWriter min, PrintWriter max) {
		while (!paginasDescripcion.isEmpty ()) {
			min.print (paginasDescripcion.peek ());
			max.print (paginasDescripcion.poll ());
		}
	}
	
	/**
	 * M\u00e9todo que agrega los nombres de las im\u00e1genes del marco de descripci\u00f3n que se precargar\u00e1n.
	 *
	 * @param min como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n las im\u00e1genes del marco de descripci\u00f3n (en este se pondr\u00e1 una cantidad reducida de caracteres).
	 * @param max como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n las im\u00e1genes del marco de descripci\u00f3n (en este se pondr\u00e1 la cantidad necesaria de caracteres para que sea m\u00e1s legible para humanos).
	 */
	private void agregarImagenesPrecargadas (PrintWriter min, PrintWriter max) {
	
		boolean comprobante = false;//para no poner coma ni nueva linea en la primera vez
	
		while (!nombreImagenes.isEmpty ()) {
			if (comprobante) {
				min.print (",");
				max.print (",\n\t\t\t\t");
			}

			comprobante = true;
			max.print ("'"	+ nombreImagenes.peek () + "'");
			max.print ("'"	+ nombreImagenes.poll () + "'");
		}
	}
	
	/**
	 * Agrega los juegos similares y sus respectivos c\u00f3digos.
	 *
	 * @param min como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n los juegos similares (en este se pondr\u00e1 una cantidad reducida de caracteres).
	 * @param max como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1n los juegos similares (en este se pondr\u00e1 la cantidad necesaria de caracteres para que sea m\u00e1s legible para humanos).
	 */
	private void agregarJuegosSimilares (PrintWriter min, PrintWriter max) {
	
		boolean comprobante = false;//para no poner nueva linea ni coma la primera vez
	
		min.print ("array(");
		max.print ("array (");
	
		for (short j = 0; j < juegosSimilares.length; j++) {
			if (comprobante) {
				min.print (",");
				max.print (",\n\t\t\t\t");
			}
			
			comprobante = true;
			min.print ("array(\"" + juegosSimilares[j][0] + "\"," + juegosSimilares[j][1] + ")");
			max.print ("array (\"" + juegosSimilares[j][0] + "\", " + juegosSimilares[j][1] + ")");
		}
		
		min.print (");function comprobar(){global $r;global $cods;if ($r==");
		max.print (");\n\n\t\t\tfunction comprobar () {\n\t\t\t\tglobal $r;\n\t\t\t\t"
			+ "global $cods;\n\n\t\t\t\tif ($r == ");

		for (short j = 0; j < juegosSimilares.length; j++) {
			if (!comprobante) {
				min.print ("||$r==" + juegosSimilares[j][1]);
				max.print (" || $r == " + juegosSimilares[j][1]);
			} else {
				min.print (juegosSimilares[j][1]);
				max.print (juegosSimilares[j][1]);
			}
			
			comprobante = false;//ahora se usa para no poner " || $r == " al final
		}
		
		min.print ("){$r++;comprobar();}}");
		max.print (") {\n\t\t\t\t\t$r++;\n\t\t\t\t\tcomprobar ();\n\t\t\t\t}\n\t\t\t}");
	}
	
	/**
	 * Si es necesario, Agrega lo necesario para que el juego se vea centrado en el navegador.
	 *
	 * @param min como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1 lo necesario para centrar el juego (en este se pondr\u00e1 una cantidad reducida de caracteres).
	 * @param max como <code><b>PrintWriter</b></code> que define el archivo en el que se escribir\u00e1 lo necesario para centrar el juego (en este se pondr\u00e1 la cantidad necesaria de caracteres para que sea m\u00e1s legible para humanos).
	 */
	private void agregarCentrado (PrintWriter min, PrintWriter max) {
		String smpc = "";//(Style Margin Para Centrar) se usa para saber si hay que poner style en el objeto (juego) para centrarlo
		
		if ((640 - ancho) / 2 > 0)
			smpc = "style=\"margin-left: " + (640 - ancho) / 2 + "px;\" ";
		else if ((480 - alto) / 2 > 0)
			smpc = "style=\"margin-top: " + (480 - alto) / 2 + "px;\" ";
			
		min.print (smpc + "data=\"../SWF/" + convertirAnombreArchivo (titulo) + ".swf\" type=\""
			+ "application/x-shockwave-flash\">t<!-- <![endif]--><!--[if IE]><object id=\"juego\" width=\""
			+ ancho + "\" height=\"" + alto + "\" " + smpc);

		max.print (smpc + "data=\"../SWF/" + convertirAnombreArchivo (titulo) + ".swf\" type=\""
			+ "application/x-shockwave-flash\">\n\t\t\t\t<!-- <![endif]-->\n\t\t\t\t<!--[if IE]>"
			+ "\n\t\t\t\t\t<object id=\"juego\" width=\"" + ancho + "\" height=\"" + alto + "\" " + smpc);
	}
}
