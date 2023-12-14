
package com.mycompany.main_examen_nikens_pierre_louis;



// importaciones
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;


public class Guardar extends JFrame {
    private JTextField txtIdMecanico, txtNombre, txtEdad, txtDomicilio, txtSueldoBase, txtGratificacion;
    private JComboBox<String> cmbTitulo, cmbEspecialidad;
    private JLabel lblSueldoTotal;
    private JButton btnGuardar, btnCorregir, btnVolver;
    private static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();

    
    public Guardar() {
        // Inicializo los componetes y el layout
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns, horizontal and vertical gaps

        // Instancio los componentes de la interfaz de usuario
        txtIdMecanico = new JTextField(10);
        txtNombre = new JTextField(10);
        txtEdad = new JTextField(10);
        txtDomicilio = new JTextField(10);
        txtSueldoBase = new JTextField(10);
        txtGratificacion = new JTextField(10);
        lblSueldoTotal = new JLabel("0");
        
        // aqui creo los ComboBoxes
        cmbTitulo = new JComboBox<>(new String[] {"Ingeniero Mecanico", "Tecnico Mecanico"});
        cmbEspecialidad = new JComboBox<>(new String[] {"Electromecanica", "Mecanica General", "Mecanica Avanzada"});
        
        // creo los buttons
        btnGuardar = new JButton("Guardar");
        btnCorregir = new JButton("Corregir");
        btnVolver = new JButton("Volver");
        
        // Establecer colores de los botones si es necesario
        btnGuardar.setBackground(Color.GREEN);
        btnCorregir.setBackground(Color.RED);
        btnVolver.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnCorregir.setForeground(Color.WHITE);
        btnVolver.setForeground(Color.WHITE);
        
       
     
        // agregar componentes al layout
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
        add(lblSueldoTotal);

        // agrega las acciones que realizaran los botones
        btnGuardar.addActionListener(e -> guardarMecanico());
        btnCorregir.addActionListener(e -> corregirDatos());
        btnVolver.addActionListener(e -> dispose());
        
        // se agraga los botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCorregir);
        panelBotones.add(btnVolver);
        add(panelBotones);

        // Pack para hacerlo visible visible
        pack();
        setLocationRelativeTo(null); // centraliza la ventana
        setVisible(true);
    }

    //Metodo
    private void guardarMecanico() {
        try {
            int id = Integer.parseInt(txtIdMecanico.getText());
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String domicilio = txtDomicilio.getText();
            String titulo = (String) cmbTitulo.getSelectedItem();
            String especialidad = (String) cmbEspecialidad.getSelectedItem();
            double sueldoBase = Double.parseDouble(txtSueldoBase.getText());
            double gratificacion = Double.parseDouble(txtGratificacion.getText());
            double sueldoTotal = sueldoBase + gratificacion;
            lblSueldoTotal.setText(String.format("%.2f", sueldoTotal));

            Mecanico nuevoMecanico = new Mecanico(id, nombre, edad, domicilio, titulo, especialidad, sueldoBase, gratificacion);
            listaMecanicos.add(nuevoMecanico);

            JOptionPane.showMessageDialog(this, "Mecánico guardado exitosamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese información válida.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void corregirDatos() {
        txtIdMecanico.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtDomicilio.setText("");
        txtSueldoBase.setText("");
        txtGratificacion.setText("");
        lblSueldoTotal.setText("0");
    }
    
    public static ArrayList<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }
    
    
    
    
    
    
}














