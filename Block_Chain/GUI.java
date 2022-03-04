import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.security.*;
import java.awt.Font;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private DefaultListModel listModel;
	private JButton btnMerkleRoot;
	private JButton btnMineBlock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 27, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(488, 27, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		String[] personName = { "Choose", "Charlie", "Adam", "Kathy", "Bob", "Alice" };
		
		JComboBox comboBox = new JComboBox(personName);
		comboBox.setBounds(180, 27, 116, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(personName);
		comboBox_1.setBounds(336, 27, 116, 22);
		contentPane.add(comboBox_1);
		
		
		listModel = new DefaultListModel();
        JList list = new JList(listModel);
		
		list.setBounds(31, 136, 573, 212);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Sign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				try {
					String tran=textField.getText() + "  " + comboBox.getSelectedItem().toString() + "  " + comboBox_1.getSelectedItem().toString();
					
					KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
					SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
					keyGen.initialize(1024, random);
					
					KeyPair pair = keyGen.generateKeyPair();
					PrivateKey priv = pair.getPrivate();
					PublicKey pub = pair.getPublic();
										
					Signature dsa = Signature.getInstance("SHA1withDSA", "SUN"); 
					dsa.initSign(priv);
					dsa.update(tran.getBytes(), 0, tran.length());
					byte[] realSig = dsa.sign();
										
					Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
					sig.initVerify(pub);
					//tran=tran+ ".";
					sig.update(tran.getBytes());
					boolean verifies = sig.verify(realSig);

					listModel.addElement( tran + " " +verifies);
					
					btnMerkleRoot.setEnabled(true); 
					
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SignatureException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(662, 12, 65, 53);
		contentPane.add(btnNewButton);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 100, 738, 12);
		contentPane.add(separator);
		
		btnMerkleRoot = new JButton("Merkle Root");
		btnMerkleRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				btnMineBlock.setEnabled(true);	
			
			}
		});
		btnMerkleRoot.setBounds(661, 207, 110, 43);
		btnMerkleRoot.setEnabled(false); 
		contentPane.add(btnMerkleRoot);
		
		btnMineBlock = new JButton("Mine Block");
		btnMineBlock.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMineBlock.setEnabled(false);
		btnMineBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMineBlock.setBounds(661, 280, 110, 53);
		contentPane.add(btnMineBlock);
		
		JLabel lblTransactionNo = new JLabel("Transaction No");
		lblTransactionNo.setBounds(35, 7, 111, 16);
		contentPane.add(lblTransactionNo);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(180, 7, 111, 16);
		contentPane.add(lblFrom);
	}
}
