package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import controle.Factory;
import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.DddInvalidoExcepiton;
import excecoes.NumeroInvalidoExcepiton;
import model.Telefone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDdd;
	private JTextField txtNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCliente frame = new NovoCliente();
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
	public NovoCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoCliente = new JLabel("Novo Cliente");
		lblNovoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNovoCliente.setBounds(63, 46, 162, 36);
		contentPane.add(lblNovoCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 96, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 121, 46, 14);
		contentPane.add(lblTelefone);
		
		txtNome = new JTextField();
		txtNome.setBounds(63, 93, 162, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(63, 121, 37, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(111, 121, 114, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstance().adicionar(Factory.getInstance().novoCliente(txtNome.getText(), Factory.getInstance().novoTelefone(Integer.parseInt(txtDdd.getText()), Integer.parseInt(txtNumero.getText())) ));
					JOptionPane.showMessageDialog(null, "adicionado");
					dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
					e.printStackTrace();
				} catch (ClienteJaAdicionadoExcepition e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
					e.printStackTrace();
				} catch (DddInvalidoExcepiton e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
					e.printStackTrace();
				} catch (NumeroInvalidoExcepiton e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
					e.printStackTrace();
				}
		
				
				
			}
		});
		btnCadastrar.setBounds(111, 157, 114, 23);
		contentPane.add(btnCadastrar);
	}
}
