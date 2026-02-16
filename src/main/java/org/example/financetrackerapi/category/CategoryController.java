package org.example.financetrackerapi.category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.financetrackerapi.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest, @AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(user,categoryRequest.getCategoryName(),categoryRequest.getCategoryType()));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(categoryService.getAll(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(categoryService.getById(user,id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @Valid @RequestBody CategoryRequest categoryRequest, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(categoryService.update(user,id,categoryRequest.getCategoryName(),categoryRequest.getCategoryType()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @AuthenticationPrincipal User user) {
       categoryService.delete(user,id);
        return ResponseEntity.noContent().build();
    }
}
