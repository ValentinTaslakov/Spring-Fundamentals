package bg.softuni.myMobilele.models.dto;

import bg.softuni.myMobilele.models.enums.EngineType;
import bg.softuni.myMobilele.models.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddOfferDTO {
    @NotNull
    @Min(1)
    private Long modelId;
    @NotNull
    private EngineType engine;
    @NotNull
    @Positive
    private Integer price;
    @NotNull
    @Min(1900)
    private Integer year;
    @NotEmpty
    private String description;
    @NotNull
    private TransmissionEnum transmission;
    @NotEmpty
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public AddOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public AddOfferDTO setEngine(EngineType engine) {
        this.engine = engine;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
