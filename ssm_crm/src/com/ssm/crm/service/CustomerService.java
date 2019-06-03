package com.ssm.crm.service;

import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;
import com.ssm.crm.utils.Page;



/**
 * 客户信息业务逻辑接口
 * @author Administrator
 *
 */
public interface CustomerService {
	
	/**
	 * 查询查询条件，分页查询用户列表
	 * @param vo
	 * @return
	 */
	Page<Customer> getCustomerByQueryVo(QueryVo vo);
	
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	Customer getCustomerById(Integer id);
	
	/**
	 * 更新客户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Integer id);


}
