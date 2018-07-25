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
import com.hing.util.EncryptDecodeUtil;
import com.hing.util.Page;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ItemService itemService;
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/updateInformation")
	public ModelAndView update(User user,Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		currentUser.setAGE(user.getAGE());
		currentUser.setCOMMENTS(user.getCOMMENTS());
		currentUser.setPHONE_NUMBER(user.getPHONE_NUMBER());
		currentUser.setSEX(user.getSEX());
		currentUser.setUSER_NAME(user.getUSER_NAME());
		
		
		userService.updateUser(currentUser);
		PageHelper.offsetPage(page.getStart(),8);
		
		List<Item> is = itemService.getItemsByUserId(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("is",is);
		mav.addObject("total",total);
		mav.setViewName("backlog");
		return mav;
	}
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(Page page,User user,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		if(!EncryptDecodeUtil.Decode(currentUser.getPASSWORD()).equals(user.getPASSWORD())) {
			
			currentUser.setPASSWORD(EncryptDecodeUtil.Encrypt(user.getPASSWORD()));
			userService.updateUser(currentUser);
		}
		session.setAttribute("currentUser", currentUser);
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is = itemService.getItemsByUserId(currentUser.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("is",is);
		mav.addObject("total",total);
		mav.setViewName("backlog");
		return mav;
	}
	
	@RequestMapping("/showMyItems")
	public ModelAndView showMyItems(Page page,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		User currentUSer = (User) session.getAttribute("currentUser");
		PageHelper.offsetPage(page.getStart(),8);
		List<Item> is = itemService.getItemsByUserId(currentUSer.getUSER_ID());
		int total = is.size();
		page.caculateLast((int) new PageInfo<>(is).getTotal());
		mav.addObject("is",is);
		mav.addObject("total",total);
		mav.setViewName("backlog");
		return mav;
	}
	
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(User user,HttpSession session ,Page page) {
		ModelAndView mav = new ModelAndView();
		if(userService.isExist(user.getUSER_NAME())) {
			if(EncryptDecodeUtil.Decode(userService.getUserByUserName(user.getUSER_NAME()).getPASSWORD()).equals(user.getPASSWORD())) {
				User currentUser = userService.getUserByUserName(user.getUSER_NAME());
				session.setAttribute("user_id", currentUser.getUSER_ID());
				session.setAttribute("user_name", currentUser.getUSER_NAME());
				session.setAttribute("currentUser", currentUser);
				mav = showMyItems(page,session);
			}else{
				mav.setViewName("index");
			}
		}
		return mav;
	}
	
	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user_name");
		session.removeAttribute("user_id");
		session.removeAttribute("currentUser");
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/Register")
	public ModelAndView Register(User user,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(user != null && user.getUSER_NAME()!=null) {
			if(!userService.isExist(user.getUSER_NAME())) {
				user.setPASSWORD(EncryptDecodeUtil.Encrypt(user.getPASSWORD()));
				userService.addUser(user);
			}
		}
		mav.setViewName("index");
		
		return mav;
	}
	
}
