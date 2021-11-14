package br.com.hugoamac.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hugoamac.catalogo.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>{

}
