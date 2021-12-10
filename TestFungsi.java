package com.ujianweek3.sqa;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ujianweek3.sqa.function.KelilingKolam;
import com.ujianweek3.sqa.function.VolumeKolam;

public class TestFungsi {
	KelilingKolam function;
	
	

	@Before
	public void setUp() throws Exception {
		function = new KelilingKolam();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//kelilingkolam
	@Test
	public void testKelilingKolam() {
		
		for (String isi : readfile("ujianjavaweek3.csv")) {
			
			
			String []data = isi.split(";");
			String panjang = data[0];
			String lebar = data[1];
			String tinggi = data[2];
			String hasil = data[3];
			System.out.println(panjang+ "," +lebar+ "," +tinggi+ ","+hasil );
			
			
			assertEquals(Double.parseDouble(hasil), function.kelilingKolam(Double.parseDouble(panjang), Double.parseDouble(lebar), Double.parseDouble(tinggi)), 0.0);
			
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
	assertEquals(-82, function.kelilingKolam(-5.5, -12.0, -3.0),0.0);
	
	}
@Test
public void testBukanAngka() {
assertEquals(82, function.kelilingKolam(aaa, -12.0, -3.0),0.0);
}
@Test
public void testTidakDimasukanAngka() {
assertEquals(0, function.kelilingKolam(0, 0, 0),0.0);
}
}







