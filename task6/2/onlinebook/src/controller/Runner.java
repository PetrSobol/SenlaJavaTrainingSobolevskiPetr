package controller;

import org.apache.log4j.Logger;

import model.Order;

public class Runner {

	public static void main(String[] args) {
		OnlineBook onlinebook=OnlineBook.getInstance();
		Logger log =Logger.getLogger(Runner.class.getName());
		
		try{
			Order order=onlinebook.getCloneOrder("Sobolevski");
			System.out.println(order.getLastname());
			order.setLastname("Tarashkevich");
			System.out.println(order.getLastname());
		}catch (CloneNotSupportedException e) {
			log.error(e);
			}
		}

	}


