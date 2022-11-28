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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Cart;
import springdemo.entity.Categories;
import springdemo.entity.Order;
import springdemo.entity.Products;
import springdemo.entity.Receipts;
import springdemo.entity.Users;
import springdemo.service.CategoryService;
import springdemo.service.ProductsService;
import springdemo.service.ReceiptsService;
import springdemo.service.UsersService;

@Controller
@RequestMapping("/ad")
public class AdminControllerBusiness {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ReceiptsService receiptsService;
	
	@Autowired
	private UsersService usersService;
	
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/showAdmin")
	public String showAdmin(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
		
		List<Order> orderList = new ArrayList<Order>();
		List<Receipts> list_receipts = receiptsService.getReceipts();
		List<Users> list_user = usersService.getUsers();
		List<Products> listProduct = productsService.getProducts();
		
		int count_users = list_user.size();
		int count_products = listProduct.size();
		
		if (list_receipts != null) {
			 for(Receipts r : list_receipts) {
				 Products product = productsService.getProduct(r.getProduct_id());
				 Users theUser = usersService.getUser(r.getUser_id());
				 Order newOrder = new Order();
				 newOrder.setReceipt_id(r.getReceipt_id());
				 newOrder.setProduct(product);
				 newOrder.setQuantity(r.getQuantity());
				 newOrder.setUser(theUser);
				 orderList.add(newOrder);
			 }
		 }
		
		theModel.addAttribute("All_orders", orderList);
		theModel.addAttribute("count_users", count_users);
		theModel.addAttribute("count_products", count_products);
		return "admin/index";
	}
	
	@GetMapping("/showUsers")
	public String showUser(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
		
		List<Users> listUser = usersService.getUsers();
		
		theModel.addAttribute("listUser", listUser);
		return "admin/users";
	}
	
	
	@GetMapping("/showProducts")
	public String showProducts(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
		
		List<Products> listProduct = productsService.getProducts();
		
		theModel.addAttribute("listProduct", listProduct);
		return "admin/products";
	}
	
	@GetMapping("/showCategoryCreatePage")
	public String showCategoryCreatePage(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
			
			HttpSession session = request.getSession();
			
			List<Categories> listCategory = categoryService.getCategories();
			Categories categories = new Categories();
			
			theModel.addAttribute("listCategory", listCategory);
			theModel.addAttribute("categories", categories);
			
			return "admin/create_category";
		}
	
	@PostMapping("/postCreateCategory")
	public String postCreateCategory(@ModelAttribute("categories") Categories categories,Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
				
		categoryService.createReceipts(categories);
		
		return "redirect:/ad/showCategoryCreatePage";
	}
	
	@GetMapping("/showProductCreatePage")
	public String showProductCreatePage(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
		
		List<Products> listProducts = productsService.getProducts();
		List<Categories> listCategory = categoryService.getCategories();
	
		
		theModel.addAttribute("listCategory", listCategory);
		theModel.addAttribute("listProducts", listProducts);
		

		return "admin/create_product";
	}
	
	@PostMapping("/postCreateProduct")
	public String postCreateProduct(Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		HttpSession session = request.getSession();
//		
//		
		Products newProduct = new Products();
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		String image = request.getParameter("image");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		newProduct.setProduct_name(productName);
		newProduct.setCategory_id(categoryId);
		newProduct.setPrice(price);
		newProduct.setImage(image);
		
		productsService.createProduct(newProduct);

		return "redirect:/ad/showProductCreatePage";
		
	}
	
	
	@GetMapping("/updateProduct")
	public String updateProduct(Model theModel, HttpServletRequest request, @RequestParam("product_id") int productId) {
		
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
	
		Products product = new Products();
		product = productsService.getProduct(productId);
		List<Categories> listCategory = categoryService.getCategories();
		
		
		theModel.addAttribute("product", product);
		theModel.addAttribute("listCategory", listCategory);

		return "admin/form_update_product";
	}
	
	@PostMapping("/updateProduct")
	public String postUpdateProduct(Model theModel, HttpServletRequest request) {
		
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		Products newProduct = new Products();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		String image = request.getParameter("image");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		newProduct.setProduct_id(product_id);
		newProduct.setProduct_name(productName);
		newProduct.setCategory_id(categoryId);
		newProduct.setPrice(price);
		newProduct.setImage(image);
		
		productsService.createProduct(newProduct);

		return "redirect:/ad/showProductCreatePage";
	}
	
	@GetMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("category_id") int category_id,Model theModel, HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		categoryService.delete(category_id);
		return "redirect:/ad/showCategoryCreatePage";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("product_id") int product_id,Model theModel,  HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		productsService.delete(product_id);
		return "redirect:/ad/showProducts";
	}
	
	@GetMapping("/viewOrder")
	public String viewOrder(@RequestParam("receipt_id") int receipt_id,Model theModel,  HttpServletRequest request) {
		
		Users user = (Users) request.getSession().getAttribute("auth");
		if (user == null) {
			 return "redirect:/home";
		}
		
		if (!user.isUser_role()) {
			 return "redirect:/home";
		}
		
		Receipts r = receiptsService.getReceipt(receipt_id);
		
		Products product = productsService.getProduct(r.getProduct_id());
		 Users theUser = usersService.getUser(r.getUser_id());
		 Order order = new Order();
		 order.setReceipt_id(r.getReceipt_id());
		 order.setProduct(product);
		 order.setQuantity(r.getQuantity());
		 order.setUser(theUser);

		theModel.addAttribute("order", order);
		
		return "admin/viewOrder";
	}
}
