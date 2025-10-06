package com.example.proyecto_1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class GestionController implements Initializable {

    // Este es el "contenedor" donde van todas las plantas
    @FXML
    private FlowPane contenedorPlantas;

    private boolean yaIniciado = false;

    // Este metodo se ejecuta cuando se abre la pantalla
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Cargando plantas...");
        cargarPlantasDesdeBD();
        yaIniciado = true;
    }

    // Metodo para cargar las plantas de la base de datos
    private void cargarPlantasDesdeBD() {
        //por si había otras plantas
        contenedorPlantas.getChildren().clear();

        //Los datos de la planta
        List<Planta> plantas = obtenerPlantasDeBD();

        System.out.println("Encontradas " + plantas.size() + " plantas");

        //Para cada planta crea la tarjeta que hice en PlantaBase con ese estilo
        for (Planta planta : plantas) {
            crearTarjetaPlanta(planta);
        }
    }

    // Metodo para obtener plantas de la base de datos
    private List<Planta> obtenerPlantasDeBD() {
        List<Planta> plantas = new ArrayList<>();
        //Conexión a la base de datos
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Datos", "root", "31102002A_")) {
            //Consulta
            String sql = "SELECT * FROM plantas";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Planta planta = new Planta(
                        resultado.getString("nombre"),
                        resultado.getString("familia"),
                        resultado.getString("luz"),
                        resultado.getInt("riego"),
                        resultado.getString("ubicacion")
                );
                plantas.add(planta);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar plantas: " + e.getMessage());
            e.printStackTrace();
        }

        return plantas;
    }

    // Metodo para crear una tarjeta individual de planta
    private void crearTarjetaPlanta(Planta planta) {
        try {
            // Coger la plantilla de Planta Base
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlantaBase.fxml"));
            Pane tarjeta = loader.load();

            // Busca cada elemento dentro de la tarjeta por su "nombre" propiedad de la planta
            Label textoNombre = (Label) tarjeta.lookup("#textoNombre");
            Label textoFamilia = (Label) tarjeta.lookup("#textoFamilia");
            Label textoLuz = (Label) tarjeta.lookup("#textoLuz");
            Label textoRiego = (Label) tarjeta.lookup("#textoRiego");
            Label textoUbicacion = (Label) tarjeta.lookup("#textoUbicacion");

            // Poner los datos de la planta en la tarjeta
            if (textoNombre != null) {
                textoNombre.setText(planta.getNombre() + ":");
            }
            if (textoFamilia != null) {
                textoFamilia.setText("Familia: " + planta.getFamilia());
            }
            if (textoLuz != null) {
                textoLuz.setText("Luz Necesaria: " + planta.getLuzNecesaria());
            }
            if (textoRiego != null) {
                textoRiego.setText("Riego: Cada " + planta.getRiego() + " días");
            }
            if (textoUbicacion != null) {
                textoUbicacion.setText("Ubicación: " + planta.getUbicacion());
            }

            // Agregar la tarjeta al contenedor
            contenedorPlantas.getChildren().add(tarjeta);

            System.out.println("Tarjeta creada para: " + planta.getNombre());

        } catch (Exception e) {
            System.out.println("Error creando tarjeta para: " + planta.getNombre());
            e.printStackTrace();
        }
    }

    //Función para volver al menú
    @FXML
    public void volverMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}