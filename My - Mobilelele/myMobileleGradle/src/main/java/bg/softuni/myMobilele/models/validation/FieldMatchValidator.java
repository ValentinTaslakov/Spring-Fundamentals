package bg.softuni.myMobilele.models.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
// имплементираме логиката на валидатора
// като при ConstraintValidator<FieldMatch, Object> посочваме нашат къстъм
// анотация и типа който ще валидираме, тук избираме Обект за да може да подаваме
// различни обекти, а не само от един тип.
public class FieldMatchValidator implements
        ConstraintValidator<FieldMatch, Object> {
// инициализираме си нужните ни променливи
    private String first;
    private String second;
    private String message;
//тези методи си идват по дефолт в следствие на имплементацията
// В първия правим инициализацията, подааваме нашата анотация
// и вътре казваме какви стойности да вземат нашите променливи
// като стринг се ориентира по анотациите в класа който ще валидираме
    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }
// тук е логиката за валидиране, подаваме че ще получим обект и другото
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
//  Създаваме долното за да можем да получим достъп да полетата на подадения
//  обект.
        BeanWrapper beanWrapper = PropertyAccessorFactory
                .forBeanPropertyAccess(value);
// Взимаме нужните ни стойности, които ще сравняваме
        Object firstValue = beanWrapper.getPropertyValue(this.first);
        Object secondValue = beanWrapper.getPropertyValue(this.second);
// флаг с който връщаме резултата
        boolean valid;
// Правим сравнението и присвояваме съответната стойност на резултата
        if (firstValue == null) {
            valid = secondValue == null;
        } else {
            valid = firstValue.equals(secondValue);
        }
//  Ако стойностите не са еднакви трябва да изведем съответните съобщения
//  които ще конкретезираме в класа който валидираме
        if (!valid) {
            context.
                    buildConstraintViolationWithTemplate(message).
                    addPropertyNode(second).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }

        return valid;
    }
}
