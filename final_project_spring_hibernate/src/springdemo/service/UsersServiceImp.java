package springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.dao.UsersDAO;
import springdemo.entity.Users;

@Service
public class UsersServiceImp implements UsersService {
	
	@Autowired
	public UsersDAO usersDAO;

	@Override
	@Transactional
	public void  registerUsers(Users user) {
		usersDAO.registerUsers(user);
	
	}

	@Override
	@Transactional
	public Users login(Users user) {
		Users userLogin = usersDAO.login(user);;
		
		return userLogin;
	}

	@Override
	@Transactional
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return usersDAO.getUsers();
	}

	@Override
	@Transactional
	public Users getUser(int user_id) {
		// TODO Auto-generated method stub
		return usersDAO.getUser(user_id);
	}

}
