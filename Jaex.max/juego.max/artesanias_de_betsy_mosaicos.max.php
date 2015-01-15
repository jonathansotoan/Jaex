<!doctype html>
<html>
	<head>
		<title>Artesan&iacute;as de Betsy: Mosaicos | Jaex - Juegos online gratis</title>
		<meta name="description" content="S&eacute; creativo y haz hermosos mosaicos jugando Artesan&iacute;as de Betsy: Mosaicos. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="artesanias de betsy, mosaicos, betsy's crafts, mosaic, juego de pintar, juego de chicas, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<img class="ml1" src="../imagen/mouse-click-izquierdo.png" alt="Click izquierdo del mouse"><div class="base t5"><br>Seleccionar<br>elemento</div>'];
			var imgs = ['mouse-click-izquierdo'];
			codigo = 90;
			ancho = 640;
			alto = 466;
			mtpCentrar = "7px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 90;
			$juegos = array (array ("christmas_prep_makeover", 52),
				array ("barbie_ride", 50),
				array ("party_shop", 49),
				array ("maquillaje_de_superestrella", 48),
				array ("girls_go_fashion_party", 47),
				array ("fireboy_and_watergirl_in_the_light_temple", 6));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 90 || $r == 52 || $r == 50 || $r == 49 || $r == 48 || $r == 47 || $r == 6) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Artesan&iacute;as de Betsy: Mosaicos
						</h4>
						<div id="descripcionCuerpo">
							En este juego podr&aacute;s rellenar dibujos por medio de mosaicos. Saca tu lado creativo!

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="466" style="margin-top: 7px;" data="http://www8.agame.com/games/flash/b/betsys_crafts_mosaic/betsys_crafts_mosaic.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="466" style="margin-top: 7px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="http://www8.agame.com/games/flash/b/betsys_crafts_mosaic/betsys_crafts_mosaic.swf">
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
