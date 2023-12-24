package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Category;
import cu.edu.cujae.rentacarback.repository.CategoryRepository;
import cu.edu.cujae.rentacarback.service.core.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> update(Integer id, Category newCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    newCategory.setName(newCategory.getName());
                    return categoryRepository.save(category);
                });
    }

    @Override
    public Optional<Category> delete(Integer id) {
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return category;
        });
    }
}
