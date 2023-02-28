import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CurrencyConvertor extends JFrame {
	private JTextField tf_from;
	private JTextField tf_to;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConvertor frame = new CurrencyConvertor();
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
	public CurrencyConvertor() {
		setTitle("CURRENCY CONVERTOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 504);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Convertor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(116, 29, 295, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblForFeburary = new JLabel("By 22nd February 2023");
		lblForFeburary.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblForFeburary.setBounds(149, 78, 227, 39);
		getContentPane().add(lblForFeburary);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(116, 168, 60, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("To");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(351, 168, 24, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		String[] currency = new String[] {"INR", "US Dollar", "Euro", "Pound", "Dinar", "Yuan", "Ruble"};
		
		JComboBox cb_from = new JComboBox();
		cb_from.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb_from.setModel(new DefaultComboBoxModel(currency));
		cb_from.setSelectedIndex(0);
		cb_from.setToolTipText("");
		cb_from.setBounds(88, 238, 105, 28);
		getContentPane().add(cb_from);
		
		JComboBox cb_to = new JComboBox();
		cb_to.setModel(new DefaultComboBoxModel(currency));
		cb_to.setSelectedIndex(1);
		cb_to.setToolTipText("");
		cb_to.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb_to.setBounds(317, 238, 105, 28);
		getContentPane().add(cb_to);
		
		tf_from = new JTextField();
		tf_from.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				
				if(!Character.isDigit(ch)) {
					e.consume();
				}
			}
		});
		tf_from.setFont(new Font("Tahoma", Font.PLAIN, 23));
		tf_from.setBounds(75, 302, 132, 47);
		getContentPane().add(tf_from);
		tf_from.setColumns(10);
		
		tf_to = new JTextField();
		tf_to.setFont(new Font("Tahoma", Font.PLAIN, 23));
		tf_to.setColumns(10);
		tf_to.setBounds(303, 302, 132, 47);
		getContentPane().add(tf_to);
		
		JButton btn_convert = new JButton("Convert");
		btn_convert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_convert.setBounds(201, 385, 105, 39);
		getContentPane().add(btn_convert);
		
		btn_convert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tf_from.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a Value!", "Warning!!!",2);
				}
					
				else if(cb_from.getSelectedIndex()==cb_to.getSelectedIndex()) {
					tf_to.setText(tf_from.getText());
				}
				
				else {
					DecimalFormat df = new DecimalFormat("#.####");
					String change;
	
					if(cb_from.getSelectedIndex()==0) {	
						if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 82.92);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 88.19);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 100.16);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 270.36);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 12.02);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) / 1.11);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==1) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 82.92);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.94);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.83);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.31);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 6.9);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 74.92);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==2) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 88.11);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 1.06);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.88);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.33);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 7.33);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 79.61);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==3) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 100.19);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 1.21);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 1.14);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.37);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 8.33);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 90.51);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==4) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 270.5);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 3.26);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 3.07);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 2.7);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 22.5);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 244.39);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==5) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 12.03);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.15);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.14);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.12);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.044);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==6) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 10.83);
							tf_to.setText(change);
						}
					}
					else if(cb_from.getSelectedIndex()==6) {	
						if(cb_to.getSelectedIndex()==0) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 1.11);
							tf_to.setText(change);
						}
						else if(cb_to.getSelectedIndex()==1) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.013);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==2) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.013);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==3) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.011);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==4) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.0041);
							tf_to.setText(change);
						}else if(cb_to.getSelectedIndex()==5) {
							change = df.format(Double.parseDouble(tf_from.getText()) * 0.092);
							tf_to.setText(change);
						}
					}
				}
			}
		});
		
	}
}
