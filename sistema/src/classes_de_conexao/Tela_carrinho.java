package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_carrinho extends JFrame {

	private JPanel contentPane;
	private JTable tbEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_carrinho frame = new Tela_carrinho();
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
	public Tela_carrinho() {
		setTitle("CARRINHO DE COMPRAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 719, 268);
		contentPane.add(scrollPane);
		
		tbEstoque = new JTable();
		tbEstoque.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ID DO JOGO", "ESTOQUE"
			}
		));
		scrollPane.setViewportView(tbEstoque);
		
		JButton btnNewButton = new JButton("LISTAR");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_jogos";

					

					PreparedStatement stmt = con.prepareStatement(sql);

							

					ResultSet rs = stmt.executeQuery();



					DefaultTableModel modelo = (DefaultTableModel) tbEstoque.getModel();

					modelo.setNumRows(0);

					while (rs.next()) {

					

						

						modelo.addRow(new Object[]{rs.getString("jogo_codigo"), rs.getString("estoque")});

						

					}

					

					

					

					rs.close();

					con.close();

			

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

			}
		});
		btnNewButton.setBounds(308, 351, 140, 55);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_inicial exibir = new Tela_inicial(); 
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
		btnVoltar.setBounds(601, 351, 140, 55);
		contentPane.add(btnVoltar);
		
		JButton btnGerenciarEstoque = new JButton("GERENCIAR ESTOQUE");
		btnGerenciarEstoque.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnGerenciarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_Gerenciamento_Estoque exibir = new Tela_Gerenciamento_Estoque(); 
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
		btnGerenciarEstoque.setBounds(22, 351, 184, 55);
		contentPane.add(btnGerenciarEstoque);
	}

}
