package com.axsosplatform.axsosplatform.services;

import com.axsosplatform.axsosplatform.models.TypeO;
import com.axsosplatform.axsosplatform.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private final TypeRepository typeRepository;


    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    public TypeO addType(TypeO typeO){

        return typeRepository.save(typeO);

    }
    public TypeO findType(String kind){
        return typeRepository.findByKind(kind);
    }


    public TypeO editType(TypeO typeO){

        return typeRepository.save(typeO);

    }
}