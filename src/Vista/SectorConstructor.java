package Vista;

import Herramientas.Construccion.EsquemaHerramientaDelJugador;
import Herramientas.Construccion.NoExisteEsquemaException;
import Juego.Jugador.Jugador;
import Juego.Mapa.ContenedorOcupadoException;
import Materiales.Diamante;
import Materiales.Madera;
import Materiales.Material;
import Materiales.Metal;
import Materiales.Piedra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class SectorConstructor extends VBox {

    private EligeVistas rutaVistas = EligeVistas.getInstance();
    private Jugador jugador;
    private SectorConstructorMateriales sectorConstruccionMateriales;
    private EsquemaHerramientaDelJugador esquema = EsquemaHerramientaDelJugador.getInstance();

    public SectorConstructor(Jugador jugador) {
        this.jugador = jugador;

        setSpacing(10);
        setTitulo();
        agregarSlots();
        agregarBotones();
        agregarSectorMateriales();
    }

    public void actualizar() {
        this.sectorConstruccionMateriales.actualizar();
    }

    private void setTitulo() {
        Text contructorTexto = new Text("Constructor");
        contructorTexto.setStyle("-fx-font: 24 arial;");
        getChildren().add(contructorTexto);
    }

    private void agregarBotones() {
        Button limpiar = new Button("Limpiar");
        Button crear = new Button("Crear");
        crear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            	try {
            		jugador.agregarHerramienta(esquema.construir());
                    sectorConstruccionMateriales.actualizar();
            	}
            	catch(NoExisteEsquemaException a) {
            		AlertBox.mostrar("No se pudo crear la herramienta, no existe esa combinacion de materiales ");
            	}
            }
        });
        HBox botonesLimpiarYCrearContenedor = new HBox();
        botonesLimpiarYCrearContenedor.setSpacing(10);
        botonesLimpiarYCrearContenedor.getChildren().addAll(limpiar, crear);
        getChildren().add(botonesLimpiarYCrearContenedor);
    }

    private void agregarSlots() {
        Image imgVacio = new Image(rutaVistas.vacio(), 35, 35, false, false);
        GridPane slots = new GridPane();

        Button slotMaterial00 = new Button("", new ImageView(imgVacio));
        Button slotMaterial01 = new Button("", new ImageView(imgVacio));
        Button slotMaterial02 = new Button("", new ImageView(imgVacio));
        Button slotMaterial10 = new Button("", new ImageView(imgVacio));
        Button slotMaterial11 = new Button("", new ImageView(imgVacio));
        Button slotMaterial12 = new Button("", new ImageView(imgVacio));
        Button slotMaterial20 = new Button("", new ImageView(imgVacio));
        Button slotMaterial21 = new Button("", new ImageView(imgVacio));
        Button slotMaterial22 = new Button("", new ImageView(imgVacio));

        getChildren().add(slots);
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
            		AlertBox.mostrar("Para que apretas aca si sabes que no tenes madera, me queres decir?");
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
                
                btnSlot.setBackground(new Background(backgroundImageMadera()));
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerPiedra = new MenuItem("Poner Piedra");
        ponerPiedra.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDePiedras() == 0) {
            		AlertBox.mostrar("Para que apretas aca si sabes que no tenes piedra, me queres decir?");
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
            	
                btnSlot.setBackground(new Background(backgroundImagePiedra()));
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerMetal = new MenuItem("Poner Metal");
        ponerMetal.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDeMetales() == 0) {
            		AlertBox.mostrar("Para que apretas aca si sabes que no tenes metal, me queres decir?");
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

                btnSlot.setBackground(new Background(backgroundImageMetal()));
                sectorConstruccionMateriales.actualizar();
            }
        });

        MenuItem ponerDiamante = new MenuItem("Poner Diamante");
        ponerDiamante.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	if(jugador.cantidadDeDiamantes() == 0) {
            		AlertBox.mostrar("Para que apretas aca si sabes que no tenes diamante, me queres decir?");
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
            	
                btnSlot.setBackground(new Background(backgroundImageDiamante()));
                sectorConstruccionMateriales.actualizar();
            }
        });

        contextMenu.getItems().addAll(ponerMadera, ponerPiedra, ponerMetal, ponerDiamante);

        return contextMenu;
    }

    //
    //button.setBackground(new Background(this.backgroundImageMadera()));

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

    private BackgroundImage imageViewPorString(String str) {
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        Image img = new Image(str, 25, 25, false, false);
        return new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize);
    }


}
