package com.niit.mycartfrontendproject.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.ProductDAO;
import com.niit.mycartbackendproject.dao.SupplierDAO;
import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Product;
import com.niit.mycartbackendproject.model.Register;
import com.niit.mycartbackendproject.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		return "Home";
	}
	@ModelAttribute("product")
	public Product pro1()
	{
		return new Product();
	}

	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request,@Valid@ModelAttribute("product")Product product, BindingResult result) {
		
		
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];

			product.getImg().getInputStream().read(bytes);

			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());

			MultipartFile file = product.getImg();
			String path = request.getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
         product.setSupid(supplier.getSupid());
         product.setSuppliername(supplier.getName());
         product.setCatid(category.getCatid());
         product.setCategoryname(category.getName());
         product.setQuantity(supplier.getQuantity());
         
		
		productDAO.saveOrUpdate(product);
		
		categoryDAO.saveOrUpdate(category);
		supplierDAO.saveOrUpdate(supplier);
		
		
		

		return "redirect:/products";
		

	}

	@RequestMapping("product/remove/{id}")
	public String removeProduct(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/products";
	}

	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("product", this.productDAO.get(id));
		model.addAttribute("productList", this.productDAO.list());
		
		

		return "redirect:/products";
	}
	
	@RequestMapping(value = "product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") int id, Model model,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
		return "redirect:/backToHome";

	}

	@RequestMapping(value = "/backToHome", method = RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct") 
	        final Object selectedProduct, final Model model) {

		model.addAttribute("selectedProduct", selectedProduct);
		//model.addAttribute("categoryList", this.categoryDAO.list());
		return "redirect:/products";
		//return "/Home";
	}

}
