package bg.softuni.myMobilele.models.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//след като сложим депенденсито правим собствена анотация
//слагаме тези три анотации при @Target посочваме типа като в случая
// ElementType.TYPE взима целия клас(тук ни е нужно защото сравняваме две полета)
// при @Target(ElementType.FIELD) взима само едно поле.
// В @Constraint посочваме класа в който се имплементира логиката за валидиране
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {

    String first();

    String second();
// долу трите полета са задължителни?!
// а горе сме добавили тези които са ни нужни на нас
// в случая две полета които ще сравняваме.
    String message() default "Invalid Email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
