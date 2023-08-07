package ru.grisha.myspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.grisha.myspring.entity.Region;

import java.util.Collection;
import java.util.Set;

@Repository
public interface RegionsRepository extends JpaRepository<Region, Long> {
    Set<Region> findAllByRegionIdIsIn(Collection<Long> regionId);
}
