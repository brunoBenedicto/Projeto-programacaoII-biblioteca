package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Fachada;
import controle.Factory;
import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import excecoes.DddInvalidoExcepiton;
import excecoes.NumeroInvalidoExcepiton;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import javafx.scene.control.ComboBox;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Pesquisar extends JFrame {

	private JPanel contentPane;
	private JTextField txtAutor;
	private JTextField txtTitulo;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtId;

	private JTable tabelaResultado;
	private JTextField txtNomeResultado;
	private JTextField txtDddResultado;
	private JTextField txtNumeroResultado;
	private JTextField txtIdResultado;
	private JPanel panelResultado;
	private JPanel panelPesquisar = new JPanel();
	private JPanel panelLivros = new JPanel();
	private JPanel panelClientes = new JPanel();
	private JPanel panelEmprestimos = new JPanel();
	private JTextField txtTituliEmprestimo;
	private JTextField txtIdCliEmprestimo;
	private JTextField txtAutorEmprestimos;
	private JTable tabelaEmprestimos;
	JComboBox<String> livros = new JComboBox<String>();

	public void preencherTabelaEmprestimo(ArrayList<Emprestimo> lista) {
		DefaultTableModel modelo = (DefaultTableModel) tabelaEmprestimos.getModel();
		Object[] linha = new Object[6];
		modelo.setRowCount(0);
		livros.removeAllItems();
		for (Emprestimo e : lista) {
			for (int i = 0; i < e.getLivros().length; i++) {
				livros.addItem(e.getLivros()[i].getNome());
			}

			linha[0] = e.getIdEmprestimo();
			linha[1] = e.getCliente().getNome();
			linha[2] = livros;
			linha[3] = e.getDataInicio();
			linha[4] = e.getDevolucao().getDataPrevista();
			linha[5] = e.getDevolucao().getDataDevolucao();
			modelo.addRow(linha);
		}

	}

	// preenche tabela dos livros
	public void preencherTabela(ArrayList<Livro> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		Object[] linha = new Object[4];
		modelo.setRowCount(0);
		for (Livro l : lista) {
			linha[0] = l.getNome();
			linha[1] = l.getAutor();
			linha[2] = l.getDataDeLancamento();
			if (l.isDisponivel())
				linha[3] = "Disponivel";
			else
				linha[3] = "Indisponivel";
			modelo.addRow(linha);

		}

	}

	// preenche tabela da busca pro clientes por procura pelo nome exibe
	// lista se no nome do cliente conter string da busca
	public void preencherTabelaResultado() {
		ArrayList<Cliente> lista = Fachada.getInstance().pesquisarCliente(txtNome.getText());
		DefaultTableModel modelo = (DefaultTableModel) tabelaResultado.getModel();
		Object[] linha = new Object[4];
		modelo.setRowCount(0);

		for (Cliente c : lista) {
			linha[0] = c.getIdCliente();
			linha[1] = c.getNome();
			linha[2] = c.getTelefone().toString();
			if (c.isAptoAEmprestimos())
				linha[3] = "Apto";
			else
				linha[3] = "A devolver";
			modelo.addRow(linha);

		}

	}

	// preenche dados do cliente selecionado
	public void preencherResultado(int id) throws ClienteNaoEncontradoExcepition {
		Cliente c = Fachada.getInstance().pesquisarCliente(id);
		txtIdResultado.setText(String.valueOf(c.getIdCliente()));
		txtNomeResultado.setText(String.valueOf(c.getNome()));
		txtDddResultado.setText(String.valueOf(c.getTelefone().getDdd()));
		txtNumeroResultado.setText(String.valueOf(c.getTelefone().getNumero()));
	}

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
		setTitle("Pesquisar");
// /* CARREGAR REPOSITORIO
		Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("a", "a", 1));
		Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("a", "a", 2));
		Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("b", "b", 3));
		Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("b", "b", 4));
		Fachada.getInstance().adicionar(Factory.getInstance().novoLivro("a", "c", 5));
		try {
			Fachada.getInstance().adicionar(
					Factory.getInstance().novoCliente("a b", Factory.getInstance().novoTelefone(81, 32529340)));
		} catch (ClienteJaAdicionadoExcepition | DddInvalidoExcepiton | NumeroInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Fachada.getInstance().adicionar(
					Factory.getInstance().novoCliente("a b", Factory.getInstance().novoTelefone(81, 32529340)));
		} catch (ClienteJaAdicionadoExcepition | DddInvalidoExcepiton | NumeroInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Fachada.getInstance().adicionar(
					Factory.getInstance().novoCliente("b", Factory.getInstance().novoTelefone(81, 32529340)));
		} catch (ClienteJaAdicionadoExcepition | DddInvalidoExcepiton | NumeroInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Fachada.getInstance().adicionar(
					Factory.getInstance().novoCliente("a", Factory.getInstance().novoTelefone(81, 32529340)));
		} catch (ClienteJaAdicionadoExcepition | DddInvalidoExcepiton | NumeroInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//      FIM CARREGAR REPOSITORIO */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 601);
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

		panelLivros.setVisible(false);

		panelLivros.setBounds(10, 51, 565, 368);
		contentPane.add(panelLivros);
		panelLivros.setLayout(null);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 11, 50, 14);
		panelLivros.add(lblAutor);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 32, 46, 14);
		panelLivros.add(lblTitulo);

		txtAutor = new JTextField();
		txtAutor.setBounds(51, 8, 276, 20);
		panelLivros.add(txtAutor);
		txtAutor.setColumns(10);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(51, 36, 276, 20);
		panelLivros.add(txtTitulo);
		txtTitulo.setColumns(10);

		JButton btnPorAutor = new JButton("Por Autor");
		btnPorAutor.setBounds(337, 7, 89, 23);
		btnPorAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabela(Fachada.getInstance().pesquisarLivroPorAutor(txtAutor.getText()));
			}
		});
		panelLivros.add(btnPorAutor);

		JButton btnPorTitulo = new JButton("Por Titulo");
		btnPorTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherTabela(Fachada.getInstance().pesquisarLivroPorTitulo(txtTitulo.getText()));
			}
		});
		btnPorTitulo.setBounds(337, 35, 89, 23);
		panelLivros.add(btnPorTitulo);

		JLabel lblLbltituloselecionado = new JLabel("lblTituloSelecionado");
		lblLbltituloselecionado.setBounds(10, 237, 441, 23);
		lblLbltituloselecionado.setHorizontalAlignment(SwingConstants.CENTER);
		panelLivros.add(lblLbltituloselecionado);

		JLabel lblautor = new JLabel("lbAutor");
		lblautor.setBounds(10, 271, 441, 14);
		lblautor.setHorizontalAlignment(SwingConstants.CENTER);
		panelLivros.add(lblautor);

		JLabel lblLbllancamento = new JLabel("lblLancamento");
		lblLbllancamento.setBounds(10, 299, 209, 14);
		lblLbllancamento.setHorizontalAlignment(SwingConstants.CENTER);
		panelLivros.add(lblLbllancamento);

		JLabel lblLblstatus = new JLabel("lblStatus");
		lblLblstatus.setBounds(229, 299, 222, 14);
		lblLblstatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelLivros.add(lblLblstatus);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 67, 545, 159);
		panelLivros.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				Object[] linha = new Object[4];
				linha[0] = modelo.getValueAt(table.getSelectedRow(), 0);
				linha[1] = modelo.getValueAt(table.getSelectedRow(), 1);
				linha[2] = modelo.getValueAt(table.getSelectedRow(), 2);
				linha[3] = modelo.getValueAt(table.getSelectedRow(), 3);

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Titulo", "Autor", "Ano de Lan\u00E7.", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNovoLivro = new JButton("Novo Livro");
		btnNovoLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NovoLivro().setVisible(true);
			}
		});
		btnNovoLivro.setBounds(436, 11, 114, 38);
		panelLivros.add(btnNovoLivro);
		panelClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelClientes.setBounds(10, 51, 461, 368);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		panelPesquisar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPesquisar.setBounds(10, 11, 305, 95);
		panelClientes.add(panelPesquisar);
		panelPesquisar.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		panelPesquisar.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 43, 48, 14);
		panelPesquisar.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);

		txtNome = new JTextField();
		txtNome.setBounds(66, 11, 229, 20);
		panelPesquisar.add(txtNome);
		txtNome.setColumns(10);

		txtId = new JTextField();
		txtId.setBounds(67, 43, 111, 20);
		panelPesquisar.add(txtId);
		txtId.setColumns(10);
		panelClientes.setVisible(false);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!txtId.getText().isEmpty()) {
					try {
						preencherResultado(Integer.parseInt(txtId.getText()));
						DefaultTableModel modelo = (DefaultTableModel) tabelaResultado.getModel();
						modelo.setRowCount(0);

					} catch (NumberFormatException | ClienteNaoEncontradoExcepition e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						e.printStackTrace();
					}

				} else if (!txtNome.getText().isEmpty())
					preencherTabelaResultado();

			}
		});
		btnPesquisar.setBounds(185, 42, 110, 23);
		panelPesquisar.add(btnPesquisar);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(331, 11, 120, 331);
		panelClientes.add(panel);
		panel.setLayout(null);

		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NovoCliente().setVisible(true);
			}
		});
		btnNovoCliente.setBounds(10, 11, 100, 23);
		panel.add(btnNovoCliente);

		JPanel panelResutadoDaBusca = new JPanel();
		panelResutadoDaBusca.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelResutadoDaBusca.setBounds(10, 117, 305, 240);
		panelClientes.add(panelResutadoDaBusca);
		panelResutadoDaBusca.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setBounds(10, 11, 285, 100);
		panelResutadoDaBusca.add(scrollPane_1);

		tabelaResultado = new JTable();
		tabelaResultado.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Id", "Nome", "Telefone", "Status" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaResultado.getColumnModel().getColumn(0).setPreferredWidth(28);
		tabelaResultado.getColumnModel().getColumn(1).setPreferredWidth(158);
		scrollPane_1.setViewportView(tabelaResultado);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					preencherResultado((int) tabelaResultado.getValueAt(tabelaResultado.getSelectedRow(), 0));
					txtNomeResultado.setEditable(false);
					txtNumeroResultado.setEditable(false);
					txtDddResultado.setEditable(false);
				} catch (ClienteNaoEncontradoExcepition e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSelecionar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSelecionar.setBounds(206, 110, 89, 23);
		panelResutadoDaBusca.add(btnSelecionar);

		panelResultado = new JPanel();
		panelResultado.setName("");
		panelResultado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelResultado.setBounds(10, 136, 285, 93);
		panelResutadoDaBusca.add(panelResultado);
		panelResultado.setLayout(null);

		JLabel label = new JLabel("Nome:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(0, 11, 59, 14);
		panelResultado.add(label);

		txtNomeResultado = new JTextField();
		txtNomeResultado.setEditable(false);
		txtNomeResultado.setColumns(10);
		txtNomeResultado.setBounds(72, 11, 203, 20);
		panelResultado.add(txtNomeResultado);

		JLabel label_1 = new JLabel("Telefone:");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setBounds(0, 36, 59, 14);
		panelResultado.add(label_1);

		txtDddResultado = new JTextField();
		txtDddResultado.setEditable(false);
		txtDddResultado.setColumns(10);
		txtDddResultado.setBounds(73, 34, 35, 20);
		panelResultado.add(txtDddResultado);

		txtNumeroResultado = new JTextField();
		txtNumeroResultado.setEditable(false);
		txtNumeroResultado.setColumns(10);
		txtNumeroResultado.setBounds(109, 34, 86, 20);
		panelResultado.add(txtNumeroResultado);

		JLabel label_2 = new JLabel("ID:");
		label_2.setBounds(199, 36, 27, 14);
		panelResultado.add(label_2);

		txtIdResultado = new JTextField();
		txtIdResultado.setEditable(false);
		txtIdResultado.setColumns(10);
		txtIdResultado.setBounds(222, 35, 53, 20);
		panelResultado.add(txtIdResultado);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeResultado.setEditable(true);
				txtNumeroResultado.setEditable(true);
				txtDddResultado.setEditable(true);
			}
		});
		btnEditar.setBounds(10, 59, 89, 23);
		panelResultado.add(btnEditar);

		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeResultado.setEditable(false);
				txtNumeroResultado.setEditable(false);
				txtDddResultado.setEditable(false);
				try {
					Fachada.getInstance().pesquisarCliente(Integer.parseInt(txtIdResultado.getText()))
							.setNome(txtNomeResultado.getText());
				} catch (NumberFormatException | ClienteNaoEncontradoExcepition e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				try {
					Fachada.getInstance().pesquisarCliente(Integer.parseInt(txtIdResultado.getText())).getTelefone()
							.setDdd(Integer.parseInt(txtDddResultado.getText()));
				} catch (NumberFormatException | DddInvalidoExcepiton | ClienteNaoEncontradoExcepition e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				try {
					Fachada.getInstance().pesquisarCliente(Integer.parseInt(txtIdResultado.getText())).getTelefone()
							.setNumero(Integer.parseInt(txtNumeroResultado.getText()));
				} catch (NumberFormatException | NumeroInvalidoExcepiton | ClienteNaoEncontradoExcepition e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "alterado");

			}
		});
		btnConfirma.setBounds(186, 59, 89, 23);
		panelResultado.add(btnConfirma);

		panelEmprestimos.setBounds(11, 51, 564, 500);
		contentPane.add(panelEmprestimos);
		panelEmprestimos.setLayout(null);

		JPanel panelEmprestimosPorCli = new JPanel();
		panelEmprestimosPorCli.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEmprestimosPorCli.setBounds(204, 11, 214, 41);
		panelEmprestimos.add(panelEmprestimosPorCli);
		panelEmprestimosPorCli.setLayout(null);

		JLabel lblId_1 = new JLabel("Id do Cliente:");
		lblId_1.setBounds(10, 16, 72, 14);
		panelEmprestimosPorCli.add(lblId_1);

		txtIdCliEmprestimo = new JTextField();
		txtIdCliEmprestimo.setBounds(80, 13, 61, 20);
		panelEmprestimosPorCli.add(txtIdCliEmprestimo);
		txtIdCliEmprestimo.setColumns(10);

		JButton btnPesquisarEmprestimoCli = new JButton("Ir");
		btnPesquisarEmprestimoCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					preencherTabelaEmprestimo(Fachada.getInstance()
							.pesquizarEmprestimoPorCliente(Integer.parseInt(txtIdCliEmprestimo.getText())));
				} catch (NumberFormatException | SemHistoricoDeEmprestimosExcepition e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnPesquisarEmprestimoCli.setBounds(151, 12, 51, 23);
		panelEmprestimosPorCli.add(btnPesquisarEmprestimoCli);

		JPanel panelEmprestimosLivros = new JPanel();
		panelEmprestimosLivros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEmprestimosLivros.setBounds(10, 63, 408, 79);
		panelEmprestimos.add(panelEmprestimosLivros);
		panelEmprestimosLivros.setLayout(null);

		JLabel lblTitulo_1 = new JLabel("Titulo:");
		lblTitulo_1.setBounds(10, 11, 37, 14);
		panelEmprestimosLivros.add(lblTitulo_1);

		JLabel lblAutor_1 = new JLabel("Autor:");
		lblAutor_1.setBounds(10, 36, 46, 14);
		panelEmprestimosLivros.add(lblAutor_1);

		txtTituliEmprestimo = new JTextField();
		txtTituliEmprestimo.setBounds(57, 8, 278, 20);
		panelEmprestimosLivros.add(txtTituliEmprestimo);
		txtTituliEmprestimo.setColumns(10);

		txtAutorEmprestimos = new JTextField();
		txtAutorEmprestimos.setBounds(57, 33, 278, 20);
		panelEmprestimosLivros.add(txtAutorEmprestimos);
		txtAutorEmprestimos.setColumns(10);

		JButton btnPesuisarEmprestimoLivros = new JButton("Ir");
		btnPesuisarEmprestimoLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesuisarEmprestimoLivros.setBounds(345, 11, 53, 43);
		panelEmprestimosLivros.add(btnPesuisarEmprestimoLivros);

		JPanel panelPesquisarCheckbox = new JPanel();
		panelPesquisarCheckbox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPesquisarCheckbox.setBounds(10, 153, 544, 336);
		panelEmprestimos.add(panelPesquisarCheckbox);
		panelPesquisarCheckbox.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 524, 273);
		panelPesquisarCheckbox.add(scrollPane_2);

		tabelaEmprestimos = new JTable();
		tabelaEmprestimos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Id", "Cliente", "Livro", "Inicio", "Data Fim", "Entregue" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, Object.class, Object.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(36);
		tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(111);
		tabelaEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(132);
		tabelaEmprestimos.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(livros));
		tabelaEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tabelaEmprestimos.getColumnModel().getColumn(4).setPreferredWidth(67);
		tabelaEmprestimos.getColumnModel().getColumn(5).setPreferredWidth(84);

		scrollPane_2.setViewportView(tabelaEmprestimos);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(428, 11, 126, 129);
		panelEmprestimos.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNovoEmprestimo = new JButton("Emprestar");
		btnNovoEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NovoEmprestimo().setVisible(true);
			}
		});
		btnNovoEmprestimo.setBounds(10, 22, 106, 31);
		panel_1.add(btnNovoEmprestimo);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FinalizarEmprestimo().setVisible(true);
			}
		});
		btnFinalizar.setBounds(10, 75, 106, 43);
		panel_1.add(btnFinalizar);

		JButton btnAtrasados = new JButton("Atrasados");
		btnAtrasados.setBounds(10, 24, 89, 23);
		panelEmprestimos.add(btnAtrasados);

		JButton btnTodos = new JButton("Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherTabelaEmprestimo(Fachada.getInstance().getEmprestimos());
			}
		});
		btnTodos.setBounds(105, 24, 89, 23);
		panelEmprestimos.add(btnTodos);
		panelEmprestimos.setVisible(false);
	}
}
