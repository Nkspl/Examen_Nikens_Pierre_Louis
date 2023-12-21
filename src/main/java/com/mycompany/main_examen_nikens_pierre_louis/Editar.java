
package com.mycompany.main_examen_nikens_pierre_louis;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Editar extends JFrame {
    private JTextField txtIdMecanico, txtNombre, txtEdad, txtDomicilio, txtSueldoBase, txtGratificacion, txtSueldoTotal;
    private JComboBox<String> cmbTitulo, cmbEspecialidad;
    private JButton btnEditar, btnCorregir, btnVolver;
    private static ArrayList<Mecanico> listaMecanicos; // Referencia a la lista de mecánicos
    private Mecanico mecanicoActual; // Mecánico actualmente seleccionado para editar
    private int indiceMecanico; // Índice del mecánico en la lista

    public Editar(ArrayList<Mecanico> listaMecanicos, int indiceMecanico) {
        this.listaMecanicos = listaMecanicos;
        this.indiceMecanico = indiceMecanico;

        mecanicoActual = listaMecanicos.get(indiceMecanico); // Obtiene el mecánico seleccionado

        setTitle("Editar un Mecanico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(0, 2, 10, 10));

        // Inicializar componentes
        txtIdMecanico = new JTextField();
        txtNombre = new JTextField();
        txtEdad = new JTextField();
        txtDomicilio = new JTextField();
        txtSueldoBase = new JTextField();
        txtGratificacion = new JTextField(10);
        txtSueldoTotal = new JTextField();

        cmbTitulo = new JComboBox<>(new String[]{"Ingeniero Mecanico", "Tecnico Mecanico"});
        cmbEspecialidad = new JComboBox<>(new String[]{"Electromecanica", "Mecanica General", "Mecanica Avanzada"});

        btnEditar = new JButton("Editar");
        btnCorregir = new JButton("Corregir");
        btnVolver = new JButton("Volver");

        // Agregar componentes al layout
        add(new JLabel("ID Mecanico:"));
        add(txtIdMecanico);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Edad:"));
        add(txtEdad);
        add(new JLabel("Domicilio:"));
        add(txtDomicilio);
        add(new JLabel("Titulo:"));
        add(cmbTitulo);
        add(new JLabel("Especialidad:"));
        add(cmbEspecialidad);
        add(new JLabel("Sueldo Base:"));
        add(txtSueldoBase);
        add(new JLabel("Gratificación Título:"));
        add(txtGratificacion);
        add(new JLabel("Sueldo Total:"));
        add(txtSueldoTotal);

        // Agregar acciones a los botones
        btnEditar.addActionListener(e -> actualizarMecanico());
        btnCorregir.addActionListener(e -> cargarDatosMecanico());
        btnVolver.addActionListener(e -> dispose());

        // Agregar botones al layout
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEditar);
        panelBotones.add(btnCorregir);
        panelBotones.add(btnVolver);
        add(panelBotones);

        // Cargar datos del mecánico actual
        cargarDatosMecanico();

        setLocationRelativeTo(null);
        setVisible(true);
    }

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
            listaMecanicos.set(indiceMecanico, mecanicoActual);

            JOptionPane.showMessageDialog(this, "Mecánico actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese información válida.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    
    
    
    
}






