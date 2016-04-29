package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField txtKupovniKurs;
	private JTextField txtProdajniKurs;
	private JComboBox cbValute;
	private JLabel lblIznos;
	private JLabel lblVrstaTransakcije;
	private JTextField txtIznos;
	private JRadioButton rbtnKupovina;
	private JRadioButton rbtnProdaja;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvrsiZamenuGUI frame = new IzvrsiZamenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriProzorIzvrsiZamenu();
			}
		});
		setTitle("Izvrsi zamenu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getCbValute());
		contentPane.add(getLblIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getTxtIznos());
		contentPane.add(getRbtnKupovina());
		contentPane.add(getRbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKupovniKurs.setBounds(10, 25, 90, 25);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblProdajniKurs.setBounds(270, 25, 90, 25);
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setBounds(10, 55, 125, 20);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}
	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setBounds(270, 55, 125, 20);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}
	private JComboBox getCbValute() {
		if (cbValute == null) {
			cbValute = new JComboBox();
			cbValute.setBounds(165, 55, 77, 20);
			cbValute.addItem("EUR");
			cbValute.addItem("USD");
			cbValute.addItem("CHF");
		}
		return cbValute;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIznos.setBounds(10, 105, 90, 25);
		}
		return lblIznos;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblVrstaTransakcije.setBounds(270, 105, 110, 25);
		}
		return lblVrstaTransakcije;
	}
	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(10, 135, 125, 20);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}
	private JRadioButton getRbtnKupovina() {
		if (rbtnKupovina == null) {
			rbtnKupovina = new JRadioButton("Kupovina");
			buttonGroup.add(rbtnKupovina);
			rbtnKupovina.setBounds(270, 147, 109, 23);
			rbtnKupovina.setSelected(true);
		}
		return rbtnKupovina;
	}
	private JRadioButton getRbtnProdaja() {
		if (rbtnProdaja == null) {
			rbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rbtnProdaja);
			rbtnProdaja.setBounds(271, 183, 109, 23);
		}
		return rbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider(0, 100, 50);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					txtIznos.setText(slider.getValue() + "");
				}
			});
			slider.setBounds(10, 227, 385, 45);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String valuta = (String) cbValute.getSelectedItem();
						int iznos = Integer.parseInt(txtIznos.getText());
						String transakcija;
						if(rbtnKupovina.isSelected())
							transakcija = "kupovina";
						else
							transakcija = "prodaja";
						
						GUIKontroler.dodajZamenuUStatus(valuta, iznos, transakcija);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(getContentPane(), "Iznos ne sme sadrzati znakovne vrednosti i mora biti popunjen.", "Greska pri unosu."
								,JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
			btnIzvrsiZamenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnIzvrsiZamenu.setBounds(10, 295, 110, 25);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriProzorIzvrsiZamenu();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnOdustani.setBounds(275, 295, 110, 25);
		}
		return btnOdustani;
	}
}
