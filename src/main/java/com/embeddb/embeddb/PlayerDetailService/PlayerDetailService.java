package com.embeddb.embeddb.PlayerDetailService;

import com.embeddb.embeddb.Entity.PlayerDetail;
import com.embeddb.embeddb.Model.PlayerDetailModel;
import com.embeddb.embeddb.Model.PlayerDetailTO;
import com.embeddb.embeddb.PlayerDetailRepository.PlayerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PlayerDetailService {

    @Autowired
    private PlayerDetailRepository playerDetailRepository;

    public static final Logger log = Logger.getLogger(PlayerDetail.class.getName());

    public PlayerDetailModel saveDetails(Integer id) {
//       PlayerDetail playerDetail = new PlayerDetail();
//       Calendar cal = Calendar.getInstance();
//       playerDetail.setId(1);
//       playerDetail.setName("Rishav");
//       playerDetail.setDateOfBirth(null);
        PlayerDetailModel playerDetailModel = new PlayerDetailModel();
        Optional<PlayerDetail> playerDetail1 = playerDetailRepository.findById(id);
        if (playerDetail1.isPresent()) {
            log.log(Level.INFO, "Value " + playerDetail1.get().getName() + " " + playerDetail1.get().getId() + " " + playerDetail1.get().getDateOfBirth());
            playerDetailModel.setDateOfBirth(playerDetail1.get().getDateOfBirth());
            playerDetailModel.setId(playerDetail1.get().getId());
            playerDetailModel.setName(playerDetail1.get().getName());
        }
        return playerDetailModel;
    }

    public void insertPlayerData(PlayerDetailModel playerDetailModel) {

        PlayerDetail playerDetail = new PlayerDetail();
        playerDetail.setName(playerDetailModel.getName());
        playerDetail.setId(playerDetailModel.getId());
        playerDetail.setDateOfBirth(playerDetailModel.getDateOfBirth());
        log.log(Level.INFO, "Value " + playerDetail.getName() + " " + playerDetail.getId() + " " + playerDetail.getDateOfBirth());

        PlayerDetail savedOb = playerDetailRepository.saveAndFlush(playerDetail);

        log.log(Level.INFO,"Saved value is " + savedOb.getId());

//        Optional<PlayerDetail> playerDetail1 = playerDetailRepository.findById(playerDetailModel.getId());
//
//        log.log(Level.INFO, "Value " + playerDetail1.get().getName() + " " + playerDetail1.get().getId() + " " + playerDetail1.get().getDateOfBirth());
      }


    public List<PlayerDetail> getPlayerList() {
        List<PlayerDetail> res = new ArrayList<>();
        PlayerDetailTO playerDetailModel = new PlayerDetailTO();
        Date date = new Date(System.currentTimeMillis());
        return playerDetailRepository.findBydateOfBirthLessThan(date);
//        playerDetailModel.setRes(res);
//        return playerDetailModel;
    }
}
