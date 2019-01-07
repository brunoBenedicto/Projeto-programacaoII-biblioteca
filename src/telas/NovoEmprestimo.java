package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import controle.Factory;
import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.ClienteNaoEncontradoExcepition;
import excecoes.LivriNaoDisponivelExcepition;
import excecoes.LivroNaoEncontradoException;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class NovoEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtLivro1;
	private JTextField txtLivro2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoEmprestimo frame = new NovoEmprestimo();
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
	public NovoEmprestimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdCliente.setBounds(31, 46, 79, 14);
		contentPane.add(lblIdCliente);

		JLabel lblIdLivro = new JLabel("Id Livro 1:");
		lblIdLivro.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdLivro.setBounds(31, 82, 79, 14);
		contentPane.add(lblIdLivro);

		JLabel lblIdLivro_1 = new JLabel("Id Livro 2:");
		lblIdLivro_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdLivro_1.setBounds(31, 107, 79, 14);
		contentPane.add(lblIdLivro_1);

		txtCliente = new JTextField();
		txtCliente.setBounds(120, 43, 86, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		txtLivro1 = new JTextField();
		txtLivro1.setBounds(120, 79, 86, 20);
		contentPane.add(txtLivro1);
		txtLivro1.setColumns(10);

		txtLivro2 = new JTextField();
		txtLivro2.setBounds(120, 104, 86, 20);
		contentPane.add(txtLivro2);
		txtLivro2.setColumns(10);

		JButton btnFazerEmprestimo = new JButton("Concluir");
		btnFazerEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = null;
				try {
					cliente = Fachada.getInstance().pesquisarCliente(Integer.parseInt(txtCliente.getText()));
					Livro livro1 = null;
					try {
						livro1 = Fachada.getInstance().pesquisarLivro(Integer.parseInt(txtLivro1.getText()));
						Livro livro2 = null;
						try {
							livro2 = Fachada.getInstance().pesquisarLivro(Integer.parseInt(txtLivro2.getText()));
							Emprestimo emprestimo = Factory.getInstance().novoEmprestimo(livro1, livro2, null, cliente);
							try {
								try {
									Fachada.getInstance().adicionar(emprestimo);
									JOptionPane.showMessageDialog(null, "adicionado");
									dispose();
								} catch (LivriNaoDisponivelExcepition e) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, e.getMessage());
									e.printStackTrace();
								}
							} catch (ClienteNaoApitoParaEmprestimos e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e.getMessage());
								e.printStackTrace();
							}
						} catch (NumberFormatException | LivroNaoEncontradoException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.getMessage());
							e.printStackTrace();
						}
					} catch (NumberFormatException | LivroNaoEncontradoException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
						e.printStackTrace();
					}
				} catch (NumberFormatException | ClienteNaoEncontradoExcepition e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnFazerEmprestimo.setBounds(117, 138, 89, 23);
		contentPane.add(btnFazerEmprestimo);
	}
}
