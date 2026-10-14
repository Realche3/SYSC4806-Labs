package org.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "buddies")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByName(String name);

    Optional <BuddyInfo> findById(Integer id);

}
