package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Backend.Produto;

public class Venda extends JFrame {

	private static final long serialVersionUID = 1;
	private JTextField nome;
	private JTextField quantidade;
	private JPanel mainWindow;
	
	public Venda() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 280);
		mainWindow = new JPanel();
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainWindow);
		mainWindow.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:216px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),}));
		
		JLabel lblNewLabel = new JLabel("3. Vender Produto: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		mainWindow.add(lblNewLabel, "4, 2, 3, 1, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		mainWindow.add(lblNewLabel_1, "4, 4, center, default");
		
		nome = new JTextField();
		mainWindow.add(nome, "6, 4, fill, default");
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		mainWindow.add(lblNewLabel_2, "4, 5, center, default");
		
		quantidade = new JTextField();
		mainWindow.add(quantidade, "6, 5, fill, default");
		quantidade.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal principal = new Principal();
	            principal.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		mainWindow.add(btnNewButton, "4, 9");
		
		JButton btnNewButton_1 = new JButton("Vender");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto aux = Principal.listaProdutos.findByName(nome.getText());
				
				if (aux != null) {
					if (aux.getValidade().isBefore(LocalDate.now())) {
						JOptionPane.showMessageDialog(null, "Venda cancelada! Produto vencido (" + aux.getValidade()+ ").");
					}
					else {
						if (aux.getQuantidade() >= Integer.parseInt(quantidade.getText())) {
							if (aux.getQuantidade() == Integer.parseInt(quantidade.getText())) {
								if (Principal.listaProdutos.remove(aux)) {
									JOptionPane.showMessageDialog(null, nome.getText()+" vendido com sucesso!");
								}
							}
							else {
								aux.setQuantidade(aux.getQuantidade() - Integer.parseInt(quantidade.getText()));
								JOptionPane.showMessageDialog(null, nome.getText()+" vendido com sucesso!");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Não há quantidade suficiente do produto para essa venda. A quantidade em estoque é: " + aux.getQuantidade());
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Não existe nenhum produto com o nome '"+nome.getText()+"' no sistema.");
				}
			}
		});
		mainWindow.add(btnNewButton_1, "6, 9");
	}
}
