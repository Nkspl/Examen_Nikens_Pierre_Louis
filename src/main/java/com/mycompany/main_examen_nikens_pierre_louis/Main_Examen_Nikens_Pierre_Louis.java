

package com.mycompany.main_examen_nikens_pierre_louis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class Main_Examen_Nikens_Pierre_Louis{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Taller Mecanico IPCHILE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        
        
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
        btnEditar.addActionListener(e -> {
            // Obtener el índice del mecánico que se quiere editar
            int indiceMecanicoAEditar = obtenerIndiceMecanicoParaEditar();
            
            // Verificar que el índice sea válido
            if (indiceMecanicoAEditar >= 0 && indiceMecanicoAEditar < Guardar.getListaMecanicos().size()) {
                Editar ventanaEditar = new Editar(Guardar.getListaMecanicos(), indiceMecanicoAEditar);
                ventanaEditar.setVisible(true);
            } else {
                
               // JOptionPane.showMessageDialog(frame, "Seleccione un mecánico para editar.");
            }
        });
        
        
        
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

//Metodo para para darle logica a la accion del boton
 private static int obtenerIndiceMecanicoParaEditar() {
    String input = JOptionPane.showInputDialog("Ingrese el ID del mecánico a editar:");
    try {
        // Intentar convertir la entrada a un entero
        int idMecanico = Integer.parseInt(input);
        
        // Buscar el índice del mecánico con el ID proporcionado
        ArrayList<Mecanico> listaMecanicos = Guardar.getListaMecanicos();
        for (int i = 0; i < listaMecanicos.size(); i++) {
            if (listaMecanicos.get(i).getIdMecanico() == idMecanico) {
                return i; // Devolver el índice si se encuentra el mecánico
            }
        }
        
        // Si no se encuentra el mecánico, mostrar un mensaje y devolver -1
        JOptionPane.showMessageDialog(null, "No se encontró un mecánico con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return -1;
    } catch (NumberFormatException e) {
        // Manejar la excepción si la entrada no es un número válido
        JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
}
 
}