package bg.softuni.myMobilele.models.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUserEmailValidator.class)
public @interface UniqueUserEmail {

  String message() default "Invalid Email";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

//  правим си анотация с която валидираме това че имейла, който взимаме
//  за юзърнаме, е уникален , няма друг с такъв в базата.
}
