package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BillMapper;
import tool.ResultData;
import entity.Bill;

@Service
@Transactional
public class BillServiceImpl implements BillService {
	@Autowired
	private BillMapper billMapper;
	
	@Override
	public Bill getBillById(Long id) {
		return billMapper.selectByPrimaryKey(id);		
	}

	@Override
	public ResultData getBills() {
		ResultData rd = new ResultData();
		List<Bill> list = billMapper.getBills();
		if(list!=null){
			rd.setFlag(1);
			rd.setData(list);
		}else{
			rd.setFlag(0);
			rd.setMsg("����ʧ��");
		}
		return rd;
	}

	@Override
	public ResultData addBill(Bill p) {
		ResultData rd = new ResultData();
		int len = billMapper.insertSelective(p);
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
	public ResultData delBill(Long id) {
		ResultData rd = new ResultData();
		int len = billMapper.deleteByPrimaryKey(id);
		if(len>0){
			rd.setFlag(1);
			rd.setMsg("ɾ���ɹ�");
		}else{
			rd.setFlag(0);
			rd.setMsg("ɾ��ʧ��");
		}
		return rd;
	}
	
}
