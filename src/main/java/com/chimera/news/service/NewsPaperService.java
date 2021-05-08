package com.chimera.news.service;

import com.chimera.news.dto.NewsPaperDTO;
import com.chimera.news.entity.NewsPaperEntity;

public interface NewsPaperService {

	public boolean validateNewsPaperInfo(NewsPaperDTO dto);
	
	public NewsPaperEntity validateAndSearchByName(String name);
}
