package com.saleit.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.saleit.dao.ItemDao;
import com.saleit.domains.Items;

public class CommonServices {
public String generateOrderNumber(String userId) {
	StringBuffer orderNumber= new StringBuffer();
	DateFormat dateFormat = new SimpleDateFormat("ddMMYYHHmmss");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	Date date1 = calendar.getTime();
	String day =new SimpleDateFormat("EE", Locale.ENGLISH).format(date1.getTime());
	orderNumber.append(day.toUpperCase());
	orderNumber.append(dateFormat.format(date));
	orderNumber.append(updateCharacterCountOfSamllerString(4,userId.substring(Math.max(0, userId.length() - 4))));
	return orderNumber.toString();
}

public String updateCharacterCountOfSamllerString(int count, String data) {
	String updatedData = data;
	StringBuffer updatedData1= new StringBuffer();
	if(data.length()<count) {
	for(int i=0;i<count-data.length();i++) {
		updatedData1.append('0');
	}
	updatedData1.append(data);
	updatedData= updatedData1.toString();
	}
	return updatedData;
}
public double roundUptwoDoubleValues(double values) {
	 BigDecimal bd = new BigDecimal(values);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    double roundedValue= bd.doubleValue();
	    return roundedValue;
}

public Items fetchItemByItemId(String itemID)  {
	Items items = new Items();
	ItemDao itemDao= new ItemDao();
	List<Items> itemList =new ArrayList<Items>();
	try {
		itemList= itemDao.fetchAllItems();
		for(Items items2 :itemList) {
			if(items2.getItemId().equals(itemID)) {
				return items2;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return items;
}

}
