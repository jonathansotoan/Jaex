import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 *
 * @author Jonathan Alexander Soto Montoya
 * @version 1.01 2/05/2013 - í/05/2013
 */
public class GUIcrearJuego {

	DefaultTableModel dtm;
	JComboBox cbTipo;
	JFrame ventana;
	JTextField tfTitulo, tfDescripcionMeta, tfDescripcion, tfPalabrasClave, tfAncho, tfAlto, tfCodigo;
	Vector paginas, tipos;

	public GUIcrearJuego () {
		tipos = new Vector (5, 2);
		paginas = new Vector (5, 2);
		GUI ();
	}

	public static void main (String args[]) {
		new GUIcrearJuego ();
	}
	
	public void GUI () {
		JButton bAgregarPagina, bEliminarPagina, bGenerar;
		JComboBox[] juegosSimilares;
		JPanel pIzquierda, subpanel, pDerecha, pBotones;
		JScrollPane jsp;
		JTable tabla;

		tfTitulo = new JTextField ();
		tfDescripcionMeta = new JTextField ();
		tfDescripcion = new JTextField ();
		tfPalabrasClave = new JTextField ();
		tfAncho = new JTextField (4);
		tfAlto = new JTextField (4);
		tfCodigo = new JTextField ();

		pIzquierda = new JPanel (new GridLayout (11, 2, 10, 10));
		pDerecha = new JPanel (new BorderLayout (10, 10));
		subpanel = new JPanel ();
		pBotones = new JPanel();

		ventana = new JFrame ("Crear juego");
		pIzquierda.add (new JLabel ("DATOS", JLabel.RIGHT));
		pIzquierda.add (new JLabel ("B\u00c1SICOS", JLabel.LEFT));
		pIzquierda.add (new JLabel ("T\u00edtulo del juego"));
		pIzquierda.add (tfTitulo);
		pIzquierda.add (new JLabel ("<html>Descripci\u00f3n de la etiqueta META<br>[ gratis en l\u00ednea en Jaexjuegos.com]</html>"));
		pIzquierda.add (tfDescripcionMeta);
		pIzquierda.add (new JLabel ("Descripci\u00f3n para el usuario"));
		pIzquierda.add (tfDescripcion);
		pIzquierda.add (new JLabel ("<html>Palabras clave<br>[, en linea, online, gratis, free]</html>"));
		pIzquierda.add (tfPalabrasClave);
		subpanel.add (tfAncho);
		subpanel.add (new JLabel ("x"));
		subpanel.add (tfAlto);
		pIzquierda.add (new JLabel ("Dimensiones originales del juego (px)"));
		pIzquierda.add (subpanel);
		pIzquierda.add (new JLabel ("C\u00f3digo del juego"));
		pIzquierda.add (tfCodigo);
		pIzquierda.add (new JLabel ("JUEGOS", JLabel.RIGHT));
		pIzquierda.add (new JLabel ("SIMILARES", JLabel.LEFT));
		
		juegosSimilares = new JComboBox [6];
		cbTipo = new JComboBox ();
		cbTipo.addItem ("Selecciona un tipo de p\u00e1gina");
		cbTipo.addItem ("Una tecla");
		cbTipo.addItem ("Dos teclas");
		cbTipo.addItem ("Tres teclas");
		cbTipo.addItem ("Teclas de movimiento");
		cbTipo.addItem ("Mouse");
		cbTipo.addItem ("Tecla barra espaciadora");
		cbTipo.addItem ("Tecla enter");
		
		for (short j = 0; j < 6; j++) {
			juegosSimilares[j] = new JComboBox ();
			llenarMenu (juegosSimilares[j], "puntuacionjuegos.txt");
			pIzquierda.add (juegosSimilares[j]);
		}
		
		dtm = new DefaultTableModel (
			new String[]{"", "Tipo", "Atributos"}, 0) {
			
				Class types[] = new Class[] {
					java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
				};
				
				public Class getColumnClass (int ColumnIndex) {
					return types[ColumnIndex];
				}
				
				@Override
				public boolean isCellEditable (int fila, int columna) {
					if (columna == 0)
						return true;
					else
						return false;
				}
			};
		tabla = new JTable (dtm);
		tabla.getColumnModel ().getColumn (0).setPreferredWidth (30);
		tabla.getColumnModel ().getColumn (1).setPreferredWidth (100);
		tabla.getColumnModel ().getColumn (2).setPreferredWidth (400);
		jsp = new JScrollPane (tabla);
		bAgregarPagina = new JButton ("Agregar p\u00e1gina");
		bEliminarPagina = new JButton ("Eliminar p\u00e1gina");
		bGenerar = new JButton ("Generar archivo");
		
		bAgregarPagina.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbTipo.getSelectedItem ().toString ().equals ("Selecciona un tipo de p\u00e1gina"))
					ventanaAgregarPaginaDescripcion (cbTipo.getSelectedItem ().toString ());
			}
		});
		
		pDerecha.add (new JLabel ("<html>P\u00c1GINAS DE DESCRIPCI\u00d3N<br></html>", JLabel.CENTER), BorderLayout.NORTH);
		pDerecha.add (jsp, BorderLayout.CENTER);
		pBotones.add (cbTipo);
		pBotones.add (bAgregarPagina);
		pBotones.add (bEliminarPagina);
		pDerecha.add (pBotones, BorderLayout.SOUTH);
		
		ventana.setLayout (new BorderLayout (10, 10));
		ventana.add (pIzquierda, BorderLayout.CENTER);
		ventana.add (pDerecha, BorderLayout.EAST);
		ventana.add (bGenerar, BorderLayout.SOUTH);
		ventana.setDefaultCloseOperation (javax.swing.WindowConstants.EXIT_ON_CLOSE);
		ventana.pack ();
		ventana.setVisible (true);
		
		llenarDatosSugeridos ("puntuacionjuegos.txt");
	}
	
	public void ventanaAgregarPaginaDescripcion (String tipo) {

		JButton bAceptarAgregar = new JButton ("Aceptar");
		JButton bCancelar = new JButton ("Cancelar");
		
		final JDialog vapd = new JDialog (ventana, "Agregar p\u00e1gina descripci\u00f3n");
		vapd.setLayout (new BorderLayout (10, 10));

		final JPanel pCentral = new JPanel (new GridLayout (3, 2, 10, 10));
		JPanel pInferior = new JPanel (new GridLayout (1, 2, 10, 10));

		final JCheckBox ckbPredeterminado = new JCheckBox ("Usar datos predeterminados");

		String[] nombresImagenes = {"tecla-flecha-arriba",
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
		"tecla-borrar-backspace",
		"tecla-control-ctrl",
		"tecla-enter",
		"tecla-esc",
		"tecla-f11",
		"tecla-shift",
		"tecla-tabulador-tab",
		"Otro"};

		final JComboBox cbNombresImagenes = new JComboBox (nombresImagenes);
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (cbNombresImagenes.getSelectedItem ().equals ("Otro"))
					cbNombresImagenes.setEditable (true);
				else
					cbNombresImagenes.setEditable (false);
			}
		});
		
		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				vapd.setVisible (false);
			}
		});
		
		bCancelar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				vapd.setVisible (false);
			}
		});
		
		pInferior.add (bAceptarAgregar);
		pInferior.add (bCancelar);
		
		if (tipo.equals ("Una tecla"))
			paginaUnaTecla (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, pCentral);
		else if (tipo.equals ("Dos teclas"))
			paginaDosTeclas (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, nombresImagenes, pCentral);
		else if (tipo.equals ("Tres teclas"))
			paginaTresTeclas (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, nombresImagenes, pCentral);
		else if (tipo.equals ("Teclas de movimiento"))
			paginaTeclasDireccion (ckbPredeterminado, bAceptarAgregar, pCentral);
		else if (tipo.equals ("Mouse"))
			paginaMouse (ckbPredeterminado, bAceptarAgregar, pCentral);
		else if (tipo.equals ("Tecla barra espaciadora"))
			paginaTeclaBarraEspaciadora (ckbPredeterminado, bAceptarAgregar, pCentral);
		else if (tipo.equals ("Tecla enter"))
			paginaTeclaEnter (ckbPredeterminado, bAceptarAgregar, pCentral);
		/*else if (tipo.equals ("Mouse click izquierdo"))
			paginaMouseClickIzquierdo (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, pCentral);
		else if (tipo.equals ("Mouse click derecho"))
			paginaMouseClickDerecho (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, pCentral);
		else if (tipo.equals ("Mouse rueda"))
			paginaMouseRueda (ckbPredeterminado, bAceptarAgregar, cbNombresImagenes, pCentral);*/
		
		vapd.add (new JLabel (tipo.toUpperCase (), JLabel.CENTER), BorderLayout.NORTH);
		vapd.add (pCentral, BorderLayout.CENTER);
		vapd.add (pInferior, BorderLayout.SOUTH);
		vapd.pack ();
		vapd.setVisible (true);
	}
	
	private void paginaUnaTecla (final JCheckBox ckbPredeterminado,
											final JButton bAceptarAgregar,
											final JComboBox cbNombresImagenes,
											JPanel pCentral) {
		
		final JTextField tfDescripcion = new JTextField ();
		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Pausar"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Nombre de la imagen"));
		pCentral.add (cbNombresImagenes);
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ()) {
					cbNombresImagenes.setSelectedItem ("tecla-letra-p");
					tfDescripcion.setText ("Pausar");
				}
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				temp.add ("Una tecla");
				temp.add (cbNombresImagenes.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ())
					+ ", " + tfDescripcion.getText ());

				tipos.add ('u');
				
				if (ckbPredeterminado.isSelected ())
					paginas.add (null);
				else
					paginas.add (new String[] {cbNombresImagenes.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ()),
						tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes.getSelectedItem ().equals ("tecla-letra-p"))
					ckbPredeterminado.setSelected (false);
			}
		});
	}
	
	private void paginaDosTeclas (final JCheckBox ckbPredeterminado,
												final JButton bAceptarAgregar,
												final JComboBox cbNombresImagenes,
												String[] nombresImagenes,
												JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (4);
		
		final JComboBox cbNombresImagenes2 = new JComboBox (nombresImagenes);

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Inclinarse"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Nombre de la imagen 1"));
		pCentral.add (cbNombresImagenes);
		pCentral.add (new JLabel ("Nombre de la imagen 2"));
		pCentral.add (cbNombresImagenes2);
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ()) {
					cbNombresImagenes.setSelectedItem ("tecla-flecha-izquierda");
					cbNombresImagenes2.setSelectedItem ("tecla-flecha-derecha");
					tfDescripcion.setText ("Inclinarse");
				}
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				temp.add ("Dos teclas");
				temp.add (cbNombresImagenes.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ())
					+ ", " + cbNombresImagenes2.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes2.getSelectedItem ().toString ())
					+ ", " + tfDescripcion.getText ());

				tipos.add ('d');
				
				if (ckbPredeterminado.isSelected ())
					paginas.add (null);
				else
					paginas.add (new String[] {cbNombresImagenes.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ()),
						cbNombresImagenes2.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes2.getSelectedItem ().toString ()),
						tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes.getSelectedItem ().equals ("tecla-flecha-izquierda"))
					ckbPredeterminado.setSelected (false);
			}
		});
		
		cbNombresImagenes2.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes2.getSelectedItem ().equals ("tecla-flecha-derecha"))
					ckbPredeterminado.setSelected (false);
			}
		});
	}
	
	private void paginaTresTeclas (final JCheckBox ckbPredeterminado,
												final JButton bAceptarAgregar,
												final JComboBox cbNombresImagenes,
												String[] nombresImagenes,
												JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (5);
		
		final JComboBox cbNombresImagenes2 = new JComboBox (nombresImagenes);
		final JComboBox cbNombresImagenes3 = new JComboBox (nombresImagenes);

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Moverse"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Nombre de la imagen 1"));
		pCentral.add (cbNombresImagenes);
		pCentral.add (new JLabel ("Nombre de la imagen 2"));
		pCentral.add (cbNombresImagenes2);
		pCentral.add (new JLabel ("Nombre de la imagen 3"));
		pCentral.add (cbNombresImagenes3);
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ()) {
					cbNombresImagenes.setSelectedItem ("tecla-flecha-izquierda");
					cbNombresImagenes2.setSelectedItem ("tecla-flecha-arriba");
					cbNombresImagenes3.setSelectedItem ("tecla-flecha-derecha");
					tfDescripcion.setText ("Moverse");
				}
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				temp.add ("Tres teclas");
				temp.add (cbNombresImagenes.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ())
					+ ", " + cbNombresImagenes2.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes2.getSelectedItem ().toString ())
					+ ", " + cbNombresImagenes3.getSelectedItem ()
					+ ", " + textoAlternativo (cbNombresImagenes3.getSelectedItem ().toString ())
					+ ", " + tfDescripcion.getText ());

				tipos.add ('t');
				
				if (ckbPredeterminado.isSelected ())
					paginas.add (null);
				else
					paginas.add (new String[] {cbNombresImagenes.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes.getSelectedItem ().toString ()),
						cbNombresImagenes2.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes2.getSelectedItem ().toString ()),
						cbNombresImagenes3.getSelectedItem ().toString (),
						textoAlternativo (cbNombresImagenes3.getSelectedItem ().toString ()),
						tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes.getSelectedItem ().equals ("tecla-flecha-izquierda"))
					ckbPredeterminado.setSelected (false);
			}
		});
		
		cbNombresImagenes2.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes2.getSelectedItem ().equals ("tecla-flecha-arriba"))
					ckbPredeterminado.setSelected (false);
			}
		});
		
		cbNombresImagenes3.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes3.getSelectedItem ().equals ("tecla-flecha-derecha"))
					ckbPredeterminado.setSelected (false);
			}
		});
	}
	
	private void paginaTeclasDireccion (final JCheckBox ckbPredeterminado,
													final JButton bAceptarAgregar,
													JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (3);
		final JComboBox cbNombresImagenes = new JComboBox (new String[] {"flechas-direccion", "flechas-direccion-secundarias-w-a-s-d", "lechas-direccion-terciarias-i-j-k-l"});

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Moverse"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Tipo de teclas"));
		pCentral.add (cbNombresImagenes);
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ()) {
					cbNombresImagenes.setSelectedItem ("flechas-direccion");
					tfDescripcion.setText ("Moverse");
				}
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				
				if (cbNombresImagenes.getSelectedItem ().equals ("flechas-direccion")) {
					temp.add ("Teclas de movimiento primarias");
					tipos.add ('p');
				} else if (cbNombresImagenes.getSelectedItem ().equals ("flechas-direccion-secundarias-w-a-s-d")) {
					temp.add ("Teclas de movimiento secundarias");
					tipos.add ('s');
				} else {
					temp.add ("Teclas de movimiento terciarias");
					tipos.add ('j');
				}

				temp.add (tfDescripcion.getText ());

				paginas.add (new String[] {tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes.getSelectedItem ().equals ("flechas-direccion"))
					ckbPredeterminado.setSelected (false);
			}
		});
	}
	
	private void paginaMouse (final JCheckBox ckbPredeterminado,
										final JButton bAceptarAgregar,
										JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (3);
		final JComboBox cbNombresImagenes = new JComboBox (new String[] {"mouse", "mouse-click-izquierdo", "mouse-click-derecho", "rueda-del-mouse"});

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Disparar"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Tipo de mouse"));
		pCentral.add (cbNombresImagenes);
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ()) {
					cbNombresImagenes.setSelectedItem ("mouse-click-izquierdo");
					tfDescripcion.setText ("Disparar");
				}
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				
				if (cbNombresImagenes.getSelectedItem ().equals ("mouse")) {
					temp.add ("Mouse");
					tipos.add ('m');
				} else if (cbNombresImagenes.getSelectedItem ().equals ("mouse-click-izquierdo")) {
					temp.add ("Click izquierdo del mouse");
					tipos.add ('q');
				} else if (cbNombresImagenes.getSelectedItem ().equals ("mouse-click-derecho")) {
					temp.add ("Click derecho del mouse");
					tipos.add ('r');
				} else {
					temp.add ("Rueda del mouse");
					tipos.add ('h');
				}

				temp.add (tfDescripcion.getText ());
				
				paginas.add (new String[] {tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
		
		cbNombresImagenes.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (!cbNombresImagenes.getSelectedItem ().equals ("mouse-click-izquierdo"))
					ckbPredeterminado.setSelected (false);
			}
		});
	}
	
	private void paginaTeclaBarraEspaciadora (final JCheckBox ckbPredeterminado,
													final JButton bAceptarAgregar,
													JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (2);

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Saltar"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ())
					tfDescripcion.setText ("Saltar");
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				temp.add ("Tecla barra espaciadora del teclado");
				temp.add (tfDescripcion.getText ());

				if (ckbPredeterminado.isSelected ())
					paginas.add (null);
				else
					paginas.add (new String[] {tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
	}
	
	private void paginaTeclaEnter (final JCheckBox ckbPredeterminado,
													final JButton bAceptarAgregar,
													JPanel pCentral) {
		
		((GridLayout)pCentral.getLayout ()).setRows (2);

		final JTextField tfDescripcion = new JTextField ();

		tfDescripcion.addKeyListener (new KeyAdapter () {
			public void keyPressed (KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER && !tfDescripcion.getText ().equals (""))
					bAceptarAgregar.doClick ();
				else if (!tfDescripcion.getText ().equals ("Acci&oacute;n"))
					ckbPredeterminado.setSelected (false);
			}
		});

		pCentral.add (ckbPredeterminado);
		pCentral.add (new JLabel (""));
		pCentral.add (new JLabel ("Descripci\u00f3n"));
		pCentral.add (tfDescripcion);

		ckbPredeterminado.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				if (ckbPredeterminado.isSelected ())
					tfDescripcion.setText ("Acci&oacute;n");
			}
		});

		bAceptarAgregar.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				Vector temp = new Vector (3, 1);
				temp.add (false);
				temp.add ("Tecla enter del teclado");
				temp.add (tfDescripcion.getText ());

				if (ckbPredeterminado.isSelected ())
					paginas.add (null);
				else
					paginas.add (new String[] {tfDescripcion.getText ()});

				dtm.addRow (temp);
			}
		});
	}

	private String textoAlternativo (String nomArchivo) {
		if (nomArchivo.equals ("tecla-borrar-backspace"))
			return "Tecla borrar del teclado";
		else if (nomArchivo.equals ("tecla-control-ctrl"))
			return "Tecla control (Ctrl)";
		else if (nomArchivo.equals ("tecla-enter"))
			return "Tecla enter del teclado";
		else if (nomArchivo.equals ("tecla-esc"))
			return "Tecla de escape (Esc)";
		else if (nomArchivo.equals ("tecla-f11"))
			return "Tecla F11 del teclado";
		else if (nomArchivo.equals ("tecla-shift"))
			return "Tecla Shift del teclado";
		else if (nomArchivo.equals ("tecla-tabulador-tab"))
			return "Tecla tabulador (Tab)";
		else {
			StringTokenizer st = new StringTokenizer (nomArchivo, "-");
			st.nextToken ();
			String s = st.nextToken ();
			if (s.equals ("flecha"))
				return "Tecla de la flecha hacia la " + st.nextToken ();
			else if (s.equals ("letra"))
				return "Tecla de la letra " + st.nextToken ().toUpperCase ();
			else if (s.equals ("numero"))
				return "Tecla del n&uacute;mero " + st.nextToken ();
			else
				return "Tecla " + s + st.nextToken ();//Ocurre solo cuando se especifica una tecla nueva con la opcion "otra"
		}
	}
	
	public void llenarMenu (JComboBox menu, String nomArchivo) {
		try {
			BufferedReader br = new BufferedReader (new FileReader (nomArchivo));

			String linea;
			br.readLine ();
			while ((linea = br.readLine ()) != null) {
				StringTokenizer st = new StringTokenizer (linea);
				menu.addItem (st.nextToken () + ". " + st.nextToken ());
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println (fnfe.toString ());
		} catch (IOException ioe) {
			System.out.println (ioe.toString ());
		}
	}
	
	public void llenarDatosSugeridos (String nomArchivo) {
		
		short filas = 0;
		
		tfAncho.setText ("640");
		tfAlto.setText ("480");
		
		try {
			BufferedReader br = new BufferedReader (new FileReader (nomArchivo));
			
			while (br.readLine () != null)
				filas++;
		} catch (FileNotFoundException fnfe) {
			System.out.println ("Error al buscar el archivo: " + fnfe.toString ());
		} catch (IOException ioe) {
			System.out.println ("Error en la lectura del archivo: " + ioe.toString ());
		}
		
		tfCodigo.setText ("" + filas);
	}
}
