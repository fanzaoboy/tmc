package com.tmc.DAO;

public interface UserDAO {

	/***
	 * 
	 * @author hd
	 * @param userName、passWord、mobileNo
	 * @since 2019-10-11
	 */
	public void userAdd(String userName, String passWord, String mobileNo);
	
	/***
	 * 
	 * @author hd
	 * @param userName、passWord、mobileNo
	 * @since 2019-10-11
	 */
	public int userLogin(String userName, String passWord);
	
	
}
