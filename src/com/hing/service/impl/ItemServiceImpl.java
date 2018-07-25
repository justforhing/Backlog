package com.hing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hing.mapper.ItemMapper;
import com.hing.pojo.Item;
import com.hing.service.ItemService;
@Service

public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemMapper itemMapper;
	@Override
	public void addItem(Item item) {
		item.setTODO_ITEM_ID(System.currentTimeMillis());
		itemMapper.add(item);
	}

	@Override
	public void deleteItem(long id) {
		itemMapper.delete(id);
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.update(item);
	}

	@Override
	public Item getItemById(long id) {
		return itemMapper.get(id);
	}

	@Override
	public List<Item> showAllItems() {
		return itemMapper.list();
	}

	@Override
	public List<Item> getItemsByUserId(long id) {
		return itemMapper.getItemsByUserId(id);
	}

	@Override
	public List<Item> getItemByCheckKey(long id, String key) {
		return itemMapper.getItemsByKey(id, key);
	}

	@Override
	public List<Item> getLeastItems(long id) {
		return itemMapper.getLastUpdateItems(id);
	}

	@Override
	public List<Item> getLastUpdateItems(long id) {
		return itemMapper.getLastUpdateItems(id);
	}

	@Override
	public List<Item> getAllItems(long id) {
		return itemMapper.getAllItems(id);
	}

	@Override
	public List<Item> getHighItems(long id) {
		return itemMapper.getHighItems(id);
	}

	@Override
	public List<Item> getMediumItems(long id) {
		return itemMapper.getMediumItems(id);
	}

	@Override
	public List<Item> getLowItems(long id) {
		return itemMapper.getLowItems(id);
	}

}
