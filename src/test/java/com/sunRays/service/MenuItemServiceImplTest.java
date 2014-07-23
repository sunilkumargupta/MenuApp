package com.sunRays.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.sunRays.dao.MenuItemDao;
import com.sunRays.model.MenuItem;

public class MenuItemServiceImplTest {
@Test
public void testGetInteger(){
	Integer menuId=2;
	MenuItem expectedMenuItem = new MenuItem();
	expectedMenuItem.setMenuId(menuId);
	
	MenuItemServiceImpl misi=new MenuItemServiceImpl();
	
	MenuItemDao mid=Mockito.mock(MenuItemDao.class);
	Whitebox.setInternalState(misi, MenuItemDao.class, mid);
	Mockito.when(mid.get(menuId)).thenReturn(expectedMenuItem);

	MenuItem actualMenuItem = misi.get(menuId);
	
	Assert.assertEquals(expectedMenuItem, actualMenuItem);
}
}
