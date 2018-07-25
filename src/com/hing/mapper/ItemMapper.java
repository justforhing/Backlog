package com.hing.mapper;

import java.util.List;

import com.hing.pojo.Item;

public interface ItemMapper {
	public void add(Item item);
	
	public void delete(long id);
	
	public void update(Item item);
	
	public Item get(long id);
	
	public List<Item> getItemsByUserId(long id);
	
	public List<Item> list();
	
	public List<Item> getItemsByKey(long user_id,String key);
	
	public List<Item> getLeastItems(long id);
	
	public List<Item> getLastUpdateItems(long id);
	
	public List<Item> getAllItems(long id);
	
	public List<Item> getHighItems(long id);
	
	public List<Item> getMediumItems(long id);
	
	public List<Item> getLowItems(long id);
	
	
}
