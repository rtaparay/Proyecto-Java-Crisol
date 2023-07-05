package TrabajoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //********************************
        //Submenu1 -> PROVEEDORES
        //Sergio Ayesta
        //********************************
        ArrayList<Proveedor> dataProveedores = new ArrayList<>();
        Scanner submenu1 = new Scanner(System.in);
        String continuar = "S";

        while (continuar.equals("S")) {
            System.out.println("===============================================================================");
            System.out.println("P E D I D O S");
            System.out.println("Seleccione un submenu --> 1=Registrar | 2=Modificar | 3=Eliminar | 4=Imprimir");
            System.out.println("===============================================================================");
    
            String proveedor_submenu_opcion = submenu1.nextLine();

            switch (proveedor_submenu_opcion) {
                case "1": //Registrar
                    dataProveedores = proveedor_submenu_registro(dataProveedores);
                    break;
                case "4": //Imprimir
                    proveedor_submenu_imprimir(dataProveedores);
                    break;
            }
            System.out.println("¿Desea continuar? S/N");
            continuar = submenu1.nextLine();

            if (continuar.equals("S") || continuar.equals("s")) {
                continuar = "S";
            } else if (continuar.equals("N") || continuar.equals("n")) {
                continuar = "N";
            }
        }

        //********************************
        //Submenu2 -> PEDIDOS
        //Sergio Ayesta
        //********************************
        ArrayList<Pedido> dataPedidos = new ArrayList<>();
        Scanner submenu2 = new Scanner(System.in);
        continuar = "S";

        while (continuar.equals("S")) {
            System.out.println("===============================================================================");
            System.out.println("P E D I D O S");
            System.out.println("Seleccione un submenu --> 1=Registrar | 2=Modificar | 3=Eliminar | 4=Imprimir");
            System.out.println("===============================================================================");

            String pedido_submenu_opcion = submenu2.nextLine();

            switch (pedido_submenu_opcion) {
                case "1": //Registrar
                    dataPedidos = pedido_submenu_registro(dataPedidos);
                    break;
                case "4": //Imprimir
                    pedido_submenu_imprimir(dataPedidos);
                    break;
            }
            System.out.println("¿Desea continuar? S/N");
            continuar = submenu2.nextLine();

            if (continuar.equals("S") || continuar.equals("s")) {
                continuar = "S";
            } else if (continuar.equals("N") || continuar.equals("n")) {
                continuar = "N";
            }
        }

    }
    public static ArrayList<Proveedor> proveedor_submenu_registro(ArrayList<Proveedor> data) {
        //Sergio Ayesta
        Proveedor p1 = new Proveedor();
        p1.registrar();
        System.out.println("");
        data.add(p1);
        return data;
    }

    public static void proveedor_submenu_imprimir(ArrayList<Proveedor> data) {
        //Sergio Ayesta
        System.out.println("====================================");
        System.out.println("Listado de proveedores registrados");
        System.out.println("====================================");
        for (Proveedor p: data) {
            p.imprimir();
        }
    }

    public static ArrayList<Pedido> pedido_submenu_registro(ArrayList<Pedido> data) {
        //Sergio Ayesta
        Pedido pe1 = new Pedido();
        pe1.registrar();
        System.out.println("");
        data.add(pe1);
        return data;
    }

    public static void pedido_submenu_imprimir(ArrayList<Pedido> data) {
        //Sergio Ayesta
        System.out.println("====================================");
        System.out.println("Listado de pedidos registrados");
        System.out.println("====================================");
        for (Pedido p: data) {
            p.imprimir();
        }
    }
}