package com.odc.underrated.services;

import com.odc.underrated.models.Reel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reelService")
public class ReelServiceImpl implements ReelService {

    @Override
    public Reel createReel(Reel reel) {
        return null;
    }

    @Override
    public List<Reel> getReels() {
        return null;
    }

    @Override
    public void batch() {
    }

    @Override
    public void deleteReel(long id) {

    }
}
