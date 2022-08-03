package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tela_dados extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfBusca1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_dados frame = new Tela_dados();
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
	public Tela_dados() {
		setTitle("MEUS DADOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		lblNewLabel.setBounds(20, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(20, 49, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		lblSenha.setBounds(20, 74, 46, 14);
		contentPane.add(lblSenha);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setEnabled(false);
		tfId.setBounds(76, 19, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(76, 46, 293, 20);
		contentPane.add(tfUsuario);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(76, 71, 293, 20);
		contentPane.add(tfSenha);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try {

						Connection con = Conexao.faz_conexao();

						String sql = "select * from dados_senhas ";

						

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
		btnNewButton.setBounds(315, 193, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equals("") || tfSenha.equals("")) {

					JOptionPane.showMessageDialog(null, "Dados em branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "update dados_senhas set usuario=?, senha=? where id=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2,tfSenha.getText());
					
					stmt.setString(3,tfId.getText());

					

					stmt.execute();

					

					

					

					stmt.close();

					con.close();

					JOptionPane.showMessageDialog(null, "Alterado com sucesso");

					tfUsuario.setText("");

					tfSenha.setText("");

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			}
		});
		btnAlterar.setBounds(315, 159, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnSeuId = new JButton("Seu Nome");
		btnSeuId.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		btnSeuId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfBusca1.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campo Busca em Branco");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from dados_senhas where usuario like ? ";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					stmt.setString(1, "%"+ tfBusca1.getText());
					

					

					ResultSet rs = stmt.executeQuery();

					

					while (rs.next()) {

					

						tfId.setText(rs.getString("id"));

						tfUsuario.setText(rs.getString("usuario"));

						tfSenha.setText(rs.getString("senha"));
						

											

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
		btnSeuId.setBounds(10, 176, 99, 40);
		contentPane.add(btnSeuId);
		
		tfBusca1 = new JTextField();
		tfBusca1.setBounds(119, 175, 86, 40);
		contentPane.add(tfBusca1);
		tfBusca1.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfId.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Abra os dados para realizar alterações");

				}else {

				

				try {

					Connection con = Conexao.faz_conexao();

					String sql = "delete from dados_senhas where id=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					

					

					stmt.setString(1, tfId.getText());

					

					stmt.execute();

					stmt.close();

					con.close();

					

					JOptionPane.showMessageDialog(null, "Usuário excluído");

					

					stmt.close();

					con.close();

					

					//limpa os campos

					

					tfId.setText("");

					tfUsuario.setText("");

					tfSenha.setText("");
					
					

					

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

				

				

				}
			}
			
		});
		btnExcluir.setFont(new Font("Futura XBlkCnIt BT", Font.PLAIN, 11));
		btnExcluir.setBounds(315, 227, 89, 23);
		contentPane.add(btnExcluir);
	}
}
