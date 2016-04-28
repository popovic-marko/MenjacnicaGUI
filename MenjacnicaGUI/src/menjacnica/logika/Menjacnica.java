package menjacnica.logika;

import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	private LinkedList<Valuta> valute = new LinkedList<>();

	@Override
	public void dodajValutu(Valuta valuta) throws Exception {
		if(valute == null || valute.contains(valuta))
			throw new Exception("Menjacnica vec sadrzi datu valutu");
		
		valute.add(valuta);
	}

	@Override
	public LinkedList<Valuta> vratiSveValute() {
		return valute;
	}

	@Override
	public void izbrisiValutu(Valuta valuta) throws Exception {
		if(valute == null){
			throw new Exception("Doslo je do greske prilikom brisanja.");
		}
		valute.remove(valuta);
	}
	
	@Override
	public int vratiIndeks(Valuta v) {
		return valute.indexOf(v);
	}

}
