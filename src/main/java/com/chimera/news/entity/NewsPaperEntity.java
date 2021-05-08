package com.chimera.news.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name="newspaper")
public class NewsPaperEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NEWSPAPER_ID")
	private int newsPaperID;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="COST")
	private double cost;
	
	@Column(name="NOOFPAGES")
	private short noOfPages;
	
	@Column(name="LANGUAGE")
	private String language;
	
	@Column(name="MAGAZINE")
	private boolean magazine;
}
