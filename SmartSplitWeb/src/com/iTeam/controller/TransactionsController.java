package com.iTeam.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iTeam.service.TransactionsService;
import com.iTeam.service.TransactionsServiceImpl;
import com.iTeam.common.UserBalance;
import com.iTeam.common.UserDashboard;
import com.iTeam.common.UserLogin;
import com.iTeam.common.Users;
import com.iTeam.common.Friend;
import com.iTeam.common.MetaTransaction;
import com.iTeam.common.Transactions;

@Controller
public class TransactionsController {
	
	
	@Resource(name="transactionsService")
	private TransactionsService transactionsService;
	
	private UserBalance userBal;
	//private String pass, usernm;
	
	@RequestMapping(value = "/mainPage",method = RequestMethod.GET)
	public String tp()
	{
		return "hello";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value = "/error",method = RequestMethod.GET)
	public String error()
	{
		return "error";
	}
	@RequestMapping(value = "/othererror",method = RequestMethod.GET)
	public String error2()
	{
		return "error2";
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpSession session)
	{
		session.removeAttribute("username");
		if (session != null) {
		    session.invalidate();
		}		
		
  	
		return "redirect:/mainPage";
	}

	@RequestMapping(value = "/dashboard/addt/{username:.+}",method = RequestMethod.GET)
	public ModelAndView addtrans(HttpServletRequest request, HttpServletResponse response, @PathVariable("username")String userid)
	{
		return new ModelAndView("addbill","userid",userid);
	}
	
