package pacote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVeiculod = new JMenu("Veículos");
		mnVeiculod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VeiculosUI veiculos = new VeiculosUI();
				veiculos.setVisible(true);
				dispose();
				
			}
		});
		
		menuBar.add(mnVeiculod);
		
		JMenu mnAgendamento = new JMenu("Agendamento");
		menuBar.add(mnAgendamento);
		
		JMenu mnFuncionario = new JMenu("Funcionários");
		mnFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FuncionarioUI funcionario = new FuncionarioUI();
				funcionario.setVisible(true);
				dispose();
				
			}
		});
		menuBar.add(mnFuncionario);
	}
}