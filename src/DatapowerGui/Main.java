package DatapowerGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTextArea;

import DatapowerSource.Expression;
import DatapowerSource.Query;
import DatapowerSource.XPathCommunicator;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private static int count;
    private StringBuffer s = new StringBuffer();
    
    private JFileChooser fc = new JFileChooser();
    private JButton btnNewButton = new JButton("Select Log File");
    private Choice choice = new Choice();
    private TextField textField_1 = new TextField();
    private JTextArea textArea = new JTextArea();
    private  JTable table = new JTable();
    public HashMap<String,String> hmap = new HashMap<String,String>();
    public Query datapowerQuery = new Query();
    private ArrayList<String> list = new ArrayList<String>();
    
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
		contentPane.setToolTipText("HI");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(214, 36, 353, 20);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
	    
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   		 if (e.getSource() == btnNewButton){
			
				 int returnVal = fc.showOpenDialog(getParent());
				 if(returnVal == JFileChooser.APPROVE_OPTION) {
					 
				   File f = fc.getSelectedFile();
				   textField.setText(f.getAbsolutePath());			
				   datapowerQuery.setFile(f.getAbsolutePath());
			     }
			    }
		    }
		});
		btnNewButton.setBounds(20, 35, 148, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("       Filter :");
		lblNewLabel.setBounds(28, 83, 73, 36);
		contentPane.add(lblNewLabel);
		
		
		choice.setBounds(144, 91, 168, 52);
		contentPane.add(choice);
		
		Label label = new Label("     Enter Value :");
		label.setBounds(355, 89, 111, 30);
		contentPane.add(label);
		
		
		textField_1.setBounds(472, 91, 173, 22);
		contentPane.add(textField_1);
		
		
		textArea.setBounds(146, 156, 499, 229);
		contentPane.add(textArea);
		choice.add("Tag1");
		choice.add("Tag2");
		choice.add("Tag3");

		
		JButton btnNewButton_1 = new JButton("Add to Filter List");
	    
		
		 btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			  /*  count++;
				s.append("Query " + count + ":- ");
				s.append(choice.getSelectedItem());
				s.append(" ");
				s.append(textField_1.getText());
				hmap.put(choice.getSelectedItem(),textField_1.getText());
				s.append("\n");
				textArea.setText(s.toString());*/
				datapowerQuery.expressionList.add(new Expression(choice.getSelectedItem(),textField_1.getText()));
				textField_1.setText(" ");
			}
		});
		btnNewButton_1.setBounds(665, 90, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Get Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XPathCommunicator x = new XPathCommunicator(datapowerQuery.getFile());
	            list = x.getOutput(datapowerQuery);
	            System.out.println(list.toString());
	            for(String s1 : list){
	            	s.append(s1);
	            	
	            	s.append("\n");
	            	
	            }
	            textArea.setText(s.toString());
			}
		});
		btnNewButton_2.setBounds(38, 130, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
		
	}
}
