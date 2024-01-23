import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCifraturaMonoAlfabetica {
	CifraturaMonoAlfabetica s=null;
	@BeforeEach
	public void setCifraturaMonoAlfabetica() {
		s=new CifraturaMonoAlfabetica();
	}
@Test
public void BlankStringTest() {
	String prova=" ";
	String result =s.cifratura(prova);
	System.out.println(new StringBuilder().append("Stringa iniziale:'").append(prova).append("'\nStringa criptata:'").append(result).append("'"));
assertTrue(prova.equals(result));
}

@Test
public void EmptyStringTest() {
	String prova="";
	String result =s.cifratura(prova);
	System.out.println(new StringBuilder().append("Stringa iniziale:'").append(prova).append("'\nStringa criptata:'").append(result).append("'"));
assertTrue(prova.isEmpty() && result.isEmpty());
}

@Test
public void NullStringTest() {
	String prova=null;
assertThrows(Exception.class,()->{s.cifratura(prova);});

}
@Test
public void cifraturaTestDefinitivo() {
	String decifrare="HomeWork sviluppo test case";
	String cifrata=s.cifratura(decifrare);
	Field field=null;
	int shift=0;
	try {
	field=s.getClass().getDeclaredField("random");
	shift=field.getInt(s);}
	catch(Exception e) {System.out.println(e.getMessage());}
	
String prova ="";
for(int u=0;u<decifrare.length();u++){
	if(u==0) {
		prova=CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(decifrare.charAt(u),shift);
	}
	else {
		prova=new StringBuilder().append(prova).append(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(decifrare.charAt(u),shift)).toString();
	}
}
	System.out.println(new StringBuilder().append("Stringa usando il metodo cifrare:").append(cifrata));
	System.out.println(new StringBuilder().append("Stringa usando il metodo cifraturaMonoalfabetica").append(prova));
	assertTrue(prova.equals(cifrata));
			
}
@Test
public void cifraturaTestparticularcharacter() {
	String decifrare="HomeWork sviluppo test case with particular character: {}";
	String cifrata=s.cifratura(decifrare);
	Field field=null;
	int shift=0;
	try {
	field=s.getClass().getDeclaredField("random");
	shift=field.getInt(s);}
	catch(Exception e) {System.out.println(e.getMessage());}
	
String prova ="";
for(int u=0;u<decifrare.length();u++){
	if(u==0) {
		prova=CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(decifrare.charAt(u),shift);
	}
	else {
		prova=new StringBuilder().append(prova).append(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(decifrare.charAt(u),shift)).toString();
	}
}
	System.out.println(new StringBuilder().append("Stringa usando il metodo cifrare:").append(cifrata));
	System.out.println(new StringBuilder().append("Stringa usando il metodo cifraturaMonoalfabetica").append(prova));
	assertTrue(prova.equals(cifrata));
			
}

@Test
public void cifraturaMonoAlfabeticaTestDefinitivo() {
     Assertions.assertAll("Verifica metodo cifraturaMonoAlfabetica",
    		    ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(197,3).equals(String.valueOf((char)(197+3-122+97)))),
    		()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(222,0).equals(String.valueOf((char)(222+0-122+97)))),
    		  ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(0,256).equals(String.valueOf((char)(256-122+97)))),
    		    ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(250,250).equals(String.valueOf((char)(250+250-122+97)))),
    		    ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(730,730).equals(String.valueOf((char)(730+730-122+97)))),
    		  ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(0,0).equals(String.valueOf((char)(0+0)))),
    		    ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(133,0).equals(String.valueOf((char)(133+0-122+97)))),
    		  ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(0,111).equals(String.valueOf((char)(111)))),
    		  ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(0,223).equals(String.valueOf((char)(223-122+97)))),
    		   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(55,0).equals(String.valueOf((char)(55)))),
    		   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(13,111).equals(String.valueOf((char)(111+13-122+97)))),
    		   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(33,151).equals(String.valueOf((char)(151+33-122+97)))),
    		   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(44,730).equals(String.valueOf((char)(44+730-122+97)))),
    	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(134,111).equals(String.valueOf((char)(111+134-122+97)))),
    	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(200,131).equals(String.valueOf((char)(200+131-122+97)))),
    	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(255,711).equals(String.valueOf((char)(255+711+97-122))))
    		 );
         
}
@Test
public void cifraturaMonoAlfabeticaTestspace(){
	Assertions.assertAll("Verifica metodo cifraturamonoalfabetica caso particolare \"\"",
 		   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(32,0).equals(" ")),
     	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(32,11).equals(" ")),
     	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(32,127).equals(" ")),
     	   ()->assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(32,300).equals(" ")));
}


}























