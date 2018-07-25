package com.hing.service;

import java.util.List;

import com.hing.pojo.Item;

public interface ItemService {
	public void addItem(Item item);
	
	public void deleteItem(long id);
	
	public void updateItem(Item item);
	
	public Item getItemById(long id);
	
	public List<Item> showAllItems();
	
	public List<Item> getItemsByUserId(long id);
	
	public List<Item> getItemByCheckKey(long id, String key);
	
	public List<Item> getLeastItems(long id);
	
	public List<Item> getLastUpdateItems(long id);
	
	public List<Item> getAllItems(long id);
	
	public List<Item> getHighItems(long id);
	
	public List<Item> getMediumItems(long id);
	
	public List<Item> getLowItems(long id);

}
