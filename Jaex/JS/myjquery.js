paginaActual=1;com=false;comBombillo=false;comPantCompleta=false;comTeclaF11=false;var seleccion;anulaClick=false;pagina[0]=$("#descripcionCuerpo").html();mostrarEstrella(estrellasActuales);if($.browser.msie){seleccion=$("#cabeza, #botonesVarios, #pie, #izquierda, #publicidadD, #panelEstrellas, #puntuacionExacta, #textoDescripcion, #bombillo, #pantallaCompleta, .addthis_button_facebook_like, .addthis_button_google_plusone, .addthis_pill_style, .marco, .marcojs, #botonesVarios img.estrella, #divDescripcion img.btnNavegacion")}else{seleccion=$("#cabeza, #botonesVarios, #pie, #izquierda, #publicidadD")}$("#siguiente").on("click",function(){sig()});$("#anterior").on("click",function(){ant()});$(".estrella").on("mouseout",function(){mostrarEstrella(estrellasActuales)}).on("mouseover",function(){mostrarEstrella(parseInt(this.alt))}).on("click",function(){if(!anulaClick){votar(parseInt(this.alt))}});$("#bombillo").on("click",function(){if(!comBombillo){$(this).attr("alt","Encender las luces");seleccion.fadeTo("slow",0.1,function(){comBombillo=true})}});$("#pantallaCompleta").on("click",function(){if(comBombillo){setTimeout("entrarPantCompleta ();",600)}else{entrarPantCompleta()}});$("html").on("click",function(a){if(a.target.id!="juego"){if(comBombillo){encenderLuces()}else{if(comPantCompleta){salirPantCompleta()}}}});$(document).on("keyup",function(a){if(a.keyCode==27){if(comBombillo){encenderLuces()}else{if(comPantCompleta){salirPantCompleta()}}}else{if(a.keyCode==33){ant()}else{if(a.keyCode==34){sig()}}}});$(".marco, .marcojs").on("mouseover",function(){$(this).attr("src","../imagen/marco-para-imagen-2.png")}).on("mouseout",function(){$(this).attr("src","../imagen/marco-para-imagen.png")});for(var j=0;j<imgs.length;j++)document.write('<img src="../imagen/' + imgs[j] + '.png" width="0" height="0" alt="Im&aacute;gen oculta para precargarla en la memoria cach&eacute;">');