package com.example.proyecto_1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    private EventObject event;


    //Todas las funciones para moverse de una pantalla a otra
    @FXML
    public void NuevaVentana1(ActionEvent event) throws IOException {
        Parent nuevaVista = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view0.fxml")));
        Scene nuevaEscena = new Scene(nuevaVista);

        // Obtener el escenario actual
        Stage escenario = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario.setScene(nuevaEscena);
        escenario.show();
    }

    @FXML
    public void Menu1(ActionEvent event) throws IOException {
        Parent nuevaVista1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view1.fxml")));
        Scene nuevaEscena1 = new Scene(nuevaVista1);

        // Obtener el escenario actual
        Stage escenario1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario1.setScene(nuevaEscena1);
        escenario1.show();
    }

    @FXML
    public void VolverPantallaPrincipal(ActionEvent event) throws IOException {
        Parent nuevaVista2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene nuevaEscena2 = new Scene(nuevaVista2);

        // Obtener el escenario actual
        Stage escenario2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario2.setScene(nuevaEscena2);
        escenario2.show();
    }

    @FXML
    public void VolverPrimeraVista(ActionEvent event) throws IOException {
        Parent nuevaVista3 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view0.fxml")));
        Scene nuevaEscena3 = new Scene(nuevaVista3);

        // Obtener el escenario actual
        Stage escenario3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario3.setScene(nuevaEscena3);
        escenario3.show();
    }

    @FXML
    public void NuevaPlanta(ActionEvent event) throws IOException {
        Parent nuevaVista4 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view2.fxml")));
        Scene nuevaEscena4 = new Scene(nuevaVista4);

        // Obtener el escenario actual
        Stage escenario4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario4.setScene(nuevaEscena4);
        escenario4.show();
    }

    @FXML
    public void ListarPlantas(ActionEvent event) throws IOException {
        Parent nuevaVista4 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view3.fxml")));
        Scene nuevaEscena4 = new Scene(nuevaVista4);

        // Obtener el escenario actual
        Stage escenario4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario4.setScene(nuevaEscena4);
        escenario4.show();
    }

    @FXML
    public void VolverMenu(ActionEvent event) throws IOException {
        Parent nuevaVista4 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view1.fxml")));
        Scene nuevaEscena4 = new Scene(nuevaVista4);

        // Obtener el escenario actual
        Stage escenario4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escenario4.setScene(nuevaEscena4);
        escenario4.show();
    }
}