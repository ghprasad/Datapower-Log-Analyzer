package DatapowerGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Datapower Log Analyzer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 494);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(214, 36, 353, 20);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JFileChooser fc = new JFileChooser();
		final JButton btnNewButton = new JButton("Select Log File");
	    
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   		 if (e.getSource() == btnNewButton){
			
				 int returnVal = fc.showOpenDialog(getParent());
				 if(returnVal == JFileChooser.APPROVE_OPTION) {
					 
				   File f = fc.getSelectedFile();
				   textField.setText(f.getAbsolutePath());			
			     }
			    }
		    }
		});
		btnNewButton.setBounds(20, 35, 148, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("       Filter :");
		lblNewLabel.setBounds(28, 83, 73, 36);
		contentPane.add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(144, 91, 168, 52);
		contentPane.add(choice);
		
		Label label = new Label("     Enter Value :");
		label.setBounds(355, 89, 111, 30);
		contentPane.add(label);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(472, 91, 173, 22);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(686, 90, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(146, 156, 499, 70);
		contentPane.add(textArea);
		choice.add("Tag1");
		choice.add("Tag2");
		choice.add("Tag3");
		
		
		
	}
}
