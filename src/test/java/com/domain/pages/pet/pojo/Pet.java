package com.domain.pages.pet.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*

        String body = "{\n  \"id\": 0,\n  " +
                "\"category\": {\n  " +
                "  \"id\": 0,\n    " +
                "\"name\": \"string\"\n " +
                " },\n  " +
                "\"name\": \"doggie\",\n " +
                " \"photoUrls\": [\n    \"string\"\n  ],\n " +
                " \"tags\": [\n   " +
                " {\n     " +
                " \"id\": 0,\n    " +
                "  \"name\": \"string\"\n  " +
                "  }\n  ],\n  " +
                "\"status\": \"available\"\n}";
 */


/*
            {
              "id": 0,
              "category": {
                "id": 0,
                "name": "string"
              },
              "name": "doggie",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "available"
            }
     */


@Data
public class Pet {

    private int id;
    Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;


}
