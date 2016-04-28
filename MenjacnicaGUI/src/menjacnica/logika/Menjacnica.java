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

}
