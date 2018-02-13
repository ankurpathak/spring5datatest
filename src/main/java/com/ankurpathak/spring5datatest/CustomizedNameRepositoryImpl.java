package com.ankurpathak.spring5datatest;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("nameRepositoryImpl")
public class CustomizedNameRepositoryImpl implements ICustomizedNameRepository {

    private MongoTemplate mongoTemplate;

    public CustomizedNameRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Name persist(@Param("name") Name name) {
        mongoTemplate.save(name);
        return name;
    }
}
