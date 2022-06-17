package bg.softuni.myMobilele.models.validation;


import bg.softuni.myMobilele.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserEmailValidator implements
        ConstraintValidator<UniqueUserEmail, String> {

//  Инжектираме си репозиторито защото ще търсим в базата
  private UserRepository userRepository;

  public UniqueUserEmailValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
// оставаме само този метод защото валидираме стойност само за едно поле
// и не ни е нужна инициализация
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
// връщаме резултата от търсенето
    return userRepository.
        findByEmail(value).
        isEmpty();
  }
}
