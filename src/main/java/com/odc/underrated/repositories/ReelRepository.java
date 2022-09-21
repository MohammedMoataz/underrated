package com.odc.underrated.repositories;

import com.odc.underrated.models.Reel;

import java.util.List;

public interface ReelRepository {
    Reel createReel(Reel reel);

    Reel getReel(Long id);

    List<Reel> getReels();

    Reel updateReel(Reel reel);

    void deleteReel(Long id);
}
