package operationmenu;

import java.util.List;
import java.util.Scanner;

import menu.BilderMenu;
import menu.IMenu;

public class Navigator {
	private PrintMenu print = new PrintMenu();
	private BilderMenu bilder = new BilderMenu();
	private Scanner scanner;

	public void startMenu() {
		print.printMenu(bilder.getListMenu());

		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			Integer number = scanner.nextInt();
			for (IMenu menu : bilder.getListMenu()) {

				if (menu.getId() == number && menu.getId() != bilder.getListMenu().size()) {
					if(menu.getAction()==null){
						print.printMenu(menu.getMenuList());
						databasesMenu(menu.getMenuList());
					}else{
						menu.getAction().process();
					}
					
					
				}
			}
			if (number == bilder.getListMenu().size()) {
				break;
			}
		}
	}
	private void databasesMenu(List<IMenu> listmenu) {
		scanner = new Scanner(System.in);
		int max=listmenu.size();
		while (scanner.hasNext()) {
			Integer number = scanner.nextInt();
          for(IMenu menu:listmenu){
        	  if(menu.getId()==number&&number!=max&&menu.getAction()!=null){
        		  menu.getAction().process();	
        		  print.printMenu(listmenu);
        	  }
        }
          if (number == listmenu.size()) {
				print.printMenu(bilder.getListMenu());
				break;
			}
		}
	}

}
