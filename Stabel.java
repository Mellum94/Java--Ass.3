public class Stabel<T> extends Lenkeliste<T>{
	/*
	Klassen skal arve fra Lenkeliste<T>, men har i tillegg
	metodene leggPaa (T x) og taAv(). Disse metodene legger til og fjerner
	elementer fra slutten av listen, slik at det siste elementet som legges inn er det første som
	tas ut (Last in, First out).
	*/

	public Stabel(){
		super();
	}

	public void leggPaa (T x){
	this.leggTil(x);
	}

	public T taAv(){
	int listeLengde = this.stoerrelse();
	T print = this.fjern(listeLengde-1);
	return print;
	}
}





/*
vivianmellum$ javac *.java && java TestStabel
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

Test stabel-spesifikke metoder leggPaa og taAv
- Test 37: OK
- Test 38: OK
- Test 39: OK
- Test 40: OK
- Test 41: OK
- Test 42: OK
- Test 43: OK
- Test 44: OK

44 tester ferdig
44 passerte, 0 feil

*/