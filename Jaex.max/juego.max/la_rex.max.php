<!doctype html>
<html>
	<head>
		<title>L.A. Rex | Jaex - Juegos online gratis</title>
		<meta name="description" content="En este juego tendr&aacute;s que ponerte en los zapatos de un dinosaurio hambriento que ha escapado en los &Aacute;ngeles; a divertirse! (13+). gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="la rex, juego de dinosaurios, juego sangriento, dinosaur game, funny game, blood game, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<br><img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Moverse</div>',
				'<br><img class="ml3" src="../imagen/tecla-letra-a.png" alt="Tecla de la letra A"> <img src="../imagen/tecla-letra-d.png" alt="Tecla de la letra D"><div class="tac">Moverse</div>',
				'<br><img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Saltar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-w.png" alt="Tecla de la letra W"><div class="base">Saltar</div>',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover<br>cabeza</div>',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5">Morder</div>'];
			var imgs = ['tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-letra-a',
				'tecla-letra-d',
				'tecla-flecha-arriba',
				'tecla-letra-w',
				'mouse',
				'mouse-click-izquierdo'];
			codigo = 98;
			ancho = 640;
			alto = 384;
			mtpCentrar = "48px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 98;
			$juegos = array (array ("acrobacias_en_avalanchas", 89),
				array ("rush_rush", 68),
				array ("jurassic_omelet", 66),
				array ("truck_mania", 36),
				array ("tractor_mania", 35),
				array ("monster_truck_demolisher", 40));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 98 || $r == 89 || $r == 68 || $r == 66 || $r == 36 || $r == 35 || $r == 40) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							L.A. Rex
						</h4>
						<div id="descripcionCuerpo">
							Juega como un dinosaurio T-Rex y destruye todo a tu paso en la ciudad de Los &Aacute;ngeles.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="384" style="margin-top: 48px;" data="../SWF/la_rex.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="384" style="margin-top: 48px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/la_rex.swf">
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
