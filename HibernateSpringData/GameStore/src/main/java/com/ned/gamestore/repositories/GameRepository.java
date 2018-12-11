package com.ned.gamestore.repositories;

import com.ned.gamestore.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);
}
