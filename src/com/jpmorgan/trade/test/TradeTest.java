package com.jpmorgan.trade.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jpmorgan.trade.Entity;
import com.jpmorgan.trade.Trade;

public class TradeTest {

	@Test
	public void testGetTradeReport() throws ParseException{
		Trade trade = new Trade();
		Entity entity = new Entity();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Entity> entityList = new ArrayList<Entity>();
		
		entity.setEntityName("Foo");
		entity.setCurrency("SGP");
		entity.setBuy_or_sell("B");
		entity.setAgreedFx(0.50);
		entity.setPricePerUnit(100.25);
		entity.setSettlementDate(sdf.parse("02-01-2016"));
		entity.setInstructionDate(sdf.parse("01-01-2016"));
		entity.setUnits(200);
		entityList.add(entity);
		
		entity = new Entity();
		entity.setEntityName("Bar");
		entity.setCurrency("AED");
		entity.setBuy_or_sell("s");
		entity.setAgreedFx(0.22);
		entity.setPricePerUnit(150.5);
		entity.setSettlementDate(sdf.parse("07-01-2016"));
		entity.setInstructionDate(sdf.parse("05-01-2016"));
		entity.setUnits(450);
		entityList.add(entity);
		
		entity = new Entity();
		entity.setEntityName("Wine");
		entity.setCurrency("GBP");
		entity.setBuy_or_sell("s");
		entity.setAgreedFx(1.50);
		entity.setPricePerUnit(85.5);
		entity.setSettlementDate(sdf.parse("05-03-2017"));
		entity.setInstructionDate(sdf.parse("04-03-2017"));
		entity.setUnits(500);
		entityList.add(entity);
		
		entity = new Entity();
		entity.setEntityName("Drinks");
		entity.setCurrency("SAR");
		entity.setBuy_or_sell("B");
		entity.setAgreedFx(0.22);
		entity.setPricePerUnit(160.5);
		entity.setSettlementDate(sdf.parse("17-03-2017"));
		entity.setInstructionDate(sdf.parse("16-03-2017"));
		entity.setUnits(600);
		entityList.add(entity);
		
		
		
		
		trade.getTradeReport(entityList);
	}
}
