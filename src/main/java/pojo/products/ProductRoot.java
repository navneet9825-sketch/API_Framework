package pojo.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRoot
{
   @JsonProperty("current_page")
   private int currentPage;
   @JsonProperty("data")
    private List<Product> product;
   private int from;
   @JsonProperty("last_page")
    private int lastPage;
   @JsonProperty("per_page")
    private int perPage;
   private int to;
   private int total;


}
