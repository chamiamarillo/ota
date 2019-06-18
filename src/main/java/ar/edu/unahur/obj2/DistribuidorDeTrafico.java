package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedor> proveedors; // atributo que va a recibir una lista

    public DistribuidorDeTrafico(List<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }

    public void addProveedor(Proveedor proveedor) {
        proveedors.add(proveedor);
    }

    public Proveedor proveedor() {
        return proveedors.get(random.nextInt(proveedors.size()));
    }

}