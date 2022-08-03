package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tela_ListaJogos extends JFrame {

	private JPanel contentPane;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListaJogos frame = new Tela_ListaJogos();
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
	public Tela_ListaJogos() {
		setTitle("Lista de Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 766, 328);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Ano", "Corredor", "Pre\u00E7o", "Categoria", "Desenvolvedores"
			}
		));
		tbDados.getColumnModel().getColumn(6).setPreferredWidth(94);
		scrollPane.setViewportView(tbDados);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(393, 350, 121, 48);
		contentPane.add(btnNewButton);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 15));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_jogos";

					

					PreparedStatement stmt = con.prepareStatement(sql);

							

					ResultSet rs = stmt.executeQuery();



					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();

					modelo.setNumRows(0);

					while (rs.next()) {

					

						

						modelo.addRow(new Object[]{rs.getString("jogo_codigo"), rs.getString("nome_jogo"), rs.getString("data_lancamento"), rs.getString("corredor"), rs.getString("jogo_preco"), rs.getString("categoria_jogo"), rs.getString("desenvolvedora_jogo")});

						

					}

					

					

					

					rs.close();

					con.close();

			

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

			

				}
			
		});
		btnListar.setBounds(252, 350, 121, 48);
		contentPane.add(btnListar);
	}
}
