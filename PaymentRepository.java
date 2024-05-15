package hp.net.demospringang2.repository;

import hp.net.demospringang2.entities.Payment;
import hp.net.demospringang2.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository  extends JpaRepository<Payment,Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findAllByStatus (String status);
    List<Payment> findByType(PaymentType type);
}
