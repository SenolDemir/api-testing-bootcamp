package com.domain.pages;

import com.domain.pages.pet.pojo.Category;
import com.domain.pages.pet.pojo.Pet;
import com.domain.pages.pet.pojo.Tag;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetModel {


    Faker faker = new Faker();


    public int generateRandomId(){
        return faker.number().numberBetween(1,1000);
    }

    public List<Tag> generateTag(int count){
        List<Tag> data = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            Tag tag = new Tag();
            tag.setId(generateRandomId());
            tag.setName(faker.ancient().hero());
            data.add(tag);
        }
        return data;
    }

    public Pet createPed(){

        Pet pet = new Pet();

        pet.setId(generateRandomId());

        Category category = new Category();
        category.setId(generateRandomId());
        category.setName(faker.dog().breed());
        pet.setCategory(category);

        pet.setName(faker.name().name());

        pet.setPhotoUrls(Arrays.asList(faker.internet().url(), faker.internet().url()));
        pet.setTags(generateTag(3));
        pet.setStatus("available");

        return pet;
    }


}
