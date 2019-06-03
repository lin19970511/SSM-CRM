package com.ssm.crm.mapper;

import java.util.List;

import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;

/**
 * 客户信息持久化接口
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface CustomerMapper {
	/**
	 * 根据查询条件分页查询用户列表
	 * @param vo
	 * @return
	 */
	List<Customer> getCustomeByQueryVo(QueryVo vo);

	/**
	 * 根据查询条件查询总记录数
	 * @param vo
	 * @return
	 */
	Integer getCountByQueryVo(QueryVo vo);
	
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
	
	/**
	 * 删除客户信息
	 * @param id
	 */
	void deleteCustomer(Integer id); 

}
