package com.sunRays.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import com.sunRays.model.MenuItem;

public class MenuItemDaoImplTest {
	MenuItemDaoImpl midi;
	SessionFactory mockSessionFactory;
	Session mockSession;
	@Before
	public void setUp(){
		//Mock SessionFactory & Session
		mockSessionFactory=Mockito.mock(SessionFactory.class);
		mockSession=Mockito.mock(Session.class);
		Mockito.when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession);

		midi=new MenuItemDaoImpl();
		Whitebox.setInternalState(midi, SessionFactory.class, mockSessionFactory);
	}
	@Test
	public void testGetMenuItemList(){
		Integer menuId=2;
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuId(menuId);
		List <MenuItem> menuItemList=new ArrayList<MenuItem>();
		menuItemList.add(menuItem);
		
		Criteria criteria=Mockito.mock(Criteria.class);
		Mockito.when(mockSession.createCriteria(MenuItem.class)).thenReturn(criteria);
		Mockito.when(criteria.list()).thenReturn(menuItemList);
		
		List <MenuItem> actualMenuItem = midi.getMenuItemList();
		
		Assert.assertEquals(menuItemList, actualMenuItem);
	}
	@Test
	public void testGetInteger(){
		Integer menuId=2;
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuId(menuId);
		
		Mockito.when(mockSession.get(MenuItem.class,menuId)).thenReturn(menuItem);
		MenuItem actualMenuItem = midi.get(menuId);

		//MenuItem expectedMenuItem=new MenuItem();
		//expectedMenuItem.setMenuId(menuId);
		
		//Assert.assertEquals(expectedMenuItem, actualMenuItem);
		Assert.assertEquals(menuItem, actualMenuItem);
	}
	
	@Test
	public void testUpdateMenuItem(){
		Integer menuId=2;
		MenuItem expectedMenuItem = new MenuItem();
		expectedMenuItem.setMenuId(menuId);
		midi.update(expectedMenuItem);
		
		Mockito.verify(mockSession).saveOrUpdate(expectedMenuItem);
	}
	
	@Test
	public void testDeleteMenuItem(){
		Integer menuId=2;
		MenuItem expectedMenuItem = new MenuItem();
		expectedMenuItem.setMenuId(menuId);
		midi.delete(expectedMenuItem);
		
		Mockito.verify(mockSession).delete(expectedMenuItem);
	}
}
