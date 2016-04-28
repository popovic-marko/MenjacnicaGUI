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

	public static void dodajValutuUStatus(String sifra, String naziv, double prodajniKurs, double kupovniKurs,
			double srednjiKurs, String skraceniNaziv) {
		String s = "Uneta valuta:" + "\t" + "Sifra: " + sifra + "\t" + "Naziv:"+ naziv + "\t"+ "Prodajni kurs: " + prodajniKurs + "\t"
				+ "Kupovni kurs: " + kupovniKurs + "\t" + "Srednji kurs:" + srednjiKurs + "\t" + "Skraceni naziv:" + skraceniNaziv + "\n";
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

}
