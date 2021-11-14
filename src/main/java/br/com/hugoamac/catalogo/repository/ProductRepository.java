package br.com.hugoamac.catalogo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hugoamac.catalogo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	public Page<Product> findByNameContaining(String name, Pageable page);
}
