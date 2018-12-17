package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import controle.Factory;
import model.Livro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pesquisar extends JFrame {

	private JPanel contentPane;
	private JTextField txtAutor;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisar frame = new Pesquisar();
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
	public Pesquisar() {
		
		JPanel panelLivros = new JPanel();
		JPanel panelClientes = new JPanel();
		JPanel panelEmprestimos = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLivros = new JButton("Livros");
		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLivros.setVisible(true);
				panelClientes.setVisible(false);
				panelEmprestimos.setVisible(false);
			}
		});
		btnLivros.setBounds(10, 11, 89, 23);
		contentPane.add(btnLivros);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLivros.setVisible(false);
				panelClientes.setVisible(true);
				panelEmprestimos.setVisible(false);
			}
		});
		btnClientes.setBounds(109, 11, 89, 23);
		contentPane.add(btnClientes);
		
		JButton btnEmprestimos = new JButton("Emprestimos");
		btnEmprestimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLivros.setVisible(false);
				panelClientes.setVisible(false);
				panelEmprestimos.setVisible(true);
			}
		});
		btnEmprestimos.setBounds(208, 11, 118, 23);
		contentPane.add(btnEmprestimos);
		
		
		panelLivros.setBounds(10, 51, 315, 199);
		contentPane.add(panelLivros);
		panelLivros.setLayout(null);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 11, 50, 14);
		panelLivros.add(lblAutor);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 32, 46, 14);
		panelLivros.add(lblTitulo);
		
		JScrollPane scrollListarLivros = new JScrollPane();
		scrollListarLivros.setBounds(10, 65, 180, 123);
		panelLivros.add(scrollListarLivros);
		
		JList list = new JList();
		list.setBounds(0, 0, 1, 1);
		scrollListarLivros.add(list);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(51, 8, 139, 20);
		panelLivros.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(51, 36, 139, 20);
		panelLivros.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnPorAutor = new JButton("Por Autor");
		btnPorAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("a", "aa", 1234));
				Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("a2", "aa", 1234));
				Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("b", "b", 1234));
				for(Livro l : Fachada.getInstance().pesquisarLivroPorAutor(txtAutor.getText())) {
					list.addComponentListener((ComponentListener) l);
				}
			}
		});
		btnPorAutor.setBounds(200, 7, 89, 23);
		panelLivros.add(btnPorAutor);
		
		JButton btnPorTitulo = new JButton("Por Titulo");
		btnPorTitulo.setBounds(200, 35, 89, 23);
		panelLivros.add(btnPorTitulo);
		
		JLabel lblLbltituloselecionado = new JLabel("lblTituloSelecionado");
		lblLbltituloselecionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbltituloselecionado.setBounds(200, 69, 105, 23);
		panelLivros.add(lblLbltituloselecionado);
		
		JLabel lblautor = new JLabel("lbAutor");
		lblautor.setHorizontalAlignment(SwingConstants.CENTER);
		lblautor.setBounds(200, 102, 105, 14);
		panelLivros.add(lblautor);
		
		JLabel lblLbllancamento = new JLabel("lblLancamento");
		lblLbllancamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbllancamento.setBounds(200, 129, 105, 14);
		panelLivros.add(lblLbllancamento);
		
		JLabel lblLblstatus = new JLabel("lblStatus");
		lblLblstatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblstatus.setBounds(200, 155, 105, 14);
		panelLivros.add(lblLblstatus);
		
		panelClientes.setBounds(10, 51, 316, 199);
		contentPane.add(panelClientes);
		
		panelEmprestimos.setBounds(11, 51, 315, 199);
		contentPane.add(panelEmprestimos);
	}
}
