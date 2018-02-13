package com.ankurpathak.spring5datatest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("nameRepository")
public interface INameRepository extends MongoRepository<Name, String>, ICustomizedNameRepository {
    List<Name> findByFirstName(@Param("firstName") String firstName);
}
