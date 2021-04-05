package com.example.guestBook;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("guests")
public class GuestBookController {
 ///   public GuestService guestService;

//    public GuestBookController(GuestService animalService) {
//        this.animalService = animalService;
//    }


    @GetMapping
    public List<GuestDto> fetchAll()    {
        return new ArrayList<GuestDto>();
    }
}
