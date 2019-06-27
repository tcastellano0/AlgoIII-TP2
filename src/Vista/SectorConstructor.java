package Vista;

import Herramientas.Construccion.EsquemaHerramientaDelJugador;
import Herramientas.Construccion.NoExisteEsquemaException;
import Juego.Jugador.Jugador;
import Juego.Mapa.ContenedorOcupadoException;
import Juego.Mapa.ContenedorVacioException;
import Materiales.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.io.File;

public class SectorConstructor extends VBox {

    private EligeRutaImagenes rutaImagenes = EligeRutaImagenes.getInstance();
    private Jugador jugador;
    private SectorConstructorMateriales sectorConstruccionMateriales;
    private EsquemaHerramientaDelJugador esquema = EsquemaHerramientaDelJugador.getInstance();
    private GridPane slots = new GridPane();
    private Image imgVacio = new Image(rutaImagenes.vacio(), 35, 35, false, false);
    private SectorInventarioHerramientas sectorHerramientas;

    public SectorConstructor(Jugador jugador, SectorInventarioHerramientas sectorHerramientas) {
        this.jugador = jugador;
        this.sectorHerramientas = sectorHerramientas;
        slots.setVgap(10);
        setSpacing(10);
        setTitulo();
        agregarSlots();
        agregarBotones();
        agregarSectorMateriales();
    }

    public void dibujarGrillaConstructor(){
        ObservableList<Node> botones = slots.getChildren();
        for (Node n: botones){
            int i = GridPane.getRowIndex(n) + 1;
            int j = GridPane.getColumnIndex(n) + 1;
            Button boton = (Button) n;
            try{
                Material m = esquema.sacar(i,j);
                esquema.poner(m, i,j);
                boton.setBackground(new Background(backgroundImagePorClase(m)));
            }
            catch (ContenedorVacioException e){
                boton.setBackground(new Background(backgroundImageVacio()));
            }
        }
    }

    public void actualizar() {
        dibujarGrillaConstructor();
        this.sectorConstruccionMateriales.actualizar();
    }

    private void setTitulo() {
        Text contructorTexto = new Text("Constructor");
        contructorTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(contructorTexto);
    }

