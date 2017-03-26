/**
 * 
 */
package com.jpmorgan.trade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Trade {
	
	/**
	 * To generate report based on the incoming and outgoing entities everyday
	 * @param entityList
	 */
	public void getTradeReport(List<Entity> entityList){
		HashMap<String,Double> incomingMap = new HashMap<String,Double>();
		HashMap<String,Double> outgoingMap = new HashMap<String,Double>();

		retInAndOutEntityData(entityList, incomingMap, outgoingMap);
		
		entriesSortedByValues(incomingMap);
		System.out.println("\nRankings of entities based on total incoming and outgoing amounts");
		System.out.println("INCOMING:");
		getRanks(entriesSortedByValues(incomingMap));
		System.out.println("OUTGOING:");
		getRanks(entriesSortedByValues(outgoingMap));
		
	}

	/**
	 * To Calculate amount based on the incoming and outgoing entities
	 * @param entityList
	 * @param incomingMap
	 * @param outgoingMap
	 */
	private void retInAndOutEntityData(List<Entity> entityList, HashMap<String, Double> incomingMap,
			HashMap<String, Double> outgoingMap) {
		for(Entity entity : entityList){
			while (isBankHoliday(entity.getSettlementDate(),entity.getCurrency())) {
				entity.setSettlementDate(addDays(entity.getSettlementDate(), 1));
			}
			double amount = entity.getPricePerUnit()*entity.getUnits()*entity.getAgreedFx();
			if("B".equalsIgnoreCase(entity.getBuy_or_sell())){
				outgoingMap.put(entity.getEntityName(), entity.getPricePerUnit()*entity.getUnits()*entity.getAgreedFx());
				System.out.println("Outgoing amount settled for the entity "+entity.getEntityName()+" on "+entity.getSettlementDate()+" is USD "+amount);
			}else{
				incomingMap.put(entity.getEntityName(), entity.getPricePerUnit()*entity.getUnits()*entity.getAgreedFx());
				System.out.println("Incoming amount settled for the entity "+entity.getEntityName()+" on "+entity.getSettlementDate()+" is USD "+amount);

			}
	}
	}
	
	/**
	 * To display the rank of each entity
	 * @param entry
	 */
	private void getRanks(List<Entry<String,Double>> entry){
		int rank = 0;
		for(Entry<String, Double> eachEntry:entry){
			rank++;
			        System.out.println(rank+". " +eachEntry.getKey()+" " +eachEntry.getValue());
			  }
		
	}
	/**
	 * To add the number of days to the date given if it is not the week day
	 * @param d
	 * @param days
	 * @return
	 */
	private Date addDays(Date d, int days) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(d);
	    cal.add(Calendar.DATE, days);
	    return cal.getTime();
	}
	
	/**
	 * To verify whether the date given is the working day or not.
	 * @param date
	 * @param currency
	 * @return
	 */
	@SuppressWarnings("static-access")
	private boolean isBankHoliday(java.util.Date date,String currency) {
	    Calendar c = new GregorianCalendar();
	    c.setTime(date);
	    if("AED".equalsIgnoreCase(currency) || "SAR".equalsIgnoreCase(currency)){
	    	
	     if((Calendar.FRIDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SATURDAY == c.get(c.DAY_OF_WEEK))) {
	        return true;
	    } else {
	        return false;
	    }
	     
	    }else {
	    	if((Calendar.SATURDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SUNDAY == c.get(c.DAY_OF_WEEK))) {
		        return (true);
		    } else {
		        return false;
	    }
	    }
	}

	


/**
 * To calculate the rank of entity based on amount
 * @param map
 * @return
 */
private <K,V extends Comparable<? super V>> 
List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

Collections.sort(sortedEntries, 
    new Comparator<Entry<K,V>>() {
        @Override
        public int compare(Entry<K,V> e1, Entry<K,V> e2) {
            return e2.getValue().compareTo(e1.getValue());
        }
    }
);

return sortedEntries;
}

}
 