package com.demo.repository;

import com.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository
        extends PagingAndSortingRepository<Category, Integer>,
                CategoryRepositoryCustom,
                JpaSpecificationExecutor<Category> {
    //extends CrudRepository<Category, Integer> {

    /*
     * search
     * sort_by
     * direction
     * offset
     * limit
     *
     * where (:q is null or c.name like %:q%)
     * /api/category?q=java
     *
     * if :q == null => where 1
     * https://www.baeldung.com/spring-data-jpa-null-parameters
     * Ignoring null Parameters Using the @Query Annotation
     *
     * if :q != null => where c.name like %:q%
     * */

    @Query(
        value = "select c from Category c where (:q is null or c.name like %:q%)"
    )
    Page<Category> findAllOrFilter(@Param("q") String searchingText, Pageable pageable);

    Category findBySlug(String slug);
}
