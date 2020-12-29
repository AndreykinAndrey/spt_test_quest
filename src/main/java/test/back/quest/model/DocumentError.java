package test.back.quest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentError {
    private String field;
    private String message;

}
