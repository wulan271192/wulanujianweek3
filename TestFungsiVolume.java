package com.ujianweek3.sqa;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ujianweek3.sqa.function.VolumeKolam;

public class TestFungsiVolume {
	VolumeKolam functionvolume;

	@Before
	public void setUp() throws Exception {
		functionvolume = new VolumeKolam();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVolumeKolam() {
		for (String isi : readfile("skenario_volume.csv")) {
		
		
		String []data = isi.split(";");
		String panjang = data[0];
		String lebar = data[1];
		String tinggi = data[2];
		String hasil = data[3];
		System.out.println(panjang+ "," +lebar+ "," +tinggi+ ","+hasil );
		
		
		assertEquals(Double.parseDouble(hasil), functionvolume.VolumeKolam(Double.parseDouble(panjang), Double.parseDouble(lebar), Double.parseDouble(tinggi)), 0.0);
		
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
	public void testBukanAngkaKolam() {
		assertEquals(198, functionvolume.VolumeKolam(aaaa, 12, 3.0),0.0);
		
	}

	@Test
	public void testAngkaNegatifKolam() {
		assertEquals(-198, functionvolume.VolumeKolam(-5.5, 12, 3.0),0.0);
		
	}

	@Test
	public void testTidakDimasukanAngkaKolam() {
		assertEquals(0, functionvolume.VolumeKolam(0, 0, 0),0.0);
		
	}
	}

