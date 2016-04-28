package menjacnica.gui.models;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.logika.Valuta;


public class MenjacnicaTableModel extends AbstractTableModel{

	private String[] kolone = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	private List<Valuta> valute;
	
	public MenjacnicaTableModel(LinkedList<Valuta> valute) {
		this.valute = valute;
	}
	
	@Override
	public int getRowCount() {
		return valute.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Valuta v = valute.get(rowIndex);
		switch (columnIndex) {
		case 0:
				return v.getSifra();
		case 1:
				return v.getSkraceniNaziv();
		case 2:
				return v.getProdajniKurs();
		case 3:
				return v.getSrednjiKurs();
		case 4:
				return v.getKupovniKurs();
		case 5:
				return v.getNaziv();
		default:
			return "N/A";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
/*	public void dodajValutuUModel(Valuta v){
		this.valute.add(v);
		fireTableDataChanged();
	}*/
	
	public void staviSveKnjigeUModel(List<Valuta> valute){
		this.valute = valute;
		fireTableDataChanged();
	}

}
