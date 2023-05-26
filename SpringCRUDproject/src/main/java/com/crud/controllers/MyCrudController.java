package com.crud.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.crud.dao.ProductDao;
import com.crud.models.Product;

@Controller
public class MyCrudController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(path = "/")
	public String index(Model m) {
		List<Product> allProducts = productDao.getAllProducts();
		m.addAttribute("products", allProducts);
		m.addAttribute("title", "Home");
		return "index";
	}

	// To show add product form
	@RequestMapping(path = "/add-product")
	public String addProdForm(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	// To handle the product form
	@RequestMapping(path = "/handleproduct", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/");
		return view;
	}

	// To delete a product
	@RequestMapping(path = "/delete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") long id, HttpServletRequest request) {
		this.productDao.deleteProduct(id);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/");
		return view;
	}

	// To edit details of a product
	@RequestMapping(path = "/update/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Product prod = this.productDao.getProd(id);
		model.addAttribute("prod", prod);
		return "update_form";
	}

	@RequestMapping(path = "/update-process", method = RequestMethod.POST)
	public RedirectView updateProcess(@ModelAttribute Product prod,
			HttpServletRequest request) {
		Long prodId = prod.getId();
		Product prodById = this.productDao.getProd(prodId);
		prodById.setName(prod.getName());
		prodById.setDescription(prod.getDescription());
		prodById.setPrice(prod.getPrice());
		this.productDao.updateProd(prodById);
//		Product prodById = this.productDao.getProd(id);
//		prodById.setName(prod.getName());
//		prodById.setDescription(prod.getDescription());
//		prodById.setPrice(prod.getPrice());
//		this.productDao.updateProd(prodById);

		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/");
		return view;
	}

}
