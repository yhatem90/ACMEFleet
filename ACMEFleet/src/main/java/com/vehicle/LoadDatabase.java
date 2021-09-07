package com.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VehicleRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Vehicle("11AA23G", "BMW","312",2012,5,true,false,0,"CAR")));
      log.info("Preloading " + repository.save(new Vehicle("11AA23F", "NISSAN","TIIDA",2009,5,false,false,0,"CAR")));
      log.info("Preloading " + repository.save(new Vehicle("11AA23A", "BMW","x5",2008,5,false,false,15,"TRUCK")));
      log.info("Preloading " + repository.save(new Vehicle("11AA237", "RENAULT","MEGANE",2020,5,false,true,0,"CAR")));
      log.info("Preloading " + repository.save(new Vehicle("11AA238", "HONDA","CRV",2019,5,false,true,0,"CAR")));
      log.info("Preloading " + repository.save(new Vehicle("11AA239", "NISSAN","TT",2018,5,false,true,0,"MOTORCYCLE")));
    };
  }
}