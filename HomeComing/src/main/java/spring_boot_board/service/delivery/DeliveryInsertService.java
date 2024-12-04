package spring_boot_board.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.domain.DeliveryDTO;
import spring_boot_board.repository.DeliveryRepository;

@Service
public class DeliveryInsertService {
	@Autowired
	DeliveryRepository deliveryRepository;
	public void execute(String purchaseNum, String deliveryNum) {
		DeliveryDTO dto= new DeliveryDTO();
		dto.setDeliveryNum(deliveryNum);
		dto.setPurchaseNum(purchaseNum);
		deliveryRepository.deliveryInsert(dto);	
	}
}