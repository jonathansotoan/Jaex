<!doctype html>
<html>
	<head>
		<title>Renegade Racing | Jaex - Juegos online gratis</title>
		<meta name="description" content="Compite en esta loca y divertida carrera llamada Renegade Racing jugando gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="renegade racing, juego de carreras, juego de autos, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<br><img class="ml3" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"> <img src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="tac">Acelerar</div>',,
				'<br><img class="ml3" src="../imagen/tecla-letra-s.png" alt="Tecla de la letra S"> <img src="../imagen/tecla-flecha-abajo.png" alt="Tecla de la flecha hacia abajo"><div class="tac">Frenar / reversar</div>',,
				'<br><img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D del teclado"><div class="tac">Inclinarse</div>',,
				'<br><img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la izquierda"><div class="tac">Inclinarse</div>',,
				'<br><img src="../imagen/barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Saltar</div>',
				'<img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X del teclado"><div class="base">Saltar</div>'];
			var imgs = ['tecla-letra-w',
				'tecla-flecha-arriba',
				'tecla-letra-s',
				'tecla-flecha-abajo',
				'tecla-letra-a',
				'tecla-letra-d',
				'tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-letra-x'];
			codigo = 84;
			ancho = 640;
			alto = 368;
			mtpCentrar = "56px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 84;
			$juegos = array (array ("earn_to_die", 11),
				array ("earn_to_die_2012", 12),
				array ("monster_truck_destroyer", 10),
				array ("monster_truck_demolisher", 40),
				array ("uphill_rush_4", 33),
				array ("stickman_freeride", 39));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 84 || $r == 11 || $r == 12 || $r == 10 || $r == 40 || $r == 33 || $r == 39) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Renegade Racing
						</h4>
						<div id="descripcionCuerpo">
							Logra pasar a trav&eacute;s de la confusi&oacute;n de las piruetas con tu veh&iacute;culo para ganar la carrera.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="368" style="margin-top: 56px;" data="../SWF/renegade_racing.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="368" style="margin-top: 56px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/renegade_racing.swf">
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