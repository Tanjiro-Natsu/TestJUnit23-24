
public class CifraturaMonoAlfabetica {
	private   String cifrare=null;
	public  int random;
	public  int createrandom() {return ((int)(Math.random()*10))+1;}
	public  void setStringCriptata(String stringa){cifrare=stringa;};
public static void main (String [] args ) {

	/*int t=0;
	
	while(true) {
		System.out.println("Inserire una frase che si vuole criptare con la cifratura mono alfabetica");
		Scanner a=new Scanner (System.in);
		cifrare=a.nextLine();
		for(int i=0;i<cifrare.length();i++) {
			if(cifrare.charAt(i)>122) {
				t=1;
				break;
			}
		}
		if(t==0) {break;}
		t=0;
	} */
	
	
}
public static String cifraturaMonoAlfabetica(int valore,int chiave) {
	String cifrata = null;
	int y=0;
	if (valore==32){
		cifrata=" ";
		y=1;
	}
	else {
	if(y!=1) {
		int valorechar=0;
		valore=valore+chiave;
		if(valore>122) {
			valorechar=valore-122;
			cifrata=String.valueOf(((char)(valorechar+97)));
		}
		else {
			cifrata=String.valueOf(((char)(valore)));
		}
		
	}}

	
	
	return cifrata;
}
public  String cifratura(String cifrare) {
	String criptata="";
random=createrandom();
	int t=cifrare.length();
	
	for(int i=0;i<t;i++) {
		int codiceAscii=(int)(cifrare.charAt(i));
	criptata=criptata+cifraturaMonoAlfabetica(codiceAscii,random);}
	return criptata;
}

}

