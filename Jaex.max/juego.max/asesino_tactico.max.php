<!doctype html>
<html>
	<head>
		<title>Asesino T&aacute;ctico | Jaex - Juegos online gratis</title>
		<meta name="description" content="Identifica tu objetivo y disparale para cumplir tu misi&oacute;n jugando Asesino T&aacute;ctico. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="asesino tactico, tactical assassin mobile, juego de accion, juego de disparos, juego de objetivos, mu&ntilde;eco de palos, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml2" src="../imagen/mouse.png" alt="Mouse"><div class="base t5">Mover para<br>apuntar</div>',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5">+Zoom /<br>disparar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-s.png" alt="Tecla de la letra S"><div class="base"> -Zoom</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Estabilizar puntero</div>'];
			var imgs = ['mouse',
				'mouse-click-izquierdo',
				'tecla-letra-s',
				'tecla-barra-espaciadora'];
			codigo = 92;
			ancho = 640;
			alto = 426;
			mtpCentrar = "27px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 92;
			$juegos = array (array ("stickman_downhill", 88),
				array ("editor_de_niveles_2", 87),
				array ("counter_strike_1.6", 59),
				array ("tequila_zombies_2", 58),
				array ("sas_zombie_assault_3", 26),
				array ("strike_force_heroes", 28));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 92 || $r == 88 || $r == 87 || $r == 59 || $r == 58 || $r == 26 || $r == 28) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Asesino T&aacute;ctico
						</h4>
						<div id="descripcionCuerpo">
							Usa tu precisi&oacute;n e inteligencia para eliminar tus objetivos lo m&aacute;s eficientemente posible.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="426" style="margin-top: 27px;" data="../SWF/asesino_tactico.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="426" style="margin-top: 27px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/asesino_tactico.swf">
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
