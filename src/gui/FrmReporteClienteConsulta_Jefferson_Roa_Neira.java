package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel_Jefferson_Roa_Neira;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

public class FrmReporteClienteConsulta_Jefferson_Roa_Neira extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JButton btnConsultar;
	private JPanel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClienteConsulta_Jefferson_Roa_Neira frame = new FrmReporteClienteConsulta_Jefferson_Roa_Neira();
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
	public FrmReporteClienteConsulta_Jefferson_Roa_Neira() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDeDirector = new JLabel("Consulta de Cliente por DNI");
		lblConsultaDeDirector.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultaDeDirector.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeDirector.setBounds(10, 11, 908, 48);
		contentPane.add(lblConsultaDeDirector);
		
		JLabel lblFechaDeInicio = new JLabel("Por favor ingrese su DNI");
		lblFechaDeInicio.setBounds(299, 72, 157, 20);
		contentPane.add(lblFechaDeInicio);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(468, 71, 149, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(641, 71, 162, 23);
		contentPane.add(btnConsultar);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(34, 102, 891, 550);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			do_btnFiltrar_actionPerformed(arg0);
		}
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent arg0) {
		String dniJefferson = txtDNI.getText().trim();
		
		ClienteModel_Jefferson_Roa_Neira model = new ClienteModel_Jefferson_Roa_Neira();
		List<Cliente> lstData = null;
		if(dniJefferson.equals("")){
			lstData = model.listaCliente();
		}else{
			lstData = model.consultaCliente(dniJefferson);	
		}
	
		// 1 La data
		JRBeanCollectionDataSource dataSource 
				= new JRBeanCollectionDataSource(lstData);

		// 2 El diseño del reporte (Diseño)
		String file = "reporteCliente.jasper";
		
		// 3 Se genera el reporte
		JasperPrint jasperPrint =
			GeneradorReporte.genera(file, dataSource, null);

		// 4 Se muestra en el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);
		
		// 5 Se añade el visor al panel
		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		
	}
}







