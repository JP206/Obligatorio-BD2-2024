package com.bd2.api.repositories;

import com.bd2.api.dto.LeaderboardDTO;
import java.util.LinkedList;

public interface ILeaderboardRepository {
    
    public LinkedList<LeaderboardDTO> getLeaderboard();
    public LinkedList<LeaderboardDTO> getTop15();
    public int getPuntaje(String correo);
}
