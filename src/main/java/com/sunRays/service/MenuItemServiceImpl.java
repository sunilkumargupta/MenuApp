package com.sunRays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunRays.dao.MenuItemDao;
import com.sunRays.model.MenuItem;

@Service("menuItemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;
	@Override
	public MenuItem get(Integer menuId) {
		return menuItemDao.get(menuId);
	}

	@Override
	public List<MenuItem> getMenuItemList() {
		return menuItemDao.getMenuItemList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MenuItem menuItem) {
		menuItemDao.update(menuItem);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(MenuItem menuItem) {
		menuItemDao.delete(menuItem);
	}

}
