package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Amadeus;
import ar.edu.unahur.obj2.proveedores.Sabre;
import ar.edu.unahur.obj2.proveedores.Worldspan;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {


    @org.testng.annotations.Test
    public void testBuscarVuelos() {
        Amadeus amadeus = new Amadeus();
        AmadeusAdapter amadeusAdapter = new AmadeusAdapter(amadeus);


        List<Proveedor> proveedorList = Stream.of(amadeusAdapter).collect(Collectors.toList());


        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedorList);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        // consulto en la api original para comparar que esta bien
        List<Vuelo> vueloOriginal = amadeus.executeSearch(fecha,"BUE" , "MIA");

        Assert.assertEquals(vuelos,vueloOriginal);




    }

    @org.testng.annotations.Test
    public void testReservar() {
        Amadeus amadeus = new Amadeus();
        AmadeusAdapter amadeusAdapter = new AmadeusAdapter(amadeus);

        List<Proveedor> proveedorList = Stream.of(amadeusAdapter).collect(Collectors.toList());


        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedorList);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}
