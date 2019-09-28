package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();

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
	}
	
	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories){
			if(category.getId()==id) 
				return category;
		}
		
		return null;
	}

}
