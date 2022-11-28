package springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Cart;
import springdemo.entity.Categories;
import springdemo.entity.Products;
import springdemo.entity.Receipts;
import springdemo.entity.Users;
import springdemo.service.CategoryService;
import springdemo.service.ProductsService;
import springdemo.service.ReceiptsService;

@Controller
@RequestMapping("/")
public class ProductsControllerBussiness {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ReceiptsService receiptsService;
	
	@Autowired
	private CategoryService categoryService;
	
	public double getTotalCartPrice(List<Cart> carts) {
        double sum = 0;
        try {
            for (Cart c : carts) {
                sum += c.getProduct().getPrice() * c.getQuantity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
	
	@GetMapping("/home")
	public String listCustomers(Model theModel, @RequestParam(value="category_id", required=false) Integer category_id) {
		// get customers from the dao
//		List<Products> theProducts = productsService.getProducts();
		
		List<Products> theProducts = new ArrayList<Products>();
		List<Categories> listCategories = categoryService.getCategories();

		if(category_id == null) {
			theProducts = productsService.getProducts();
		}else {
			theProducts = productsService.getProductBuyCategory(category_id);
		}
		
		// add the customers to the model
		theModel.addAttribute("products", theProducts);
		theModel.addAttribute("listCategories", listCategories);
		return "list-products";
	}
	
	@GetMapping("/detail")
	public String detail(Model theModel, @RequestParam("productId") int productId) {
		
		Products product = productsService.getProduct(productId);
		theModel.addAttribute("product", product);
		
		return "detail";
	}
	
	@GetMapping("/cart")
	public String card(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		 if (user == null) {
			 return "redirect:/auth/login";
		 }
		 HttpSession session = request.getSession();
		 
		 List<Cart> cartList = new ArrayList<Cart>();
			
		 List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");
		 
		double totalPrice = 0;
			
		if(cart_list != null) {
			totalPrice = getTotalCartPrice(cart_list);
			cartList = cart_list;
		}
		
		session.setAttribute("carts", cartList);
		session.setAttribute("TOTAL", totalPrice);
		 
		return "cart";
	}
	
	@GetMapping("/addCart")
	public String addCart(Model theModel, HttpServletRequest request) {
		if (request.getSession().getAttribute("auth") == null) {
			 return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();
		List<Cart> cartList = new ArrayList<Cart>();
		
		List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");
		int productId = Integer.parseInt(request.getParameter("productId"));
		Products product = productsService.getProduct(productId);
		
		Cart cm = new Cart();
		cm.setQuantity(1);
		cm.setProduct(product);

		 if (cart_list == null) {
			 cartList.add(cm);
		 }else {
			 cartList= cart_list;
			 boolean exist = false;
			 
			 for (Cart c : cart_list) {
				 if(c.getProduct().getProduct_id() == productId) {
					 exist = true;
					 break;
				 }
			 }
			 
			 if(!exist) {
				 cartList.add(cm);
			 }
		 }
		
		session.setAttribute("carts", cartList);
		return "redirect:/cart";
	}
	
	@GetMapping("/removeCart")
	public String removeCart(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();

		List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		if(cart_list != null){
            for(Cart c : cart_list){
                if(c.getProduct().getProduct_id() == productId){
                	
                    cart_list.remove(cart_list.indexOf(c));
                    break;
                }
            }
        }
		
		session.setAttribute("carts", cart_list);
		return "redirect:/cart";
	}
	
	@PostMapping("/buyProduct")
	public String buyProduct(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();
			
		List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		
		
		if(cart_list != null){
            for(Cart c : cart_list){
                if(c.getProduct().getProduct_id() == productId){
                	Receipts newReceipt = new Receipts();
                    newReceipt.setProduct_id(productId);
            		newReceipt.setQuantity(c.getQuantity());
            		newReceipt.setUser_id(user.getUser_id());
            		
            		receiptsService.createReceipts(newReceipt);
            		
                    cart_list.remove(cart_list.indexOf(c));
                    break;
                }
            }
        }
		
		session.setAttribute("carts", cart_list);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/auth/login";
		}
		HttpSession session = request.getSession();
			
		List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");
	
		if(cart_list != null){
            for(Cart c : cart_list){
            	Receipts newReceipt = new Receipts();
                newReceipt.setProduct_id(c.getProduct().getProduct_id());
        		newReceipt.setQuantity(c.getQuantity());
        		newReceipt.setUser_id(user.getUser_id());
        		receiptsService.createReceipts(newReceipt);
            }
        }
		cart_list.clear();
		
		session.setAttribute("carts", cart_list);
		return "redirect:/user/myOrder";
	}
	
	@GetMapping("/quantityIncDec")
	public String quantityIncDec(Model theModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		int productId;
		String id = request.getParameter("productId");
		String action = request.getParameter("action");
		
		List<Cart> cart_list = (List<Cart>) session.getAttribute("carts");

		productId = Integer.parseInt(id);
		
		if(action.equals("inc")){
            for(Cart c : cart_list){
                if(c.getProduct().getProduct_id() == productId){
                    int qua = c.getQuantity();
                    qua++;
                    c.setQuantity(qua);
                    break;
                } 
            }

        }
		
        if(action.equals("dec")){
            for(Cart c : cart_list){
                if(c.getProduct().getProduct_id() == productId ){
                    if(c.getQuantity() > 1){
                        int qua = c.getQuantity();
                        qua--;
                        c.setQuantity(qua);
                        break;
                    }
                } 
            }
        }
        
        session.setAttribute("carts", cart_list);
		return "redirect:/cart";
	}
	

}
