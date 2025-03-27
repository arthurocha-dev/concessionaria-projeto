package pacote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class VeiculosUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdVeiculo;
	private JLabel lblMarca;
	private JTextField textMarca;
	private JButton btnAdiconar;
	private JList list;
	private DefaultListModel<String> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeiculosUI frame = new VeiculosUI();
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
	public VeiculosUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdicionarVeiculo = new JLabel("Adicionar veículo:");
		lblAdicionarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdicionarVeiculo.setBounds(10, 35, 144, 14);
		contentPane.add(lblAdicionarVeiculo);
		
		JLabel lblIdVeiculo = new JLabel("ID do veículo:");
		lblIdVeiculo.setBounds(10, 60, 86, 14);
		contentPane.add(lblIdVeiculo);
		
		textIdVeiculo = new JTextField();
		textIdVeiculo.addKeyListener(new KeyAdapter() {
			@Override
			//fazer com o que o campo só permita números
			public void keyTyped(KeyEvent e) {
				char id = e.getKeyChar();
				if(!Character.isDigit(id)) {
					e.consume();
				}
			}                                                
		});
		textIdVeiculo.setBounds(93, 60, 86, 20);
		contentPane.add(textIdVeiculo);
		textIdVeiculo.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 85, 46, 14);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(93, 85, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		btnAdiconar = new JButton("Adicionar");
		btnAdiconar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textIdVeiculo.getText();
				String marca = textMarca.getText();
				if(!marca.isEmpty()) {
					listModel.addElement(marca);
					textMarca.setText("");
				}
			}
		});
		btnAdiconar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdiconar.setBounds(165, 227, 89, 23);
		contentPane.add(btnAdiconar);
		
		
		 
		listModel = new DefaultListModel<>();
		
		list = new JList(listModel);
		list.setBounds(305, 59, 83, 27);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane(listModel);
		scrollPane.setBounds(322, 60, 2, 2);
		contentPane.add(scrollPane);
	}
}
