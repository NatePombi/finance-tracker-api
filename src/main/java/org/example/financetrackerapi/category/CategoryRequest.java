package org.example.financetrackerapi.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryRequest {
    @NotBlank(message = "category name cannot be empty")
    private String categoryName;
    @NotNull(message = "category type cannot be null")
    private CategoryType categoryType;
}
