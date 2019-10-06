package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*private static List<Category> categories = new ArrayList<>();

	static{
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("description for television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		// second category
		
		category = new Category();
		
		//adding first category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("description for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		
		// Third category
		
		category = new Category();
		
		//adding second category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("description for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}*/
	
	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category where active= :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	// Getting single category
	@Override
	public Category get(int id) {
		/*for(Category category : categories){
			if(category.getId()==id) 
				return category;
		}*/
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try{
			// add the category to the db table
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	
	// Updating a single category
	@Override
	public boolean update(Category category) {
		try{
			// add the category to the db table
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			// add the category to the db table
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}
