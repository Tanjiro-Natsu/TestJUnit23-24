package io;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ArbitrarySupplier;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

class CifraturaMonoAlfabeticaPBTest {

	@Property
	@StatisticsReport(format=Histogram.class)
	void cifraturaPBTest(@ForAll(supplier=prova.class)String decifrare) {
		Statistics.label("stringa").collect(decifrare);
		CifraturaMonoAlfabetica s=new CifraturaMonoAlfabetica();
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
	assertTrue(prova.equals(cifrata));
	}
	@Property
	@StatisticsReport(format=Histogram.class)
	void cifraturaMonoAlfabeticaPbTest(@ForAll @IntRange(min=0,max=61)int value,@ForAll @IntRange(min=0,max=61)int key) {
		Statistics.label("value").collect(value);
		Statistics.label("key").collect(key);
		if(32==value) {
			assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(value,key).equals(String.valueOf((char)(value))));	
		}
		else {
		assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(value,key).equals(String.valueOf((char)(value+key))));
		}
	}
	
	@Property
	@StatisticsReport(format=Histogram.class)
	void cifraturaMonoAlfabeticaPbTestOutOfBound(@ForAll @IntRange(min=62,max=300)int value,@ForAll @IntRange(min=61,max=300)int key) {
		Statistics.label("value").collect(value);
		Statistics.label("key").collect(key);
		assertTrue(CifraturaMonoAlfabetica.cifraturaMonoAlfabetica(value,key).equals(String.valueOf((char)(value+key-122+97))));
		
	}
	
		
	public class prova implements ArbitrarySupplier<String>{
		public Arbitrary<String> get(){
			return Arbitraries.strings().withCharRange(((char)(0)),((char)(122))).ofMinLength(0).ofMaxLength(1402);
		}	
	}
	
	
}
