package Frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Backend.*;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel mainWindow;
	private JTextField nome;
	private JTextField quantidade;
	private JTextField validade;

	public Cadastro() {
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
		
		JLabel lblNewLabel = new JLabel("1. Cadastrar Produto: ");
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
		
		JLabel lblNewLabel_3 = new JLabel("Data de Validade: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		mainWindow.add(lblNewLabel_3, "4, 6, center, default");
		
		validade = new JTextField();
		mainWindow.add(validade, "6, 6, fill, default");
		validade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("(yyyy-dd-mm)");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		mainWindow.add(lblNewLabel_4, "4, 7, center, default");
		
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
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Principal.listaProdutos.inserir(new Produto(nome.getText(), Integer.parseInt(quantidade.getText()), LocalDate.parse(validade.getText())));
					JOptionPane.showMessageDialog(null, nome.getText()+" cadastrado com sucesso!");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Algo deu errado, verifique se preencheu tudo corretamente.");
				}
			}
		});
		mainWindow.add(btnNewButton_1, "6, 9");
	}

}
