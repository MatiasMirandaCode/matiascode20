package pe.edu.vallegrande.Controller;

import pe.edu.vallegrande.Model.Modelo;
import pe.edu.vallegrande.Visual.Vista;

import javax.swing.*;
import java.util.ResourceBundle;

public class Controlador {
    private Modelo modelo;
    private Vista vista;
    private ResourceBundle mensajes;

    public Controlador(Modelo modelo, Vista vista, ResourceBundle mensajes) {
        this.modelo = modelo;
        this.vista = vista;
        this.mensajes = mensajes;

        this.vista.btnMostrarSaludo.addActionListener(e -> mostrarDialogoSaludo());
    }

    private void mostrarDialogoSaludo() {
        String nombre = JOptionPane.showInputDialog(vista, mensajes.getString("pregunta_nombre"));
        if (nombre == null) return;
        nombre = nombre.trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, mensajes.getString("error_nombre"), mensajes.getString("error_titulo"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        modelo.setNombre(nombre);
        String saludo = String.format(mensajes.getString("saludo"), modelo.getNombre());
        JOptionPane.showMessageDialog(vista, saludo);
    }
}
