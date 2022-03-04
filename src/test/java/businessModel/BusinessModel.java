package businessModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessModel {
    private String name;
    private String lastName;
    private String gender;
    private boolean isMarried;
}
