package com.lab11.laborator11.service;

import com.lab11.laborator11.entity.Player;
import com.lab11.laborator11.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public Player savePlayer(Player player){                    //POST -> salveaza un singur player
       return repository.save(player);
    }
    public List<Player> savePlayers(List<Player> players){      //POST -> salveza mai multi playeri
        return repository.saveAll(players);
    }
    public List<Player> getPlayers(){
        return repository.findAll();
    }
    public Player getPlayerById(int id){                        //GET -> cauta dupa id
        return repository.findById(id).orElse(null);
    }
    public Player getPlayerByName(String name){                 //GET -> cauta dupa nume
        return repository.findByName(name);
    }
    public String deletePlayer(int id){
        repository.deleteById(id);
        return "Player-ul cu id-ul "+id+" a fost sters";        //DELETE -> sterge in functie de id
    }
    public Player playerUpdate(Player player){
        Player playerExistent = repository.findById(player.getId()).orElse(null);
        playerExistent.setName(player.getName());
        playerExistent.setCountry(player.getCountry());
        return repository.save(playerExistent);
    }

}
