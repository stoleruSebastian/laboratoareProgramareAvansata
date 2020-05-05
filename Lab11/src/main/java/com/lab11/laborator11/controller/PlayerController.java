package com.lab11.laborator11.controller;

import com.lab11.laborator11.entity.Player;
import com.lab11.laborator11.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService service;
    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
        return service.savePlayer(player);
    }
    @PostMapping("/addPlayers")
    public List<Player> addPlayers(@RequestBody List<Player> players){
        return service.savePlayers(players);
    }
    @GetMapping("/players")
    public List<Player> findAll(){
        return service.getPlayers();
    }
    @GetMapping("/playerByName/{name}")
    public Player findByName(@PathVariable String name){
        return service.getPlayerByName(name);
    }
    @GetMapping("/playerById/{id}")
    public Player findById(@PathVariable int id){
       return service.getPlayerById(id);
    }
    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player){
        return service.playerUpdate(player);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id){
        return service.deletePlayer(id);
    }
}
