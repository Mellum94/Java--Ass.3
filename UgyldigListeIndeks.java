
class UgyldigListeIndeks extends RuntimeException {
	/*
	Når vi arbeider med indekser kan vi møte på feil dersom vi forsøker å nå en indeks som
	ikke eksisterer. For å ta høyde for eventuelle feil brukes unntaksklassen. 
	*/
		UgyldigListeIndeks(int indeks) {
			super("Ugyldig indeks: " + indeks);
		}
	}
