function mostrarEstrella(a){switch(a){case 10:$("#diez").attr("src","../imagen/estrella-mitad-derecha-amarilla.png");case 9:$("#nueve").attr("src","../imagen/estrella-mitad-izquierda-amarilla.png");case 8:$("#ocho").attr("src","../imagen/estrella-mitad-derecha-amarilla.png");case 7:$("#siete").attr("src","../imagen/estrella-mitad-izquierda-amarilla.png");case 6:$("#seis").attr("src","../imagen/estrella-mitad-derecha-amarilla.png");case 5:$("#cinco").attr("src","../imagen/estrella-mitad-izquierda-amarilla.png");case 4:$("#cuatro").attr("src","../imagen/estrella-mitad-derecha-amarilla.png");case 3:$("#tres").attr("src","../imagen/estrella-mitad-izquierda-amarilla.png");case 2:$("#dos").attr("src","../imagen/estrella-mitad-derecha-amarilla.png");case 1:$("#uno").attr("src","../imagen/estrella-mitad-izquierda-amarilla.png")}quitarEstrella(a+1)}function quitarEstrella(a){switch(a){case 1:$("#uno").attr("src","../imagen/estrella-mitad-izquierda-gris.png");case 2:$("#dos").attr("src","../imagen/estrella-mitad-derecha-gris.png");case 3:$("#tres").attr("src","../imagen/estrella-mitad-izquierda-gris.png");case 4:$("#cuatro").attr("src","../imagen/estrella-mitad-derecha-gris.png");case 5:$("#cinco").attr("src","../imagen/estrella-mitad-izquierda-gris.png");case 6:$("#seis").attr("src","../imagen/estrella-mitad-derecha-gris.png");case 7:$("#siete").attr("src","../imagen/estrella-mitad-izquierda-gris.png");case 8:$("#ocho").attr("src","../imagen/estrella-mitad-derecha-gris.png");case 9:$("#nueve").attr("src","../imagen/estrella-mitad-izquierda-gris.png");case 10:$("#diez").attr("src","../imagen/estrella-mitad-derecha-gris.png")}}function refrescarPuntuacion(){$.get("../PHP/intermediario.php",{id:codigo,instruccion:"0"},function(a){$("#puntuacionExacta").html(a)});$.get("../PHP/intermediario.php",{id:codigo,instruccion:"1"},function(a){estrellasActuales=Math.round(a);mostrarEstrella(estrellasActuales)})}function sig(){$("#descripcionCuerpo").hide("fast",function(){if(paginaActual==pagina.length){paginaActual=0}$(this).html(pagina[paginaActual]);paginaActual++}).show("fast")}function ant(){$("#descripcionCuerpo").hide("fast",function(){if(paginaActual==1){paginaActual=pagina.length}else{paginaActual--}$(this).html(pagina[paginaActual-1])}).show("fast")}