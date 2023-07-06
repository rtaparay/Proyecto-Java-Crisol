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

        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("===============================================================================");
            System.out.println("P R O V E E D O R E S");
            System.out.println("Seleccione un submenu --> 1=Registrar | 2=Modificar | 3=Eliminar | 4=Imprimir");
            System.out.println("===============================================================================");

            String proveedor_submenu_opcion = submenu1.nextLine();

            switch (proveedor_submenu_opcion) {
                case "1": //Registrar
                    dataProveedores = proveedor_submenu_registro(dataProveedores);
                    break;
                case "2": //Modificar
                    dataProveedores = proveedor_submenu_modificar(dataProveedores);
                    break;
                case "3": //Eliminar
                    dataProveedores = proveedor_submenu_eliminar(dataProveedores);
                    break;
                case "4": //Imprimir
                    proveedor_submenu_imprimir(dataProveedores);
                    break;
            }
            System.out.println("¿Desea continuar? S/N");
            continuar = submenu1.nextLine();

            if (continuar.equalsIgnoreCase("N")) {
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

        while (continuar.equalsIgnoreCase("S")) {
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

            if (continuar.equalsIgnoreCase("N")) {
                continuar = "N";
            }
        }

        //********************************
        //Submenu3 -> CLIENTES
        //RAUL TAPARA
        //********************************

        ArrayList<Cliente> dataClientes = new ArrayList<>();

        Scanner submenu3 = new Scanner(System.in);
        continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("===============================================================================");
            System.out.println("C L I E N T E S");
            System.out.println("Seleccione un submenu --> 1=Registrar | 2=Modificar | 3=Eliminar | 4=Imprimir");
            System.out.println("===============================================================================");

            String cliente_submenu_opcion = submenu3.nextLine();

            switch (cliente_submenu_opcion) {
                case"1": //Registrar
                    dataClientes = cliente_submenu_registro(dataClientes);
                    break;
                case "2": //Modificar
                    dataClientes = cliente_submenu_modificar(dataClientes);
                    break;
                case "3": //Eliminar
                    dataClientes = cliente_submenu_eliminar(dataClientes);
                    break;
                case "4": //Imprimir
                    cliente_submenu_imprimir(dataClientes);
                    break;
            }
            System.out.println("¿Desea continuar? S/N");
            continuar = submenu3.nextLine();

            if (continuar.equalsIgnoreCase("N")) {
                continuar = "N";
            }
        }

        //********************************
        //Submenu4 -> SEGMENTOS
        //RAUL TAPARA
        //********************************

        ArrayList<Segmento> dataSegmentos = new ArrayList<>();

        Scanner submenu4 = new Scanner(System.in);
        continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("===============================================================================");
            System.out.println("S E G M E N T O S");
            System.out.println("Seleccione un submenu --> 1=Registrar | 2=Modificar | 3=Eliminar | 4=Imprimir");
            System.out.println("===============================================================================");

            String segmento_submenu_opcion = submenu4.nextLine();

            switch (segmento_submenu_opcion) {
                case "1": //Registrar
                    dataSegmentos = segmento_submenu_registro(dataSegmentos);
                    break;
                case "2": //Modificar
                    dataSegmentos = segmento_submenu_modificar(dataSegmentos);
                    break;
                case "3": //Eliminar
                    dataSegmentos = segmento_submenu_eliminar(dataSegmentos);
                    break;
                case "4": //Imprimir
                    segmento_submenu_imprimir(dataSegmentos);
                    break;
            }
            System.out.println("¿Desea continuar? S/N");
            continuar = submenu4.nextLine();

            if (continuar.equalsIgnoreCase("N")) {
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

    public static ArrayList<Proveedor> proveedor_submenu_modificar(ArrayList<Proveedor> data) {
        //Sergio Ayesta
        Proveedor p1 = new Proveedor();
        data = p1.modificar(data);
        return data;
    }

    public static ArrayList<Proveedor> proveedor_submenu_eliminar(ArrayList<Proveedor> data) {
        //Sergio Ayesta
        Proveedor p1 = new Proveedor();
        data = p1.eliminar(data);
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

    public static ArrayList<Cliente> cliente_submenu_registro(ArrayList<Cliente> data) {
        //RAUL TAPARA
        Cliente c1 = new Cliente();
        c1.registrar();
        System.out.println("");
        data.add(c1);
        return data;
    }

    public static ArrayList<Cliente> cliente_submenu_modificar(ArrayList<Cliente> data) {
        //RAUL TAPARA
        Cliente c1 = new Cliente();
        data = c1.modificar(data);
        return data;
    }

    public static ArrayList<Cliente> cliente_submenu_eliminar(ArrayList<Cliente> data) {
        //RAUL TAPARA
        Cliente c1 = new Cliente();
        c1.eliminar(data);
        return data;
    }

    public static void cliente_submenu_imprimir(ArrayList<Cliente> data) {
        //RAUL TAPARA
        System.out.println("====================================");
        System.out.println("Listado de clientes registrados");
        System.out.println("====================================");
        for (Cliente c : data) {
            c.imprimir();
        }
    }

    public static ArrayList<Segmento> segmento_submenu_registro(ArrayList<Segmento> data) {
        //RAUL TAPARA
        Segmento s1 = new Segmento();
        s1.registrar();
        System.out.println("");
        data.add(s1);
        return data;
    }

    public static ArrayList<Segmento> segmento_submenu_modificar(ArrayList<Segmento> data) {
        //RAUL TAPARA
        Segmento s1 = new Segmento();
        data = s1.modificar(data);
        return data;
    }

    public static ArrayList<Segmento> segmento_submenu_eliminar(ArrayList<Segmento> data) {
        //RAUL TAPARA
        Segmento s1 = new Segmento();
        s1.eliminar(data);
        return data;
    }

    public static void segmento_submenu_imprimir(ArrayList<Segmento> data) {
        //RAUL TAPARA
        System.out.println("====================================");
        System.out.println("Listado de segmentos registrados");
        System.out.println("====================================");
        for (Segmento s : data) {
            s.imprimir();
        }
    }
}
