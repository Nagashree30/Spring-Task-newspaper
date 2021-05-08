package com.chimera.news.dao;

import java.util.Objects;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chimera.news.entity.NewsPaperEntity;

@Repository
public class NewsPaperDAOImpl implements NewsPaperDAO {
	@Autowired
	private SessionFactory factory;

	public NewsPaperDAOImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean saveNewsPaperInfo(NewsPaperEntity entity) {
		System.out.println("invoke save newspaper");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			System.out.println("data is saved");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return true;
	}

	@Override
	public NewsPaperEntity getNewsPaper(String name) {
		System.out.println("invoke getNewspaper");
		Session session = factory.openSession();
		try {
			String syntax = "SELECT SE FROM NewsPaperEntity SE WHERE SE.name='" + name + "'";
			Query query = session.createQuery(syntax);
			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("entity found=" + name);
				NewsPaperEntity answer = (NewsPaperEntity) result;
				System.out.println(answer);
				return answer;
			} else {
				System.out.println("entity not found=" + name);
				return null;
			}

		}

		catch (Exception e) {
			System.out.println("exception occured:" + e.getMessage());
			e.printStackTrace();
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");
			}
		}
		return null;
	}

}
