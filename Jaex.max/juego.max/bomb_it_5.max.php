<!doctype html>
<html>
	<head>
		<title>Bomb it 5 | Jaex - Juegos online gratis</title>
		<meta name="description" content="Utiliza de manera adecuada las bombas para acabar con tus rivales y ser el mejor jugando Bomb it 5. gratis en l&iacute;nea en Jaexjuegos.com">
		<meta name="keywords" content="bomb it 5, juego de bombas, juego multijugador, juego bomberman, juego divertido, en linea, online, gratis, free">

		<script type="text/javascript">
			var pagina = ['',
				'<br><b>Modo de un jugador:</b>',
				'<img class="ml3" src="../imagen/flechas-direccion.png" alt="Botones de direcci&oacute;n"><div class="tac">Moverse</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Poner bomba</div>',
				'<br><b>Modo de dos jugadores:</b>',
				'<img class="ml3" src="../imagen/flechas-direccion.png" alt="Botones de direcci&oacute;n"><div class="tac">Moverse (jugador 1)</div>',
				'<img class="ml2" src="../imagen/tecla-enter.png" alt="Tecla Enter"><div class="base ml1 t5">Poner bomba<br>(jugador 1)</div>',
				'<img class="ml3" src="../imagen/flechas-direccion-secundarias-w-a-s-d.png" alt="Botones de direcci&oacute;n secundarios"><div class="tac">Moverse (jugador 2)</div>',
				'<br><img src="../imagen/tecla-barra-espaciadora.png" alt="Barra espaciadora del teclado"><div class="tac">Poner bomba (jugador 2)</div>',
				'<br><img class="ml2" src="../imagen/tecla-letra-p.png" alt="Tecla de la letra P"><div class="base">Pausar</div>'];
			var imgs = ['flechas-direccion',
				'tecla-barra-espaciadora',
				'tecla-enter',
				'flechas-direccion-secundarias-w-a-s-d',
				'tecla-letra-p'];
			codigo = 91;
			ancho = 640;
			alto = 466;
			mtpCentrar = "7px";
			mlpCentrar = "0px";
		</script>

		<?php
			$codigo = 91;
			$juegos = array (array ("big_head_football", 77),
				array ("the_king_of_fighters_wing", 72),
				array ("carrera_a_muerte", 64),
				array ("counter_strike_1.6", 59),
				array ("dragon_ball_fierce_fighting", 73),
				array ("party_shop", 49));

			function comprobar () {
				global $r;
				global $cods;

				if ($r == 91 || $r == 77 || $r == 72 || $r == 64 || $r == 59 || $r == 73 || $r == 49) {
					$r++;
					comprobar ();
				}
			}

			include ("../PHP/obtencionDatosBD.php");
			include ("../PHP/reproduccionExt1.php");
		?>
							Bomb it 5
						</h4>
						<div id="descripcionCuerpo">
							Utiliza las bombas para abrirte camino mientras adquieres habilidades para derrotar tus rivales.

							<?php include ("../PHP/reproduccionExt2.php"); ?>

			<div id="centro">
				<!--[if !IE]> -->
					<object id="juego" width="640" height="466" style="margin-top: 7px;" data="../SWF/bomb_it_5.swf" type="application/x-shockwave-flash">
				<!-- <![endif]-->
				<!--[if IE]>
					<object id="juego" width="640" height="466" style="margin-top: 7px;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0">
						<param name="movie" value="../SWF/bomb_it_5.swf">
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
