package org.example.financetrackerapi.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {
    private String name;
    private CategoryType type;
}
