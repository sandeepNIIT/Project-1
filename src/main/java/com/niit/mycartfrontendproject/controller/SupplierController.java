package com.niit.mycartfrontendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.ProductDAO;
import com.niit.mycartbackendproject.dao.SupplierDAO;
import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Product;
import com.niit.mycartbackendproject.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	
	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		return "Home";
	}
	
	//For add and update supplier both
	@RequestMapping(value= "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier){
		supplierDAO.saveOrUpdate(supplier);
		product.setCategoryname(supplier.getCategoryname());
		product.setProid(supplier.getProid());
		product.setName(supplier.getProductname());
		product.setQuantity(supplier.getQuantity());
		product.setSuppliername(supplier.getName());
		productDAO.saveOrUpdate(product);
		category.setCatid(supplier.getCatid());
		category.setName(supplier.getCategoryname());
		categoryDAO.saveOrUpdate(category);
		
		return "redirect:/suppliers";
		
	}
	
	@RequestMapping("supplier/remove/{id}")
    public String removeSupplier(@PathVariable("id") int id,ModelMap model) throws Exception{
		
       try {
		supplierDAO.delete(id);
		model.addAttribute("message","Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "redirect:/suppliers";
    }
 
    @RequestMapping("supplier/edit/{id}")
    public String editSupplier(@PathVariable("id") int id, Model model){
    	System.out.println("editSupplier");
        model.addAttribute("supplier", this.supplierDAO.get(id));
        model.addAttribute("listSuppliers", this.supplierDAO.list());
        return "redirect:/suppliers";
    }
	
	
}
