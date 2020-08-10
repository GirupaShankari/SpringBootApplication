package com.girupa.itechapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    //Content-Type text/plain
    @RequestMapping(value="/test")
     public String test()
     {
         return "Happy Learning Spring !!! ";
     }

     //Content-Type application/json
    @RequestMapping(value="/test-json")
     public Map testJson()
     {
        Map<String,Object> map=new HashMap<>();
        map.put("name","girupa");
        map.put("college","AAMEC");
        map.put("dept","CSE");
        map.put("city","Thanjavur");
        map.put("pincode",613006);

        return map;
     }

    //Content-Type application/json
    @RequestMapping(value="/person")
    public Person getPerson()
    {
        List<String> languages=new ArrayList<>();
        languages.add("ta");
        languages.add("en");
        languages.add("hi");

        Address address=new Address();
        address.state="Tamil Nadu";
        address.city="Thanjavur";
        address.pincode=613006;

        Person person=new Person();
        person.id=1;
        person.name="girupa";
        person.languages=languages;
        person.address=address;

        return person;
    }
}
