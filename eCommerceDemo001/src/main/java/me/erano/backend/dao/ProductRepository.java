package me.erano.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import me.erano.backend.entity.Product;

//CrossOrigin -> backend ve Front-Endi beraber yapmamıza yarayan bir mimari
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//query method
	//localhost:8080/api/products/search/findByCategoryId?id=1
	Page<Product> findByCategoryId(@Param("id")Long id, Pageable pageable);

	//query method
	//search for products by keyword
	//localhost:8080/api/products/search/findByNameContaining?name=Python
	Page<Product> findByNameContaining(@Param("name") String name,Pageable pageable);
	//Select * from Product p where p.name like concat('%',:name,'%')
	
	
}
