package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HomePage {

	private JFrame frmViaoPaulista;
	private JTextField tf_User;
	private JTextField tf_Destino;
	private JTextField tf_Data;
	private JPasswordField pf_Password;
	private JTextField tf_CadUser;
	private JPasswordField pf_CadPass;
	private JTextField tf_CadNome;
	private JTextField tf_CadEmail;
	private JTextField tf_CadEndereco;
	private JTextField tf_CEP;
	private JTextField tf_NumCartao;
	private JTextField tf_ValRecarga;
	private JTextField tf_ConsultaCartao;
	private JButton btn_Consultar;
	private JTextField tf_CompraNumCartao;
	public String etapa;
	public CardLayout cardLayout;
	public JPanel pnl_Page;
	public Connect connection;
	public JLabel lbl_txtNome;
	public JLabel lbl_txtEmail;
	public JLabel lbl_txtValCartao;
	public JLabel lbl_txtValCredito;
	public JLabel lbl_TxtValCred;
	public JLabel lbl_ErroConsulta;
	public Download download;
	public JLabel lbl_Error;
	public boolean logado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmViaoPaulista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		download = new Download();
		connection = new Connect();
		frmViaoPaulista = new JFrame();
		frmViaoPaulista.setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/resources/logo.png")));
		frmViaoPaulista.setTitle("Via\u00E7\u00E3o Paulista \r\n");
		frmViaoPaulista.setBounds(100, 100, 1600, 900);
		frmViaoPaulista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViaoPaulista.getContentPane().setLayout(null);
		logado = false;
		
		JPanel pnl_Main = new JPanel();
		pnl_Main.setBounds(10, 0, 1584, 861);
		frmViaoPaulista.getContentPane().add(pnl_Main);
		pnl_Main.setLayout(null);
		
		JPanel pnl_Menu = new JPanel();
		pnl_Menu.setBackground(Color.WHITE);
		pnl_Menu.setBounds(-11, 0, 1585, 105);
		pnl_Main.add(pnl_Menu);
		pnl_Menu.setLayout(null);
		
		JLabel lbl_Cadastro = new JLabel("Cadastro");
		lbl_Cadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				etapa = "cadastro";
				if(logado) {
					cardLayout.show(pnl_Page, etapa);
					
				} else {
					cardLayout.show(pnl_Page, "login");
				}
				
				lbl_txtNome.setText("");
				lbl_txtEmail.setText("");
				lbl_txtValCartao.setText("");
				lbl_txtValCredito.setText("");
				tf_ConsultaCartao.setText("");

				tf_User.setText("");
				pf_Password.setText("");

				tf_CadUser.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");

				tf_NumCartao.setText("");
				tf_ValRecarga.setText("");

				tf_CompraNumCartao.setText("");
				lbl_TxtValCred.setText("");
			}
		});
		lbl_Cadastro.setBackground(Color.WHITE);
		lbl_Cadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Cadastro.setBounds(652, 3, 126, 102);
		pnl_Menu.add(lbl_Cadastro);
		
		JLabel lbl_Recarga = new JLabel("Recarga");
		lbl_Recarga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(pnl_Page, "recarga");
				lbl_txtNome.setText("");
				lbl_txtEmail.setText("");
				lbl_txtValCartao.setText("");
				lbl_txtValCredito.setText("");
				tf_ConsultaCartao.setText("");

				tf_User.setText("");
				pf_Password.setText("");

				tf_CadUser.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");

				tf_NumCartao.setText("");
				tf_ValRecarga.setText("");

				tf_CompraNumCartao.setText("");
				lbl_TxtValCred.setText("");
			}
		});
		lbl_Recarga.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Recarga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Recarga.setBounds(516, 3, 126, 102);
		pnl_Menu.add(lbl_Recarga);
		
		JLabel lbl_Servicos = new JLabel("Servicos");
		lbl_Servicos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Servicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Servicos.setBounds(385, 3, 126, 102);
		pnl_Menu.add(lbl_Servicos);
		
		JLabel lbl_Sobre = new JLabel("Sobre");
		lbl_Sobre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sobre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Sobre.setBounds(262, 3, 126, 102);
		pnl_Menu.add(lbl_Sobre);
		
		JLabel lbl_Home = new JLabel("Home");
		lbl_Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(pnl_Page, "home");
				etapa = "";
				lbl_txtNome.setText("");
				lbl_txtEmail.setText("");
				lbl_txtValCartao.setText("");
				lbl_txtValCredito.setText("");
				tf_ConsultaCartao.setText("");

				tf_User.setText("");
				pf_Password.setText("");

				tf_CadUser.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");

				tf_NumCartao.setText("");
				tf_ValRecarga.setText("");

				tf_CompraNumCartao.setText("");
				lbl_TxtValCred.setText("");
			}
		});
		lbl_Home.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Home.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Home.setBounds(142, 3, 126, 102);
		pnl_Menu.add(lbl_Home);
		
		JLabel lbl_Icon = new JLabel("");
		lbl_Icon.setBounds(10, 0, 105, 105);
		pnl_Menu.add(lbl_Icon);
		lbl_Icon.setIcon(new ImageIcon(HomePage.class.getResource("/resources/logo - Copia.png")));
		
		JLabel lbl_Pedido = new JLabel("Pedido");
		lbl_Pedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				etapa = "compra";
				if(logado) {
					cardLayout.show(pnl_Page, etapa);
					
				} else {
					cardLayout.show(pnl_Page, "login");
				}
				
				lbl_txtNome.setText("");
				lbl_txtEmail.setText("");
				lbl_txtValCartao.setText("");
				lbl_txtValCredito.setText("");
				tf_ConsultaCartao.setText("");

				tf_User.setText("");
				pf_Password.setText("");

				tf_CadUser.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");

				tf_NumCartao.setText("");
				tf_ValRecarga.setText("");

				tf_CompraNumCartao.setText("");
				lbl_TxtValCred.setText("");
			}
		});
		lbl_Pedido.setForeground(new Color(0, 0, 0));
		lbl_Pedido.setBackground(new Color(245, 222, 179));
		lbl_Pedido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Pedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Pedido.setBounds(764, 3, 126, 102);
		pnl_Menu.add(lbl_Pedido);
		
		JLabel lbl_Consulta = new JLabel("Consulta");
		lbl_Consulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				etapa = "consulta";
				if(logado) {
					cardLayout.show(pnl_Page, etapa);
					
				} else {
					cardLayout.show(pnl_Page, "login");
				}
				
				lbl_txtNome.setText("");
				lbl_txtEmail.setText("");
				lbl_txtValCartao.setText("");
				lbl_txtValCredito.setText("");
				tf_ConsultaCartao.setText("");

				tf_User.setText("");
				pf_Password.setText("");

				tf_CadUser.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");

				tf_NumCartao.setText("");
				tf_ValRecarga.setText("");

				tf_CompraNumCartao.setText("");
				lbl_TxtValCred.setText("");
			}
		});
		lbl_Consulta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Consulta.setForeground(Color.BLACK);
		lbl_Consulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Consulta.setBackground(new Color(245, 222, 179));
		lbl_Consulta.setBounds(891, 3, 126, 102);
		pnl_Menu.add(lbl_Consulta);
		
		pnl_Page = new JPanel();
		cardLayout = new CardLayout(0, 0);
		pnl_Page.setBackground(new Color(100, 149, 237));
		pnl_Page.setBounds(0, 104, 1574, 757);
		pnl_Main.add(pnl_Page);
		pnl_Page.setLayout(cardLayout);
		
		JPanel pnl_Login = new JPanel();
		pnl_Login.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_Login, "login");
		pnl_Login.setLayout(null);
		
		JPanel pnl_BoxLogin = new JPanel();
		pnl_BoxLogin.setLayout(null);
		pnl_BoxLogin.setBackground(Color.WHITE);
		pnl_BoxLogin.setBounds(420, 150, 712, 407);
		pnl_Login.add(pnl_BoxLogin);
		
		JLabel lbl_SenhaNova = new JLabel("Esqueceu sua senha...");
		lbl_SenhaNova.setForeground(new Color(100, 149, 237));
		lbl_SenhaNova.setBounds(167, 236, 137, 14);
		pnl_BoxLogin.add(lbl_SenhaNova);
		
		JButton btn_Entrar = new JButton("Entrar");
		btn_Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_Entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String usuario = "";
					String senha= "";
					String query = "Select cpf,senha from usuarios where cpf ='"+ tf_User.getText() + "'";
					System.out.println(query);
					ResultSet rs = Connect.executeQuery(query);
					while (rs.next()) {
						usuario = rs.getString(1);
						senha = rs.getString(2);
						
					}
					System.out.println(usuario + "/" + senha);
					System.out.println("Input");
					System.out.println(tf_User.getText()+ "/" + pf_Password.getText());
					if(usuario.equals(tf_User.getText()) && senha.equals(pf_Password.getText())) {
						
						System.out.println(usuario + "/" + senha);
						cardLayout.show(pnl_Page, etapa);
						logado = true;
					} else {
						lbl_Error.setText("Usuário e/ou Senha Inválido");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_Entrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Entrar.setBounds(167, 261, 344, 34);
		pnl_BoxLogin.add(btn_Entrar);
		
		tf_User = new JTextField();
		tf_User.setToolTipText("CPF\r\n");
		tf_User.setColumns(10);
		tf_User.setBounds(220, 152, 291, 20);
		pnl_BoxLogin.add(tf_User);
		
		JLabel lbl_Senha = new JLabel("Senha");
		lbl_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Senha.setBounds(167, 184, 78, 25);
		pnl_BoxLogin.add(lbl_Senha);
		
		JLabel lbl_User = new JLabel("CPF");
		lbl_User.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_User.setBounds(167, 148, 78, 25);
		pnl_BoxLogin.add(lbl_User);
		
		JLabel lbl_Title = new JLabel("Bem Vindo, \u00E9 necess\u00E1rio autenticar-se para acessar esta sess\u00E3o");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Title.setBounds(0, 0, 712, 98);
		pnl_BoxLogin.add(lbl_Title);
		
		pf_Password = new JPasswordField();
		pf_Password.setBounds(220, 188, 291, 20);
		pnl_BoxLogin.add(pf_Password);
		
		lbl_Error = new JLabel("");
		lbl_Error.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Error.setForeground(new Color(255, 0, 0));
		lbl_Error.setBounds(167, 109, 344, 32);
		pnl_BoxLogin.add(lbl_Error);
		
		JPanel pnl_Home = new JPanel();
		pnl_Home.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_Home, "home");
		pnl_Home.setLayout(null);
		
		JPanel pnl_BoxHome = new JPanel();
		pnl_BoxHome.setBounds(56, 253, 550, 295);
		pnl_BoxHome.setBackground(Color.WHITE);
		pnl_Home.add(pnl_BoxHome);
		pnl_BoxHome.setLayout(null);
		
		tf_Destino = new JTextField();
		tf_Destino.setText("Digite aqui o seu destino");
		tf_Destino.setToolTipText("Digite aqui o seu destino");
		tf_Destino.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_Destino.setBounds(10, 49, 530, 40);
		pnl_BoxHome.add(tf_Destino);
		tf_Destino.setColumns(10);
		
		tf_Data = new JTextField();
		tf_Data.setToolTipText("Digite aqui a data de embarque\r\n");
		tf_Data.setText("Digite aqui a data de embarque\r\n");
		tf_Data.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf_Data.setColumns(10);
		tf_Data.setBounds(10, 122, 530, 40);
		pnl_BoxHome.add(tf_Data);
		
		JButton btn_Consulta = new JButton("Consultar");
		btn_Consulta.setBackground(new Color(0, 0, 0));
		btn_Consulta.setForeground(new Color(0, 0, 0));
		btn_Consulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Consulta.setBounds(10, 217, 530, 40);
		pnl_BoxHome.add(btn_Consulta);
		
		JLabel lbl_HomeTitle = new JLabel("Consulte nossas Tarifas\r\n");
		lbl_HomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HomeTitle.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 32));
		lbl_HomeTitle.setForeground(Color.WHITE);
		lbl_HomeTitle.setBounds(56, 108, 550, 80);
		pnl_Home.add(lbl_HomeTitle);
		
		JLabel lbl_HomeTitle_2 = new JLabel("e Hor\u00E1rios");
		lbl_HomeTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HomeTitle_2.setForeground(Color.WHITE);
		lbl_HomeTitle_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 32));
		lbl_HomeTitle_2.setBounds(56, 148, 550, 104);
		pnl_Home.add(lbl_HomeTitle_2);
		
		JLabel lbl_imgHome = new JLabel("");
		lbl_imgHome.setIcon(new ImageIcon(HomePage.class.getResource("/resources/homepage.png")));
		lbl_imgHome.setBounds(811, 93, 699, 488);
		pnl_Home.add(lbl_imgHome);
		
		JPanel pnl_Border = new JPanel();
		pnl_Border.setBackground(Color.DARK_GRAY);
		pnl_Border.setBounds(800, 85, 720, 503);
		pnl_Home.add(pnl_Border);
		
		JPanel pnl_CadastroUser = new JPanel();
		pnl_CadastroUser.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_CadastroUser, "cadastro");
		pnl_CadastroUser.setLayout(null);
		
		JPanel pnl_BoxCadastroUser = new JPanel();
		pnl_BoxCadastroUser.setLayout(null);
		pnl_BoxCadastroUser.setBackground(Color.WHITE);
		pnl_BoxCadastroUser.setBounds(420, 150, 711, 431);
		pnl_CadastroUser.add(pnl_BoxCadastroUser);
		
		JButton btn_CadUser = new JButton("Confirmar");
		btn_CadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_CadUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ncartao = 0;
				String query = "Insert into cartoes(valor,credito,status,nome) values ('00,00','00,00','novo','" + tf_CadUser.getText() + "')";
				Connect.executeQuery2(query);
				System.out.println(query);
				query = "Select ncartao from cartoes where nome = '" + tf_CadUser.getText() + "'";
				ResultSet rs = Connect.executeQuery(query);
				try {
					while(rs.next()) {
						ncartao = rs.getInt(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				query = "Insert into usuarios(cpf,ncartao,nome,email,senha,endereco,cep,cargo) values ('" + tf_CadUser.getText() + "'," + Integer.toString(ncartao) + ",'" + tf_CadNome.getText() + "','" + tf_CadEmail.getText() + "','" + pf_CadPass.getText() + "','" + tf_CadEndereco.getText() + "','" + tf_CEP.getText() +"','usuario')";
				System.out.println(query);
				Connect.executeQuery2(query);
				
				JOptionPane.showMessageDialog(null, "Número do cartão:" + Integer.toString(ncartao));
				tf_CadUser.setText("");
				pf_CadPass.setText("");
				tf_CadNome.setText("");
				tf_CadEmail.setText("");
				tf_CadEndereco.setText("");
				tf_CEP.setText("");
			}
		});
		btn_CadUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_CadUser.setBounds(149, 345, 362, 34);
		pnl_BoxCadastroUser.add(btn_CadUser);
		
		tf_CadUser = new JTextField();
		tf_CadUser.setToolTipText("CPF\r\n");
		tf_CadUser.setColumns(10);
		tf_CadUser.setBounds(220, 115, 291, 20);
		pnl_BoxCadastroUser.add(tf_CadUser);
		
		JLabel lbl_CadSenha = new JLabel("Senha");
		lbl_CadSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CadSenha.setBounds(149, 284, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CadSenha);
		
		JLabel lbl_CadUser = new JLabel("CPF");
		lbl_CadUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CadUser.setBounds(149, 111, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CadUser);
		
		JLabel lbl_Title_1 = new JLabel("Insira aqui suas informa\u00E7\u00F5es para realizar a solicita\u00E7\u00E3o de cadastro e emiss\u00E3o de cart\u00E3o");
		lbl_Title_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Title_1.setBounds(0, 0, 712, 98);
		pnl_BoxCadastroUser.add(lbl_Title_1);
		
		pf_CadPass = new JPasswordField();
		pf_CadPass.setBounds(220, 289, 291, 20);
		pnl_BoxCadastroUser.add(pf_CadPass);
		
		JLabel lbl_CadError = new JLabel("");
		lbl_CadError.setForeground(Color.RED);
		lbl_CadError.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_CadError.setBounds(167, 72, 344, 32);
		pnl_BoxCadastroUser.add(lbl_CadError);
		
		JLabel lbl_CadNome = new JLabel("Nome");
		lbl_CadNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CadNome.setBounds(149, 146, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CadNome);
		
		tf_CadNome = new JTextField();
		tf_CadNome.setToolTipText("CPF\r\n");
		tf_CadNome.setColumns(10);
		tf_CadNome.setBounds(220, 150, 291, 20);
		pnl_BoxCadastroUser.add(tf_CadNome);
		
		JLabel lbl_CadEmail = new JLabel("E-mail");
		lbl_CadEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CadEmail.setBounds(149, 182, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CadEmail);
		
		tf_CadEmail = new JTextField();
		tf_CadEmail.setToolTipText("CPF\r\n");
		tf_CadEmail.setColumns(10);
		tf_CadEmail.setBounds(220, 184, 291, 20);
		pnl_BoxCadastroUser.add(tf_CadEmail);
		
		JLabel lbl_CadEndereço = new JLabel("Endere\u00E7o");
		lbl_CadEndereço.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CadEndereço.setBounds(149, 214, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CadEndereço);
		
		tf_CadEndereco = new JTextField();
		tf_CadEndereco.setToolTipText("CPF\r\n");
		tf_CadEndereco.setColumns(10);
		tf_CadEndereco.setBounds(220, 218, 291, 20);
		pnl_BoxCadastroUser.add(tf_CadEndereco);
		
		JLabel lbl_CEP = new JLabel("CEP");
		lbl_CEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CEP.setBounds(149, 253, 78, 25);
		pnl_BoxCadastroUser.add(lbl_CEP);
		
		tf_CEP = new JTextField();
		tf_CEP.setToolTipText("CPF\r\n");
		tf_CEP.setColumns(10);
		tf_CEP.setBounds(220, 253, 291, 20);
		pnl_BoxCadastroUser.add(tf_CEP);
		
		JPanel pnl_Recarga = new JPanel();
		pnl_Recarga.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_Recarga, "recarga");
		pnl_Recarga.setLayout(null);
		
		JPanel pnl_RecargaBox = new JPanel();
		pnl_RecargaBox.setBackground(Color.WHITE);
		pnl_RecargaBox.setBounds(426, 148, 711, 431);
		pnl_Recarga.add(pnl_RecargaBox);
		pnl_RecargaBox.setLayout(null);
		
		JLabel lbl_NumCartao = new JLabel("N\u00BA do Cart\u00E3o");
		lbl_NumCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NumCartao.setBounds(158, 150, 113, 25);
		pnl_RecargaBox.add(lbl_NumCartao);
		
		tf_NumCartao = new JTextField();
		tf_NumCartao.setText("");
		tf_NumCartao.setBounds(272, 150, 291, 25);
		pnl_RecargaBox.add(tf_NumCartao);
		tf_NumCartao.setColumns(10);
		
		JLabel lbl_NumCartao_1 = new JLabel("Valor da Recarga");
		lbl_NumCartao_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NumCartao_1.setBounds(158, 207, 113, 25);
		pnl_RecargaBox.add(lbl_NumCartao_1);
		
		tf_ValRecarga = new JTextField();
		tf_ValRecarga.setText("");
		tf_ValRecarga.setColumns(10);
		tf_ValRecarga.setBounds(272, 207, 291, 25);
		pnl_RecargaBox.add(tf_ValRecarga);
		
		JLabel lbl_Title_2 = new JLabel("Insira o n\u00FAmero de seu cart\u00E3o e o valor da recarga");
		lbl_Title_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Title_2.setBounds(0, 0, 712, 98);
		pnl_RecargaBox.add(lbl_Title_2);
		
		JButton btn_Confirmar = new JButton("Confirmar");
		btn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE cartoes set credito = '" + tf_ValRecarga.getText() + "' where ncartao = " + tf_NumCartao.getText();
					Connect.executeQuery2(query);
					tf_ValRecarga.setText("");
					tf_NumCartao.setText("");
				
				
				}
		});
		btn_Confirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Confirmar.setBounds(158, 283, 411, 34);
		pnl_RecargaBox.add(btn_Confirmar);
		
		JLabel lbl_Error_1 = new JLabel("");
		lbl_Error_1.setForeground(Color.RED);
		lbl_Error_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Error_1.setBounds(158, 84, 405, 32);
		pnl_RecargaBox.add(lbl_Error_1);
		
		JPanel pnl_Consulta = new JPanel();
		pnl_Consulta.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_Consulta, "consulta");
		pnl_Consulta.setLayout(null);
		
		JPanel pnl_ConsultaBox = new JPanel();
		pnl_ConsultaBox.setBackground(new Color(255, 255, 255));
		pnl_ConsultaBox.setBounds(420, 150, 711, 431);
		pnl_Consulta.add(pnl_ConsultaBox);
		pnl_ConsultaBox.setLayout(null);
		
		JLabel lbl_Title_1_1 = new JLabel("Insira aqui o n\u00FAmero do cart\u00E3o que deseja consultar");
		lbl_Title_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Title_1_1.setBounds(0, 0, 712, 98);
		pnl_ConsultaBox.add(lbl_Title_1_1);
		
		JLabel lbl_NumCartao_2 = new JLabel("N\u00BA do Cart\u00E3o");
		lbl_NumCartao_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NumCartao_2.setBounds(151, 109, 114, 25);
		pnl_ConsultaBox.add(lbl_NumCartao_2);
		
		tf_ConsultaCartao = new JTextField();
		tf_ConsultaCartao.setText("");
		tf_ConsultaCartao.setColumns(10);
		tf_ConsultaCartao.setBounds(265, 109, 301, 25);
		pnl_ConsultaBox.add(tf_ConsultaCartao);
		
		btn_Consultar = new JButton("Consultar");
		btn_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Consultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					lbl_txtNome.setText("");
					lbl_txtEmail.setText("");
					lbl_txtValCartao.setText("");
					lbl_txtValCredito.setText("");
					String query = "SELECT usuarios.nome,usuarios.email,cartoes.valor,cartoes.credito\r\n"
							+ "FROM usuarios\r\n"
							+ "INNER JOIN cartoes\r\n"
							+ "ON usuarios.ncartao = cartoes.ncartao where cartoes.ncartao = '" + tf_ConsultaCartao.getText() + "'";
					ResultSet rs = Connect.executeQuery(query);
					while (rs.next()) {
						lbl_txtNome.setText(rs.getString(1));
						lbl_txtEmail.setText(rs.getString(2));
						lbl_txtValCartao.setText(rs.getString(3));
						lbl_txtValCredito.setText(rs.getString(4));
					}
					if(lbl_txtNome.getText() == "") {
						lbl_ErroConsulta.setText("Cartão não encontrado");
					}
					rs.close();
				} catch(SQLException except) {
					lbl_ErroConsulta.setText("Cartão não encontrado");
				}
				
			}
		});
		btn_Consultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Consultar.setBounds(151, 158, 415, 34);
		pnl_ConsultaBox.add(btn_Consultar);
		
		JLabel lbl_Nome = new JLabel("Nome do Usu\u00E1rio:");
		lbl_Nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Nome.setBounds(151, 213, 114, 25);
		pnl_ConsultaBox.add(lbl_Nome);
		
		lbl_txtNome = new JLabel("");
		lbl_txtNome.setBounds(265, 213, 301, 25);
		pnl_ConsultaBox.add(lbl_txtNome);
		
		JLabel lbl_Email = new JLabel("E-mail");
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Email.setBounds(151, 249, 114, 25);
		pnl_ConsultaBox.add(lbl_Email);
		
		lbl_txtEmail = new JLabel("");
		lbl_txtEmail.setBounds(265, 249, 301, 25);
		pnl_ConsultaBox.add(lbl_txtEmail);
		
		JLabel lbl_ValCartao = new JLabel("Valor no Cart\u00E3o");
		lbl_ValCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ValCartao.setBounds(151, 285, 114, 25);
		pnl_ConsultaBox.add(lbl_ValCartao);
		
		lbl_txtValCartao = new JLabel("");
		lbl_txtValCartao.setBounds(265, 285, 301, 25);
		pnl_ConsultaBox.add(lbl_txtValCartao);
		
		JLabel lbl_ValCredito = new JLabel("Cr\u00E9dito Pendente ");
		lbl_ValCredito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ValCredito.setBounds(151, 321, 114, 25);
		pnl_ConsultaBox.add(lbl_ValCredito);
		
		lbl_txtValCredito = new JLabel("");
		lbl_txtValCredito.setBounds(265, 321, 301, 25);
		pnl_ConsultaBox.add(lbl_txtValCredito);
		
		lbl_ErroConsulta = new JLabel("");
		lbl_ErroConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ErroConsulta.setForeground(Color.RED);
		lbl_ErroConsulta.setBounds(151, 64, 415, 34);
		pnl_ConsultaBox.add(lbl_ErroConsulta);
		
		JPanel pnl_Compra = new JPanel();
		pnl_Compra.setBackground(new Color(100, 149, 237));
		pnl_Page.add(pnl_Compra, "compra");
		pnl_Compra.setLayout(null);
		
		JPanel pnl_CompraBox = new JPanel();
		pnl_CompraBox.setBackground(new Color(255, 255, 255));
		pnl_CompraBox.setBounds(420, 150, 711, 431);
		pnl_Compra.add(pnl_CompraBox);
		pnl_CompraBox.setLayout(null);
		
		JLabel lbl_Title_2_1 = new JLabel("Insira o n\u00FAmero do cart\u00E3o\r\n");
		lbl_Title_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_Title_2_1.setBounds(0, 0, 712, 98);
		pnl_CompraBox.add(lbl_Title_2_1);
		
		JLabel lbl_NumCartao_3 = new JLabel("N\u00BA do Cart\u00E3o");
		lbl_NumCartao_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_NumCartao_3.setBounds(166, 99, 113, 25);
		pnl_CompraBox.add(lbl_NumCartao_3);
		
		tf_CompraNumCartao = new JTextField();
		tf_CompraNumCartao.setText("");
		tf_CompraNumCartao.setColumns(10);
		tf_CompraNumCartao.setBounds(280, 99, 291, 25);
		pnl_CompraBox.add(tf_CompraNumCartao);
		
		JButton btn_Prosseguir = new JButton("Prosseguir >>");
		btn_Prosseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "Select credito from cartoes where ncartao = " + tf_CompraNumCartao.getText();
				
				ResultSet rs = Connect.executeQuery(query);
				try {
					while(rs.next()) {
						lbl_TxtValCred.setText(rs.getString(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Prosseguir.setBounds(166, 147, 113, 23);
		pnl_CompraBox.add(btn_Prosseguir);
		
		JLabel lbl_ValCred = new JLabel("Valor do Cr\u00E9dito a ser pago");
		lbl_ValCred.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ValCred.setBounds(166, 197, 172, 25);
		pnl_CompraBox.add(lbl_ValCred);
		
		JButton btn_GerarBol = new JButton("Gerar Boleto");
		btn_GerarBol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_GerarBol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String query = "SELECT usuarios.nome,usuarios.cpf,cartoes.credito FROM usuarios INNER JOIN cartoes ON usuarios.ncartao = cartoes.ncartao where cartoes.ncartao =" + tf_CompraNumCartao.getText();
				System.out.println(query);
				ResultSet rs = Connect.executeQuery(query);
				try {
					while (rs.next()) {
						String nome = rs.getString(1);
						String cpf = rs.getString(2);
						String valor = rs.getString(3);
						PDF pdf = new PDF();
						pdf.WriteInvoice(nome, cpf, valor);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_GerarBol.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_GerarBol.setBounds(166, 258, 405, 44);
		pnl_CompraBox.add(btn_GerarBol);
		
		lbl_TxtValCred = new JLabel("");
		lbl_TxtValCred.setBounds(336, 197, 233, 25);
		pnl_CompraBox.add(lbl_TxtValCred);
		
		JButton btn_GerarRelatorio = new JButton("Gerar Relat\u00F3rio das compras de hoje");
		btn_GerarRelatorio.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_GerarRelatorio.setBounds(166, 330, 405, 44);
		pnl_CompraBox.add(btn_GerarRelatorio);
		
		JPanel pnl_BoxLogin_1 = new JPanel();
		cardLayout.show(pnl_Page, "home");
		
	}
}
