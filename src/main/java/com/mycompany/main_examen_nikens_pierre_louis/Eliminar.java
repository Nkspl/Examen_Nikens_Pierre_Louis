
package com.mycompany.main_examen_nikens_pierre_louis;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Eliminar extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnEliminar, btnVolver;
    private static ArrayList<Mecanico> listaMecanicos; // Referencia a la lista de mecánicos

    public Eliminar(ArrayList<Mecanico> listaMecanicos) {
        Eliminar.listaMecanicos = listaMecanicos; // Inicializa la referencia de la lista

        setTitle("Eliminar un registro de Mecanicos especifico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        
        // Define las columnas de la tabla
        String[] columnNames = {"ID Mecanico", "Nombre", "Edad", "Domicilio", "Titulo", "Especialidad", "Sueldo Base", "Gratificación", "Sueldo Total"};
        
        // Crea el modelo de la tabla y desactiva la edición
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace todas las celdas no editables
            }
        };
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

        // ScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Botón de eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Elimina el mecánico de la lista y actualiza la tabla
                    listaMecanicos.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un mecánico para eliminar.");
                }
            }
        });

        // Botón de volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        // Añade los componentes al JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.PAGE_END);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnVolver);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}






















