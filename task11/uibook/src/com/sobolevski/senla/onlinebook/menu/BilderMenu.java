package com.sobolevski.senla.onlinebook.menu;

import java.util.ArrayList;
import java.util.List;

import com.sobolevski.senla.onlinebook.action.AddNewBookAction;
import com.sobolevski.senla.onlinebook.action.AddNewCustomerAction;
import com.sobolevski.senla.onlinebook.action.AddNewOrderAction;
import com.sobolevski.senla.onlinebook.action.AddNewWriterAction;
import com.sobolevski.senla.onlinebook.action.DeleteBookAction;
import com.sobolevski.senla.onlinebook.action.PrintBookActionAll;
import com.sobolevski.senla.onlinebook.action.PrintCustomerAllAction;
import com.sobolevski.senla.onlinebook.action.PrintOrderAllAction;
import com.sobolevski.senla.onlinebook.action.PrintWriterAllAction;
import com.sobolevski.senla.onlinebook.action.QuantityFinishOrderAction;
import com.sobolevski.senla.onlinebook.action.SortBookDateAction;
import com.sobolevski.senla.onlinebook.action.SortBookPriceAction;
import com.sobolevski.senla.onlinebook.action.SortBookStage;
import com.sobolevski.senla.onlinebook.action.SortNameBookAction;
import com.sobolevski.senla.onlinebook.action.SortOrderPriceAction;

public class BilderMenu {
	private List<IMenu> listmenu;

	public BilderMenu() {
		listmenu = new ArrayList<IMenu>();
		IMenu menu1 = new Menu("Work to databases book", 1);
		IMenu menu2 = new Menu("Work to databases order", 2);
		IMenu menu3 = new Menu("Work to databases writer", 3);
		IMenu menu4 = new Menu("Work to databases customer", 4);
		IMenu menu5 = new Menu("Exit", 5);
		IMenu menubook1 = new Menu("Print all book", 1, new PrintBookActionAll());
		IMenu menubook2 = new Menu("Add new book", 2, new AddNewBookAction());
		IMenu menubook3 = new Menu("Delete book", 3, new DeleteBookAction());
		IMenu menubook4 = new Menu("Print sort Book Name", 4, new SortNameBookAction());
		IMenu menubook5 = new Menu("Print sort Book Price", 5, new SortBookPriceAction());
		IMenu menubook6 = new Menu("Print sort Book Quantity", 6, new SortBookDateAction());
		IMenu menubook7 = new Menu("Export book in CSV", 7, new SortBookStage());
		IMenu menubook8 = new Menu("Import book with CSV", 8, new SortBookStage());
		IMenu menubook9 = new Menu("Exit", 9);
		menu1.setMenuList(menubook1);
		menu1.setMenuList(menubook2);
		menu1.setMenuList(menubook3);
		menu1.setMenuList(menubook4);
		menu1.setMenuList(menubook5);
		menu1.setMenuList(menubook6);
		menu1.setMenuList(menubook7);
		menu1.setMenuList(menubook8);
		menu1.setMenuList(menubook9);
		IMenu menuorder1 = new Menu("Print all order", 1,new PrintOrderAllAction());
		IMenu menuorder2 = new Menu("Add new order", 2,new AddNewOrderAction());
		IMenu menuorder3 = new Menu("Delete order", 3);
		IMenu menuorder4 = new Menu("Print sort  order Date", 4);
		IMenu menuorder5 = new Menu("Export order in CSV", 5,new QuantityFinishOrderAction());
		IMenu menuorder6 = new Menu("Import order with CSV", 6);
		IMenu menuorder7 = new Menu("Exit", 7);
		menu2.setMenuList(menuorder1);
		menu2.setMenuList(menuorder2);
		menu2.setMenuList(menuorder3);
		menu2.setMenuList(menuorder4);
		menu2.setMenuList(menuorder5);
		menu2.setMenuList(menuorder6);
		menu2.setMenuList(menuorder7);

		IMenu menuwriter1 = new Menu("Print all writer", 1,new PrintWriterAllAction());
		IMenu menuwriter2 = new Menu("Add new writer", 2,new AddNewWriterAction());
		IMenu menuwriter3 = new Menu("Delete writer", 3);
		IMenu menuwriter4 = new Menu("Print sort  writer name", 4,new SortOrderPriceAction());
		IMenu menuwriter5 = new Menu("Export writer in CSV", 5,new QuantityFinishOrderAction());
		IMenu menuwriter6 = new Menu("Import writer with CSV", 6);
		IMenu menuwriter7 = new Menu("Exit", 7);
		menu3.setMenuList(menuwriter1);
		menu3.setMenuList(menuwriter2);
		menu3.setMenuList(menuwriter3);
		menu3.setMenuList(menuwriter4);
		menu3.setMenuList(menuwriter5);
		menu3.setMenuList(menuwriter6);
		menu3.setMenuList(menuwriter7);
		
		
		IMenu menucustomer1 = new Menu("Print all customer", 1,new PrintCustomerAllAction());
		IMenu menucustomer2 = new Menu("Add new customer", 2,new AddNewCustomerAction());
		IMenu menucustomer3 = new Menu("Delete customer", 3);
		IMenu menucustomer4 = new Menu("Print sort  customer name", 4,new SortOrderPriceAction());
		IMenu menucustomer5 = new Menu("Export customer in CSV", 5,new QuantityFinishOrderAction());
		IMenu menucustomer6 = new Menu("Import customer with CSV", 6);
		IMenu menucustomer7 = new Menu("Exit", 7);
		menu4.setMenuList(menucustomer1);
		menu4.setMenuList(menucustomer2);
		menu4.setMenuList(menucustomer3);
		menu4.setMenuList(menucustomer4);
		menu4.setMenuList(menucustomer5);
		menu4.setMenuList(menucustomer6);
		menu4.setMenuList(menucustomer7);
		
		
		
		listmenu.add(menu1);
		listmenu.add(menu2);
		listmenu.add(menu3);
		listmenu.add(menu4);
		listmenu.add(menu5);
	}

	public List<IMenu> getListMenu() {
		return this.listmenu;
	}
}
