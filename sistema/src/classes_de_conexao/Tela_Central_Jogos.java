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
import java.awt.Font;

public class Tela_Central_Jogos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Central_Jogos frame = new Tela_Central_Jogos();
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
	public Tela_Central_Jogos() {
		setResizable(false);
		setTitle("MENU JOGOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LISTA DE JOGOS");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_ListaJogos exibir = new Tela_ListaJogos(); 
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
		btnNewButton.setBounds(111, 28, 178, 60);
		contentPane.add(btnNewButton);
		
		JButton btnAlterarJogos = new JButton("ALTERAR JOGOS");
		btnAlterarJogos.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnAlterarJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_jogos exibir = new Tela_jogos(); 
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
		btnAlterarJogos.setBounds(111, 110, 178, 60);
		contentPane.add(btnAlterarJogos);
		
		JButton btnAdicionarJogos = new JButton("ADICIONAR JOGOS");
		btnAdicionarJogos.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnAdicionarJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_jogos ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_adicionar_jogos exibir = new Tela_adicionar_jogos(); 
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
		btnAdicionarJogos.setBounds(111, 190, 178, 60);
		contentPane.add(btnAdicionarJogos);
		
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
		btnVoltar.setBounds(350, 217, 84, 44);
		contentPane.add(btnVoltar);
	}

}
