<!doctype html>
<html>
	<head>
		<title>Acrobacias en avalanchas | Jaex - Juegos online gratis</title>
		<meta name="description" content="S&eacute; lo m&aacute;s r&aacute;pido posible y huye de la avalancha mientras haces acrobacias jugando Acrobacias en avalanchas. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="acrobacias en avalanchas, avalanche stunts, juego de acrobacias, juego de habilidad, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Saltar</div>',
				'<img class="ml2" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"><div class="base">Saltar</div>',
				'<img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Inclinarse</div>',
				'<img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D"><div class="tac">Inclinarse</div>',
				'<img class="ml2" src="../imagen/tecla-flecha-abajo.png" alt="Tecla de la flecha hacia abajo"><div class="base">Agacharse</div>',
				'<img class="ml2" src="../imagen/tecla-letra-s.png" alt="Tecla de la letra S"><div class="base">Agacharse</div>',
				'<img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"><div class="base">Superman</div>',
				'<img class="ml3" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"> <img src="../imagen/tecla-letra-c.png" alt="Tecla de la letra C"><div class="tac"><div class="tac">Tocar tabla</div>',
				'<img class="ml2" src="../imagen/tecla-letra-r.png" alt="Tecla de la letra R"><div class="base">Reiniciar<br>nivel</div>',
				'<img class="ml2" src="../imagen/tecla-letra-p.png" alt="Tecla de la letra P"><div class="base">Pausar<br>juego</div>'];
			var imgs = ['tecla-flecha-arriba',
				'tecla-letra-w',
				'tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-letra-a',
				'tecla-letra-d',
				'tecla-flecha-abajo',
				'tecla-letra-s',
				'tecla-letra-x',
				'tecla-letra-x',
				'tecla-letra-c',
				'tecla-letra-r',
				'tecla-letra-p'];
			codigo = 89;
			ancho = 600;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "20px";
		</script>

		<?php
			$codigo = 89;
			$juegos = array (array ("renegade_racing", 84),
				array ("stunt_master", 74),
				array ("nitro_ninjas", 53),
				array ("uphill_rush", 30),
				array ("uphill_rush_5", 34),
				array ("earn_to_die_2012", 12));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 89 || $r == 84 || $r == 74 || $r == 53 || $r == 30 || $r == 34 || $r == 12) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Acrobacias en avalanchas
						</h4>
						<div id="descripcionCuerpo">
							Ser&aacute;s soltado al inicio de una avalancha, as&iacute; que huye lo m&aacute;s pronto posible de ella!

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="600" height="480" style="margin-left: 80px;" data="http://www8.agame.com/games/flash/a/avalanche_stunts/avalanche_stunts.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="600" height="480" style="margin-left: 80px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="http://www8.agame.com/games/flash/a/avalanche_stunts/avalanche_stunts.swf">
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
