package com.bd2.api.web;

import com.bd2.api.dto.LeaderboardDTO;
import com.bd2.api.repositories.ILeaderboardRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class LeaderboardController {
    
    private final ILeaderboardRepository leaderboardRepository;
    
    @Autowired
    public LeaderboardController(final ILeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }
    
    @GetMapping(path = "/leaderboard")
    public @ResponseBody LinkedList<LeaderboardDTO> getPartidos() { //@ResponseBody serializa JSON en el body del response
        return leaderboardRepository.getLeaderboard();
    }
}