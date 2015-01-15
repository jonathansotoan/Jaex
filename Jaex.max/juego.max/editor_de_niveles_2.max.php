<!doctype html>
<html>
	<head>
		<title>Editor de Niveles 2 | Jaex - Juegos online gratis</title>
		<meta name="description" content="Usa tu creatividad para crearle el camino al mu&ntilde;eco de palos a la puerta jugando Editor de Niveles 2 gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content=" editor de niveles 2, mu&ntilde;eco de palos, juego de aventura, juego de puzzle, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover<br>elemento</div>',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5">Poner<br>elemento</div>',
				'<br><img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Moverse</div>',
				'<br><img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D"><div class="tac">Moverse</div>',
				'<br><img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"><div class="base">Saltar</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-r.png" alt="Tecla de la letra R"><div class="base">Reiniciar<br>nivel</div>'];
			var imgs = ['mouse',
				'mouse-click-izquierdo',
				'tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-flecha-arriba',
				'tecla-letra-a',
				'tecla-letra-d',
				'tecla-letra-w',
				'tecla-barra-espaciadora',
				'tecla-letra-r'];
			codigo = 87;
			ancho = 640;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 87;
			$juegos = array (array ("escape_de_la_prision", 62),
				array ("light-bot_2.0", 1),
				array ("stickman_freeride", 39),
				array ("snail_bob_3", 38),
				array ("twin_cat_warrior_2", 4),
				array ("fireboy_and_watergirl_in_the_forest_temple_3", 8));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 87 || $r == 62 || $r == 1 || $r == 39 || $r == 38 || $r == 4 || $r == 8) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Editor de Niveles 2
						</h4>
						<div id="descripcionCuerpo">
							Crea el camino para este mu&ntilde;eco de palos para que pueda llegar sano y salvo a la puerta.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="480" data="../SWF/editor_de_niveles_2.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="480" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/editor_de_niveles_2.swf">
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
