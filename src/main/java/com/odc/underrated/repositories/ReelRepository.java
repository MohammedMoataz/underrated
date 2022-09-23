package com.odc.underrated.repositories;

import com.odc.underrated.models.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepository extends JpaRepository<Reel, String> {
}
