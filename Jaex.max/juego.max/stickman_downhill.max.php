<!doctype html>
<html>
	<head>
		<title>Stickman Downhill | Jaex - Juegos online gratis</title>
		<meta name="description" content="Acelera, salta, haz piruetas y lo m&aacute;s importante, divi&eacute;rtete jugando Stickman Downhill. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="stickman downhill, mu&ntilde;eco de palos, juego de bicicleta, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<br><img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Acelerar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"><div class="base">Acelerar</div>',
				'<br><img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Inclinarse</div>',
				'<br><img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D"><div class="tac">Inclinarse</div>',
				'<br><img class="ml2" src="../imagen/tecla-flecha-abajo.png" alt="Tecla de la flecha hacia abajo"><div class="base">Frenar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-s.png" alt="Tecla de la letra S"><div class="base">Frenar</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"><div class="base">S&uacute;perman</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-z.png" alt="Tecla de la letra Z"><div class="base">Sin manos</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-z.png" alt="Tecla de la letra Z"><img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"><div class="tac">Sin nada</div><span class="ft"> + </span>',
				'<br><img class="ml2" src="../imagen/tecla-letra-r.png" alt="Tecla de la letra R"><div class="base">Reiniciar<br>nivel</div>'];
			var imgs = ['tecla-flecha-arriba',
				'tecla-letra-w',
				'tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-letra-a',
				'tecla-letra-d',
				'tecla-flecha-abajo',
				'tecla-letra-s',
				'tecla-barra-espaciadora',
				'tecla-letra-x',
				'tecla-letra-z',
				'tecla-letra-r'];
			codigo = 88;
			ancho = 640;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 88;
			$juegos = array (array ("escape_de_la_prision", 62),
				array ("light-bot", 2),
				array ("stickman_freeride", 39),
				array ("editor_de_niveles_2", 87),
				array ("uphill_rush_5", 34),
				array ("fireboy_and_watergirl_in_the_ice_temple", 7));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 88 || $r == 62 || $r == 2 || $r == 39 || $r == 87 || $r == 34 || $r == 7) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Stickman Downhill
						</h4>
						<div id="descripcionCuerpo">
							Baja la monta&ntilde;a lo m&aacute;s r&aacute;pido que puedas y no te olvides de las piruetas.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="480" data="http://www8.agame.com/mirror/flash/s/Stickman_downhill/secure_StickmanDownhill.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="480" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="http://www8.agame.com/mirror/flash/s/Stickman_downhill/secure_StickmanDownhill.swf">
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
