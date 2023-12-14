
package com.mycompany.main_examen_nikens_pierre_louis;



import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Listar extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnVolver;

    public Listar(ArrayList<Mecanico> listaMecanicos) {
        setTitle("Listar todos los registros de Mecanicos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Columnas para el JTable
        String[] columnNames = {"ID Mecanico", "Nombre", "Edad", "Domicilio", "Titulo", "Especialidad", "Sueldo Base", "Gratificación", "Sueldo Total"};
        
        // Modelo de la tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Rellenar la tabla con los datos de los mecánicos
        for (Mecanico mecanico : listaMecanicos) {
            Object[] row = new Object[]{
                    mecanico.getIdMecanico(),
                    mecanico.getNombre(),
                    mecanico.getEdad(),
                    mecanico.getDomicilio(),
                    mecanico.getTitulo(),
                    mecanico.getEspecialidad(),
                    mecanico.getSueldoBase(),
                    mecanico.getGratificacionTitulo(),
                    mecanico.getSueldoTotal()
            };
            tableModel.addRow(row);
        }

        // Scroll pane para hacer scrollable la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Botón para volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose()); // Cierra la ventana

        // Añadir componentes al frame
        add(scrollPane, BorderLayout.CENTER); // Añade el scrollPane con la tabla al centro
        add(btnVolver, BorderLayout.SOUTH); // Añade el botón al final de la ventana

        // Configuración final de la ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }
}









        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    
   

