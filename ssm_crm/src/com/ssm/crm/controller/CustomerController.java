package com.ssm.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.crm.pojo.BaseDict;
import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;
import com.ssm.crm.service.BaseDictService;
import com.ssm.crm.service.CustomerService;
import com.ssm.crm.utils.Page;

/**
 * 客户信息请求处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private  CustomerService customerService;
	
	@Value("${customer_from_type}")
	private String customer_from_type;
	
	@Value("${custome_industry_type}")
	private String custome_industry_type;
	
	@Value("${custome_level_type}")
    private String custome_level_type;
	
	@RequestMapping("list")
	public String list(Model model ,QueryVo vo){
		//查询来源
		List<BaseDict> fromType= baseDictService.getBaseDictByCode(customer_from_type);
		//查询行业
		List<BaseDict> industryType= baseDictService.getBaseDictByCode(custome_industry_type);
		//查询级别
		List<BaseDict> levelType= baseDictService.getBaseDictByCode(custome_level_type);

		
		//设置数据模型返回
		model.addAttribute("fromType" , fromType);
		model.addAttribute("industryType" , industryType);
		model.addAttribute("levelType" , levelType);
		
		//跟据查询条件分页查询用户列表
		Page<Customer> page = customerService.getCustomerByQueryVo(vo);
				
		//设置分页数返回
		model.addAttribute("page", page);
		//返回查询条件
		model.addAttribute("vo", vo);
		return "customer";
		
	}
	
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer cdit(Integer id){
		Customer customer= customerService.getCustomerById(id);
		return customer;
		 
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer){
		String msg ="1";
		
		try {
			customerService.updateCustomer(customer);
			msg = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
		
	}
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id){
		String msg ="1";
		try {
			customerService.deleteCustomer(id);
			msg = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
		
	}

	
	
	@RequestMapping("myTage")
	public String myTage(){
		
		return "myTage";
		
	}

}
