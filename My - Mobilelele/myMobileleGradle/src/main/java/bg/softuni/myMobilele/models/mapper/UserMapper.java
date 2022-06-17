package bg.softuni.myMobilele.models.mapper;

import bg.softuni.myMobilele.models.dto.UserRegisterDTO;
import bg.softuni.myMobilele.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Създаваме интерфейс за този мапър с тази анотация
@Mapper(componentModel = "string")
public interface UserMapper {

//    И за метода изписваме какъв обект искаме да получим след мапването
//    и в скобите кой обект ще подадем
//    анотацията не знам много за нея
    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);
}
