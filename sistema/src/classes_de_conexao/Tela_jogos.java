package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_jogos extends JFrame {

	private JPanel contentPane;
	private JTextField tfCorredor;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tf_Data;
	private JTextField tfPreco;
	private JTextField tfDesc;
	private JTextField tfDev;
	private JTextField tfBusca1;
	private JButton btnNewButton;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_jogos frame = new Tela_jogos();
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
	public Tela_jogos() {
		setTitle("JOGOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Corredor");
		lblNewLabel.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 62, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeJogo = new JLabel("Nome Jogo");
		lblNomeJogo.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblNomeJogo.setBounds(10, 38, 62, 25);
		contentPane.add(lblNomeJogo);
		
		JLabel lblLancamento = new JLabel("Ano");
		lblLancamento.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblLancamento.setBounds(10, 74, 62, 25);
		contentPane.add(lblLancamento);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblPreco.setBounds(10, 110, 62, 25);
		contentPane.add(lblPreco);
		
		JLabel lblDescricao = new JLabel("Categoria");
		lblDescricao.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 146, 62, 25);
		contentPane.add(lblDescricao);
		
		JLabel lblDesenvolvedora = new JLabel("Desenvolvedora");
		lblDesenvolvedora.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblDesenvolvedora.setBounds(10, 182, 109, 25);
		contentPane.add(lblDesenvolvedora);
		
		JLabel lblCodigoJogo = new JLabel("Codigo Jogo");
		lblCodigoJogo.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblCodigoJogo.setBounds(224, 11, 62, 25);
		contentPane.add(lblCodigoJogo);
		
		tfCorredor = new JTextField();
		tfCorredor.setBounds(70, 13, 86, 20);
		contentPane.add(tfCorredor);
		tfCorredor.setColumns(10);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(291, 13, 86, 20);
		contentPane.add(tfId);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(70, 40, 307, 20);
		contentPane.add(tfNome);
		
		tf_Data = new JTextField();
		tf_Data.setColumns(10);
		tf_Data.setBounds(70, 77, 307, 20);
		contentPane.add(tf_Data);
		
		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(70, 112, 73, 20);
		contentPane.add(tfPreco);
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		tfDesc.setBounds(70, 148, 307, 20);
		contentPane.add(tfDesc);
		
		tfDev = new JTextField();
		tfDev.setColumns(10);
		tfDev.setBounds(97, 184, 280, 20);
		contentPane.add(tfDev);
		
		tfBusca1 = new JTextField();
		tfBusca1.setBounds(127, 262, 86, 36);
		contentPane.add(tfBusca1);
		tfBusca1.setColumns(10);
		
		btnNewButton = new JButton("Numero Jogo");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfBusca1.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo Busca em Branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_jogos where jogo_codigo like ? ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, "%"+ tfBusca1.getText());
					

					

					ResultSet rs = stmt.executeQuery();

					

					while (rs.next()) {

					

						tfCorredor.setText(rs.getString("corredor"));

						tfId.setText(rs.getString("jogo_codigo"));

						tfNome.setText(rs.getString("nome_jogo"));
						
						tf_Data.setText(rs.getString("data_lancamento"));
						
						tfPreco.setText(rs.getString("jogo_preco"));
						
						tfDesc.setText(rs.getString("categoria_jogo"));
						
						tfDev.setText(rs.getString("desenvolvedora_jogo"));

											

					}

							

					rs.close();

					con.close();

								

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

		

				}
			}
		});
		btnNewButton.setBounds(10, 262, 114, 36);
		contentPane.add(btnNewButton);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_Central_Jogos exibir = new Tela_Central_Jogos(); 
						exibir.setVisible(true);
						
						setVisible(false);

					}

					

					stmt.close();

					con.close();

					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}
			}
		});
		btnVoltar.setBounds(328, 295, 93, 20);
		contentPane.add(btnVoltar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 14));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().equals("") || tfPreco.equals("")) {

					JOptionPane.showMessageDialog(null, "Dados em branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "update dados_jogos set corredor=?, nome_jogo=?, data_lancamento=?, jogo_preco=?, categoria_jogo=?, desenvolvedora_jogo=? where jogo_codigo=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1,tfCorredor.getText());

					stmt.setString(2,tfNome.getText());
					
					stmt.setString(3,tf_Data.getText());
					
					stmt.setString(4,tfPreco.getText());
					
					stmt.setString(5,tfDesc.getText());
					
					stmt.setString(6,tfDev.getText());
					
					stmt.setString(7,tfId.getText());

					

					stmt.execute();

					

					

					

					stmt.close();

					con.close();

					JOptionPane.showMessageDialog(null, "Alterado com sucesso");

					tfCorredor.setText("");

					tfNome.setText("");
					
					tf_Data.setText("");
					
					tfPreco.setText("");
					
					tfDesc.setText("");
					
					tfDev.setText("");
					
					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			}
		});
		btnAlterar.setBounds(328, 269, 96, 22);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Abra os dados para realizar alterações");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "delete from dados_jogos where jogo_codigo=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					

					stmt.setString(1, tfId.getText());

					

					stmt.execute();

					stmt.close();

					con.close();

					

					JOptionPane.showMessageDialog(null, "Jogo excluído");

					

					stmt.close();

					con.close();

					

					//limpa os campos

					

					tfId.setText("");

					tfNome.setText("");

					tf_Data.setText("");
					
					tfCorredor.setText("");
					
					tfPreco.setText("");
					
					tfDesc.setText("");
					
					tfDev.setText("");
					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
				
			}
		});
		btnExcluir.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 14));
		btnExcluir.setBounds(328, 243, 96, 22);
		contentPane.add(btnExcluir);
	}
}
