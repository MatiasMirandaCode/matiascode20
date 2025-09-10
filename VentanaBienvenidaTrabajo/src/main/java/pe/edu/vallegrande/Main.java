package pe.edu.vallegrande;

import pe.edu.vallegrande.Model.Modelo;
import pe.edu.vallegrande.Visual.Vista;
import pe.edu.vallegrande.Controller.Controlador;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Look & Feel no disponible");
        }

        // 📌 Cargar idioma
        Locale locale = Locale.getDefault();
        ResourceBundle mensajes = getBundle("Mensajes", locale);

        // 📌 Modelo y Vista
        Modelo modelo = new Modelo();
        Vista vista = new Vista(mensajes);

        // 📌 Cargar icono desde recursos
        URL iconURL = Main.class.getResource("/fuego.png"); // Asegúrate que el nombre coincida
        if (iconURL != null) {
            ImageIcon icono = new ImageIcon(iconURL);
            vista.setIconImage(icono.getImage());
        } else {
            System.out.println("⚠️ No se encontró el archivo fuego.png");
        }

        // 📌 Controlador
        new Controlador(modelo, vista, mensajes);

        // 📌 Mostrar ventana
        SwingUtilities.invokeLater(() -> vista.setVisible(true));
    }
}
