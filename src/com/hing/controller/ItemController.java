package com.hing.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hing.pojo.Item;
import com.hing.pojo.User;
import com.hing.service.ItemService;
import com.hing.service.UserService;
import com.hing.util.Page;

@Controller
@RequestMapping("")
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	UserService userService;
	@RequestMapping("/getLeastItems")
	public ModelAndView getLeastItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getLeastItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	
	@RequestMapping("/getLastUpdateItems")
	public ModelAndView getLastUpdateItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getLastUpdateItems(currentUser.getUSER_ID());
		int total = is.size();
		System.out.println("total"+total);
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	
	@RequestMapping("/getAllItems")
	public ModelAndView getAllItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getAllItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	
	@RequestMapping("/getHighItems")
	public ModelAndView getHighItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getHighItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	
	
	@RequestMapping("/getMediumItems")
	public ModelAndView getMediumItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getMediumItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	@RequestMapping("/getLowItems")
	public ModelAndView getLowItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getLowItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	@RequestMapping("/deleteItem")
	public ModelAndView deleteItem(Page page,HttpSession session,Item item) {
		ModelAndView mav = new ModelAndView();
		itemService.deleteItem(item.getTODO_ITEM_ID());
		User currentUser = (User)session.getAttribute("currentUser");
		
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is = itemService.getItemsByUserId(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");	
		return mav;
	}
	
	@RequestMapping("/addItem")
	public ModelAndView addItem(Page page,Item item,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser= (User)session.getAttribute("currentUser");
		item.setUser(currentUser);
		itemService.addItem(item);
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getItemsByUserId(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	@RequestMapping("/findAboutItem")
	public ModelAndView findAboutItem(Page page,HttpSession session,String key) {
		ModelAndView mav = new ModelAndView();
		User currentUser = userService.getUserByUserName((String)session.getAttribute("user_name"));
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getItemByCheckKey(currentUser.getUSER_ID(),key);
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.setViewName("backlog");
		return mav;
	}
	
	
	@RequestMapping("/editItem")
	public ModelAndView editItem(Item item,HttpSession session,Page page) {
		ModelAndView mav = new ModelAndView();
		Item currentItem = itemService.getItemById(item.getTODO_ITEM_ID());
		User currentUser= (User)session.getAttribute("currentUser");
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getLeastItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.addObject("currentItem",currentItem);
		mav.setViewName("backlog");
		return mav;
	}
	
	@RequestMapping("/updateItem")
	public ModelAndView updateItem(Item item,HttpSession session,Page page) {
		ModelAndView mav = new ModelAndView();
		User currentUser= (User)session.getAttribute("currentUser");
		item.setUser(currentUser);
		itemService.updateItem(item);
		Item currentItem = itemService.getItemById(item.getTODO_ITEM_ID());
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is =itemService.getLeastItems(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("total",total);
		mav.addObject("is",is);
		mav.addObject("currentItem",currentItem);
		mav.setViewName("backlog");
		return mav;
	}
	
	
}
