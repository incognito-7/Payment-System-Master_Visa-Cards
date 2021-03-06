package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.model.RequestedCard;
import edu.mum.model.ResponseInfo;
import edu.mum.service.CreditCardService;

@Controller
public class HomeController {
	
	@Autowired
	private CreditCardService creditCardService;

	@RequestMapping(value="/")
	public String homePage(){
		System.out.println("Welcome to Payment");
		return "index";
	}
	
	@RequestMapping(value = "/verifycard", method = RequestMethod.POST)
	public @ResponseBody ResponseInfo verifyCard(@RequestBody RequestedCard requestedCard){
		ResponseInfo responseInfo = new ResponseInfo();
		char response = creditCardService.verifyCreditCard(requestedCard);
		responseInfo.setResponse(response);
		
		return responseInfo;
	}
	
	@RequestMapping(value = "/afterplaceorder", method = RequestMethod.POST)
	public @ResponseBody ResponseInfo afterPlaceOrder(@RequestBody RequestedCard requestedCard){
		ResponseInfo responseInfo = new ResponseInfo();
		char response = creditCardService.afterPlaceOrder(requestedCard);
		responseInfo.setResponse(response);
				
		return responseInfo;
	}
}

