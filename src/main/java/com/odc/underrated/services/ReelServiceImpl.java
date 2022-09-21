package com.odc.underrated.services;

import com.odc.underrated.models.Reel;
import com.odc.underrated.repositories.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reelService")
public class ReelServiceImpl implements ReelService {

    @Autowired
    ReelRepository reelRepository;

    @Override
    public Reel createReel(Reel reel) {
        return reelRepository.createReel(reel);
    }

    @Override
    public Reel getReel(Long id) {
        return reelRepository.getReel(id);
    }

    @Override
    public List<Reel> getReels() {
        return reelRepository.getReels();
    }

    @Override
    public Reel updateReel(Reel reel) {
        return reelRepository.updateReel(reel);
    }

    @Override
    public void deleteReel(Long id) {
        reelRepository.deleteReel(id);
    }
}
