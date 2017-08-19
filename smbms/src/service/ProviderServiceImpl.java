package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.ResultData;
import dao.ProviderMapper;
import entity.Provider;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	ProviderMapper providerMapper;

	@Override
	public Provider getProviderById(Long id) {
		return providerMapper.selectByPrimaryKey(id);		
	}

	@Override
	public ResultData getProviders() {
		ResultData rd = new ResultData();
		List<Provider> list = providerMapper.getProviders();
		if(list!=null){
			rd.setFlag(1);
			rd.setData(list);
		}else{
			rd.setFlag(0);
			rd.setMsg("¼ÓÔØÊ§°Ü");
		}
		return rd;
	}

	@Override
	public ResultData addProvider(Provider p) {
		ResultData rd = new ResultData();
		int len = providerMapper.insertSelective(p);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("Ìí¼Ó³É¹¦");
		}else{
			rd.setFlag(0);
			rd.setMsg("Ìí¼ÓÊ§°Ü");
		}
		return rd;
	}

	@Override
	public ResultData delProvider(Long id) {
		ResultData rd = new ResultData();
		int len = providerMapper.deleteByPrimaryKey(id);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("É¾³ý³É¹¦");
		}else{
			rd.setFlag(0);
			rd.setMsg("É¾³ýÊ§°Ü");
		}
		return rd;
	}
	
}
