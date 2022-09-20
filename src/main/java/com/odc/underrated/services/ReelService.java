package com.odc.underrated.services;

import com.odc.underrated.models.Reel;

import java.util.List;

public interface ReelService {

    Reel createReel(Reel reel);

    List<Reel> getReels();

    void batch();

    void deleteReel(long id);
}
