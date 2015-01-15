<!doctype html>
<html>
	<head>
		<title>Strike Force Heroes 2 | Jaex - Juegos online gratis</title>
		<meta name="description" content="Dispara, corre y cubrete para ganarle al equipo contrario y divertirte mucho jugando Strike Force Heroes 2 gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="strike force heroes 2, juego de disparos, juego en equipo, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<br><img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"><div class="base">Saltar</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-flecha-abajo.png" alt="Tecla de la flecha hacia abajo"><div class="base">Agacharse</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-s.png" alt="Tecla de la letra S"><div class="base">Agacharse</div>',
				'<br><img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Moverse</div>',
				'<br><img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D"><div class="tac">Moverse</div>',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover para<br>apuntar</div>',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5">Disparar</div>',
				'<img class="ml1" src="../imagen/mouse-click-derecho.png" alt="Click derecho del mouse"><div class="base t5">Recargar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-r.png" alt="Tecla de la letra R"><div class="base">Recargar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-q.png" alt="Tecla de la letra Q"><div class="base">Cambiar<br>arma</div>',
				'<br><img class="ml2" src="../imagen/tecla-shift.png" alt="Tecla Shift"><div class="base">Cambiar<br>arma</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-p.png" alt="Tecla de la letra P"><div class="base">Pausar</div>'];
			
			var imgs=['tecla-flecha-arriba',
				'tecla-letra-w',
				'tecla-barra-espaciadora',
				'tecla-flecha-abajo',
				'tecla-letra-s',
				'tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-letra-a',
				'tecla-letra-d',
				'mouse',
				'mouse-click-izquierdo',
				'mouse-click-derecho',
				'tecla-letra-r',
				'tecla-letra-q',
				'tecla-shift',
				'tecla-letra-p'];
			codigo = 95;
			ancho = 640;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 95;
			$juegos = array (array ("strike_force_heroes", 28),
				array ("tiros_libres", 71),
				array ("asesino_tactico", 92),
				array ("counter_strike_1.6", 59),
				array ("tequila_zombies_2", 58),
				array ("sas_zombie_assault_2_insane_asylum", 27));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 95 || $r == 28 || $r == 71 || $r == 92 || $r == 59 || $r == 58 || $r == 27) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Strike Force Heroes 2
						</h4>
						<div id="descripcionCuerpo">
							Llega la segunda parte de este gran juego de disparos, ahora con mucha m&aacute;s diversi&oacute;n.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="480" data="../SWF/strike_force_heroes_2.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="480" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/strike_force_heroes_2.swf">
				<!--><!--dgx-->
					<param name="quality" value="high">
					<param name="wmode" value="opaque">
					<a href="http://get.adobe.com/es/flashplayer/" target="_blank">
						<img id="noFlash" class="atraccionPrincipal" src="../imagen/noFlash640x480.png" alt="Instale el complemento Flash para visualizar correctamente la p&aacute;gina">
					</a>
					</object>
				<!-- <![endif]-->
			</div>

		<?php include ("../PHP/reproduccionExt3.php");?>
</html>
