package testrail.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestResultRequest {
    private int status_id;
    private int assignedto_id;
    private List<Object> custom_step_results = new ArrayList<>();
}
