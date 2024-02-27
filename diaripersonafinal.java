package Diario;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class diaripersonafinal {
    private JFrame frame;
    private JTextField txtid;
    private JTextField txtFecha;
    private JTextArea txtDescripcion;
    private Diario diario;
    private JTextArea txtAreaResultados;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Component txtIngresaID;
   
    public diaripersonafinal() {
        diario = new Diario();
        inicializarGUI();
    }

    private void inicializarGUI() {
        frame = new JFrame("Diario Personal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        
        panel.add(new JLabel("Fecha (dd/MM/yyyy):"));
        txtFecha = new JTextField();
        panel.add(txtFecha);
        
        panel.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea(5, 20);
        JScrollPane scrollPaneDescripcion = new JScrollPane(txtDescripcion);
        panel.add(scrollPaneDescripcion);
        
        panel.add(new JLabel("Ingresa ID:"));
        txtIngresaID = new JTextArea(5, 20);
        JScrollPane scrollPaneIngresaID = new JScrollPane(txtIngresaID);
        panel.add(scrollPaneIngresaID);
        
        //botones de interacion
        
        
        
        JButton btnAgregar = new JButton("Agregar Entrada");
        btnAgregar.addActionListener(e -> agregarEntrada());
        panel.add(btnAgregar);

        JButton btnConsultar = new JButton("Consultar Entrada");
        btnConsultar.addActionListener(e -> consultarEntrada());
        panel.add(btnConsultar);
        
        JButton btnModificar = new JButton("Modificar Entrada");
        btnModificar.addActionListener(e -> modificarEntrada());
        panel.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar Entrada");
        btnEliminar.addActionListener(e -> eliminarEntrada());
        panel.add(btnEliminar);

        JButton btnConsultar1 = new JButton("Consultar por ID");
        btnConsultar1.addActionListener(e -> agregarEntrada());
        panel.add(btnConsultar1);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> salir());
        panel.add(btnSalir);
        // Aquí se puede añadir más botones y funcionalidades como modificar y eliminar entradas

        txtAreaResultados = new JTextArea(07, 10);
        JScrollPane scrollPaneResultados = new JScrollPane(txtAreaResultados);
        frame.add(scrollPaneResultados, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private Object salir() {
    	{
    	    System.exit(0);
    	}
		return null;
	}

	private Object eliminarEntrada() {
		 {
	        try {
	            Date fecha = sdf.parse(txtFecha.getText());
	            diario.eliminarEntrada(fecha);
	            txtAreaResultados.setText("Entrada eliminada ");
	        } catch (Exception e) {
	            txtAreaResultados.setText("ID incorrecto: " + e.getMessage());
	        }
	    }
		return null;
	}

	private Object modificarEntrada() {
	 {
	        try {
	            Date fecha = sdf.parse(txtFecha.getText());
	            String modificacion = txtDescripcion.getText();
	            diario.agregarEntrada(fecha, modificacion);
	            txtAreaResultados.setText("No se encontro ninguna modificacion");
	        } catch (Exception e) {
	            txtAreaResultados.setText("Modificacion exitosa " + e.getMessage());
	        }
	    }
		return null;
	}

	private void agregarEntrada() {
        try {
            Date fecha = sdf.parse(txtFecha.getText());
            String descripcion = txtDescripcion.getText();
            diario.agregarEntrada(fecha, descripcion);
            txtAreaResultados.setText("Entrada agregada.");
        } catch (Exception e) {
            txtAreaResultados.setText("Error al agregar la entrada: " + e.getMessage());
        }
    }

    private void consultarEntrada() {
        try {
            Date fecha = sdf.parse(txtFecha.getText());
            Entrada entrada = diario.obtenerEntrada(fecha);
            if (entrada != null) {
                txtAreaResultados.setText("Entrada encontrada:\nFecha: " +
                        sdf.format(entrada.getFecha()) + "\nDescripción: " +
                        entrada.getDescripcion());
            } else {
                txtAreaResultados.setText("No se encontró ninguna entrada para la fecha especificada.");
            }
        } catch (Exception e) {
            txtAreaResultados.setText("Error al consultar la entrada: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new diaripersonafinal());
    }

	public JTextField getTxtid() {
		return txtid;
	}

	public void setTxtid(JTextField txtid) {
		this.txtid = txtid;
	}
}
