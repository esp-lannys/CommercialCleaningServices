package se.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommercialCleaningServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommercialCleaningServicesApplication.class, args);
	}
 /*
  * https://www.baeldung.com/spring-security-login
  * kiểu như cái controller của em, nó chưa duyệt qua do file pom đó nữa
  * mà méo bỏ cái dependency vô thì project gãy hết, nên là có security
  * rồi ok làm cái trang anh gửi đi mốt anh chỉ oauth2 để lấy token , good luck, t mò xong rồi, code ở chú nhé, xíu làm không được hú anh
  */
}
