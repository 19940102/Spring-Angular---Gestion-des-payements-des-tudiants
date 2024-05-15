package hp.net.demospringang2.web;

import hp.net.demospringang2.entities.Payment;
import hp.net.demospringang2.entities.Student;
import hp.net.demospringang2.repository.PaymentRepository;
import hp.net.demospringang2.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class PaymentRestController {

    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    public PaymentRestController(PaymentRepository paymentRepository,StudentRepository studentRepository){
        this.paymentRepository = paymentRepository;
        this.studentRepository= studentRepository;
    }
    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();}
     @GetMapping(path ="student/{code}/payments")
   public List<Payment> PaymentsByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);}
       @GetMapping(path =  "/payments/{id}")
    public  Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
@GetMapping("/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/students/{code}")
public Student getStudentByCode(@PathVariable String code){
    return  studentRepository.findByCode(code);
    }
    @GetMapping("/studentsByProgramId")
    public List<Student>  getStudentsByProgramId(@RequestParam String programId){
    return studentRepository.findByProgramId(programId);
    }
}

