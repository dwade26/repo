package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany mangementCo,managementCo2,managementCo3,managementCo4 ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
		managementCo2 = new ManagementCompany(mangementCo);
		managementCo3 = new ManagementCompany();
		managementCo4 = new ManagementCompany("Bob", "123456789",2,1,1,2,2);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=managementCo2=managementCo3=managementCo4=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		Property nullProperty=null;
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty("A","Red",1000,"Me"),1,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",9,9,1,1),2,0);
		assertEquals(mangementCo.addProperty("C","Green",1000,"Me"),-4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",8,8,1,1),3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",15,15,1,1),-3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",7,7,1,1),4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",1,9,1,1),-1,0);
		assertEquals(mangementCo.addProperty(nullProperty),-2,0);
	}
	
	@Test
	public void testRemoveLastProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		Property nullProperty=null;
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty("A","Red",1000,"Me"),1,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",9,9,1,1),2,0);
		assertEquals(mangementCo.addProperty("C","Green",1000,"Me"),-4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",8,8,1,1),3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",15,15,1,1),-3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",7,7,1,1),4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",1,9,1,1),-1,0);
		assertEquals(mangementCo.addProperty(nullProperty),-2,0);
		
		mangementCo.removeLastProperty();
		assertEquals(mangementCo.getPropertiesCount(),4);
		mangementCo.removeLastProperty();
		assertEquals(mangementCo.getPropertiesCount(),3);
		mangementCo.removeLastProperty();
		mangementCo.removeLastProperty();
		mangementCo.removeLastProperty();
		assertEquals(mangementCo.getPropertiesCount(),0);
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);
		
	}
	
	
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}
	
	@Test
	public void testGetHighestRentProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		Property nullProperty=null;
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty("A","Red",1000,"Me"),1,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",9,9,1,1),2,0);
		assertEquals(mangementCo.addProperty("C","Green",1000,"Me"),-4,0);
		assertEquals(mangementCo.addProperty("B","Blue",3000,"Me",8,8,1,1),3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",15,15,1,1),-3,0);
		
		assertEquals(mangementCo.addProperty(nullProperty),-2,0);
		
		assertEquals(mangementCo.getHighestRentPropperty().toString(),"B,Blue,Me,5000.0");
		assertEquals(managementCo2.getHighestRentPropperty(),null);
		assertEquals(mangementCo.addProperty("B","Blue",6000,"Me",7,7,1,1),4,0);
		assertEquals(mangementCo.getHighestRentPropperty().toString(),"B,Blue,Me,6000.0");
	}
	
	@Test
	public void testGetTotalRent() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		Property nullProperty=null;
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty("A","Red",1000,"Me"),1,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",9,9,1,1),2,0);
		assertEquals(mangementCo.addProperty("C","Green",1000,"Me"),-4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",8,8,1,1),3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",15,15,1,1),-3,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",7,7,1,1),4,0);
		assertEquals(mangementCo.addProperty("B","Blue",5000,"Me",1,9,1,1),-1,0);
		assertEquals(mangementCo.addProperty(nullProperty),-2,0);
		
		assertEquals(mangementCo.getTotalRent(), 18613);
		assertEquals(managementCo2.getTotalRent(), 0);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 156.78";
		System.out.println(expectedString);
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
		assertEquals(managementCo2.addProperty(sampleProperty), 0);
		assertEquals(expectedString, managementCo2.toString());
		String expectedString2 = "List of the properties for , taxID: \n"
				+ "______________________________________________________\n"
				
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 0.0";
		assertEquals(expectedString2, managementCo3.toString());
		assertEquals(managementCo4.addProperty("A","B",100,"C",1,1,1,1), 0);
		String expectedString3 = "List of the properties for Bob, taxID: 123456789\n"
				+ "______________________________________________________\n"
				+ "A,B,C,100.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 2.0";
		assertEquals(expectedString3, managementCo4.toString());
				
	}

}
