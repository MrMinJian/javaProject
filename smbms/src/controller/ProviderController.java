package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Provider;
import service.ProviderService;
import tool.ResultData;

@Controller
@RequestMapping("provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	//加载所有供应商
	@RequestMapping(value="providerList")
	public String getAllProvider(Map<String,Object> map){
		ResultData rd = providerService.getProviders();
		if(rd.getFlag()==1){
			map.put("pList", rd.getData());
		}else{
			map.put("pList", rd);
		}
		return "providerList";
	}
	
	//加载指定供应商
	@RequestMapping(value="providerRest/{id}")
	public String getProviderById(@PathVariable("id")Long id,Map<String,Object> map){
		Provider p = providerService.getProviderById(id);
		if(p!=null){
			map.put("provider",p);
		}
		return "providerView";
	}
	
	//添加供应商
	@RequestMapping(value="providerRest",method=RequestMethod.POST)
	public String addProvider(Provider p,Map<String,Object> map){
		ResultData rd = providerService.addProvider(p);
		map.put("addResult",rd);
		if(rd.getFlag()==1){			
			return "redirect:/provider/providerList";
		}else{
			return "providerAdd";
		}		
	}
	
	//删除供应商
	@RequestMapping(value="providerRest/{id}",method=RequestMethod.DELETE)
	public String delProvider(@PathVariable("id")Long id,Map<String,Object> map){
		ResultData rd = providerService.delProvider(id);
		map.put("delResult",rd);
		if(rd.getFlag()==1){			
			return "redirect:/provider/providerList";
		}else{
			return "providerView";
		}
	}
}
