package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tool.ResultData;
import dao.UserMapper;
import entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;	
	
	public User getUserById(Long id) {		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResultData isLogin(String usercode, String userpassword) {
		ResultData rd = new ResultData();
		User u = userMapper.getLoginData(usercode);
		if(u!=null&&userpassword.equals(u.getUserpassword())){			
			rd.setFlag(1);
			rd.setData(u);
		}else{
			rd.setFlag(0);
			rd.setMsg("�û������������!");
		}
		return rd;
	}

	@Override
	public ResultData getUsers() {
		ResultData rd = new ResultData();
		List<User> list = userMapper.getUsers();
		if(list!=null){
			rd.setData(list);			
		}else{
			rd.setFlag(0);
			rd.setMsg("����ʧ��");
		}		
		return rd;
	}

	@Override
	public ResultData addUser(User u) {
		ResultData rd = new ResultData();
		int len = userMapper.insertSelective(u);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("��ӳɹ�");
		}else{
			rd.setFlag(0);
			rd.setMsg("���ʧ��");
		}
		return rd;
	}

	@Override
	public ResultData delUser(Long id) {
		ResultData rd = new ResultData();
		int len = userMapper.deleteByPrimaryKey(id);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("ɾ���ɹ�");
		}else{
			rd.setFlag(0);
			rd.setMsg("ɾ��ʧ��");
		}
		return rd;
	}

	@Override
	public ResultData updateUser(User u) {
		ResultData rd = new ResultData();
		int len = userMapper.updateByPrimaryKeySelective(u);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("���³ɹ�");
		}else{
			rd.setFlag(0);
			rd.setMsg("����ʧ��");
		}
		return rd;
	}

}
