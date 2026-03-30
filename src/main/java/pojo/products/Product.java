package pojo.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product
{
    private String id;
    private String name;
    private String description;
    private float price;
    @JsonProperty("is_location_offer")
    private String isLocationOffer;
    @JsonProperty("is_rental")
    private String isRental;
    @JsonProperty("co2_rating")
    private String co2Rating;
    @JsonProperty("in_stock")
    private String inStock;
    @JsonProperty("is_eco_friendly")
    private String isEcoFriendly;
    @JsonProperty("product_image")
    private ProductImage productImage;
    private Category category;
    private Brand brand;
}
