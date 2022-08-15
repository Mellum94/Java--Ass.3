import java.util.LinkedList;
import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T>{

	/* Klassen Lenkeliste<T> implementerer Liste<T>. Vi skal enkelt kunne sette inn
	elementer på slutten av listen og ta ut fra starten slik at det første elementet som ble satt inn
	også er det første som blir tatt ut. På denne måten kan listen benyttes som en kø (First in,
	First out). Metoden leggTil (T x) setter inn et element på slutten av listen, mens
	fjern () fjerner og returnere elementet på starten av listen
	
	Metoden sett(int pos, T x) setter inn elementet på en gitt posisjon og overskrive
	det som var der fra før av.

	Metoden leggTil(int pos, T x) legger inn et nytt element i listen og skyve neste
	element ett hakk lenger bak.

	Metoden fjern(int pos) fjerner på gitt indeks i listen.
	*/


	
	class Node {
		//klasse som hører til Lenkeliste.
		Node neste = null;
		T data; 

		Node(T x){
			data = x;
		}
	}
	

	protected Node start = null;
	protected Node slutt = null;
	protected int listeLengde = 0;
	//Liste<T> liste = new Lenkeliste();



	public int stoerrelse(){
		Node p = start;
		int n = 0;

		while (p != null){
			n++; p = p.neste;
		} 
		return n;
	}
	

	public void leggTil(int pos, T x) throws UgyldigListeIndeks{
		
		if (pos >listeLengde || pos < 0) {
			throw new UgyldigListeIndeks(pos);
		}

		if (pos == 0) {
			Node temp = new Node(x);
			temp.neste = start;
			start = temp;
			listeLengde++;
			return;
		}
		Node p = start; 

		for (int i = 0; i<(pos-1);i++) {
			p = p.neste;	
		}

		Node temp = new Node(x);
		temp.neste = p.neste;
		p.neste = temp;
		listeLengde++;
		
	}

	public void leggTil(T x){
		if (start == null) {
			start = new Node(x);
			listeLengde++;
			return;
		}
		Node p = start;
		while(p.neste != null){
			p = p.neste;
		}
		p.neste = new Node(x);
		listeLengde++;



	}


	public void sett(int pos, T x) throws UgyldigListeIndeks{
		if (pos >= listeLengde) {
			throw new UgyldigListeIndeks(pos);
		}
		if (pos < 0){
			throw new UgyldigListeIndeks(pos);
		}



		Node p = start;
		for (int i = 0; i < pos; i++) {
			if (p.neste == null){
				throw new UgyldigListeIndeks(pos);
			}
			p = p.neste;
		}
		p.data = x;
	}


	public T hent(int pos) throws UgyldigListeIndeks{
		

		if (listeLengde == 0){
			throw new UgyldigListeIndeks(pos);
		}

		if (pos<0 || pos >= listeLengde) {
			throw new UgyldigListeIndeks(pos);
		}

		
		Node p = start;
		for (int i = 0; i <pos; i++)
			p = p.neste;
		return p.data;	
	}




	public T fjern(int pos) throws UgyldigListeIndeks{
		if (listeLengde == 0 || pos < 0){
			throw new UgyldigListeIndeks(pos);
		}
		if (pos > listeLengde){
			throw new UgyldigListeIndeks(pos);
		}

		if (start == null){
			throw new UgyldigListeIndeks(pos);
		} 

		if(pos >= listeLengde){
			throw new UgyldigListeIndeks(pos);
		}

		if (pos == 0){
			T posNull = start.data;
			start = null;
			return posNull; 
		}


		Node p = start;
		for(int i = 1; i < pos; i++)
			p = p.neste;


		Node n = p.neste;
		p.neste = n.neste; 

		if(pos == (listeLengde-1)){
			slutt = p;
		}
		listeLengde --;
		return n.data;


	}


	public T fjern(){
		if(start == null){
			throw new UgyldigListeIndeks(-1);
		}

		T liste = start.data;
		start = start.neste;
		listeLengde --;
		return liste;

	}


	//Iterator for klassen Lenkeliste
	@Override
	public Iterator<T> iterator(){
		return new LenkelisteIterator<T>(this);
	}
	
	public class LenkelisteIterator<T> implements Iterator<T> {
		
		int indexPosition = 0;
		Liste<T> indreListe;

		public LenkelisteIterator(Liste<T> indreListe){
			this.indreListe = indreListe;
		}

		@Override
		public boolean hasNext(){
			if (indreListe.stoerrelse() <= indexPosition ) {
				return false;
			}
			return true;
		}

		@Override
		public T next(){
			return indreListe.hent(indexPosition++);
		}

		//void remove();		Dette er valgfritt.

	}

	


	/*
	public static void main(String[] args) {
		Lenkeliste<String> ourList = new Lenkeliste<String>();
		ourList.leggTil("HEI");
		ourList.leggTil("PAA");
		ourList.leggTil("DEG");

		for (String element : ourList ) {
			System.out.println(element);
		}

	}

	*/
}



/*
$ javac *.java && java TestLenkeliste
Test tom liste
- Test 1: OK

Test ett element
- Test 2: OK
- Test 3: OK
- Test 4: OK
- Test 5: OK

Test leggTil() og fjern() med flere elementer
- Test 6: OK
- Test 7: OK
- Test 8: OK
- Test 9: OK
- Test 10: OK
- Test 11: OK

Test leggTil() og leggTil(pos) paa indeks
- Test 12: OK
- Test 13: OK
- Test 14: OK
- Test 15: OK
- Test 16: OK
- Test 17: OK

Test fjern(pos) og sett(pos, x) med indekser
- Test 18: OK
- Test 19: OK
- Test 20: OK
- Test 21: OK
- Test 22: OK
- Test 23: OK

Test unntak
- Test 24: OK
- Test 25: OK
- Test 26: OK
- Test 27: OK
- Test 28: OK
- Test 29: OK
- Test 30: OK
- Test 31: OK
- Test 32: OK
- Test 33: OK
- Test 34: OK
- Test 35: OK
- Test 36: OK

36 tester ferdig
36 passerte, 0 feil

*/
