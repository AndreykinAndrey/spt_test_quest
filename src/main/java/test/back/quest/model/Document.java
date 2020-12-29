package test.back.quest.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@ToString
@Validated
public class Document {
    @NotBlank
    @Size(min = 9, max = 9)
    private String seller;
    @NotBlank
    @Size(min = 9, max = 9)
    private String customer;

    @NotEmpty
    ArrayList<@Valid Product> products;

}
