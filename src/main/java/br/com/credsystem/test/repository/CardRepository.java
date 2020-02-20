package br.com.credsystem.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.credsystem.test.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
