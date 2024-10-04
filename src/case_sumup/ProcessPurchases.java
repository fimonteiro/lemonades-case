package case_sumup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessPurchases {


	public static void main(String[] args) {	
		List<Map<String , Integer>> purchases  = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> purchase1 = new HashMap<String, Integer>();
		Map<String, Integer> purchase2 = new HashMap<String, Integer>();
		Map<String, Integer> purchase3 = new HashMap<String, Integer>();

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

		System.out.println(processBill(purchases));
	}


	public static ArrayList<Integer> processBill(List<Map<String , Integer>> bill) {

		int priceLemonade = 5;
		int totalValueLemonadeUser;
		int totalMoneyOfUser;

		int fiveDolars = 0;
		int tenDolars = 0;
		int twentyDolars = 0;

		ArrayList<Integer> myChange = new ArrayList<Integer>();
		ArrayList<Integer> shouldRefundToUser = new ArrayList<Integer>();
		ArrayList<Integer> finalChange = new ArrayList<Integer>();

		Collections.sort(bill, new Comparator<Map<String, Integer>>() {
			public int compare(final Map<String, Integer> identifier, final Map<String, Integer> position) {
				return identifier.get("position_in_line").compareTo(position.get("position_in_line"));
			}});


		for (Map<String, Integer> validateBuyer : bill) {			  
			myChange.add(validateBuyer.get("bill_value"));
			totalValueLemonadeUser = validateBuyer.get("requested_lemonades") * priceLemonade;
			totalMoneyOfUser = validateBuyer.get("bill_value");
			shouldRefundToUser.add(totalMoneyOfUser - totalValueLemonadeUser);
		}

		if(shouldRefundToUser.get(0) > 0) {
			return null;
		}

		for(int i = 0; i < myChange.size(); i++) {
			int moneyToRefund = shouldRefundToUser.get(i);
			int moneyFromUser = myChange.get(i);
			if(shouldRefundToUser.get(i) == 0) {
				finalChange.add(myChange.get(i));
				switch(myChange.get(i)) {
				case 5:
					fiveDolars++;
					break;
				case 10:
					tenDolars++;
					break;
				case 20:
					twentyDolars++;
					break;
				}
			} else {
				if(fiveDolars > 0 || tenDolars > 0 || twentyDolars > 0) {
					switch(moneyToRefund) {
					case 5:
						if(moneyFromUser == 10 && fiveDolars == 1) {
							fiveDolars--;
							tenDolars++;
							finalChange.clear();
							finalChange.add(myChange.get(i));
						} else if (moneyFromUser == 20 && fiveDolars > 0) {
							fiveDolars--;
							twentyDolars++;
							finalChange.clear();
							finalChange.add(myChange.get(i));
						} else if (moneyFromUser == 20 && fiveDolars == 0) {
							return null;
						}
						break;
					case 10:
						if(fiveDolars == 2 && moneyFromUser != 20) {
							fiveDolars = fiveDolars - 2;
						} else {
							fiveDolars = fiveDolars - 2;
							twentyDolars++;
							finalChange.clear();
							finalChange.add(myChange.get(i));
						}
						break;
					case 15:
						if(moneyFromUser == 20 && fiveDolars > 0 && tenDolars > 0) {
							fiveDolars = 0;
							tenDolars = 0;
							twentyDolars++;
							finalChange.clear();
							finalChange.add(myChange.get(i));
						} else if (moneyFromUser == 20 && fiveDolars == 3) {
							fiveDolars = 0;
							twentyDolars++;
							finalChange.clear();
							finalChange.add(myChange.get(i));
						}
						break;
					default:
						return null;
					}
				} else {
					return null;
				}
			} 
		}
		return finalChange;
	}
}
