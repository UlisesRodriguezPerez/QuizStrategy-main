package Vista;

import ArtesMarciales.ArteMarcial;
import ArtesMarciales.Ataque;
import ArtesMarciales.AtaqueEspecial;
import Modelo.DragWindow;
import Strategy.AtaqueP1;
import Strategy.Jugador;
import Strategy.StrategyManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Pantalla implements Initializable, DragWindow {

    private ArrayList<Text> ataquesArte1J1 = new ArrayList<>();
    private ArrayList<Text> ataquesArte2J1 = new ArrayList<>();
    private ArrayList<Text> ataquesArte3J1 = new ArrayList<>();
    private ArrayList<Text> ataquesArte1J2 = new ArrayList<>();
    private ArrayList<Text> ataquesArte2J2 = new ArrayList<>();
    private ArrayList<Text> ataquesArte3J2 = new ArrayList<>();
    private ArrayList<ImageView> fotosJ2 = new ArrayList<ImageView>();
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Ataque> ataquesJ1;
    private ArrayList<Ataque> ataquesJ2;
    private String ataquesSJ1 = "";
    private String ataquesSJ2 = "";
    private String ataquesSEJ1 = "";
    private String ataquesSEJ2 = "";

    @FXML
    private ComboBox<String> artesCBJ1;

    @FXML
    private Pane contenedor;

    //Ataques jugador 1
    @FXML
    private Text at1art1J1;

    @FXML
    private Text at2art1J1;

    @FXML
    private Text at3art1J1;

    @FXML
    private Text at1art2J1;

    @FXML
    private Text at2art2J1;

    @FXML
    private Text at3art2J1;

    @FXML
    private Text at1art3J1;

    @FXML
    private Text at2art3J1;

    @FXML
    private Text at3art3J1;

    //Ataques jugador 2

    @FXML
    private Text at1art1J2;

    @FXML
    private Text at2art1J2;

    @FXML
    private Text at3art1J2;

    @FXML
    private Text at1art2J2;

    @FXML
    private Text at2art2J2;

    @FXML
    private Text at3art3J2;

    @FXML
    private Text at1art3J2;

    @FXML
    private Text at2art3J2;

    @FXML
    private Text at3art2J2;

    //Textos de área ataques
    @FXML
    private TextArea ataquesNormalesJ1;

    @FXML
    private TextArea ataquesNormalesJ2;

    @FXML
    private TextArea ataquesEspecialesJ2;

    @FXML
    private TextArea ataquesEspecialesJ1;

    //Imágenes de ataques
    @FXML
    private ImageView fotoArteJ1;

    @FXML
    private ImageView fotoArte1J2;

    @FXML
    private ImageView fotoArte2J2;

    @FXML
    private ImageView fotoArte3J2;

    //Artes J1
    @FXML
    private Text arte1J1;

    @FXML
    private Text arte2J1;

    @FXML
    private Text arte3J1;

    //Artes J2
    @FXML
    private Text arte1J2;

    @FXML
    private Text arte2J2;

    @FXML
    private Text arte3J2;

    //Puntajes

    @FXML
    private Text puntajeJ1;

    @FXML
    private Text puntajeJ2;

    @FXML
    private Text ganador;

    @FXML
    void generarAtaqueJ1(ActionEvent event) {
        jugador1.setEstrategiaAtaque(AttackStrategiesEnum.PLAYER1);
        ataquesJ1 = jugador1.getEstrategiaAtaque().ataque();
    }

    @FXML
    void generarAtaqueJ2(ActionEvent event) throws FileNotFoundException {
        jugador2.setEstrategiaAtaque(AttackStrategiesEnum.PLAYER2);
        ataquesJ2 = jugador2.getEstrategiaAtaque().ataque();
        for (int i = 0; i < 3; i++){
            String pathFoto = jugador2.artesEscogidas.get(i).getImagen();
            InputStream stream = new FileInputStream(pathFoto);
            Image image = new Image(stream);
            fotosJ2.get(i).setImage(image);
        }
    }

    @FXML
    void pelear(ActionEvent event) {
        jugador1.recibirAtaques(ataquesJ2);
        jugador2.recibirAtaques(ataquesJ1);

        for(Ataque a: ataquesJ1) {
            if (a instanceof AtaqueEspecial) {
                ataquesSEJ1 = ataquesSEJ1 + a.getNombre() + "\n";
            } else {
                ataquesSJ1 = ataquesSJ1 + jugador1.recibirAtaques(ataquesJ2) + "\n";
                ataquesSJ2 = ataquesSJ2 + jugador2.recibirAtaques(ataquesJ1) + "\n";
            }
        }

        for(Ataque a: ataquesJ2) {
            if (a instanceof AtaqueEspecial) {
                ataquesSEJ2 = ataquesSEJ1 + a.getNombre() + "\n";
            } else {
                ataquesSJ1 = ataquesSJ1 + jugador1.recibirAtaques(ataquesJ2) + "\n";
                ataquesSJ2 = ataquesSJ2 + jugador2.recibirAtaques(ataquesJ1) + "\n";
            }
        }

        ataquesNormalesJ1.setText(ataquesSJ1);
        ataquesNormalesJ2.setText(ataquesSJ2);

        ataquesEspecialesJ1.setText(ataquesSEJ1);
        ataquesEspecialesJ2.setText(ataquesSEJ2);

        puntajeJ1.setText(jugador1.getVida() + " de 2000");
        puntajeJ2.setText(jugador2.getVida() + " de 2000");

        if (jugador1.getVida() < 0 && jugador2.getVida() < 0){
            if (jugador1.getVida() > jugador2.getVida()){
                ganador.setText("JUGADOR 1");
            }else if (jugador2.getVida() > jugador1.getVida()){
                ganador.setText("JUGADOR 2");
            }else{
                ganador.setText("EMPATE");
            }
        }else if (jugador1.getVida() > 0 && jugador2.getVida() < 0){
            ganador.setText("JUGADOR 1");
        }else if (jugador2.getVida() > 0 && jugador1.getVida() < 0){
            ganador.setText("JUGADOR 2");
        }else if (jugador2.getVida() == 0 && jugador1.getVida() == 0){
            ganador.setText("EMPATE");
        }
    }

    @FXML
    void reasignarj1(ActionEvent event){
        jugador1.reasignarArtesMarciales();

    }

    @FXML
    void reasignarj2(ActionEvent event){
        jugador2.reasignarArtesMarciales();
    }

    @FXML
    void ponerFoto(ActionEvent event) throws FileNotFoundException {
        String nom = artesCBJ1.getSelectionModel().getSelectedItem();
        for (ArteMarcial arteMarcial : jugador1.artesMarciales){
            if (arteMarcial.getNombre().equals(nom)){
                jugador1.setArteMarcialActual(arteMarcial);
                System.out.println(jugador1.getArteMarcialActual());
                String pathFoto = arteMarcial.getImagen();
                InputStream stream = new FileInputStream(pathFoto);
                Image image = new Image(stream);
                fotoArteJ1.setImage(image);
            }
        }
    }

    @FXML
    void cerrar(MouseEvent event){
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        stageActual.close();
        System.exit(0);
    }

    private void nombrarArtesAtaques(){
        ataquesArte1J1.add(at1art1J1); ataquesArte1J1.add(at2art1J1); ataquesArte1J1.add(at3art1J1);
        ataquesArte2J1.add(at1art2J1); ataquesArte2J1.add(at2art2J1); ataquesArte2J1.add(at3art2J1);
        ataquesArte3J1.add(at1art3J1); ataquesArte3J1.add(at2art3J1); ataquesArte3J1.add(at3art3J1);

        ataquesArte1J2.add(at1art1J2); ataquesArte1J2.add(at2art1J2); ataquesArte1J2.add(at3art1J2);
        ataquesArte2J2.add(at1art2J2); ataquesArte2J2.add(at2art2J2); ataquesArte2J2.add(at3art2J2);
        ataquesArte3J2.add(at1art3J2); ataquesArte3J2.add(at2art3J2); ataquesArte3J2.add(at3art3J2);

        StrategyManager.llenar();

        jugador1 = new Jugador();
        jugador2 = new Jugador();
        jugador1.setEnemigo(jugador2);
        jugador2.setEnemigo(jugador1);

        arte1J1.setText(jugador1.artesMarciales.get(0).getNombre());
        arte2J1.setText(jugador1.artesMarciales.get(1).getNombre());
        arte3J1.setText(jugador1.artesMarciales.get(2).getNombre());

        arte1J2.setText(jugador2.artesMarciales.get(0).getNombre());
        arte2J2.setText(jugador2.artesMarciales.get(1).getNombre());
        arte3J2.setText(jugador2.artesMarciales.get(2).getNombre());

        ArrayList<Ataque> nomsAt1J1 = jugador1.artesMarciales.get(0).getAtaques();
        ArrayList<Ataque> nomsAt2J1 = jugador1.artesMarciales.get(1).getAtaques();
        ArrayList<Ataque> nomsAt3J1 = jugador1.artesMarciales.get(2).getAtaques();
        ArrayList<Ataque> nomsAt1J2 = jugador2.artesMarciales.get(0).getAtaques();
        ArrayList<Ataque> nomsAt2J2 = jugador2.artesMarciales.get(1).getAtaques();
        ArrayList<Ataque> nomsAt3J2 = jugador2.artesMarciales.get(2).getAtaques();


        for (int t = 0; t < 3; t++){
            ataquesArte1J1.get(t).setText(nomsAt1J1.get(t).getNombre());
            ataquesArte2J1.get(t).setText(nomsAt2J1.get(t).getNombre());
            ataquesArte3J1.get(t).setText(nomsAt3J1.get(t).getNombre());
            ataquesArte1J2.get(t).setText(nomsAt1J2.get(t).getNombre());
            ataquesArte2J2.get(t).setText(nomsAt2J2.get(t).getNombre());
            ataquesArte3J2.get(t).setText(nomsAt3J2.get(t).getNombre());
        }

        ObservableList <String> artes = FXCollections.observableArrayList();
        System.out.println(jugador1.artesMarciales.get(0).getNombre());
        System.out.println(jugador1.artesMarciales.get(1).getNombre());
        System.out.println(jugador1.artesMarciales.get(2).getNombre());
        System.out.println("*********************************************************************\n");
        System.out.println(jugador2.artesMarciales.get(0).getNombre());
        System.out.println(jugador2.artesMarciales.get(1).getNombre());
        System.out.println(jugador2.artesMarciales.get(2).getNombre());
        System.out.println("*********************************************************************\n");
        artes.add(jugador1.artesMarciales.get(0).getNombre());
        artes.add(jugador1.artesMarciales.get(1).getNombre());
        artes.add(jugador1.artesMarciales.get(2).getNombre());
        artesCBJ1.setItems(artes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(contenedor);
        nombrarArtesAtaques();
        fotosJ2.add(fotoArte1J2);
        fotosJ2.add(fotoArte2J2);
        fotosJ2.add(fotoArte3J2);
    }
}
