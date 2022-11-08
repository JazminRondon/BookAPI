package com.BetterWorldBook.BookAPI.repository;

import com.BetterWorldBook.BookAPI.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {


}
