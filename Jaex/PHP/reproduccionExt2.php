</div></div><img id="anterior" class="btnNavegacion" src="../imagen/anterior-icono.png" alt="Anterior"><img id="siguiente" class="btnNavegacion" src="../imagen/siguiente-icono.png" alt="Siguiente"></div><div id="juegosSimilares"><h3 id="textoJuegosSimilares">Juegos similares</h3><table style="border-spacing: 6px;"><tr><td><a href="<?php $nJuego=rand(0,5);echo $juegos[$nJuego][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[$nJuego][1];unset($juegos[$nJuego]);$juegos=array_values($juegos);?>.jpg"></div></td><td><a href="<?php $nJuego=rand(0,4);echo $juegos[$nJuego][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[$nJuego][1];unset($juegos[$nJuego]);$juegos=array_values($juegos);?>.jpg"></div></td></tr><tr><td><a href="<?php $nJuego=rand(0,3);echo $juegos[$nJuego][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[$nJuego][1];unset($juegos[$nJuego]);$juegos=array_values($juegos);?>.jpg"></div></td><td><a href="<?php $nJuego=rand(0,2);echo $juegos[$nJuego][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[$nJuego][1];unset($juegos[$nJuego]);$juegos=array_values($juegos);?>.jpg"></div></td></tr><tr><td><a href="<?php $nJuego=rand(0,1);echo $juegos[$nJuego][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[$nJuego][1];unset($juegos[$nJuego]);$juegos=array_values($juegos);?>.jpg"></div></td><td><a href="<?php echo $juegos[0][0];?>.php"><img class="marcojs" alt="Marco para im&aacute;genes" src="../imagen/marco-para-imagen.png"></a><div class="divImagenvpjs"><img class="imagenvpjs" alt="Ir al juego" src="../imagen/juegosvp/<?php echo $juegos[0][1];unset($juegos);?>.jpg"></div></td></tr></table></div></div><div id="posCen">