package hp.net.demospringang2;

import hp.net.demospringang2.entities.PayementStatus;
import hp.net.demospringang2.entities.Payment;
import hp.net.demospringang2.entities.PaymentType;
import hp.net.demospringang2.entities.Student;
import hp.net.demospringang2.repository.PaymentRepository;
import hp.net.demospringang2.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoSpringAngApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Mohamed")
                    .code("125856").programId("BDCC")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("CHAIMAA")
                    .code("128646").programId(" BDCC")
                    .build());

            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Hassan")
                    .code("18563").programId("sadia")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Sarah")
                    .code("169856").programId("sadia")
                    .build());

            PaymentType[] paymentTypes =PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st->{
                for (int i =0; i<10 ;i++){
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment =Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .type(paymentTypes[index])
                            .status(PayementStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();

                    paymentRepository.save(payment);
                }

        });

    };

    }

}