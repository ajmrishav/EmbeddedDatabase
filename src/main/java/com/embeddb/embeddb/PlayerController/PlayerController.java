package com.embeddb.embeddb.PlayerController;

import com.embeddb.embeddb.Entity.PlayerDetail;
import com.embeddb.embeddb.Model.PlayerDetailModel;
import com.embeddb.embeddb.PlayerDetailService.PlayerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class PlayerController {

    @Autowired
    PlayerDetailService playerDetailService;

    @GetMapping("/check/{id}")
    public PlayerDetailModel test(@PathVariable("id") Integer id){
        return playerDetailService.saveDetails(id);
    }

    @RequestMapping(value = "/insert/playerdetail", method = RequestMethod.POST)
    public Boolean insertPlayerDetail(@RequestBody PlayerDetailModel playerDetailModel) {
        playerDetailService.insertPlayerData(playerDetailModel);
        return true;
    }

    @PostMapping("/get/player")
    public List<PlayerDetail> getPlayerDetailList() {
        return playerDetailService.getPlayerList();
    }

}

