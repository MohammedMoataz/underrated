package com.odc.underrated.repositories;

import com.odc.underrated.models.Reel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reelRepository")
public class ReelRepositoryImpl implements ReelRepository {

    @Override
    public Reel createReel(Reel reel) {
        return null;
    }

    @Override
    public List<Reel> getReels() {
        return null;
    }

    @Override
    public Reel updateReel(Reel reel) {
        return null;
    }

    @Override
    public void deleteReel(long id) {

    }
}
