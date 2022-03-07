package businessModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessModel {
    private boolean success;
    private String deck_id;
    private int remaining;
    private boolean shuffled;
}
