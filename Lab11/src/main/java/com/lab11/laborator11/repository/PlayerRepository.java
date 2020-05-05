package com.lab11.laborator11.repository;

import com.lab11.laborator11.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository <Player,Integer> {
    Player findByName(String name);
}
