package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import controle.Factory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoLivro frame = new NovoLivro();
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
	public NovoLivro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoLivro = new JLabel("Novo Livro");
		lblNovoLivro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNovoLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoLivro.setBounds(46, 53, 118, 22);
		contentPane.add(lblNovoLivro);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitulo.setBounds(10, 103, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAutor.setBounds(10, 129, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblAnoDeLancamento = new JLabel("Ano de Lancamento:");
		lblAnoDeLancamento.setBounds(20, 154, 118, 14);
		contentPane.add(lblAnoDeLancamento);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(66, 100, 169, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(66, 126, 169, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(148, 151, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada.getInstance().adicionar(Factory.getInstance().novoLivro(txtTitulo.getText(), txtAutor.getText(), Integer.parseInt(txtData.getText())));
				JOptionPane.showMessageDialog(null,"Adicionado!");
				dispose();
			}
		});
		btnCadastrar.setBounds(146, 184, 89, 23);
		contentPane.add(btnCadastrar);
	}
}
