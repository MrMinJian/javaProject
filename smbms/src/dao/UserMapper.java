package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select * from smbms_user where usercode=#{usercode}")
    User getLoginData(String usercode);
    
    @Select("select * from smbms_user")
    List<User> getUsers();
}