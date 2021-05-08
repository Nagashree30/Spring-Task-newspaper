package com.chimera.news.dao;

import com.chimera.news.entity.NewsPaperEntity;

public interface NewsPaperDAO {

	public boolean saveNewsPaperInfo(NewsPaperEntity dto);
	public NewsPaperEntity getNewsPaper(String name);
}
