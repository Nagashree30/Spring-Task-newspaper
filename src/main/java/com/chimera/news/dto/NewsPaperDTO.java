package com.chimera.news.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewsPaperDTO {

	private String name;
	private double cost;
	private short noOfPages;
	private String language;
	private boolean magazine;

	public NewsPaperDTO() {
		System.out.println("created" + this.getClass().getSimpleName());
	}
}
