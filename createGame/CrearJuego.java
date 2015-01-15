import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CrearJuego {
	static Document d;
	static PrintWriter sal;
	static PrintWriter salMin;
	static NodeList listaDeDatos;

	public static void main (String args[]) {
		boolean comComa = false;
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		int numFile = 0;
		String smpc = "";//(Style Margin Para Centrar) se usa para saber si hay que poner style en el objeto para centrarlo
		Queue<String> filenames = new LinkedList<String>();
	
		try {
			//Creación de una especie de fábrica de documentos
			dbf = DocumentBuilderFactory.newInstance ();
			
			//Creación del constructor de documentos a partir de la fábrica de documentos
			db = dbf.newDocumentBuilder ();
			
			//Creación del documento xml con el nombre de archivo especificado a partir del constructor de documentos
			d = db.parse ("EstructuraJuego.xml");
			
			sal = new PrintWriter(new FileWriter(etiquetas ("date").item (0).getTextContent () + ".max.php"));
			salMin = new PrintWriter(new FileWriter(etiquetas ("date").item (0).getTextContent () + ".php"));
			
		} catch (org.xml.sax.SAXException saxe) {
			System.out.println ("Error (SAXException): " + saxe.getMessage ());
		} catch (ParserConfigurationException pce) {
			System.out.println ("Error (ParserConfigurationException): " + pce.getMessage ());
		} catch (IOException ioe) {
			System.out.println ("Error (IOException): " + ioe.getMessage ());
		}
			
		if ((640 - Integer.parseInt (etiquetas ("date").item (6).getTextContent ())) / 2 > 0)
			smpc = "style=\"margin-left: " + (640 - Integer.parseInt (etiquetas ("date").item (6).getTextContent ())) / 2 + "px;\" ";
		else if ((480 - Integer.parseInt (etiquetas ("date").item (7).getTextContent ())) / 2 > 0)
			smpc = "style=\"margin-top: " + (480 - Integer.parseInt (etiquetas ("date").item (7).getTextContent ())) / 2 + "px;\" ";

		sal.print ("<!doctype html>\n<html>\n\t<head>\n\t\t<title>"
			+ etiquetas ("date").item (1).getTextContent ()
			+ " | Jaex - Juegos online gratis</title>\n\t\t<meta name=\"description\" content=\""
			+ etiquetas ("date").item (2).getTextContent ()
			+ " gratis en l&iacute;nea en Jaexjuegos.com\">\n\t\t<meta name=\"keywords\" content=\""
			+ etiquetas ("date").item (3).getTextContent ()
			+ ", en linea, online, gratis, free\">\n\n\t\t<script type=\"text/javascript\">\n\t\t\tvar pagina = [''");

		salMin.print ("<!doctype html><html><head><title>"
			+ etiquetas ("date").item (1).getTextContent ()
			+ " | JaexJuegos.com - Juegos online gratis</title><meta name=\"description\" content=\""
			+ etiquetas ("date").item (2).getTextContent ()
			+ " gratis en l&iacute;nea en Jaexjuegos.com\"><meta name=\"keywords\" content=\""
			+ etiquetas ("date").item (3).getTextContent ()
			+ ", en linea, online, gratis, free\"><script type=\"text/javascript\">var pagina=[''");

		for (short j = 0; j < etiquetas ("image").getLength (); j++) {
			//si lo que hay dentro de type de cada imágen de la descripción es igual a "una tecla"
			if (etiquetas ("type").item (j).getTextContent ().equals ("una tecla")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"><div class=\"base\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				salMin.print (",'<img class=\"ml2\" src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"><div class=\"base\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				filenames.add (etiquetas ("filename").item (numFile).getTextContent ());
				numFile++;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("dos teclas")) {
				sal.print (",\n\t\t\t\t'<br><img class=\"ml3\" src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 1).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 1).getTextContent ()
					+ "\"><div class=\"tac\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				salMin.print (",'<br><img class=\"ml3\" src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 1).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 1).getTextContent ()
					+ "\"><div class=\"tac\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				filenames.add (etiquetas ("filename").item (numFile).getTextContent ());
				filenames.add (etiquetas ("filename").item (numFile + 1).getTextContent ());
				numFile += 2;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("tres teclas")) {
				sal.print (",\n\t\t\t\t'<img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 1).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 1).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 2).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 2).getTextContent ()
					+ "\"><div class=\"tac\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				salMin.print (",'<img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 1).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 1).getTextContent ()
					+ "\"> <img src=\"../imagen/"
					+ etiquetas ("filename").item (numFile + 2).getTextContent ()
					+ ".png\" alt=\""
					+ etiquetas ("alt").item (numFile + 2).getTextContent ()
					+ "\"><div class=\"tac\">"
					+ etiquetas ("description").item (j).getTextContent ()
					+ "</div>'");

				filenames.add (etiquetas ("filename").item (numFile).getTextContent ());
				filenames.add (etiquetas ("filename").item (numFile + 1).getTextContent ());
				filenames.add (etiquetas ("filename").item (numFile + 2).getTextContent ());
				numFile += 3;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("una letra")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-letra-"
					+ etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la letra "
					+ etiquetas ("filename").item (numFile).getTextContent ().toUpperCase () + "\"><div class=\"base\">");

				salMin.print (",'<img class=\"ml2\" src=\"../imagen/tecla-letra-"
					+ etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la letra "
					+ etiquetas ("filename").item (numFile).getTextContent ().toUpperCase () + "\"><div class=\"base\">");
					
					if (etiquetas ("description").item (j).getTextContent ().equals ("")) {
						sal.print ("Pausar</div>'");
						salMin.print ("Pausar</div>'");
					} else {
						sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
						salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					}

				filenames.add ("tecla-letra-" + etiquetas ("filename").item (numFile).getTextContent ());
				numFile ++;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("barra espaciadora")) {
				sal.print (",\n\t\t\t\t'<br><img src=\"../imagen/tecla-barra-espaciadora.png\" alt=\"Barra espaciadora del teclado\"><div class=\"tac\">");
				
				salMin.print (",'<br><img src=\"../imagen/tecla-barra-espaciadora.png\" alt=\"Barra espaciadora del teclado\"><div class=\"tac\">");
				
				if (etiquetas ("description").item (j).getTextContent ().equals ("")) {
					sal.print ("Saltar</div>'");
					salMin.print ("Saltar</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}
				
				filenames.add ("tecla-barra-espaciadora");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("mouse")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/mouse.png\" alt=\"Mouse\"><div class=\"base t5\">");
				
				salMin.print (",'<img class=\"ml2\" src=\"../imagen/mouse.png\" alt=\"Mouse\"><div class=\"base t5\">");
				
				if (etiquetas ("description").item (j).getTextContent ().equals ("")) {
					sal.print ("Mover para<br>apuntar</div>'");
					salMin.print ("Mover para<br>apuntar</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}
				
				filenames.add ("mouse");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("click izquierdo")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-izquierdo.png\" alt=\"Click izquierdo del mouse\"><div class=\"base t5\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");

				salMin.print (",'<img class=\"ml1\" src=\"../imagen/mouse-click-izquierdo.png\" alt=\"Click izquierdo del mouse\"><div class=\"base t5\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");
				
				filenames.add ("mouse-click-izquierdo");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("click derecho")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml1\" src=\"../imagen/mouse-click-derecho.png\" alt=\"Click derecho del mouse\"><div class=\"base t5\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");

				salMin.print (",'<img class=\"ml1\" src=\"../imagen/mouse-click-derecho.png\" alt=\"Click derecho del mouse\"><div class=\"base t5\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");
				
				filenames.add ("mouse-click-derecho");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("una flecha")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-flecha-"
					+ etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la flecha hacia "
					+ etiquetas ("filename").item (numFile).getTextContent () + "\"><div class=\"base\">");

				salMin.print (",'<img class=\"ml2\" src=\"../imagen/tecla-flecha-"
					+ etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la flecha hacia "
					+ etiquetas ("filename").item (numFile).getTextContent () + "\"><div class=\"base\">");
					
					if (etiquetas ("description").item (j).getTextContent ().equals ("")) {
						sal.print ("Saltar</div>'");
						salMin.print ("Saltar</div>'");
					} else {
						sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
						salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					}
					
					filenames.add ("tecla-flecha-" + etiquetas ("filename").item (numFile).getTextContent ());
					numFile++;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("dos flechas")) {
				sal.print (",\n\t\t\t\t'<br><img class=\"ml3\" src=\"../imagen/tecla-flecha-izquierda.png\" alt=\"Tecla de la flecha hacia la izquierda\"> <img src=\"../imagen/tecla-flecha-derecha.png\" alt=\"Tecla de la flecha hacia la derecha\"><div class=\"tac\">");

				salMin.print (",'<br><img class=\"ml3\" src=\"../imagen/tecla-flecha-izquierda.png\" alt=\"Tecla de la flecha hacia la izquierda\"> <img src=\"../imagen/tecla-flecha-derecha.png\" alt=\"Tecla de la flecha hacia la derecha\"><div class=\"tac\">");
				
				if (etiquetas ("description").item (j).getTextContent () == "") {
					sal.print ("Inclinarse</div>'");
					salMin.print ("Inclinarse</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}
				
				filenames.add ("tecla-flecha-izquierda");
				filenames.add ("tecla-flecha-derecha");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("tres flechas")) {
				sal.print (",\n\t\t\t\t'<img src=\"../imagen/tecla-flecha-izquierda.png\" alt=\"Tecla de la flecha izquierda\"> <img src=\"../imagen/tecla-flecha-arriba.png\" alt=\"Tecla de la flecha arriba\"> <img src=\"../imagen/tecla-flecha-derecha.png\" alt=\"Tecla de la flecha derecha\"><div class=\"tac\">");

				salMin.print (",'<img src=\"../imagen/tecla-flecha-izquierda.png\" alt=\"Tecla de la flecha izquierda\"> <img src=\"../imagen/tecla-flecha-arriba.png\" alt=\"Tecla de la flecha arriba\"> <img src=\"../imagen/tecla-flecha-derecha.png\" alt=\"Tecla de la flecha derecha\"><div class=\"tac\">");

					if (etiquetas ("description").item (j).getTextContent () == "") {
						sal.print ("Moverse</div>'");
						salMin.print ("Moverse</div>'");
					} else {
						sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
						salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					}
					
					filenames.add ("tecla-flecha-izquierda");
					filenames.add ("tecla-flecha-arriba");
					filenames.add ("tecla-flecha-derecha");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("dos letras")) {
				sal.print (",\n\t\t\t\t'<br><img class=\"ml3\" src=\"../imagen/tecla-letra-");
				salMin.print (",'<br><img class=\"ml3\" src=\"../imagen/tecla-letra-");
				
				if (etiquetas ("filename").item (numFile).getTextContent ().equals ("")) {
					sal.print ("a.png\" alt=\"Tecla de la letra A\"> <img src=\"../imagen/tecla-letra-d.png\" alt=\"Tecla de la letra D\"><div class=\"tac\">");
					salMin.print ("a.png\" alt=\"Tecla de la letra A\"> <img src=\"../imagen/tecla-letra-d.png\" alt=\"Tecla de la letra D\"><div class=\"tac\">");
					
					filenames.add ("tecla-letra-a");
					filenames.add ("tecla-letra-d");
				} else {
					sal.print (etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la letra "
						+ etiquetas ("filename").item (numFile).getTextContent ().toUpperCase () + "\"> <img src=\"../imagen/tecla-letra-"
						+ etiquetas ("filename").item (numFile + 1).getTextContent () + ".png\" alt=\"Tecla de la letra "
						+ etiquetas ("filename").item (numFile + 1).getTextContent ().toUpperCase () + "\"><div class=\"tac\">");

					sal.print (etiquetas ("filename").item (numFile).getTextContent () + ".png\" alt=\"Tecla de la letra "
						+ etiquetas ("filename").item (numFile).getTextContent ().toUpperCase () + "\"> <img src=\"../imagen/tecla-letra-"
						+ etiquetas ("filename").item (numFile + 1).getTextContent () + ".png\" alt=\"Tecla de la letra "
						+ etiquetas ("filename").item (numFile + 1).getTextContent ().toUpperCase () + "\"><div class=\"tac\">");
						
					filenames.add ("tecla-letra-" + etiquetas ("filename").item (numFile).getTextContent ());
					filenames.add ("tecla-letra-" + etiquetas ("filename").item (numFile + 1).getTextContent ());
				}

				if (etiquetas ("description").item (j).getTextContent () == "") {
					sal.print ("Inclinarse</div>'");
					salMin.print ("Inclinarse</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}
				
				numFile += 2;
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("tres letras")) {
				sal.print (",\n\t\t\t\t'<img src=\"../imagen/tecla-letra-a.png\" alt=\"Tecla de la letra A\"> <img src=\"../imagen/tecla-letra-w.png\" alt=\"Tecla de la letra W\"> <img src=\"../imagen/tecla-letra-d.png\" alt=\"Tecla de la letra D\"><div class=\"tac\">");

				salMin.print (",'<img src=\"../imagen/tecla-letra-a.png\" alt=\"Tecla de la letra A\"> <img src=\"../imagen/tecla-letra-w.png\" alt=\"Tecla de la letra W\"> <img src=\"../imagen/tecla-letra-d.png\" alt=\"Tecla de la letra D\"><div class=\"tac\">");

				if (etiquetas ("description").item (j).getTextContent () == "") {
					sal.print ("Moverse</div>'");
					salMin.print ("Moverse</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}

				filenames.add ("tecla-letra-a");
				filenames.add ("tecla-letra-w");
				filenames.add ("tecla-letra-d");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("flechas pri") || etiquetas ("type").item (j).getTextContent ().equals ("flechas")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion.png\" alt=\"Botones de direcci&oacute;n\"><div class=\"tac\">");

				salMin.print (",'<img class=\"ml3\" src=\"../imagen/flechas-direccion.png\" alt=\"Botones de direcci&oacute;n\"><div class=\"tac\">");

				if (etiquetas ("description").item (j).getTextContent () == "") {
					sal.print ("Moverse</div>'");
					salMin.print ("Moverse</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}

				filenames.add ("flechas-direccion");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("flechas sec")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion-secundarias-w-a-s-d.png\" alt=\"Botones de direcci&oacute;n secundarios\"><div class=\"tac\">");

				salMin.print (",'<img class=\"ml3\" src=\"../imagen/flechas-direccion-secundarias-w-a-s-d.png\" alt=\"Botones de direcci&oacute;n secundarios\"><div class=\"tac\">");

				if (etiquetas ("description").item (j).getTextContent () == "") {
					sal.print ("Moverse</div>'");
					salMin.print ("Moverse</div>'");
				} else {
					sal.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
					salMin.print (etiquetas ("description").item (j).getTextContent () + "</div>'");
				}

				filenames.add ("flechas-direccion-secundarias-w-a-s-d");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("flechas ter")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml3\" src=\"../imagen/flechas-direccion-terciarias-i-j-k-l.png\" alt=\"Botones de direcci&oacute;n terciarios\"><div class=\"tac\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");

				salMin.print (",'<img class=\"ml3\" src=\"../imagen/flechas-direccion-terciarias-i-j-k-l.png\" alt=\"Botones de direcci&oacute;n terciarios\"><div class=\"tac\">" + etiquetas ("description").item (j).getTextContent () + "</div>'");
				
				filenames.add ("flechas-direccion-terciarias-i-j-k-l");
			} else if (etiquetas ("type").item (j).getTextContent ().equals ("enter")) {
				sal.print (",\n\t\t\t\t'<img class=\"ml2\" src=\"../imagen/tecla-enter.png\" alt=\"Tecla Enter\"><div class=\"base ml1\">"
					+ etiquetas ("description").item (j).getTextContent () + "</div>'");
				salMin.print (",'<img class=\"ml2\" src=\"../imagen/tecla-enter.png\" alt=\"Tecla Enter\"><div class=\"base ml1\">"
					+ etiquetas ("description").item (j).getTextContent () + "</div>'");

				filenames.add ("tecla-enter");
			}
		}

		sal.print ("];\n\t\t\tvar imgs = [");
		salMin.print ("];var imgs=[");

		while (!filenames.isEmpty ()) {
			if (comComa) {
				sal.print (",\n\t\t\t\t");
				salMin.print (",");
			} else
				comComa = true;

				sal.print ("'"	+ filenames.peek () + "'");
				salMin.print ("'"	+ filenames.poll () + "'");
			}

		sal.print ("];\n\t\t\tcodigo = " + etiquetas ("date").item (5).getTextContent ()
			+ ";\n\t\t\tancho = " + etiquetas ("date").item (6).getTextContent ()
			+ ";\n\t\t\talto = " + etiquetas ("date").item (7).getTextContent ()
			+ ";\n\t\t\tmtpCentrar = \"" + (480 - Integer.parseInt (etiquetas ("date").item (7).getTextContent ())) / 2
			+ "px\";\n\t\t\tmlpCentrar = \"" + (640 - Integer.parseInt (etiquetas ("date").item (6).getTextContent ())) / 2
			+ "px\";\n\t\t</script>\n\n\t\t<?php\n\t\t\t$codigo = " + etiquetas ("date").item (5).getTextContent ()
			+ ";\n\t\t\t$juegos = array (array (\"" + etiquetas ("path").item (0).getTextContent ()
			+ "\", " + etiquetas ("code").item (0).getTextContent ()
			+ "),\n\t\t\t\tarray (\"" + etiquetas ("path").item (1).getTextContent ()
			+ "\", " + etiquetas ("code").item (1).getTextContent ()
			+ "),\n\t\t\t\tarray (\"" + etiquetas ("path").item (2).getTextContent ()
			+ "\", " + etiquetas ("code").item (2).getTextContent ()
			+ "),\n\t\t\t\tarray (\"" + etiquetas ("path").item (3).getTextContent ()
			+ "\", " + etiquetas ("code").item (3).getTextContent ()
			+ "),\n\t\t\t\tarray (\"" + etiquetas ("path").item (4).getTextContent ()
			+ "\", " + etiquetas ("code").item (4).getTextContent ()
			+ "),\n\t\t\t\tarray (\"" + etiquetas ("path").item (5).getTextContent ()
			+ "\", " + etiquetas ("code").item (5).getTextContent ()
			+ "));\n\n\t\t\tfunction comprobar () {\n\t\t\t\tglobal $r;\n\t\t\t\tglobal $cods;\n\n\t\t\t\tif ($r == "
			+ etiquetas ("date").item (5).getTextContent () + " || $r == "
			+ etiquetas ("code").item (0).getTextContent () + " || $r == "
			+ etiquetas ("code").item (1).getTextContent () + " || $r == "
			+ etiquetas ("code").item (2).getTextContent () + " || $r == "
			+ etiquetas ("code").item (3).getTextContent () + " || $r == "
			+ etiquetas ("code").item (4).getTextContent () + " || $r == "
			+ etiquetas ("code").item (5).getTextContent ()
			+ ") {\n\t\t\t\t\t$r++;\n\t\t\t\t\tcomprobar ();\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tinclude (\"../PHP/obtencionDatosBD.php\");\n\t\t\tinclude (\"../PHP/reproduccionExt1.php\");\n\t\t?>\n\t\t\t\t\t\t\t"
			+ etiquetas ("date").item (1).getTextContent () + "\n\t\t\t\t\t\t</h4>\n\t\t\t\t\t\t<div id=\"descripcionCuerpo\">\n\t\t\t\t\t\t\t"
			+ etiquetas ("date").item (9).getTextContent () + "\n\n\t\t\t\t\t\t\t<?php include (\"../PHP/reproduccionExt2.php\"); ?>\n\n\t\t\t<div id=\"centro\">\n\t\t\t\t<!--[if !IE]> -->\n\t\t\t\t\t<object id=\"juego\" width=\""
			+ etiquetas ("date").item (6).getTextContent () + "\" height=\""
			+ etiquetas ("date").item (7).getTextContent () + "\" " + smpc + "data=\"../SWF/"
			+ etiquetas ("date").item (0).getTextContent ()
			+ ".swf\" type=\"application/x-shockwave-flash\">\n\t\t\t\t<!-- <![endif]-->\n\t\t\t\t<!--[if IE]>\n\t\t\t\t\t<object id=\"juego\" width=\""
			+ etiquetas ("date").item (6).getTextContent () + "\" height=\""
			+ etiquetas ("date").item (7).getTextContent () + "\" " + smpc + "classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0\">\n\t\t\t\t\t\t<param name=\"movie\" value=\"../SWF/"
			+ etiquetas ("date").item (0).getTextContent () + ".swf\">\n\t\t\t\t<!--><!--dgx-->\n\t\t\t\t\t<param name=\"quality\" value=\"hig"
			+ "h\">\n\t\t\t\t\t<param name=\"wmode\" value=\"opaque\">\n\t\t\t\t\t<a href=\"http://get.adobe.com/es/flashplayer/\" target"
			+ "=\"_blank\">\n\t\t\t\t\t\t<img id=\"noFlash\" class=\"atraccionPrincipal\" src=\"../imagen/noFlash640x480.png\" alt"
			+ "=\"Instale el complemento Flash para visualizar correctamente la p&aacute;gina\">\n\t\t\t\t\t</a>\n\t\t\t\t\t</object>\n\t"
			+ "\t\t\t<!-- <![endif]-->\n\t\t\t</div>\n\n\t\t<?php include (\"../PHP/reproduccionExt3.php\");?>\n</html>");

		salMin.print ("];codigo=" + etiquetas ("date").item (5).getTextContent ()
			+ ";ancho=" + etiquetas ("date").item (6).getTextContent ()
			+ ";alto=" + etiquetas ("date").item (7).getTextContent ()
			+ ";mtpCentrar=\"" + (480 - Integer.parseInt (etiquetas ("date").item (7).getTextContent ())) / 2
			+ "px\";mlpCentrar=\"" + (640 - Integer.parseInt (etiquetas ("date").item (6).getTextContent ())) / 2
			+ "px\";</script><?php $codigo=" + etiquetas ("date").item (5).getTextContent ()
			+ ";$juegos=array(array(\"" + etiquetas ("path").item (0).getTextContent ()
			+ "\"," + etiquetas ("code").item (0).getTextContent ()
			+ "),array(\"" + etiquetas ("path").item (1).getTextContent ()
			+ "\"," + etiquetas ("code").item (1).getTextContent ()
			+ "),array(\"" + etiquetas ("path").item (2).getTextContent ()
			+ "\"," + etiquetas ("code").item (2).getTextContent ()
			+ "),array(\"" + etiquetas ("path").item (3).getTextContent ()
			+ "\"," + etiquetas ("code").item (3).getTextContent ()
			+ "),array(\"" + etiquetas ("path").item (4).getTextContent ()
			+ "\"," + etiquetas ("code").item (4).getTextContent ()
			+ "),array(\"" + etiquetas ("path").item (5).getTextContent ()
			+ "\"," + etiquetas ("code").item (5).getTextContent ()
			+ "));function comprobar(){global $r;global $cods;if($r=="
			+ etiquetas ("date").item (5).getTextContent () + "||$r=="
			+ etiquetas ("code").item (0).getTextContent () + "||$r=="
			+ etiquetas ("code").item (1).getTextContent () + "||$r=="
			+ etiquetas ("code").item (2).getTextContent () + "||$r=="
			+ etiquetas ("code").item (3).getTextContent () + "||$r=="
			+ etiquetas ("code").item (4).getTextContent () + "||$r=="
			+ etiquetas ("code").item (5).getTextContent ()
			+ "){$r++;comprobar();}}include(\"../PHP/obtencionDatosBD.php\");include(\"../PHP/reproduccionExt1.php\");?>"
			+ etiquetas ("date").item (1).getTextContent () + "</h4><div id=\"descripcionCuerpo\">"
			+ etiquetas ("date").item (9).getTextContent () + "<?php include(\"../PHP/reproduccionExt2.php\");?><div id=\"centro\"><!--[if !IE]> --><object id=\"juego\" width=\""
			+ etiquetas ("date").item (6).getTextContent () + "\" height=\""
			+ etiquetas ("date").item (7).getTextContent () + "\" " + smpc + "data=\"../SWF/"
			+ etiquetas ("date").item (0).getTextContent ()
			+ ".swf\" type=\"application/x-shockwave-flash\"><!-- <![endif]--><!--[if IE]><object id=\"juego\" width=\""
			+ etiquetas ("date").item (6).getTextContent () + "\" height=\""
			+ etiquetas ("date").item (7).getTextContent () + "\" " + smpc + "classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0\"><param name=\"movie\" value=\"../SWF/"
			+ etiquetas ("date").item (0).getTextContent () + ".swf\"><!--><!--dgx--><param name=\"quality\" value=\"hig"
			+ "h\"><param name=\"wmode\" value=\"opaque\"><a href=\"http://get.adobe.com/es/flashplayer/\" target"
			+ "=\"_blank\"><img id=\"noFlash\" class=\"atraccionPrincipal\" src=\"../imagen/noFlash640x480.png\" alt"
			+ "=\"Instale el complemento Flash para visualizar correctamente la p&aacute;gina\"></a></object>"
			+ "<!-- <![endif]--></div><?php include(\"../PHP/reproduccionExt3.php\");?></html>");

		salMin.close ();
		sal.close ();
	}

	public static NodeList etiquetas (String s) {
		return d.getDocumentElement().getElementsByTagName(s);
	}
}
