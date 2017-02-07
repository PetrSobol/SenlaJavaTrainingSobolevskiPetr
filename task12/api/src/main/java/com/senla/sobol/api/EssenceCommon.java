package com.senla.sobol.api;

import java.io.Serializable;

public class EssenceCommon implements Serializable {
	private String nameMetod;
	private Object curront;
	private Object[] objects;
 
	public Object getCurront() {
		return curront;
	}

	public void setCurront(Object curront) {
		this.curront = curront;
	}

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

	public String getNameMetod() {
		return nameMetod;
	}

	public void setNameMetod(String nameMetod) {
		this.nameMetod = nameMetod;
	}

}
