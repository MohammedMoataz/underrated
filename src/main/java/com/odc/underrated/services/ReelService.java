package com.odc.underrated.services;

import com.odc.underrated.models.Reel;
import com.odc.underrated.models.User;

import java.util.List;

public interface ReelService {

    Reel createReel(Reel reel);

    Reel getReel(Long id);

    List<Reel> getReels();

    Reel updateReel(Reel reel);

    void deleteReel(Long id);
}
