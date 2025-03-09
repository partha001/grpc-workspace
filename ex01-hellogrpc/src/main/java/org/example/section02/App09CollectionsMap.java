package org.example.section02;

import com.partha.models.section02.Car;
import com.partha.models.section02.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this program is to show how have composition with map
 * and the method available on the proto-map attribute
 */
public class App09CollectionsMap {

    private static final Logger log = LoggerFactory.getLogger(App09CollectionsMap.class);


    public static void main(String[] args) {
        var car1 = Car.newBuilder()
                .setMake("honda")
                .setModel("civic")
                .setYear(2000)
                .build();

        var car2 = Car.newBuilder()
                .setMake("honda")
                .setModel("accord")
                .setYear(2002)
                .build();

        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(), car1)
                .putInventory(car2.getYear(), car2)
                .build();

        log.info("dealer: {}", dealer);

        log.info("2002 ? {}", dealer.containsInventory(2002));
        log.info("2007 ? {}", dealer.containsInventory(2007));

        //this proto-map also comes with the below useful methods;
        //dealer.getInventoryOrThrow(2002)
        //dealer.getInventoryOrDefault(2002)
    }
}
