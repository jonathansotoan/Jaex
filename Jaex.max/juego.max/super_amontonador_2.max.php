<!doctype html>
<html>
	<head>
		<title>S&uacute;per Amontonador | Jaex - Juegos online gratis</title>
		<meta name="description" content="Pon a prueba tu habilidad para crear equilibrio y apila estos divertidos personajes jugando S&uacute;per Acumulador 2 gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="super amontonador 2, super stacker 2, juego de habilidad, juego divertido, juego de destrezas, juego puzzle, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base">Mover figuras</div>',
				'<img class="ml2" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base">Soltar figura</div>'];
			var imgs = ['mouse',
				'mouse-click-izquierdo'];
			codigo = 85;
			ancho = 523;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "58px";
		</script>

		<?php
			$codigo = 85;
			$juegos = array (array ("dynamite_blast", 14),
				array ("qoosh", 83),
				array ("shape_switcher", 67),
				array ("liquid_measure_2", 61),
				array ("stream_master_unlimited", 15),
				array ("light-bot", 2));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 85 || $r == 14 || $r == 83 || $r == 67 || $r == 61 || $r == 15 || $r == 2) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							S&uacute;per Amontonador
						</h4>
						<div id="descripcionCuerpo">
							Haz divertidas figuras con unas cuantas m&aacute;s peque&ntilde;as sin dejar que caigan.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="523" height="480" style="margin-left: 58px;" data="../SWF/super_amontonador_2.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="523" height="480" style="margin-left: 58px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/super_amontonador_2.swf">
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