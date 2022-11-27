package com.visionaryCrofting.demo.repositories;

import com.visionaryCrofting.demo.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
