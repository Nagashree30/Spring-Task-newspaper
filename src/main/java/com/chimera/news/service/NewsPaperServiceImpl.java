package com.chimera.news.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chimera.news.dao.NewsPaperDAO;
import com.chimera.news.dto.NewsPaperDTO;
import com.chimera.news.entity.NewsPaperEntity;

@Service
public class NewsPaperServiceImpl implements NewsPaperService {
	@Autowired
	private NewsPaperDAO newsPaperDAO;

	public static Map<String,String> map=new HashMap<String, String>();
	
	public NewsPaperServiceImpl() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateNewsPaperInfo(NewsPaperDTO dto) {
		boolean flag = false;
		if (Objects.nonNull(dto)) {
			/*
			 * This is the one way to copy dto to entity NewsPaperEntity entity=new
			 * NewsPaperEntity(); entity.setName(dto.getName());
			 * entity.setLanguage(dto.getLanguage());
			 */
			String name = dto.getName();
			if (name != null && name.length() > 5 && !name.isEmpty()) {
				flag = true;
			} else {
				System.out.println("Enter a valid name");
				map.put("Name", "Enter a valid name");
				flag = false;
			}
			if (flag) {
				double cost = dto.getCost();
				if (cost != 0 && cost > 0) {
					flag = true;

				} else {
					System.out.println("Enter a valid cost");
					map.put("Cost", "Enter a valid cost");
					flag = false;
				}
			}
			if(flag) {
				short noOfPages=dto.getNoOfPages();
				if(noOfPages!=0 && noOfPages>0) {
					flag=true;
				}else {
					System.out.println("Enter a valid Number of Pages");
					map.put("Pages", "Enter a valid Number of Pages");
					flag=false;
				}
			}
			if(flag) {
				String language=dto.getLanguage();
				if(language!=null && !language.isEmpty() && language.length()>2) {
					flag=true;
				}else {
					System.out.println("Enter a valid Language");
					map.put("Language", "Enter a valid Language");
					flag=false;
				}
			}
			if(flag) {
				boolean magazine=dto.isMagazine();
				if(magazine) {
					flag=true;
				}else {
					System.out.println("Enter a valid Magazine");
					map.put("Magazine", "Enter a valid Magazine");
					flag=false;
				}
			}
			if (flag) {
				NewsPaperEntity entity = new NewsPaperEntity();
				BeanUtils.copyProperties(dto, entity); // beanutil is a class copyproperties is a static property
				return this.newsPaperDAO.saveNewsPaperInfo(entity);
			}
		}
		return false;
	}

	@Override
	public NewsPaperEntity validateAndSearchByName(String name) {
		System.out.println("invoked validateAndSearchByName");
		NewsPaperEntity paper = null;
		try {
		if(name!=null && !name.isEmpty()&& name.length()>3) {
			System.out.println("Name is valid, can search");
			paper = this.newsPaperDAO.getNewsPaper(name);
			System.out.println("Newspaper found"+ paper);
			return paper;
		} else {
			System.out.println("Name is invalid, cannot search");
		}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
