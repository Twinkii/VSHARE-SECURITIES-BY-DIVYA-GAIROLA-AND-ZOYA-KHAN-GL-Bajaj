package com.stockapp.VShare;
import  com.stockapp.VShare.Stocks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
	 @GetMapping("/")
	    public String helloWorld() {
	        return "hello";
	    }

	    

	    @RequestMapping("/restricted")
	    public String restricted() {
	    	
	        return "Welcome you are logged in with your gmail account";
	    }
	    
	    @GetMapping("/user")
	   public String user(Principal p) {
	    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	String username;
	    	if (principal instanceof UserDetails) {
	    	  username = ((UserDetails)principal).getUsername();
	    	} else {
	    	  username = principal.toString();
	    	}
	        return "USER DETAILS:="+ username;
	   }
	    
	  
	    
	    @RequestMapping("/webscrapping")
	    public  List<Stocks> webscrap() throws IOException {
	    	 List<Stocks> stocks=new ArrayList<Stocks>();
	    	  final String url = 
	                  "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";
	          
	         
	              final Document document = Jsoup.connect(url).get();
	              
	              for (Element row : document.select(
	                  "table.tablesorter.full tr")) {
	                  if (row.select("td:nth-of-type(1)").text().equals("")) {
	                      continue;
	                  }
	                  else {
	                     final String ticker =  row.select("td:nth-of-type(1)").text();
	                     
	                     final String name = row.select("td:nth-of-type(2)").text();
	                     
	                     final String tempPrice = row.select("td.right:nth-of-type(3)").text();
	                     
	                     final double tempPrice1 = Double.parseDouble(tempPrice.replace(",", ""));

	                     
	                      stocks.add(new Stocks(ticker ,name ,tempPrice1));
	                  }
	              }
	          
	          return stocks;
	    }
	    
}
