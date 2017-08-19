package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Provider;

public interface ProviderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
    
    @Select("select * from smbms_provider")
    List<Provider> getProviders();
}