<!doctype html>
<html>
	<head>
		<title>Super Mario Star Scramble | Jaex - Juegos online gratis</title>
		<meta name="description" content="Ayuda a Mario a rescatar a su princesa mientras te diviertes con este cl&aacute;sico juego jugando Super Mario Star Scramble 3 gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="super mario bros, mario star scramble 3, juego de aventura, juego de mario, juego cl&aacute;sico, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml3" src="../imagen/tecla-flecha-izquierda.png" alt="Tecla de la flecha hacia la izquierda"> <img src="../imagen/tecla-flecha-derecha.png" alt="Tecla de la flecha hacia la derecha"><div class="tac">Moverse</div>',
				'<img class="ml2" src="../imagen/tecla-flecha-arriba.png" alt="Tecla de la flecha hacia arriba"><div class="base">Entrar</div>',
				'<img class="ml2" src="../imagen/tecla-flecha-abajo.png" alt="Tecla de la flecha hacia abajo"><div class="base">Agacharse</div>',
				'<img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Saltar</div>',
				'<img class="ml2" src="../imagen/tecla-letra-z.png" alt="Tecla de la letra Z"><div class="base">Saltar</div>',
				'<img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"><div class="base">Disparar</div>'];
			var imgs = ['tecla-flecha-izquierda',
				'tecla-flecha-derecha',
				'tecla-flecha-arriba',
				'tecla-flecha-abajo',
				'tecla-letra-z',
				'tecla-letra-x'];
			codigo = 86;
			ancho = 640;
			alto = 400;
			mtpCentrar = "40px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 86;
			$juegos = array (array ("super_mario_flash", 43),
				array ("super_mario_battle", 45),
				array ("super_smash_flash", 56),
				array ("mario_rain_race", 57),
				array ("crash_bandicoot", 42),
				array ("sonic", 44));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 86 || $r == 43 || $r == 45 || $r == 56 || $r == 57 || $r == 42 || $r == 44) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Super Mario Star Scramble
						</h4>
						<div id="descripcionCuerpo">
							Ten cuidado con los obst&aacute;culos que se te presentar&aacute;n en esta gran aventura.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="400" style="margin-top: 40px;" data="../SWF/super_mario_star_scramble_3.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="400" style="margin-top: 40px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/super_mario_star_scramble_3.swf">
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
