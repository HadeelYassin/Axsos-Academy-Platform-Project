package com.axsosplatform.axsosplatform.services;

import com.axsosplatform.axsosplatform.models.Tag;
import com.axsosplatform.axsosplatform.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private  final TagRepository tagRepository;


    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    public Tag addTag(Tag tag){
        return tagRepository.save(tag);
    }


    public Tag findTagById(Long id){
        Optional<Tag> tag =tagRepository.findById(id);
        if (tag.isPresent()){
            return tag.get();

        }else {
            return null;
        }
    }


    public Tag editTag(Tag tag){
        return tagRepository.save(tag);

    }

    public List<Tag> findAllTag(){
        return tagRepository.findAll();
    }
}
