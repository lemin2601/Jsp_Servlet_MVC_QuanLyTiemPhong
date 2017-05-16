package model.bo;

import java.util.ArrayList;

import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	
	private UserDAO _DAO;
	
	public UserBO(){
		_DAO  = new UserDAO();
	}
	
	public int addItem(User item){
		return _DAO.addItem(item);
	}
	
	public int editItem(User item){
		return _DAO.editItem(item);
	}
	
	public int deleteItem(long item){
		return _DAO.deleteItem(item);
	}
	
	public User CheckUser(String user){
		return _DAO.getItem(user);
	}
	
	public User CheckLogin(User item){
		return _DAO.getItem(item.getUsername(), item.getPassword());
	}
	public User CheckLogin(String user,String pass){
		return _DAO.getItem(user,pass);
	}
	public ArrayList<User> getList(){
		return _DAO.getList();
	}
	public ArrayList<User> getList(long start,long num){
		return _DAO.getList(start,num);
	}
	public ArrayList<User> getList(long start,long num,String key){
		return _DAO.getList(start,num,key);
	}
	public long countItems(){
		return _DAO.countItems();
	}
	public long countItems(String key){
		return _DAO.countItems(key);
	}
	
        
        public User getUser(long id){
		return _DAO.getItem(id);
	}
	
	
}
