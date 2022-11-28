package springdemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Cart;
import springdemo.entity.Order;
import springdemo.entity.Products;
import springdemo.entity.Receipts;
import springdemo.entity.Users;
import springdemo.service.ProductsService;
import springdemo.service.ReceiptsService;

@Controller
@RequestMapping("/user")
public class OrderController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ReceiptsService receiptsService;
	
	@GetMapping("/myOrder")
	public String myOrder(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();
		
		List<Order> orderList = new ArrayList<Order>();
		List<Receipts> list_receipts = receiptsService.getReceiptsByUser(user.getUser_id());
		
		 if (list_receipts != null) {
			 for(Receipts r : list_receipts) {
				 Products product = productsService.getProduct(r.getProduct_id());
				 Order newOrder = new Order();
				 newOrder.setReceipt_id(r.getReceipt_id());
				 newOrder.setProduct(product);
				 newOrder.setQuantity(r.getQuantity());
				 orderList.add(newOrder);
			 }
		 }
		
		session.setAttribute("orders", orderList);
		return "orders";
	}
	
	@GetMapping("/deleteMyOrder")
	public String deleteMyOrder(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();
		int productId = Integer.parseInt(request.getParameter("productId"));
		receiptsService.deteleReceipts(productId);
		
		return "redirect:/user/myOrder";
	}
	

}
