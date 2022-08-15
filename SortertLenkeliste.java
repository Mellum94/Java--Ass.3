public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{



	/*
	Kallet på leggTil(T x) setter inn elementer
	i sortert rekkefølge (fra minst til størst), når vi bruker fjern()-metoden (uten parametere)
	tas det største elementet ut.
	*/ 



	SortertLenkeliste(){
		super();
	}

	@Override
	public void leggTil(T x){
		if (this.stoerrelse() == 0){
			super.leggTil(x);
			return; //avslutter 
			
		}

		for (int i = 0; i < this.stoerrelse(); i++) {

			if(hent(i).compareTo(x) >= 0){
				super.leggTil(i, x);
				return;
			}

		}

		super.leggTil(x);
		return;

	}
	@Override
	public T fjern(){
	
		//Fjerner siste element i listen.

		int liste = this.stoerrelse();
		T retur = super.fjern(liste-1);
		return retur; 

	}

	public void sett(int pos, T x) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public void leggTil(int pos, T x) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}


/*

$ javac *.java && java TestSortertLenkeliste
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
- Test 12: OK

Test leggTil() med Integer i stedet for String
- Test 13: OK

Test fjern(pos) med indekser
- Test 14: OK
- Test 15: OK
- Test 16: OK
- Test 17: OK
- Test 18: OK

Test unntak
- Test 19: OK
- Test 20: OK
- Test 21: OK
- Test 22: OK
- Test 23: OK
- Test 24: OK
- Test 25: OK
- Test 26: OK
- Test 27: OK
- Test 28: OK
- Test 29: OK
- Test 30: OK
- Test 31: OK

31 tester ferdig
31 passerte, 0 feil

*/


