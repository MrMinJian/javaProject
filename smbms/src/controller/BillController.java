package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Bill;
import entity.Provider;
import service.BillService;
import service.BillServiceImpl;
import service.ProviderService;
import service.ProviderServiceImpl;
import tool.ResultData;

@Controller
@RequestMapping("bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	//加载所有商品
		@RequestMapping(value="billList")
		public String getAllBill(Map<String,Object> map){
			ResultData rd = billService.getBills();
			if(rd.getFlag()==1){
				map.put("bList", rd.getData());
			}else{
				map.put("bList", rd);
			}
			return "billList";
		}
		
		//加载指定商品
		@RequestMapping(value="billRest/{id}")
		public String getBillById(@PathVariable("id")Long id,Map<String,Object> map){
			Bill b = billService.getBillById(id);
			if(b!=null){
				map.put("bill",b);
			}
			return "billView";
		}
		//跳转到添加页面
		@RequestMapping("toAdd")
		public String toAdd(Map<String,Object> map){
			ProviderService providerService = new ProviderServiceImpl();
			ResultData rd = providerService.getProviders();
			Map<String, String> providers = new HashMap<String, String>();			
			for(Provider p : (List<Provider>)rd.getData()){
				providers.put(p.getId().toString(),p.getProname());
			}
			map.put("providers", providers);
			return "billAdd";
		}
		
		//添加商品
		@RequestMapping(value="billRest",method=RequestMethod.POST)
		public String addBill(Bill b,Map<String,Object> map){
			ResultData rd = billService.addBill(b);
			map.put("addResult",rd);
			if(rd.getFlag()==1){			
				return "redirect:/bill/billList";
			}else{
				return "billAdd";
			}		
		}
		
		//删除商品
		@RequestMapping(value="billRest/{id}",method=RequestMethod.DELETE)
		public String delBill(@PathVariable("id")Long id,Map<String,Object> map){
			ResultData rd = billService.delBill(id);
			map.put("delResult",rd);
			if(rd.getFlag()==1){			
				return "redirect:/bill/billList";
			}else{
				return "billView";
			}
		}
}
