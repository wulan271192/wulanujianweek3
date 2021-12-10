package com.ujianweek3.sqa;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ujianweek3.sqa.function.KonversiSuhu;

public class TestFungsiKonversi {
	KonversiSuhu function;

	@Before
	public void setUp() throws Exception {
		function = new KonversiSuhu();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKonversiSuhu() {
	
			for (String isi : readfile("KonversiSuhu.csv")) {
				
				
				String []data = isi.split(";");
				String fahrenheit = data[0];
				String celcius = data[1];
				System.out.println(fahrenheit+ "," +celcius );
				
				
				assertEquals(Double.parseDouble(celcius), function.KonversiSuhu(Double.parseDouble(fahrenheit)), 0.00001);
				
			}
			
			
			
		}

	public List<String> readfile(String namefile) {
		List<String> penampung = new ArrayList<String>();
		
		try
		{
			
			
			//File myFile = new File(nameFile);
			InputStream myFile =getClass().getClassLoader().getResourceAsStream(namefile);
			
			Scanner reader = new Scanner(myFile);
			
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
			
	}catch (Exception e) {
		e.printStackTrace();

	}
		return penampung;
	}
		
@Test
public void testAngkaNegatif() {
assertEquals(-5, function.KonversiSuhu(23),-0.00001);
	
}
@Test
public void testBukanAngka() {
assertEquals(aaaa, function.KonversiSuhu(aaaa),0.00001);
}
@Test
public void testTidakDimasukanAngka() {
assertEquals(0, function.KonversiSuhu(32),0.000000);
}




	
	}


