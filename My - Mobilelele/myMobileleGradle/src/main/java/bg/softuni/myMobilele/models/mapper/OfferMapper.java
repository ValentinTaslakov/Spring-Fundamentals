package bg.softuni.myMobilele.models.mapper;


import bg.softuni.myMobilele.models.dto.AddOfferDTO;
import bg.softuni.myMobilele.models.entities.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {
  OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
