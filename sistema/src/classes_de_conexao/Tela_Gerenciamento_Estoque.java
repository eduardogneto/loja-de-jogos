package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_Gerenciamento_Estoque extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfEstoque;
	private JTextField tfBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Gerenciamento_Estoque frame = new Tela_Gerenciamento_Estoque();
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
	public Tela_Gerenciamento_Estoque() {
		setTitle("Gerenciamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(70, 13, 307, 20);
		contentPane.add(tfId);
		
		tfEstoque = new JTextField();
		tfEstoque.setColumns(10);
		tfEstoque.setBounds(70, 50, 307, 20);
		contentPane.add(tfEstoque);
		
		JLabel lblNomeJogo = new JLabel("Id");
		lblNomeJogo.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblNomeJogo.setBounds(10, 11, 62, 25);
		contentPane.add(lblNomeJogo);
		
		JLabel lblLancamento = new JLabel("Estoque");
		lblLancamento.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		lblLancamento.setBounds(10, 47, 62, 25);
		contentPane.add(lblLancamento);
		
		JButton btnNewButton = new JButton("Codigo Jogo");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfBusca.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo Busca em Branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_jogos where jogo_codigo like ? ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, "%"+ tfBusca.getText());
					

					

					ResultSet rs = stmt.executeQuery();

					

					while (rs.next()) {

				

						tfId.setText(rs.getString("jogo_codigo"));

						tfEstoque.setText(rs.getString("estoque"));
						


											

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
		btnNewButton.setBounds(10, 200, 114, 36);
		contentPane.add(btnNewButton);
		
		tfBusca = new JTextField();
		tfBusca.setColumns(10);
		tfBusca.setBounds(127, 200, 86, 36);
		contentPane.add(tfBusca);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfId.getText().equals("") || tfEstoque.equals("")) {

					JOptionPane.showMessageDialog(null, "Dados em branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "update dados_jogos set estoque=? where jogo_codigo=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1,tfEstoque.getText());
					stmt.setString(2,tfId.getText());
					

					

					stmt.execute();

					

					

					

					stmt.close();

					con.close();

					JOptionPane.showMessageDialog(null, "Alterado Estoque com sucesso");


					tfEstoque.setText("");
					
					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			}
		});
		btnAlterar.setBounds(310, 148, 114, 36);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 13));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_carrinho exibir = new Tela_carrinho(); 
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
		btnVoltar.setBounds(310, 200, 114, 36);
		contentPane.add(btnVoltar);
	}

}
