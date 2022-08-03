package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Tela_inicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_inicial frame = new Tela_inicial();
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
	public Tela_inicial() {
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCarrinhoDeCompras = new JButton("ESTOQUE");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
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
		btnCarrinhoDeCompras.setForeground(Color.BLACK);
		btnCarrinhoDeCompras.setBackground(Color.WHITE);
		btnCarrinhoDeCompras.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnCarrinhoDeCompras.setBounds(236, 184, 188, 66);
		contentPane.add(btnCarrinhoDeCompras);
		
		JButton btnJogos = new JButton("JOGOS");
		btnJogos.addActionListener(new ActionListener() {
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
		btnJogos.setBackground(Color.WHITE);
		btnJogos.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnJogos.setBounds(10, 107, 188, 66);
		contentPane.add(btnJogos);
		
		JButton btnAdicionarJogos_1_1 = new JButton("MEUS DADOS");
		btnAdicionarJogos_1_1.setBackground(Color.WHITE);
		btnAdicionarJogos_1_1.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnAdicionarJogos_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_senhas ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_dados exibir = new Tela_dados(); 
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
		btnAdicionarJogos_1_1.setBounds(236, 107, 188, 66);
		contentPane.add(btnAdicionarJogos_1_1);
		
		JTextArea txtrMenuPrincipal = new JTextArea();
		txtrMenuPrincipal.setEditable(false);
		txtrMenuPrincipal.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 40));
		txtrMenuPrincipal.setText("MENU PRINCIPAL");
		txtrMenuPrincipal.setBounds(81, 30, 284, 66);
		contentPane.add(txtrMenuPrincipal);
		
		JButton btnJogos_1 = new JButton("SAIR");
		btnJogos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_senhas ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_de_acesso exibir = new Tela_de_acesso(); 
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
		btnJogos_1.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnJogos_1.setBackground(Color.WHITE);
		btnJogos_1.setBounds(10, 184, 188, 66);
		contentPane.add(btnJogos_1);
	}
}
