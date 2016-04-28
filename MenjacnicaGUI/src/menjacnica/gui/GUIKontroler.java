package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.gui.models.MenjacnicaTableModel;
import menjacnica.logika.Menjacnica;
import menjacnica.logika.Valuta;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnicaProzor;
	private static DodajKursGUI dodajKursProzor;
	private static Menjacnica menjacnica;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
					menjacnicaProzor = new MenjacnicaGUI();
					menjacnicaProzor.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String ucitajFajl(){
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(menjacnicaProzor.getContentPane());

		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			File fajl = fc.getSelectedFile();
			return "Ucitan fajl: " + fajl.getAbsolutePath() + "\n";
		}
		return null;
	}

	public static String sacuvajFajl(){
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showSaveDialog(menjacnicaProzor.getContentPane());

		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			File f = fc.getSelectedFile();
			return "Sacuvan fajl: " + f.getAbsolutePath() + "\n";
		}
		return null;
	}

	public static void zatvoriAplikaciju(){
		int vrednost = JOptionPane.showConfirmDialog(menjacnicaProzor.getContentPane(), "Da li zelite da izadjete "
				+ "iz programa?", "Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);

		if(vrednost == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	public static void aboutDijalog(){
		JOptionPane.showMessageDialog(menjacnicaProzor.getContentPane(),"Aplikacija je uradjena od strane studenta:" + "\n" + 
				"Marko Popovic 215/2014" ,"About", JOptionPane.PLAIN_MESSAGE);
	}

	public static void zatvoriProzorDodajKurs(){
		dodajKursProzor.dispose();
	}

	public static void dodajValutuUStatus(Valuta v) {
		String s = "Uneta valuta:" + "\t" + v.toString();
		menjacnicaProzor.getTextAreaStatus().append(s);
	}

	public static void dodajValutuUModel(Valuta v) throws Exception{
		menjacnica.dodajValutu(v);
		menjacnicaProzor.osveziTabelu();
	}

	public static void pokreniDodajKursProzor() {
		dodajKursProzor = new DodajKursGUI();
		dodajKursProzor.setLocationRelativeTo(null);
		dodajKursProzor.setVisible(true);
	}

	public static LinkedList<Valuta> vratiSveValute() {
		return menjacnica.vratiSveValute();
	}

	public static void upozorenjeZaBrisanje() {
		JOptionPane.showMessageDialog(menjacnicaProzor.getContentPane(), "Morate izabrati red koji sadrzi podatke kursa za brisanje!",
				"Greska prilikom brisanja", JOptionPane.ERROR_MESSAGE);
	}

	public static void izbrisiValutu(Valuta v) {
		try {
			int index = menjacnica.vratiIndeks(v);
			menjacnica.izbrisiValutu(v);
			menjacnicaProzor.osveziTabelu();
			menjacnicaProzor.getTextAreaStatus().append("Izbrisana je red sa indeksom: " + index + "." + "\n");
			JOptionPane.showMessageDialog(menjacnicaProzor.getContentPane(), "Uspesno ste izbrisali valutu.",
					"Uspesno brisanje", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(menjacnicaProzor.getContentPane(), "Doslo je do greske prilikom brisanja.",
					"Greska prilikom brisanja", JOptionPane.ERROR_MESSAGE);
		}
	}

}
