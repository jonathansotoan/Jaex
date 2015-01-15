<!doctype html>
<html>
	<head>
		<title>Xenos | Jaex - Juegos online gratis</title>
		<meta name="description" content="Luces, colores y mucha diversi&oacute; es lo que encontrar&aacute;s jugando Xenos gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="xenos, juego espacial, juego futurista, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml3" src="../imagen/flechas-direccion.png" alt="Botones de direcci&oacute;n"><div class="tac">Moverse</div>',
				'<img class="ml3" src="../imagen/flechas-direccion-secundarias-w-a-s-d.png" alt="Botones de direcci&oacute;n secundarios"><div class="tac">Moverse</div>',
				'<br><img class="ml2" src="../imagen/tecla-numero-1.png" alt="Tecla del n&uacute;mero 1"><div class="base">Cambiar<br>arma</div>',
				'<br><img class="ml2" src="../imagen/tecla-numero-2.png" alt="Tecla del n&uacute;mero 2"><div class="base">Cambiar<br>arma</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Continuar</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-p.png" alt="Tecla de la letra P"><div class="base">Pausar</div>'];
			var imgs = ['flechas-direccion',
				'flechas-direccion-secundarias-w-a-s-d',
				'tecla-numero-1',
				'tecla-numero-2',
				'tecla-barra-espaciadora',
				'tecla-letra-p'];
			codigo = 96;
			ancho = 640;
			alto = 427;
			mtpCentrar = "26px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 96;
			$juegos = array (array ("strike_force_heroes", 28),
				array ("strike_force_heroes_2", 95),
				array ("qoosh", 83),
				array ("dragon_ball_fierce_fighting", 73),
				array ("super_smash_flash", 56),
				array ("pac-xon", 55));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 96 || $r == 28 || $r == 95 || $r == 83 || $r == 73 || $r == 56 || $r == 55) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Xenos
						</h4>
						<div id="descripcionCuerpo">
							Tendr&aacute;s m&aacute;s de un arma para acabar con todos tus enemigos en este ambiente espacial.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="427" style="margin-top: 26px;" data="../SWF/xenos.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="427" style="margin-top: 26px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/xenos.swf">
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
