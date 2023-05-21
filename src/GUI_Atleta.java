import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI_Atleta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblSexo;
	private JLabel lblEdad;
	private JLabel lblEstatura;
	private JComboBox cboSexo;
	private JTextField txtEdad;
	private JTextField txtEstatura;
	private JTextArea txtResultado;
	private JButton btnCalificar;
	private JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Atleta frame = new GUI_Atleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Atleta() {
		setTitle("Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 23, 90, 14);
		contentPane.add(lblSexo);
		
		lblEdad = new JLabel("Edad (a\u00F1os):");
		lblEdad.setBounds(10, 57, 90, 14);
		contentPane.add(lblEdad);
		
		lblEstatura = new JLabel("Estatura (mt):");
		lblEstatura.setBounds(10, 92, 90, 14);
		contentPane.add(lblEstatura);
		
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		cboSexo.setBounds(135, 20, 153, 20);
		contentPane.add(cboSexo);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(135, 54, 153, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtEstatura = new JTextField();
		txtEstatura.setBounds(135, 89, 153, 20);
		contentPane.add(txtEstatura);
		txtEstatura.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 184, 657, 286);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 645, 263);
		panel.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		btnCalificar = new JButton("Calificar");
		btnCalificar.addActionListener(this);
		btnCalificar.setBounds(435, 72, 89, 23);
		contentPane.add(btnCalificar);
		
		lblPeso = new JLabel("Peso (kg):");
		lblPeso.setBounds(10, 131, 90, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(135, 128, 153, 20);
		contentPane.add(txtPeso);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCalificar) {
			actionPerformedBtnCalificar(arg0);
		}
	}
	
	// Declaración de Variables Globales
		int sexo, edad, peso;
		double estatura;
		String escogerSexo, aptitud;
		private JLabel lblPeso;
		private JTextField txtPeso;
	
	protected void actionPerformedBtnCalificar(ActionEvent arg0) {
		// Entrada de Datos
				sexo = getSexo();
				edad = getEdad();
				estatura = getEstatura();
				peso = getPeso();
				// Proceso de Cálculo
				escogerSexo = getEscogerSexo(sexo);
				aptitud = calificarAptitud(escogerSexo,edad, estatura, peso);
				// Salida de Resultados
				mostrar();
			}
			int getSexo() {
				return cboSexo.getSelectedIndex();
			}
			int getEdad() {
				return Integer.parseInt(txtEdad.getText());
			}
			double getEstatura() {
				return Double.parseDouble(txtEstatura.getText());
			}
			int getPeso() {
				return Integer.parseInt(txtPeso.getText());
			}
			String getEscogerSexo(int s) {
				String es;
				switch(s) {
					case 0:		es = "Masculino"; break;
					default:	es = "Femenino"; break;
				}
				return es;
			}
			
			static String calificarAptitud(String es, int edad, double estatura, int peso) {
				if (es == "Masculino" && edad >= 18 && estatura > 1.70 && peso < 70) {
					return "apto";
				}
				else if (es == "Femenino" && edad > 16 && estatura >= 1.70 && peso <= 60) {
					return "apto";
				}
				else {
					return "no apto";
				}
			}
			void mostrar() {
				txtResultado.setText("RESULTADOS DEL EXAMEN DE APTITUD DE ATLETAS");
				txtResultado.append("\nEl sexo del atleta es: "+escogerSexo);
				txtResultado.append("\nLa edad del atleta es: "+edad);
				txtResultado.append("\nLa estatura del atleta es: "+estatura);
				txtResultado.append("\nEl peso del atleta es: "+peso);
				txtResultado.append("\nEl atleta se encuentra: "+aptitud);
			}
			
		}
