package com.example.demo.util;

import com.example.demo.models.entities.CategoryEntity;
import com.example.demo.models.enums.CategoryEnum;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<CategoryEntity> categories =
                    Arrays.stream(CategoryEnum.values())
                            .map(CategoryEntity::new)
                            .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
        }
    }
}
