package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import excecoes.EmprestimoNaoEncontradoExcepition;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalizarEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdEmprestimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarEmprestimo frame = new FinalizarEmprestimo();
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
	public FinalizarEmprestimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEmprestmo = new JLabel("Id Emprestmo:");
		lblIdEmprestmo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdEmprestmo.setBounds(53, 56, 84, 14);
		contentPane.add(lblIdEmprestmo);
		
		txtIdEmprestimo = new JTextField();
		txtIdEmprestimo.setBounds(147, 53, 86, 20);
		contentPane.add(txtIdEmprestimo);
		txtIdEmprestimo.setColumns(10);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstance().finalizar(Fachada.getInstance().pesquisarEmprestimo(Integer.parseInt(txtIdEmprestimo.getText())));
					
					JOptionPane.showMessageDialog(null, "entregue");
					dispose();
				} catch (NumberFormatException | EmprestimoNaoEncontradoExcepition e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnFinalizar.setBounds(243, 52, 89, 23);
		contentPane.add(btnFinalizar);
	}
}
