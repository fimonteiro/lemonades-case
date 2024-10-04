# lemonades-case

# Requisites
- Java
# Description
The ProcessPurchases class is a Java program designed to handle a basic simulation of lemonade purchases, where customers pay using various denominations of bills, and the system calculates the correct change based on available funds.

If the first client buy one limonade for 5 dol and the second one buy two limonades paying 10 dol, we need to change 5 dol and keep just the 10 dol. 

Each purchase is represented as a `Map<String, Integer>` where the keys represent
- **bill_value:** Money used by the customer ($5, $10 or $20)
- **position_in_line:** The position of the customer in the queue
- **requested_lemonades:** The number of lemonades requested by the customer.

# Solution
- The solution of the case is on `src/case_sumup/ProcessPurchases.java`
- Test and validate different scenarios is on `src/test/ProcessPurchasesTest.java`

### Change Calculation:
The program calculates whether the customer should receive change after purchasing lemonade, based on a fixed lemonade price ($5).

Also tracks how much we have of money to change to the customer the correct change. If we don't have money enough, will return `null`.

### processBill method
This method processes the list of purchases and calculates the change for each customer. It follows these steps:

**Sort the customers by their position in line:**
```
Collections.sort(bill, new Comparator<Map<String, Integer>>() {
			public int compare(final Map<String, Integer> identifier, final Map<String, Integer> position) {
				return identifier.get("position_in_line").compareTo(position.get("position_in_line"));
			}});
```
**For each customer:**
- Calculate the total value of lemonade they requested (price per lemonade is $5 * requested_lemonades).
- Determine the amount of money they should be refunded to the client `shouldRefundToUser.add(totalMoneyOfUser - totalValueLemonadeUser)`.

**Check availability of bills:**
- Track how many $5, $10, and $20 bills are available for providing change. Using a `for` and `switch` for different cases.

**Return Change:**
- If the correct change can be provided, the program returns an ArrayList<Integer> representing the final state of bill.
- If change cannot be provided, the function returns `null`.
