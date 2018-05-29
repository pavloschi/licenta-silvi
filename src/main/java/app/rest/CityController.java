package app.rest;

import app.model.City;
import app.repository.CityRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    //Get all cities
    @GetMapping("/find")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    //Create a new City
    @PostMapping("/add")
    public City createCity(@RequestBody City city){
        System.out.println("CC: " + city.getCountryCode());

        if(Strings.isEmpty(city.getCountryCode())){
            city.setCountryCode("SLV");
        }

        if(city.getPopulation() == null ){
            city.setPopulation(1L);
        }

        return cityRepository.save(city);
    }


}
