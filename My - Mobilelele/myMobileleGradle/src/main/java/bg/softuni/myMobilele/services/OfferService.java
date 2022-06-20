package bg.softuni.myMobilele.services;

import bg.softuni.myMobilele.models.dto.AddOfferDTO;
import bg.softuni.myMobilele.models.entities.ModelEntity;
import bg.softuni.myMobilele.models.entities.OfferEntity;
import bg.softuni.myMobilele.models.entities.UserEntity;
import bg.softuni.myMobilele.models.mapper.OfferMapper;
import bg.softuni.myMobilele.repositories.ModelRepository;
import bg.softuni.myMobilele.repositories.OfferRepository;
import bg.softuni.myMobilele.repositories.UserRepository;
import bg.softuni.myMobilele.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {
    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private ModelRepository modelRepository;
    private CurrentUser currentUser;
    private OfferMapper offerMapper;

    @Autowired
    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        ModelRepository modelRepository,
                        CurrentUser currentUser,
                        OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public Optional<OfferEntity> getOffers() {
        return offerRepository.findById(Long.valueOf(1));
    }

    public void addOffer(AddOfferDTO addOfferDTO){
        OfferEntity newOffer = offerMapper.
                addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository.findByEmail(currentUser.getEmail()).
                orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).
                orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }
}
