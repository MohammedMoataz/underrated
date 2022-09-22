package com.odc.underrated.services;

import com.odc.underrated.dtos.req.ReelReq;
import com.odc.underrated.dtos.res.ReelRes;

import java.util.List;

public interface ReelService {

    ReelRes save(ReelReq reelReq);

    ReelRes findById(String id);

    List<ReelRes> findAll();

    ReelRes updateReel(String reelId, ReelReq reelReq);

    void deleteById(String id);
}
