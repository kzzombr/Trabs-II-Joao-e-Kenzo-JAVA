package Frontend;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultListCellRenderer;

public class Listagem extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel mainWindow;
	
	public Listagem() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		mainWindow = new JPanel();
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainWindow);
		GridBagLayout gbl_mainWindow = new GridBagLayout();
		gbl_mainWindow.columnWidths = new int[]{100, 300, 100};
		gbl_mainWindow.rowHeights = new int[]{100, 500, 50, 50};
		mainWindow.setLayout(gbl_mainWindow);
		
		JLabel lblNewLabel = new JLabel("2. Listar Produtos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 1;
		gbc_lblNewLabel.anchor = GridBagConstraints.CENTER;
		gbc_lblNewLabel.gridwidth = 1;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		mainWindow.add(lblNewLabel, gbc_lblNewLabel);
		
		JList<String> produtosList = new JList<String>();
		produtosList.setCellRenderer(new DefaultListCellRenderer());
		GridBagConstraints gbc_produtosList = new GridBagConstraints();
		gbc_produtosList.gridheight = 1;
		gbc_produtosList.anchor = GridBagConstraints.CENTER;
		gbc_produtosList.fill = GridBagConstraints.HORIZONTAL;
		gbc_produtosList.gridwidth = 1;
		gbc_produtosList.gridx = 1;
		gbc_produtosList.gridy = 1;
		mainWindow.add(produtosList, gbc_produtosList);
		
		JButton btnNewButton = new JButton("Listar Produtos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Principal.listaProdutos.vazia()) {
					JOptionPane.showMessageDialog(null, "Ainda não foi cadastado nenhum produto.");
				}
				else {
					produtosList.setListData(Principal.listaProdutos.gerarVetor());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 1;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 1;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		mainWindow.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
	            principal.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 1;
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridwidth = 1;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 3;
		mainWindow.add(btnNewButton_1, gbc_btnNewButton_1);
		
	}
}
