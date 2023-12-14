
package com.mycompany.main_examen_nikens_pierre_louis;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Editar extends JFrame {
    private JTextField txtIdMecanico, txtNombre, txtEdad, txtDomicilio, txtSueldoBase, txtGratificacion, txtSueldoTotal;
    private JComboBox<String> cmbTitulo, cmbEspecialidad;
    private JButton btnEditar, btnCorregir, btnVolver;
    private static ArrayList<Mecanico> listaMecanicos; // Referencia a la lista de mecánicos
    private Mecanico mecanicoActual; // Mecánico actualmente seleccionado para editar

    public Editar(ArrayList<Mecanico> listaMecanicos, int indiceMecanico) {
        cargarDatosMecanico();
        mecanicoActual = listaMecanicos.get(indiceMecanico); // Obtiene el mecánico seleccionado

        setTitle("Editar un Mecanico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2, 10, 10));

        // Crear e inicializar los campos de texto y comboboxes aquí...

        // Botón de editar
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Recoge y valida los datos ingresados por el usuario
                // Actualiza el objeto mecanicoActual y la lista de mecánicos
            }
        });

        // Botón de corregir
        btnCorregir = new JButton("Corregir");
        btnCorregir.addActionListener(e -> {
            // Restablece los campos de entrada a los valores del mecánicoActual
        });

        // Botón de volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> dispose());

        // Añade los componentes al JFrame aquí...

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Métodos para cargar los datos del mecánico seleccionado y actualizar la lista...
    
    // Método para cargar los datos del mecánico seleccionado en los campos de texto y comboboxes
    private void cargarDatosMecanico() {
      
        txtIdMecanico.setText(String.valueOf(mecanicoActual.getIdMecanico()));
        txtNombre.setText(mecanicoActual.getNombre());
        txtEdad.setText(String.valueOf(mecanicoActual.getEdad()));
        txtDomicilio.setText(mecanicoActual.getDomicilio());
        cmbTitulo.setSelectedItem(mecanicoActual.getTitulo());
        cmbEspecialidad.setSelectedItem(mecanicoActual.getEspecialidad());
        txtSueldoBase.setText(String.format("%.2f", mecanicoActual.getSueldoBase()));
        txtGratificacion.setText(String.format("%.2f", mecanicoActual.getGratificacionTitulo()));
        txtSueldoTotal.setText(String.format("%.2f", mecanicoActual.getSueldoTotal()));
    }

    // Método para actualizar la lista de mecánicos con los datos editados
    private void actualizarMecanico() {
        try {
            int id = Integer.parseInt(txtIdMecanico.getText());
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String domicilio = txtDomicilio.getText();
            String titulo = (String) cmbTitulo.getSelectedItem();
            String especialidad = (String) cmbEspecialidad.getSelectedItem();
            double sueldoBase = Double.parseDouble(txtSueldoBase.getText());
            double gratificacionTitulo = Double.parseDouble(txtGratificacion.getText());

            // Actualizar el mecánico actual con los nuevos datos
            mecanicoActual.setIdMecanico(id);
            mecanicoActual.setNombre(nombre);
            mecanicoActual.setEdad(edad);
            mecanicoActual.setDomicilio(domicilio);
            mecanicoActual.setTitulo(titulo);
            mecanicoActual.setEspecialidad(especialidad);
            mecanicoActual.setSueldoBase(sueldoBase);
            mecanicoActual.setGratificacionTitulo(gratificacionTitulo);
            mecanicoActual.calcularSueldoTotal(); // Recalcula el sueldo total
           
            // Reemplaza el mecánico en la lista con el mecánico actualizado
            listaMecanicos.set(listaMecanicos.indexOf(mecanicoActual), mecanicoActual);

            JOptionPane.showMessageDialog(this, "Mecánico actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese información válida.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    
 
    
}






