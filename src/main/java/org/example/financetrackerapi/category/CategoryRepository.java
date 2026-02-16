package org.example.financetrackerapi.category;

import org.example.financetrackerapi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUser(User user);

    Optional<Category> findByIdAndUser(Long id, User user);

    boolean existsByUserAndName(User user, String name);
}
