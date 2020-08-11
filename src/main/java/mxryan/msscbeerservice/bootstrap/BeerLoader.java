package mxryan.msscbeerservice.bootstrap;

import mxryan.msscbeerservice.domain.Beer;
import mxryan.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            Beer beer = Beer.builder()
                    .beerName("Oompa-Loompa")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.95"))
                    .build();

            beerRepository.save(beer);

            Beer beer2 = Beer.builder()
                    .beerName("TurkeyBoy")
                    .beerStyle("Lager")
                    .quantityToBrew(400)
                    .minOnHand(40)
                    .upc(337010000002L)
                    .price(new BigDecimal("9.95"))
                    .build();

            beerRepository.save(beer2);

            System.out.println("Loaded beers. Num: " + beerRepository.count());

        }
    }
}
