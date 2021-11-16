package io.hitman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import io.hitman.model.Hitman;


@Repository
public interface HitmanRepository extends JpaRepository<Hitman, Long>{

}
