package com.vitorlipe.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlipe.boot.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
