package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import case_sumup.ProcessPurchases;

class ProcessPurchasesTest {

	@Test
	@DisplayName("Validate if return [10, 5]")
	void processBill10_5() {
		ProcessPurchases processPurchases = new ProcessPurchases();
		List<Map<String , Integer>> purchases  = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> purchase1 = new HashMap<String, Integer>();
		Map<String, Integer> purchase2 = new HashMap<String, Integer>();
		Map<String, Integer> purchase3 = new HashMap<String, Integer>();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10, 5));
		
	    purchase1.put("bill_value", 10);
	    purchase1.put("position_in_line", 2);
	    purchase1.put("requested_lemonades", 1);
	    
	    purchase2.put("bill_value", 5);
	    purchase2.put("position_in_line", 1);
	    purchase2.put("requested_lemonades", 1);
	    
	    purchase3.put("bill_value", 5);
	    purchase3.put("position_in_line", 3);
	    purchase3.put("requested_lemonades", 1);	    
	    
	    purchases.add(0,purchase1);
	    purchases.add(1,purchase2);
	    purchases.add(2,purchase3);

	    assertEquals(expected, processPurchases.processBill(purchases));
	}
	
	@Test
	@DisplayName("Validate if return [20]")
	void processBill20() {
		ProcessPurchases processPurchases = new ProcessPurchases();
		List<Map<String , Integer>> purchases  = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> purchase1 = new HashMap<String, Integer>();
		Map<String, Integer> purchase2 = new HashMap<String, Integer>();
		Map<String, Integer> purchase3 = new HashMap<String, Integer>();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(20));
		
		purchase1.put("bill_value", 20);
	    purchase1.put("position_in_line", 3);
	    purchase1.put("requested_lemonades", 2);
	    
	    purchase2.put("bill_value", 5);
	    purchase2.put("position_in_line", 2);
	    purchase2.put("requested_lemonades", 1);
	    
	    purchase3.put("bill_value", 5);
	    purchase3.put("position_in_line", 1);
	    purchase3.put("requested_lemonades", 1);
	    
	    purchases.add(0,purchase1);
	    purchases.add(1,purchase2);
	    purchases.add(2,purchase3);

	    assertEquals(expected, processPurchases.processBill(purchases));
	}

	
	@Test
	@DisplayName("Validate if return [10]")
	void processBill10() {
		ProcessPurchases processPurchases = new ProcessPurchases();
		List<Map<String , Integer>> purchases  = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> purchase1 = new HashMap<String, Integer>();
		Map<String, Integer> purchase2 = new HashMap<String, Integer>();
		Map<String, Integer> purchase3 = new HashMap<String, Integer>();
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(10));
		
	    purchase1.put("bill_value", 10);
	    purchase1.put("position_in_line", 2);
	    purchase1.put("requested_lemonades", 1);
	    
	    purchase2.put("bill_value", 5);
	    purchase2.put("position_in_line", 1);
	    purchase2.put("requested_lemonades", 1);
	    
	    purchases.add(0,purchase1);
	    purchases.add(1,purchase2);

	    assertEquals(expected, processPurchases.processBill(purchases));
	}

	@Test
	@DisplayName("Validate if return null, given that we don't have change")
	void processBill_null() {
		ProcessPurchases processPurchases = new ProcessPurchases();
		List<Map<String , Integer>> purchases  = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> purchase1 = new HashMap<String, Integer>();
		Map<String, Integer> purchase2 = new HashMap<String, Integer>();
		Map<String, Integer> purchase3 = new HashMap<String, Integer>();
		
		
	    purchase1.put("bill_value", 10);
	    purchase1.put("position_in_line", 2);
	    purchase1.put("requested_lemonades", 2);
	    
	    purchase2.put("bill_value", 10);
	    purchase2.put("position_in_line", 1);
	    purchase2.put("requested_lemonades", 1);
	    
	    purchases.add(0,purchase1);
	    purchases.add(1,purchase2);

	    assertEquals(null, processPurchases.processBill(purchases));
	}


}
