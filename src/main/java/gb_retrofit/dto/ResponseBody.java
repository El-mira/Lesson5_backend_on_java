package gb_retrofit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
