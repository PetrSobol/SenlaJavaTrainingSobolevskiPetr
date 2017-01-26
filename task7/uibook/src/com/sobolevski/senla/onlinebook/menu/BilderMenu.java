package com.sobolevski.senla.onlinebook.menu;

import java.util.ArrayList;
import java.util.List;

import com.sobolevski.senla.onlinebook.action.AddNewBookAction;
import com.sobolevski.senla.onlinebook.action.AddNewOrderAction;
import com.sobolevski.senla.onlinebook.action.CloneOrderAction;
import com.sobolevski.senla.onlinebook.action.CloseOrderAction;
import com.sobolevski.senla.onlinebook.action.DeleteBookAction;
import com.sobolevski.senla.onlinebook.action.ExportBookAction;
import com.sobolevski.senla.onlinebook.action.ExportOrderAction;
import com.sobolevski.senla.onlinebook.action.ImportBookAction;
import com.sobolevski.senla.onlinebook.action.ImportOrderAction;
import com.sobolevski.senla.onlinebook.action.MuchOrderAction;
import com.sobolevski.senla.onlinebook.action.OrderDateToDateAction;
import com.sobolevski.senla.onlinebook.action.OrderStageAction;
import com.sobolevski.senla.onlinebook.action.PrintBookActionAll;
import com.sobolevski.senla.onlinebook.action.PrintBookAnnotationAction;
import com.sobolevski.senla.onlinebook.action.PrintOrderActionAll;
import com.sobolevski.senla.onlinebook.action.PrintOrderAnnotationAction;
import com.sobolevski.senla.onlinebook.action.QuantityFinishOrderAction;
import com.sobolevski.senla.onlinebook.action.SaveBaseAction;
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
		IMenu menu3 = new Menu("Clone order", 3,new CloneOrderAction());
		IMenu menu4 = new Menu("Save changes to the database", 4,new SaveBaseAction());
		IMenu menu5 = new Menu("Import/export", 5);
		IMenu menu6 = new Menu("Print annotation", 6);
		IMenu menu7 = new Menu("Exit", 7);
		IMenu menubook1 = new Menu("Print all book", 1, new PrintBookActionAll());
		IMenu menubook2 = new Menu("Add new book", 2, new AddNewBookAction());
		IMenu menubook3 = new Menu("Delete book", 3, new DeleteBookAction());
		IMenu menubook4 = new Menu("Print sort Book Name", 4, new SortNameBookAction());
		IMenu menubook5 = new Menu("Print sort Book Price", 5, new SortBookPriceAction());
		IMenu menubook6 = new Menu("Print sort Book Date", 6, new SortBookDateAction());
		IMenu menubook7 = new Menu("Print sort Book Stage", 7, new SortBookStage());
		IMenu menubook8 = new Menu("Exit", 8);
		menu1.setMenuList(menubook1);
		menu1.setMenuList(menubook2);
		menu1.setMenuList(menubook3);
		menu1.setMenuList(menubook4);
		menu1.setMenuList(menubook5);
		menu1.setMenuList(menubook6);
		menu1.setMenuList(menubook7);
		menu1.setMenuList(menubook8);
		IMenu menuorder1 = new Menu("Print all order", 1, new PrintOrderActionAll());
		IMenu menuorder2 = new Menu("Add new order", 2,new AddNewOrderAction());
		IMenu menuorder3 = new Menu("close order", 3,new CloseOrderAction());
		IMenu menuorder4 = new Menu("Print sort  order Price", 4,new SortOrderPriceAction());
		IMenu menuorder5 = new Menu("Quantity finish order date to date (dd.MM.yyyy)", 5,new QuantityFinishOrderAction());
		IMenu menuorder6 = new Menu("Print order date to date (dd.MM.yyyy)", 6,new OrderDateToDateAction());
		IMenu menuorder7 = new Menu("How much money date to date (dd.MM.yyyy)", 7,new MuchOrderAction());
		IMenu menuorder8 = new Menu("Print sort order stage", 8,new OrderStageAction());
		IMenu menuorder9 = new Menu("Exit", 9);
		menu2.setMenuList(menuorder1);
		menu2.setMenuList(menuorder2);
		menu2.setMenuList(menuorder3);
		menu2.setMenuList(menuorder4);
		menu2.setMenuList(menuorder5);
		menu2.setMenuList(menuorder6);
		menu2.setMenuList(menuorder7);
		menu2.setMenuList(menuorder8);
		menu2.setMenuList(menuorder9);
		
		IMenu menuanotation1 = new Menu("Print order annotation", 1,new PrintOrderAnnotationAction());
		IMenu menuanotation2 = new Menu("Print book annotation ", 2,new PrintBookAnnotationAction());
		IMenu menuanotation3 = new Menu("Exit", 3);
		menu6.setMenuList(menuanotation1);
		menu6.setMenuList(menuanotation2);
		menu6.setMenuList(menuanotation3);
		
		IMenu menuexportorder = new Menu("Export book", 1,new ExportBookAction());
		IMenu menuexportbook = new Menu("Export order", 2,new ExportOrderAction());
		IMenu menuimportorder = new Menu("Import order", 3,new ImportOrderAction());
		IMenu menuimportbook = new Menu("Import book",4,new ImportBookAction());
		IMenu exit = new Menu("Exit", 5);
		
		menu5.setMenuList(menuexportorder);
		menu5.setMenuList(menuexportbook);
		menu5.setMenuList(menuimportorder);
		menu5.setMenuList(menuimportbook);
		menu5.setMenuList(exit);
		
		
		listmenu.add(menu1);
		listmenu.add(menu2);
		listmenu.add(menu3);
		listmenu.add(menu4);
		listmenu.add(menu5);
		listmenu.add(menu6);
		listmenu.add(menu7);
	}

	public List<IMenu> getListMenu() {
		return this.listmenu;
	}
}
