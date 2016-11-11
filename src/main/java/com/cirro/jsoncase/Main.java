package com.cirro.jsoncase;

import com.cirro.pojos.T3;
import com.cirro.pojos.T2;
import com.cirro.pojos.T1;
import com.cirro.sorter.DefaultSorter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import java.util.stream.Stream;

/**
 *
 * @author diego.romero
 */
public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        try {
            List<T1> t1 = new ArrayList<>();
            List<T2> t2 = new ArrayList<>();
            List<T3> t3Items = new ArrayList<>();
            List<T3> t3GroupByX = new ArrayList<>();
            
            ResourceBundle t1Route = ResourceBundle.getBundle("com.cirro.properties.routes");

            Stream<String> streamT1 = Files.lines(Paths.get(t1Route.getString("t1")));;
            for (String s : (Iterable<String>) streamT1::iterator) {
                t1.add(new ObjectMapper().readValue(s, T1.class));
            }

            Stream<String> streamT2 = Files.lines(Paths.get(t1Route.getString("t2")));
            for (String s : (Iterable<String>) streamT2::iterator) {
                t2.add(new ObjectMapper().readValue(s, T2.class));
            }
            
            t1.forEach((itemT1) -> {
                t2.stream().filter((itemT2) -> (itemT1.getZ().equals(itemT2.getZ()))).forEachOrdered((itemT2) -> {
                    t3Items.add(new T3(itemT1.getX(),itemT1.getY(),itemT2.getY()));
                });
            });
            
            t3Items.stream().collect(groupingBy(
                    item -> item.getX(), collectingAndThen(
                            reducing((a, b) -> new T3(a.getX(), (a.getT1y()+ b.getT1y()),(a.getT2y()+b.getT2y()))),
                            Optional::get)
                    )
                ).forEach(
                    (x, item) -> {
                        t3GroupByX.add(item);
                    });
            
            Collections.sort(t3GroupByX, new DefaultSorter());
            System.out.printf("      %1s     %-9s      %-9s",  "x", "SUM(t1.y)", "SUM(t2.y)\n");

            t3GroupByX.forEach(item-> {
                    System.out.printf("%10.4f  %10.4f   %10.4f \n", item.getX(), item.getT1y(), item.getT2y());           
                });
            
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
