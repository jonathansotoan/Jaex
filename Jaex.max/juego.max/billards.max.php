<!doctype html>
<html>
	<head>
		<title>Billards | Jaex - Juegos online gratis</title>
		<meta name="description" content="Demuestra que eres el mejor jugando este divertido deporte, el billar jugando Billards gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="juego de billar, billards, juego de deporte, juego multijugador, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover palo</div>',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5">Potencia / Tirar</div>'];
			var imgs = ['mouse',
				'mouse-click-izquierdo'];
			codigo = 93;
			ancho = 640;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 93;
			$juegos = array (array ("acrobacias_en_avalanchas", 89),
				array ("puzzle_motos_tuning", 82),
				array ("counter_strike_1.6", 59),
				array ("big_head_football", 77),
				array ("carrera_atv", 65),
				array ("bad_piggies", 16));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 93 || $r == 89 || $r == 82 || $r == 59 || $r == 77 || $r == 65 || $r == 16) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Billards
						</h4>
						<div id="descripcionCuerpo">
							Juega con un amigo o contra la computadora este divertido juego de billar pool.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="480" data="../SWF/billards.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="480" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/billards.swf">
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