package spring_boot_board.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot_board.domain.OrderListDTO;
import spring_boot_board.domain.PaymentDTO;
import spring_boot_board.domain.PurchaseDTO;

@Repository
public class PurchaseRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "purchaseRepositorySql";
	String statement;
	
	public String selectPurchaseNum() {
		statement = namespace + ".selectPurchaseNum";
		return sqlSession.selectOne(statement);
	}
	public int purchaseInsert(PurchaseDTO dto) {
		statement = namespace + ".purchaseInsert";
		return sqlSession.insert(statement, dto);
	}
	public int purchaseListInsert(Map<String, Object> map) {
		statement = namespace + ".purchaseListInsert";
		return sqlSession.insert(statement, map);
	}
	public PurchaseDTO purchaseSelectOne(String purchaseNum) {
		statement = namespace + ".purchaseSelect";
		return sqlSession.selectOne(statement,purchaseNum);
	}
	public int paymentInsert(PaymentDTO dto) {
		statement = namespace + ".paymentInsert";
		return sqlSession.insert(statement,dto);
	}
	public List<OrderListDTO> orderList(Map<String , String> map){
		statement = namespace + ".orderList";
		return sqlSession.selectList(statement, map);
	}
}