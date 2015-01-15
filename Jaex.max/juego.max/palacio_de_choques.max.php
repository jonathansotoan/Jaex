<!doctype html>
<html>
	<head>
		<title>Palacio de choques | Jaex - Juegos online gratis</title>
		<meta name="description" content="En este juego tienes que destruir los dem&aacute;s coches para sobrevivr utilizando todo tipo de ayudas o poderes. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="smash palace, palacio de choques, juego de destrucci&oacute;n, juego de autos, funny game, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml3" src="../imagen/flechas-direccion.png" alt="Botones de direcci&oacute;n"><div class="tac">Conducir</div>',
				'<img class="ml3" src="../imagen/flechas-direccion-secundarias-w-a-s-d.png" alt="Botones de direcci&oacute;n secundarios"><div class="tac">Conducir</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-z.png" alt="Tecla de la letra Z"><div class="base">Nitro</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-x.png" alt="Tecla de la letra X"><div class="base">Lanzar<br>poder</div>',
				'<br><img class="ml2" src="../imagen/tecla-esc.png" alt="Tecla Esc (Escape)"><div class="base">Pause</div>'];
			var imgs = ['flechas-direccion',
				'flechas-direccion-secundarias-w-a-s-d',
				'tecla-letra-z',
				'tecla-letra-x',
				'tecla-esc'];
			codigo = 99;
			ancho = 640;
			alto = 480;
			mtpCentrar = "0px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 99;
			$juegos = array (array ("la_rex", 98),
				array ("earn_to_die_2012", 12),
				array ("earn_to_die", 11),
				array ("truck_mania", 36),
				array ("dynamite_blast_2", 35),
				array ("monster_truck_demolisher", 40));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 99 || $r == 98 || $r == 12 || $r == 11 || $r == 36 || $r == 35 || $r == 40) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Palacio de choques
						</h4>
						<div id="descripcionCuerpo">
							Tu misi&oacute;n en este juego es destruir los dem&aacute;s coches a choques con ayuda de divetidos poderes.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="480" data="../SWF/palacio_de_choques.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="480" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/palacio_de_choques.swf">
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
