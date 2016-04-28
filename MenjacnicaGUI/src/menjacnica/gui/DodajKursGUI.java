package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.logika.Valuta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JTextField txtProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField txtSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKursGUI frame = new DodajKursGUI();
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
	public DodajKursGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriProzorDodajKurs();
			}
		});
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 310, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getTxtSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setHorizontalTextPosition(SwingConstants.LEADING);
			lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSifra.setBounds(16, 20, 80, 20);
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNaziv.setBounds(170, 20, 80, 20);
		}
		return lblNaziv;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setBounds(16, 45, 110, 20);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setBounds(170, 45, 110, 20);
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblProdajniKurs.setBounds(16, 100, 80, 20);
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setBounds(16, 125, 110, 20);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKupovniKurs.setBounds(170, 100, 80, 20);
		}
		return lblKupovniKurs;
	}
	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setBounds(170, 125, 110, 20);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSrednjiKurs.setBounds(16, 180, 80, 20);
		}
		return lblSrednjiKurs;
	}
	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setBounds(16, 205, 110, 20);
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSkraceniNaziv.setBounds(170, 180, 80, 20);
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setBounds(170, 205, 110, 20);
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean unos = true;
					String sifra = txtSifra.getText();
					if(sifra.equals(""))
						unos = false;
					String naziv = txtNaziv.getText();
					if(naziv.equals(""))
						unos = false;
					try {
						double prodajniKurs = Double.parseDouble(txtProdajniKurs.getText());
						if(prodajniKurs < 0)
							unos = false;
						double kupovniKurs = Double.parseDouble(txtKupovniKurs.getText());
						if(kupovniKurs < 0)
							unos = false;
						double srednjiKurs = Double.parseDouble(txtSrednjiKurs.getText());
						if(srednjiKurs < 0)
							unos = false;
						String skraceniNaziv = txtSkraceniNaziv.getText();
						if(skraceniNaziv.equals("") || skraceniNaziv.length() > 3){
							JOptionPane.showMessageDialog(getContentPane(), "Skraceni naziv ne sme biti duzi od 3 karaktera i mor"
									+ "a biti popunjen.", "Greska pri unosu."
									,JOptionPane.INFORMATION_MESSAGE);
							unos = false;
						}
						if(unos){
							Valuta v = new Valuta(sifra, naziv, prodajniKurs, kupovniKurs, srednjiKurs, skraceniNaziv);
							GUIKontroler.dodajValutuUModel(v);
							GUIKontroler.dodajValutuUStatus(v);
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(getContentPane(), "Kurs ne sme sadrzati znakovne vrednosti.", "Greska pri unosu."
													,JOptionPane.WARNING_MESSAGE);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(getContentPane(), "Valuta sa unetom sifrom vec postoji.", "Greska pri unosu", JOptionPane.WARNING_MESSAGE);
					}
					
				}

			});
			btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnDodaj.setBounds(16, 248, 110, 25);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriProzorDodajKurs();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnOdustani.setBounds(170, 248, 110, 25);
		}
		return btnOdustani;
	}
}
