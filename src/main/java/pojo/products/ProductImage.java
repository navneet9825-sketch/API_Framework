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
public class ProductImage
{
    private String id;
    @JsonProperty("by_name")
    private String byName;
    @JsonProperty("by_url")
    private String byUrl;
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("source_url")
    private String sourceUrl;
    @JsonProperty("file_name")
    private String fileName;
    private String title;
}
