

package com.mycompany.main_examen_nikens_pierre_louis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class Main_Examen_Nikens_Pierre_Louis{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Taller Mecanico IPCHILE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Taller Mecanico IPCHILE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titulo, BorderLayout.NORTH);

        JPanel botonesPanel = new JPanel(new FlowLayout());
        JButton btnCrear = new JButton("CREAR NUEVO MECANICO");
        JButton btnEditar = new JButton("EDITAR UN MECANICO");
        JButton btnListar = new JButton("LISTAR TODOS LOS MECANICOS");
        JButton btnEliminar = new JButton("ELIMINAR UN MECANICO");
        
        // Acción para el botón CREAR NUEVO MECANICO
        btnCrear.addActionListener(e -> {
            Guardar ventanaGuardar = new Guardar();
            ventanaGuardar.setVisible(true);
        });

        
      
        
        // Acción para el botón EDITAR UN MECANICO
       /* btnEditar.addActionListener(e -> {
             ventanaEditar = new Editar();
            ventanaEditar.setVisible(true);
        });
                          */
       
       
       
      
        // Acción para el botón LISTAR TODOS LOS MECANICOS
        
        btnListar.addActionListener(e -> {
    Listar ventanaListar = new Listar(Guardar.getListaMecanicos());
    ventanaListar.setVisible(true);
});
        
   

       
       // Acción para el botón ELIMINAR UN MECANICO
     btnEliminar.addActionListener(e -> {
    ArrayList<Mecanico> listaMecanicos = Guardar.getListaMecanicos(); // Suponiendo que tienes este método estático en la clase Guardar
    Eliminar ventanaEliminar = new Eliminar(listaMecanicos);
    ventanaEliminar.setVisible(true);
});


        botonesPanel.add(btnCrear);
        botonesPanel.add(btnEditar);
        botonesPanel.add(btnListar);
        botonesPanel.add(btnEliminar);
        frame.add(botonesPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
