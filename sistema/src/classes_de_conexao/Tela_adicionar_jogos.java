package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Tela_adicionar_jogos extends JFrame {

	private JPanel contentPane;
	private JTextField tfCorredor;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfPreco;
	private JTextField tfDesc;
	private JTextField tfDev;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_adicionar_jogos frame = new Tela_adicionar_jogos();
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
	public Tela_adicionar_jogos() {
		setTitle("ADD JOGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADICIONAR");
		btnNewButton.setFont(new Font("Futura XBlk BT", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().equals("") || tfPreco.equals("")) {

					JOptionPane.showMessageDialog(null, "Dados em branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "insert	into dados_jogos(corredor,nome_jogo,data_lancamento,jogo_preco,categoria_jogo,desenvolvedora_jogo) values (?,?,?,?,?,?)";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfCorredor.getText());

					stmt.setString(2,tfNome.getText());
					
					stmt.setString(3,tfData.getText());
					
					stmt.setString(4,tfPreco.getText());
					
					stmt.setString(5,tfDesc.getText());
					
					stmt.setString(6,tfDev.getText());

					

					stmt.execute();

					

					

					

					stmt.close();

					con.close();

					JOptionPane.showMessageDialog(null, "Jogo adicionado com Sucesso");

					tfCorredor.setText("");

					tfNome.setText("");
					
					tfData.setText("");
					
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
		btnNewButton.setBounds(41, 218, 115, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Corredor");
		lblNewLabel.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 62, 25);
		contentPane.add(lblNewLabel);
		
		tfCorredor = new JTextField();
		tfCorredor.setColumns(10);
		tfCorredor.setBounds(70, 13, 86, 20);
		contentPane.add(tfCorredor);
		
		JLabel lblCodigoJogo = new JLabel("Codigo Jogo");
		lblCodigoJogo.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblCodigoJogo.setBounds(224, 11, 62, 25);
		contentPane.add(lblCodigoJogo);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(291, 13, 86, 20);
		contentPane.add(tfId);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(70, 40, 307, 20);
		contentPane.add(tfNome);
		
		JLabel lblNomeJogo = new JLabel("Nome Jogo");
		lblNomeJogo.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblNomeJogo.setBounds(10, 38, 62, 25);
		contentPane.add(lblNomeJogo);
		
		JLabel lblLancamento = new JLabel("Ano");
		lblLancamento.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblLancamento.setBounds(10, 74, 62, 25);
		contentPane.add(lblLancamento);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(80, 77, 297, 20);
		contentPane.add(tfData);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblPreco.setBounds(10, 110, 62, 25);
		contentPane.add(lblPreco);
		
		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(70, 112, 73, 20);
		contentPane.add(tfPreco);
		
		JLabel lblDescricao = new JLabel("Categoria");
		lblDescricao.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblDescricao.setBounds(10, 146, 62, 25);
		contentPane.add(lblDescricao);
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		tfDesc.setBounds(70, 148, 307, 20);
		contentPane.add(tfDesc);
		
		JLabel lblDesenvolvedora = new JLabel("Desenvolvedora");
		lblDesenvolvedora.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblDesenvolvedora.setBounds(10, 182, 109, 25);
		contentPane.add(lblDesenvolvedora);
		
		tfDev = new JTextField();
		tfDev.setColumns(10);
		tfDev.setBounds(97, 184, 280, 20);
		contentPane.add(tfDev);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Futura XBlk BT", Font.PLAIN, 12));
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
		btnVoltar.setBounds(234, 218, 115, 35);
		contentPane.add(btnVoltar);
	}

}
