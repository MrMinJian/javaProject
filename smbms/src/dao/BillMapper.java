package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Bill;

public interface BillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
    
    @Select("select * from smbms_bill")
    List<Bill> getBills();
}