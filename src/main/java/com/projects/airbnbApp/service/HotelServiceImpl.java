package com.projects.airbnbApp.service;

import com.projects.airbnbApp.dto.HotelDto;
import com.projects.airbnbApp.entity.Hotel;
import com.projects.airbnbApp.exception.ResourceNotFoundException;
import com.projects.airbnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating new hotel with name {}", hotelDto.getName());

        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created new hotel with Id: {}",hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting hotel with Id: {}",id);

        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with Id: " + id));

        return modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating hotel with Id: {}",id);

        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with Id: " + id));

        modelMapper.map(hotelDto, hotel);   // copy from hotel dto to hotel
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public void deleteHotelById(Long id) {
        boolean exists = hotelRepository.existsById(id);
        if(!exists) throw  new ResourceNotFoundException("Hotel not found with ID:"+id);

        hotelRepository.deleteById(id);
        //TODO: delete the future inventories for this hotel
    }


}
