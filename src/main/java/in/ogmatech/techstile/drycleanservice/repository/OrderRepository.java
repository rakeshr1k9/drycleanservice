package in.ogmatech.techstile.drycleanservice.repository;

import in.ogmatech.techstile.drycleanservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByIsDeletedAndBranchIdAndOrderStatusIdInOrderByOrderShouldDeliverAtAsc(Byte isDeleted, Integer branchId, List<Integer> orderStatusId);
    List<Order> findByIsDeletedAndBranchIdAndCustomerMobileOrderByOrderShouldDeliverAtAsc(Byte isDeleted, Integer branchId, Long customerMobile);
    List<Order> findByIsDeletedAndBranchIdAndOrderNumberLikeOrderByOrderShouldDeliverAtAsc(Byte isDeleted, Integer branchId, Integer orderNumber);
    List<Order> findByIsQuickDeliveryAndIsDeletedAndBranchIdAndOrderStatusIdInOrderByOrderShouldDeliverAtAsc(Byte isQuickDelivery, Byte isDeleted, Integer branchId, List<Integer> orderStatusId);
}
