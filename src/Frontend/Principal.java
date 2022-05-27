package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Lista;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel mainWindow;
	public static Lista listaProdutos = new Lista();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setTitle("Trabalho II");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		mainWindow = new JPanel();
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainWindow);
		GridBagLayout gbl_mainWindow = new GridBagLayout();
		gbl_mainWindow.columnWidths = new int[]{100, 300, 100};
		gbl_mainWindow.rowHeights = new int[]{100, 100, 100, 100, 100};
		mainWindow.setLayout(gbl_mainWindow);
		
		JLabel lblNewLabel = new JLabel("Escolha uma opção:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 1;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		mainWindow.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton cadastrarButton = new JButton("1. Cadastrar Produto");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro();
				cadastro.setTitle("Trabalho II");
				cadastro.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_cadastrarButton = new GridBagConstraints();
		gbc_cadastrarButton.anchor = GridBagConstraints.NORTH;
		gbc_cadastrarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cadastrarButton.gridx = 1;
		gbc_cadastrarButton.gridy = 1;
		mainWindow.add(cadastrarButton, gbc_cadastrarButton);
		
		JButton listarButton = new JButton("2. Listar Produtos");
		listarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listagem listar = new Listagem();
				listar.setVisible(true);
				listar.setTitle("Trabalho II");
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_listarButton = new GridBagConstraints();
		gbc_listarButton.anchor = GridBagConstraints.NORTH;
		gbc_listarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_listarButton.gridx = 1;
		gbc_listarButton.gridy = 2;
		mainWindow.add(listarButton, gbc_listarButton);
		
		JButton venderButton = new JButton("3. Vender Produto");
		venderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venda venda = new Venda();
				venda.setVisible(true);
				venda.setTitle("Trabalho II");
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_venderButton = new GridBagConstraints();
		gbc_venderButton.anchor = GridBagConstraints.NORTH;
		gbc_venderButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_venderButton.gridx = 1;
		gbc_venderButton.gridy = 3;
		mainWindow.add(venderButton, gbc_venderButton);
		
		JButton encerrarButton = new JButton("4. Encerrar aplicação");
		encerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_encerrarButton = new GridBagConstraints();
		gbc_encerrarButton.anchor = GridBagConstraints.NORTH;
		gbc_encerrarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_encerrarButton.gridx = 1;
		gbc_encerrarButton.gridy = 4;
		mainWindow.add(encerrarButton, gbc_encerrarButton);
	}
	
}
