package com.example.proyecto_1;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.EventObject;
import java.util.Objects;

public class PlantaController {

    @FXML
    private TextField nombreNuevo;
    @FXML private TextField familiaNuevo;
    @FXML private TextField luzNuevo;
    @FXML private TextField riegoNuevo;
    @FXML private TextField ubicacionNuevo;

    @FXML
    public void NuevaPlanta(ActionEvent event) {
        try{

            String nombre = nombreNuevo.getText();
            String familia = familiaNuevo.getText();
            String luz = luzNuevo.getText();
            int riego = Integer.parseInt(riegoNuevo.getText());
            String ubicacion = ubicacionNuevo.getText();

            if(nombre.isEmpty() || familia.isEmpty() || luz.isEmpty() || ubicacion.isEmpty() ){
                System.out.println("Error");
                return;
            }
            //crear nueva planta
            Planta planta = new Planta(nombre, familia, luz, riego, ubicacion);

            // Guardar en la base de datos
            try (Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Datos", "root", "31102002A_")) {
                String sql = "INSERT INTO plantas (nombre, familia, luz, riego, ubicacion) VALUES (?, ?, ?, ?, ?)";
                //Para insertar los datos en mysql
                PreparedStatement stmt = conexion.prepareStatement(sql);
                stmt.setString(1, planta.getNombre());
                stmt.setString(2, planta.getFamilia());
                stmt.setString(3, planta.getLuzNecesaria());
                stmt.setInt(4, planta.getRiego());
                stmt.setString(5, planta.getUbicacion());
                //Inserta la planta en al tabla
                stmt.executeUpdate();

                System.out.println("Planta añadida correctamente");
                limpiarCampos();

                URL cargado = getClass().getResource("view3.fxml");
                if(cargado == null){
                    System.out.println("Eror no se encuentra planta");
                    return;
                }

                System.out.println("Cargado" +  cargado);;

                //Enseña la planta en la vista
                Parent cargar = FXMLLoader.load(cargado);
                Stage escenario = (Stage) ((Node) event.getSource()).getScene().getWindow();
                escenario.setScene(new Scene(cargar,1920,1080));
                escenario.setMaximized(true);
                escenario.show();

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void VolverPrimeraVista(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view1.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void VerPlantas(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view3.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    //al cargar la planta se borran los campos
    private void limpiarCampos() {
        nombreNuevo.clear();
        familiaNuevo.clear();
        luzNuevo.clear();
        riegoNuevo.clear();
        ubicacionNuevo.clear();
    }
}