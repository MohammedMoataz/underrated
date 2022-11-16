package com.odc.underrated.services;

import com.odc.underrated.dtos.req.ReelReq;
import com.odc.underrated.dtos.res.ReelRes;
import com.odc.underrated.dtos.res.UserRes;
import com.odc.underrated.models.Reel;
import com.odc.underrated.models.User;
import com.odc.underrated.repositories.ReelRepository;
import com.odc.underrated.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("reelService")
public class ReelServiceImpl implements ReelService {

    @Autowired
    ReelRepository reelRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ReelRes save(ReelReq reelReq) {
        User user = userRepository.findById(reelReq.getUserId()).get();
        Reel reel = mapEntityFromRequest(reelReq, user);
        reel = reelRepository.save(reel);
        return mapEntityToResponse(reel, user);
    }

    @Override
    public ReelRes findById(String id) {
        Reel reel = reelRepository.findById(id).get();
        User user = reel.getUser();
        return mapEntityToResponse(reel, user);
    }

    @Override
    public List<ReelRes> findAll() {
        List<ReelRes> response = new ArrayList<>();
        reelRepository.findAll().forEach(reel ->
                response.add(mapEntityToResponse(reel, reel.getUser()))
        );

        return response;
    }

    @Override
    public ReelRes updateReel(String reelId, ReelReq reelReq) {
        Reel reel = reelRepository.findById(reelId).get();
        updateEntityFromRequest(reel, reelReq);
        reelRepository.save(reel);
        return mapEntityToResponse(reel, reel.getUser());
    }

    @Override
    public void deleteById(String id) {
        reelRepository.deleteById(id);
    }

    @Override
    public void like(String reelId, String userId) {
        Reel reel = reelRepository.findById(reelId).get();
        User user = userRepository.findById(userId).get();
        reel.getLikedUsers().add(user);
        reelRepository.save(reel);
    }

    private Reel mapEntityFromRequest(ReelReq reelReq, User user) {
        return new Reel(
                reelReq.getVideo(),
                reelReq.getCaption(),
                reelReq.getLocation(),
                reelReq.getDate(),
                user
        );
    }

    private void updateEntityFromRequest(Reel reel, ReelReq reelReq) {
        reel.setCaption(reelReq.getCaption());
        reel.setLocation(reelReq.getLocation());
        reel.setDate(reelReq.getDate());
    }

    private ReelRes mapEntityToResponse(Reel reel, User user) {
        UserRes userRes = new UserRes(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCountry()
        );

        return new ReelRes(
                reel.getId(),
                reel.getVideo(),
                reel.getCaption(),
                reel.getLocation(),
                reel.getDate(),
                userRes
        );
    }
}