    private Button crearBotonLimpiar(){
        Button limpiar = new Button("Limpiar");
        limpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                for(int i=1; i<=3; i++)
                    for (int j = 1; j <= 3; j++) {
                        try {
                            jugador.guardar(esquema.sacar(i, j));
                        }
                        catch (ContenedorVacioException c){
                            continue;
                        }
                    }
                ObservableList<Node> botones = slots.getChildren();
                for ( Node n: botones){
                    if (n instanceof Button){
                        ((Button)n).setBackground(new Background(backgroundImageVacio()));
                    }
                }
                sectorConstruccionMateriales.actualizar();
            }
        });
        return limpiar;
    }

    private Button crearBotonCrear(){
        Button crear = new Button("Crear");
        crear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try {
                    jugador.agregarHerramienta(esquema.construir());
                    ponerSonidoConstruccion();
                    dibujarGrillaConstructor();
                    sectorConstruccionMateriales.actualizar();
                    sectorHerramientas.actualizar();
                    //System.out.println(jugador.cantidadDeHerramientas());
                } catch (NoExisteEsquemaException a) {
                    AlertBox.mostrar("No se pudo crear la herramienta, no existe esa combinacion de materiales ");
                }
            }

        });
        return crear;
    }

    private void agregarBotones() {
        HBox botonesLimpiarYCrearContenedor = new HBox();
        botonesLimpiarYCrearContenedor.setSpacing(10);
        botonesLimpiarYCrearContenedor.getChildren().addAll(crearBotonLimpiar(), crearBotonCrear());
        getChildren().add(botonesLimpiarYCrearContenedor);
    }

    private void agregarSlots() {
        Button slotMaterial00 = new Button("", new ImageView(imgVacio));
        slotMaterial00.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial01 = new Button("", new ImageView(imgVacio));
        slotMaterial01.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial02 = new Button("", new ImageView(imgVacio));
        slotMaterial02.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial10 = new Button("", new ImageView(imgVacio));
        slotMaterial10.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial11 = new Button("", new ImageView(imgVacio));
        slotMaterial11.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial12 = new Button("", new ImageView(imgVacio));
        slotMaterial12.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial20 = new Button("", new ImageView(imgVacio));
        slotMaterial20.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial21 = new Button("", new ImageView(imgVacio));
        slotMaterial21.setBackground(new Background(backgroundImageVacio()));
        Button slotMaterial22 = new Button("", new ImageView(imgVacio));
        slotMaterial22.setBackground(new Background(backgroundImageVacio()));

        getChildren().add(1,slots);
        slots.add(slotMaterial00, 0, 0);
        slots.add(slotMaterial01, 0, 1);
        slots.add(slotMaterial02, 0, 2);
        slots.add(slotMaterial10, 1, 0);
        slots.add(slotMaterial11, 1, 1);
        slots.add(slotMaterial12, 1, 2);
        slots.add(slotMaterial20, 2, 0);
        slots.add(slotMaterial21, 2, 1);
        slots.add(slotMaterial22, 2, 2);

        slotMaterial00.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial00));
        slotMaterial01.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial01));
        slotMaterial02.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial02));
        slotMaterial10.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial10));
        slotMaterial11.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial11));
        slotMaterial12.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial12));
        slotMaterial20.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial20));
        slotMaterial21.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial21));
        slotMaterial22.setContextMenu(getContextMenuConstruccionParaSlot(slotMaterial22));

    }


    private void agregarSectorMateriales() {
        this.sectorConstruccionMateriales = new SectorConstructorMateriales(this.jugador);

        getChildren().add(this.sectorConstruccionMateriales);
    }

    private ContextMenu getContextMenuConstruccionParaSlot(Button btnSlot) {
        int columna = GridPane.getColumnIndex(btnSlot) + 1;
        int fila = GridPane.getRowIndex(btnSlot) + 1;
        
        ContextMenu contextMenu = new ContextMenu();

        MenuItem ponerMadera = new MenuItem("Poner Madera");
        ponerMadera.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDeMaderas() == 0) {
            		AlertBox.mostrar("¿Para que apretas aca si sabes que no tenes madera, me queres decir?");
            		return;
            	}

            	Madera madera = jugador.sacarUnaMadera();

            	try {
            		esquema.poner(madera, fila, columna);
            	}catch(ContenedorOcupadoException ex) {
            		Material materialAnterior = esquema.sacar(fila, columna);
            		jugador.guardar(materialAnterior);
            		
            		esquema.poner(madera, fila, columna);
            	}
                
                dibujarGrillaConstructor();
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerPiedra = new MenuItem("Poner Piedra");
        ponerPiedra.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDePiedras() == 0) {
            		AlertBox.mostrar("¿Para que apretas aca si sabes que no tenes piedra, me queres decir?");
            		return;
            	}

            	Piedra piedra = jugador.sacarUnaPiedra();

            	try {
            		esquema.poner(piedra, fila, columna);
            	}catch(ContenedorOcupadoException ex) {
            		Material materialAnterior = esquema.sacar(fila, columna);
            		jugador.guardar(materialAnterior);
            		
            		esquema.poner(piedra, fila, columna);
            	}

                dibujarGrillaConstructor();
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerMetal = new MenuItem("Poner Metal");
        ponerMetal.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDeMetales() == 0) {
            		AlertBox.mostrar("¿Para que apretas aca si sabes que no tenes metal, me queres decir?");
            		return;
            	}

            	Metal metal = jugador.sacarUnMetal();

            	try {
            		esquema.poner(metal, fila, columna);
            	}catch(ContenedorOcupadoException ex) {
            		Material materialAnterior = esquema.sacar(fila, columna);
            		jugador.guardar(materialAnterior);
            		
            		esquema.poner(metal, fila, columna);
            	}

                dibujarGrillaConstructor();
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerDiamante = new MenuItem("Poner Diamante");
        ponerDiamante.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDeDiamantes() == 0) {
            		AlertBox.mostrar("¿Para que apretas aca si sabes que no tenes diamante, me queres decir?");
            		return;
            	}

            	Diamante diamante = jugador.sacarUnDiamante();

            	try {
            		esquema.poner(diamante, fila, columna);
            	}catch(ContenedorOcupadoException ex) {
            		Material materialAnterior = esquema.sacar(fila, columna);
            		jugador.guardar(materialAnterior);
            		
            		esquema.poner(diamante, fila, columna);
            	}

                dibujarGrillaConstructor();
                sectorConstruccionMateriales.actualizar();
            }
        });

        contextMenu.getItems().addAll(ponerMadera, ponerPiedra, ponerMetal, ponerDiamante);

        return contextMenu;
    }

    private BackgroundImage backgroundImagePorClase(Material mat){
        Class <? extends Material> clase = mat.getClass();
        if (clase == Madera.class)
            return backgroundImageMadera();
        if (clase == Piedra.class)
            return backgroundImagePiedra();
        if (clase == Metal.class)
            return backgroundImageMetal();
        if (clase == Diamante.class)
            return backgroundImageDiamante();
        return backgroundImageVacio();
    }

    private BackgroundImage backgroundImageMadera() {
        return imageViewPorString("Vista/images/MaterialesPanelConstruccion/cons_madera.png");
    }

    private BackgroundImage backgroundImagePiedra() {
        return imageViewPorString("Vista/images/MaterialesPanelConstruccion/cons_piedra.png");
    }

    private BackgroundImage backgroundImageMetal() {
        return imageViewPorString("Vista/images/MaterialesPanelConstruccion/cons_metal.png");
    }

    private BackgroundImage backgroundImageDiamante() {
        return imageViewPorString("Vista/images/MaterialesPanelConstruccion/cons_diamante.png");
    }
    private BackgroundImage backgroundImageVacio() {
        return imageViewPorString("Vista/images/MaterialesPanelConstruccion/cons_vacio.png");
    }

    private BackgroundImage imageViewPorString(String str) {
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        Image img = new Image(str, 25, 25, false, false);
        return new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize);
    }

    private void ponerSonidoConstruccion() {
        String ruidoConstruir = "src/Sonidos/craft2.mp3";

        Media sound = new Media(new File(ruidoConstruir).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}
