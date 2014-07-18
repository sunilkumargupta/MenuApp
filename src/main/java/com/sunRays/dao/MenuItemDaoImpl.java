package com.sunRays.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sunRays.model.MenuItem;

@Repository("menuItemDao")
public class MenuItemDaoImpl implements MenuItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public MenuItem get(Integer menuId) {
		return (MenuItem) sessionFactory.getCurrentSession().get(MenuItem.class, menuId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> getMenuItemList() {
		return (List<MenuItem>) sessionFactory.getCurrentSession().createCriteria(MenuItem.class).list();
	}

	@Override
	public void update(MenuItem menuItem) {
		System.out.println("Calling saveOrUpdate");
		sessionFactory.getCurrentSession().saveOrUpdate(menuItem);
	}

	@Override
	public void delete(MenuItem menuItem) {
		//sessionFactory.getCurrentSession().createQuery("DELETE FROM menuitems WHERE empid = "+menuItem.getMenuId()).executeUpdate();
		sessionFactory.getCurrentSession().delete(menuItem);
		
	}

}
