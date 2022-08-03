package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tela_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
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
	public Tela_cadastro() {
		setResizable(false);
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 41, 81, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		lblUsuario.setBounds(10, 78, 81, 46);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		lblSenha.setBounds(10, 113, 134, 46);
		contentPane.add(lblSenha);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(68, 55, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(68, 92, 222, 20);
		contentPane.add(tfUsuario);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(68, 127, 201, 20);
		contentPane.add(tfSenha);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(10, 279, 414, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equals("") || tfSenha.equals("")) {

					JOptionPane.showMessageDialog(null, "Usuario/senha em branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "insert	into dados_senhas(usuario,senha) values (?,?)";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2,tfSenha.getText());

					

					stmt.execute();

					

					

					

					stmt.close();

					con.close();

					JOptionPane.showMessageDialog(null, "Salvo");

					tfUsuario.setText("");

					tfSenha.setText("");

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
				
			}
		});
		btnNewButton.setBounds(10, 29, 189, 42);
		panel.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
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
		btnVoltar.setBounds(209, 29, 195, 42);
		panel.add(btnVoltar);
	}
}