	@RequestMapping(value = "/dashboard",method = RequestMethod.GET)
	public ModelAndView showDashboard(HttpSession session)
	{
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		UserDashboard friendsBal = null;
		ModelAndView model1 = null;
		UserLogin existingUser = null;
		String user = null, passwd = null;
		boolean exists = false;
		try
		{
			
				friendsBal = transactionsService.getDashboard(session.getAttribute("username").toString());
				json = mapper.writeValueAsString(friendsBal);
				System.out.println("Session userid:"+session.getAttribute("username"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model1 = new ModelAndView("dashboard");
		model1.addObject("friendsBal", json);
		return model1;
			
	}
	
	@RequestMapping(value = "/dashboard/friend/gotosettleup/{settleupdetails:.+}")
	public ModelAndView goToSettleUp(HttpServletRequest request, @PathVariable("settleupdetails")String details, HttpSession session)
	{
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		String [] name = details.split("-");
		String useremail = null;
		ModelAndView model1 = null;
		double amount = Double.parseDouble(name[3]);
		MetaTransaction trn = null;
		try{
			useremail = transactionsService.findUserEmailID(name[0], name[1]);
			
			trn = new MetaTransaction();
			trn.setAddedBy(session.getAttribute("username").toString());
			trn.setGroupid(1);
			trn.setOtherFirstName(name[0]);
			trn.setOtherLastName(name[1]);
			trn.setFirstName(useremail);
			trn.setAmountOwe(amount);
			trn.setTotalAmount(amount);
			json = mapper.writeValueAsString(trn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model1 = new ModelAndView("settleup");
		model1.addObject("trans", json);
		return model1;
	}
	
	@RequestMapping(value = "/dashboard/friend/settleup/{settleupdetails:.+}")
	public String settleUp(HttpServletRequest request, @PathVariable("settleupdetails")String details, HttpSession session)
	{
		System.out.println("Hello");
		String [] name = details.split("-");
		String useremail = null;
		double amount = Double.parseDouble(name[2]);
		Transactions trn = null;
		try{
			useremail = transactionsService.findUserEmailID(name[0], name[1]);
			trn = new Transactions(1, session.getAttribute("username").toString(), useremail, amount, amount, "null", "null", "null");
			transactionsService.settleUp(trn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "redirect:/othererror";
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/dashboard/friend/transaction/deleteexp/{id:.+}")
	public String deleteExp(HttpServletRequest request, @PathVariable("id")String id, HttpSession session)
	{
		System.out.println("Hello");
	    int trnid = Integer.parseInt(id);
		
		try{
		transactionsService.deleteTrn(trnid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "redirect:/othererror";
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/dashboard/friend/{username:.+}",method = RequestMethod.POST)
	public ModelAndView showFriendsTransactions1(@PathVariable("username")String user, HttpSession session)
	{
		String json = "";
		System.out.println(user);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		Friend friendsData = null;
		try
		{
			friendsData = transactionsService.getFriendsTransactions(session.getAttribute("username").toString(), user);
			json = mapper.writeValueAsString(friendsData);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView model1 = new ModelAndView("friend");
		
		 model1.addObject("friendsTransactions", json);
		return model1;
			
	}
	
	@RequestMapping(value = "/dashboard/friend/transaction/{transid}",method = RequestMethod.POST)
	public ModelAndView showTransaction(@PathVariable("transid")Integer id)
	{
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		MetaTransaction trans = null;
		try
		{
			trans = transactionsService.getIndividualTransaction(id);
			System.out.println(trans.getCategory());
			json = mapper.writeValueAsString(trans);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView model1 = new ModelAndView("friendssingletransaction");
		
		 model1.addObject("transaction", json);
		return model1;
	}
	
	@RequestMapping(value = "/dashboard/addt/newbill/{username}",method = RequestMethod.POST)
	public String addNewBill(@ModelAttribute("transaction") Transactions transaction,BindingResult result, @PathVariable("username")String user, HttpSession session)
	{
		String res = null, useremail = null;
		String[] name = null;
		try
		{
			transaction.setGroupid(1); //Needs to be changed
			name = user.split("-");
			useremail = transactionsService.findUserEmailID(name[0], name[1]);
			transaction.setAddedTo(useremail);
			transaction.setAddedBy(session.getAttribute("username").toString());
			res = transactionsService.addBill(transaction);
			System.out.println("res:"+res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "redirect:/othererror";
		}
		return "redirect:/dashboard";
			
	}
	
	@RequestMapping(value = "/userlogin",method = RequestMethod.GET)
	public String setSession(@ModelAttribute("appUser")Users appUser, HttpServletRequest request, HttpServletResponse response,HttpSession session)
	{
		UserLogin existingUser = null;
		boolean exists = false;
		
		try
		{
		existingUser = transactionsService.checkUserExistance(appUser.getEmail(), appUser.getPassword());
		exists = existingUser.getExists().equalsIgnoreCase("success");
		session.setAttribute("username", appUser.getEmail());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(exists)
		{
			return "redirect:/dashboard";
		}
		else
		{
			return "redirect:/error";
		}
		
	}
	
	@RequestMapping(value = "/dashboard/updatetrans/{transid}")
	public ModelAndView updateTrans(@PathVariable("transid")Integer id)
	{
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		MetaTransaction trans = null;
		try
		{
			trans = transactionsService.getIndividualTransaction(id);
			System.out.println(trans.getCategory());
			json = mapper.writeValueAsString(trans);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView model1 = new ModelAndView("updatetransaction");
		
		 model1.addObject("transaction", json);
		return model1;			
	}
	
	@RequestMapping(value = "/updatetr/{transid}",method = RequestMethod.POST)
	public String check1(@ModelAttribute("uTransaction") MetaTransaction uTransaction,BindingResult result, @PathVariable("transid")Integer id)
	{
		String res = null, useremail = null;
		String[] name = null;
		Transactions tr = null;
		try
		{
			uTransaction.setIdTransactions(id);
			name = uTransaction.getOtherFirstName().split(" ");
			useremail = transactionsService.findUserEmailID(name[0], name[1]);
			tr = new Transactions();
			tr.setAddedBy(uTransaction.getAddedBy());
			tr.setAddedTo(useremail);
			tr.setAmountOwe(uTransaction.getAmountOwe());
			tr.setTotalAmount(uTransaction.getTotalAmount());
			tr.setCategory(uTransaction.getCategory());
			tr.setTitle(uTransaction.getTitle());
			tr.setIdTransactions(uTransaction.getIdTransactions());
			res = transactionsService.updateTransaction(tr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "redirect:/othererror";
		}
		return "redirect:/dashboard";
			
	}
	
	@RequestMapping(value = "/dashboard/updateuser")
	public ModelAndView updateUser(HttpSession session)
	{
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		Users usr = null;
		try
		{
			usr = transactionsService.getUser(session.getAttribute("username").toString());
			json = mapper.writeValueAsString(usr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView model1 = new ModelAndView("updateuser");
		
		 model1.addObject("user", json);
		return model1;			
	}
	
	@RequestMapping(value = "/updateusr",method = RequestMethod.POST)
	public String updateUserDashboard(@ModelAttribute("updateUser") Users usr,BindingResult result)
	{
		String res = null;
		try
		{
			res = transactionsService.updateUser(usr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "redirect:/othererror";
		}
		return "redirect:/dashboard";
			
	}
}
