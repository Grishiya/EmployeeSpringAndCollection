package pro.sky.java.course2.EmployeeSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "В имени могут быть только буквы")
public class IllegalNameException extends IllegalArgumentException {

   public IllegalNameException(String message) {
       super(message);
    }
}
