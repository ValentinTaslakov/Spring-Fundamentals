package bg.softuni.myMobilele.services;


import bg.softuni.myMobilele.models.dto.BrandDTO;
import bg.softuni.myMobilele.models.dto.ModelDTO;
import bg.softuni.myMobilele.models.entities.BrandEntity;
import bg.softuni.myMobilele.models.entities.ModelEntity;
import bg.softuni.myMobilele.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

  private BrandRepository brandRepository;

  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }
//взимаме всички марки
  public List<BrandDTO> getAllBrands() {
    return brandRepository.
        findAll().
        stream().
        map(this::mapBrand).
        collect(Collectors.toList());
  }
//към всяка марка добавяме списъка със моделите
  private BrandDTO mapBrand(BrandEntity brandEntity) {
    List<ModelDTO> models = brandEntity.
        getModels().
        stream().
        map(this::mapModel).
        toList();

    return new BrandDTO().
        setModels(models).
        setName(brandEntity.getName());
  }
//сетваме ид-то и името на модела
  private ModelDTO mapModel(ModelEntity modelEntity) {
    return new ModelDTO().
        setId(modelEntity.getId()).
        setName(modelEntity.getName());
  }

//  правим данните в дто и после използваме дто-то да подадем на Html-ла
//  който да ги зареди във формата за добавяне на оферти
}
