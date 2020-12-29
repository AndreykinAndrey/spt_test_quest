package test.back.quest.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
public class Product {
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 13, max = 13)
    private String code;
}
