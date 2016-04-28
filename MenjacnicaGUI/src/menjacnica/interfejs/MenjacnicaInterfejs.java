package menjacnica.interfejs;

import java.util.LinkedList;

import menjacnica.logika.Valuta;

public interface MenjacnicaInterfejs {
	
	public void dodajValutu(Valuta valuta) throws Exception;
	public LinkedList<Valuta> vratiSveValute();
	public void izbrisiValutu(Valuta valuta)throws Exception;
	public int vratiIndeks(Valuta v);
}
