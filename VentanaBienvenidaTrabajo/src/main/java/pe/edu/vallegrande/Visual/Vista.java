package pe.edu.vallegrande.Visual;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class Vista extends JFrame {
    public JButton btnMostrarSaludo = new JButton();

    public Vista(ResourceBundle mensajes) {
        super(mensajes.getString("titulo"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250));
        btnMostrarSaludo.setText(mensajes.getString("boton_saludo"));
        panel.add(btnMostrarSaludo);
        this.setContentPane(panel);
    }
}
