<!doctype html>
<html>
	<head>
		<title>Portero Estrella | Jaex - Juegos online gratis</title>
		<meta name="description" content="Si eres &aacute;gil con el mouse entonces este es tu juego, se lo m&aacute;s veloz posible para tapar los disparos del equipo rival jugando Portero Estrella. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="portero estrella, portero premier, goalkeeper premier, juego de portero, juego de futbol, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover<br>manos</div>'];
			var imgs = ['mouse'];
			codigo = 94;
			ancho = 640;
			alto = 384;
			mtpCentrar = "48px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 94;
			$juegos = array (array ("billar_billiards", 93),
				array ("tiros_libres", 71),
				array ("pelotas_de_futbol", 63),
				array ("red_ball_4", 9),
				array ("big_head_football", 77),
				array ("uphill_rush_5", 34));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 94 || $r == 93 || $r == 71 || $r == 63 || $r == 9 || $r == 77 || $r == 34) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Portero Estrella
						</h4>
						<div id="descripcionCuerpo">
							S&eacute; un portero estrella atrapando todos los tiros hechos por tu contrincante, no dejes de intentarlo!

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="384" style="margin-top: 48px;" data="../SWF/portero_estrella.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="384" style="margin-top: 48px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/portero_estrella.swf">
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