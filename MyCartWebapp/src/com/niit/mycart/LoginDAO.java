package com.niit.mycart;

public class LoginDAO {
	public boolean IsValidUser(String UserId,String Password){
		if(UserId.equals(Password))
				{
				return true;
				}
		else
		{
			return false;
		}
	}

}
