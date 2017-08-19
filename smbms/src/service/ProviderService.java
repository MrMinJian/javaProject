package service;

import tool.ResultData;
import entity.Provider;

public interface ProviderService {
	Provider getProviderById(Long id);
	
	ResultData getProviders();
	
	ResultData addProvider(Provider p);
	
	ResultData delProvider(Long id);
}
