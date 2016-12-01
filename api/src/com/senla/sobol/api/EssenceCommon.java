package com.senla.sobol.api;

import java.io.Serializable;
import java.util.List;

public class EssenceCommon implements Serializable {
	private String nameMetod;
	private List<?> lsit;
	private Integer number;
	private Boolean answerend=false;
	private Object []objects;

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

	public EssenceCommon() {
		super();
	}

	public List<?> getLsit() {
		return lsit;
	}

	public void setLsit(List<?> lsit) {
		this.lsit = lsit;
	}

	public String getNameMetod() {
		return nameMetod;
	}

	public void setNameMetod(String nameMetod) {
		this.nameMetod = nameMetod;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getAnswerend() {
		return answerend;
	}

	public void setAnswerend(Boolean answerend) {
		this.answerend = answerend;
	}

}
