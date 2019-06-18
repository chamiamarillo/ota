package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Worldspan;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public class WorldspanAdapter implements Proveedor {

    private Worldspan worldspan;

    @Override
    public List<Vuelo> buscarVuelos(DateTime fecha, String origen, String destino) {
        return worldspan.searchFlights(fecha.getDayOfMonth(), fecha.getMonthOfYear(), fecha.getYear(), origen, destino);
    }

    @Override
    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        return worldspan.bookFlight(vuelo, pasajeros);
    }
}
