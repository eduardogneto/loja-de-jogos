package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_acesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_acesso frame = new Tela_de_acesso();
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
	public Tela_de_acesso() {
		setTitle("Tela de acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 55, 108, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 18));
		lblSenha.setBounds(10, 123, 108, 52);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(77, 66, 314, 34);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pfSenha.setBounds(77, 134, 310, 34);
		contentPane.add(pfSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_senhas where usuario=? and senha=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2, new String(pfSenha.getPassword()));

					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_inicial exibir = new Tela_inicial(); 
						exibir.setVisible(true);
						
						setVisible(false);

					}else {

						JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto");

					}

					

					stmt.close();

					con.close();

					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}
				
			}
		});
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 18));
		btnNewButton.setBounds(101, 209, 120, 41);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select * from dados_senhas ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					

					ResultSet rs = stmt.executeQuery();

					

					if(rs.next()) {

						

						Tela_cadastro exibir = new Tela_cadastro(); 
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
		btnCadastrarse.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 18));
		btnCadastrarse.setBounds(231, 209, 159, 41);
		contentPane.add(btnCadastrarse);
	}
}
