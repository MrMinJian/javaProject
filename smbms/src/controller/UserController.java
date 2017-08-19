package controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

import entity.User;
import service.UserService;
import tool.ResultData;
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//方法一:ModelAndView为返回类型
	/*@RequestMapping("/login")
	public ModelAndView isLogin(String usercode,String userpassword,HttpSession session){
		ModelAndView model = new ModelAndView();
		ResultData rd = userService.isLogin(usercode, userpassword);
		if(rd.getFlag()==1){
			session.setAttribute("user", rd.getData());
			model.setViewName("redirect:/frame.jsp");
		}else{
			session.setAttribute("result", rd);
			model.setViewName("login");
		}
		return model;
	}*/
	
	//方法二:Model作为参数 等同于request
		/*@RequestMapping("/login")
		public String isLogin(String usercode,String userpassword,Model model,HttpSession session){
			ResultData rd = userService.isLogin(usercode, userpassword);
			if(rd.getFlag()==1){
				session.setAttribute("user", rd.getData());
				return "redirect:/frame.jsp";
			}else{
				model.addAttribute("result",rd);
				return "login";
			}
		}*/
	
	// 方法三:Map作为参数
	/*@RequestMapping("/login")
	public String isLogin(String usercode,String userpassword,Map<String,Object> model,HttpSession session) {
		ResultData rd = userService.isLogin(usercode, userpassword);
		if (rd.getFlag() == 1) {
			session.setAttribute("user", rd.getData());
			return "redirect:/frame.jsp";
		} else {
			model.put("result", rd);
			return "login";
		}
	}*/
	
	// 方法四:json
	@RequestMapping("/login")
	@ResponseBody
	public String isLogin(String usercode, String userpassword,HttpSession session) {
		ResultData rd = userService.isLogin(usercode, userpassword);
		if (rd.getFlag() == 1) {
			session.setAttribute("user", rd.getData());
		}
		return JSON.toJSONString(rd);
	}	
	//读取所有用户信息
	@RequestMapping(value="userList")
	public String getAllUser(Map<String,Object> map){
		ResultData rd = userService.getUsers();
		map.put("result", rd.getData());
		//System.out.println(rd.getData());
		return "userList";
	}
	
	//读取单个用户信息
	@RequestMapping(value="userRest/{id}",method=RequestMethod.GET)
	public String getUserById(@PathVariable("id") Long id,Map<String, Object> map) {
		User u = userService.getUserById(id);
		map.put("result", u);
		return "userView";
	}
	//添加用户
	@RequestMapping(value="/userRest",method=RequestMethod.POST)
	public String addUser(User u,Map<String, Object> map) {
		ResultData rd = userService.addUser(u);
		if(rd.getFlag()==0){
			map.put("result", rd);
			return "userAdd";
		}		
		return "redirect:/user/userList";
	}
	//删除用户
	@RequestMapping(value="userRest/{id}",method=RequestMethod.DELETE)
	public String delUser(@PathVariable("id") Long id,Map<String, Object> map){
		ResultData rd = userService.delUser(id);
		if(rd.getFlag()==0){
			map.put("delresult", rd);
			return "userView";
		}
		return "redirect:/user/userList";
	}
	//跳转到更新页面
	@RequestMapping("toUpdate/{id}")
	public String toUpdate(@PathVariable("id")Long id,Map<String, Object> map){
		User u = userService.getUserById(id);
		map.put("user", u);
		
		Map<String, String> sexs = new HashMap<String, String>();
		sexs.put("1", "女");
		sexs.put("2", "男");
		map.put("sexs", sexs);
		
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("1", "系统管理员");
		roles.put("2", "经理");
		roles.put("3", "普通用户");
		map.put("roles", roles);
		return "userUpdate";
	}
	
	@RequestMapping("update")
	public String updateUser(User user,Map<String, Object> map){
		ResultData rd = userService.updateUser(user);
		if(rd.getFlag()==0){
			map.put("updateResult", rd);
			return "userUpdate";
		}
		return "redirect:/user/userList";
	}
	
	@ModelAttribute
	public void init(Long id,Map<String, Object> map){
		if(id!=null){
			/*User u = userService.getUserById(id);
			map.put("user", u);*/
		}
	}
}
