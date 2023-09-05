package pro.sky.java.course2.EmployeeSpring.util;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.course2.EmployeeSpring.exception.IllegalNameException;

public class EmployeeNameValidator {

    public static void checkName(String... names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new IllegalNameException("В имени должны быть только буквы");
            }
        }
    }
}
