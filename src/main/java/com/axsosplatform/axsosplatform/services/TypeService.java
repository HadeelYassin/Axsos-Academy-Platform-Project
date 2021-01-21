package com.axsosplatform.axsosplatform.services;

import com.axsosplatform.axsosplatform.models.Type;
import com.axsosplatform.axsosplatform.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private final TypeRepository typeRepository;


    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    public Type addType(Type type){

        return typeRepository.save(type);

    }
    public Type findType(String kind){
        return typeRepository.findByKind(kind);
    }


    public Type editType(Type type){

        return typeRepository.save(type);

    }
}