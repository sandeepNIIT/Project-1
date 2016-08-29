package com.niit.mycartfrontendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.ProductDAO;
import com.niit.mycartbackendproject.dao.SupplierDAO;
import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Product;
import com.niit.mycartbackendproject.model.Supplier;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@RequestMapping(value = "/categories",method = RequestMethod.GET)
	public String listCategories(Model model) {
		
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		return "Home";
	}

	// For add and update category both
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {
		
       categoryDAO.saveOrUpdate(category);
       supplier.setCategoryname(category.getName());
       supplier.setCatid(category.getCatid());
       supplierDAO.saveOrUpdate(supplier);
       product.setCategoryname(category.getName());
       productDAO.saveOrUpdate(product);
       
       

		return "redirect:/categories";
		

	}

	@RequestMapping("category/remove/{id}")
	public String deleteCategory(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/categories";
	}

	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable("id") int id, ModelMap model) {
		
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("categoryList", this.categoryDAO.list());
		
		model.addAttribute("isAdminClickedCategories", "true");
		 
		
		 
		 return "Home";
	}
	
	
	
}
