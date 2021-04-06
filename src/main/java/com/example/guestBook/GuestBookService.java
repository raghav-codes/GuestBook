package com.example.guestBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepository guestBookRepository;
     public List<GuestDto> getAllComments(){

         return guestBookRepository.findAll().stream().map(guestBookEntity -> {
             return new GuestDto(guestBookEntity.getGuestName(), guestBookEntity.getGuestComment());
         }).collect(Collectors.toList());


//
//         animalEntity -> {
//             HabitatDto habitat = animalEntity.getHabitat() == null ? null :
//                     new HabitatDto(
//                             animalEntity.getHabitat().getName(),
//                             animalEntity.getHabitat().getType()
//                     );

     }

    public void addGuest(GuestDto guestDto) throws Exception {

        Optional<GuestBookEntity> guestCommentExists = guestBookRepository.findAll().stream().filter(guestBookEntity -> guestBookEntity.getGuestName().equals(guestDto.getGuestName())).findAny();

        if(guestCommentExists.isPresent()){
            throw new Exception();
        } else {
            guestBookRepository.save(new GuestBookEntity(guestDto.getGuestName(), guestDto.getGuestComment()));
        }
    }
}
