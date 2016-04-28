package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	
	private static MenjacnicaGUI menjacnicaProzor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	
}
