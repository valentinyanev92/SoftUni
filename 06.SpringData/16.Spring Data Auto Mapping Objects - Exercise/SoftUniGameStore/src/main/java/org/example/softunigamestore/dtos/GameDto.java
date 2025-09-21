package org.example.softunigamestore.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class GameDto {
    @NotEmpty
    @Size(min = 3, max = 100)
    private String title;

    @NotEmpty
    @Positive
    private BigDecimal price;

    @NotEmpty
    @Positive
    private double size;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String trailer;

    @NotEmpty
    @Pattern(regexp = "^https?://[a-zA-Z0-9./_-]+$")
    private String thumbnailUrl;

    @NotEmpty
    @Size(min = 20)
    private String description;

    private String  releaseDate;

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %s%nDescription: %s%nRelease date: %s%n", title, price, description, releaseDate);
    }

    public GameDto() {}

    public GameDto(String title, BigDecimal price, double size, String trailer, String thumbnailUrl, String description, String  releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
