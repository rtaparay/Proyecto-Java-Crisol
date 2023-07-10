package TrabajoFinal.GUI;

import TrabajoFinal.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class MenuCrisol extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuCategoria, menuCliente, menuLibreria, menuLibro, menuPedido, menuProducto, menuProveedor,
            menuSegmento, menuTiendaEcommerce, menuTiendaFisica, menuUsuario;
    private JMenuItem itemRegistrar, itemModificar, itemEliminar, itemActualizar;

    private JMenuItem masivoRFM, masivoSegmento;
    public MenuCrisol() {


        // Configuración básica del Menu
        setTitle("Sistema de Gestion Crisol"); //Cambiarle Titulo
        //Podemos agregar una imagen de fondo.
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación del menú
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Creación de los elementos del menú
        menuCategoria = crearMenu("Categoría");
        menuBar.add(menuCategoria);
        menuCliente = crearMenu("Cliente");
        menuBar.add(menuCliente);
        /*
        menuLibreria = crearMenu("Librería");
        menuBar.add(menuLibreria);
         */
        menuLibro = crearMenu("Libro");
        menuBar.add(menuLibro);
        menuPedido = crearMenu("Pedido");
        menuBar.add(menuPedido);
        /*
        menuProducto = crearMenu("Producto");
        menuBar.add(menuProducto);
         */
        menuProveedor = crearMenu("Proveedor");
        menuBar.add(menuProveedor);
        menuSegmento = crearMenu("Segmento");
        menuBar.add(menuSegmento);
        menuTiendaEcommerce = crearMenu("Tienda Ecomerce");
        menuBar.add(menuTiendaEcommerce);
        menuTiendaFisica = crearMenu("Tienda Fisica");
        menuBar.add(menuTiendaFisica);
        menuUsuario = crearMenu("Usuario");
        menuBar.add(menuUsuario);
    }

    private JMenu crearMenu(String nombre) {
        //TODO trasladarlo al main definitivo
        //Usuarios
        UsuarioSistema user = new UsuarioSistema("","","","","");
        user.cargaInicial();
        final ArrayList<UsuarioSistema> luser  = user.getLuser();
        //Categorias
        Categoria cat = new Categoria(0,"");
        cat.cargaInicial();
        final ArrayList<Categoria> listaCategorias = cat.getListaCategorias();
        //Clientes
        Cliente cliente = new Cliente(0,"","","",0,0,0.0,0,'\u0000');
        cliente.cargaInicial();
        final  ArrayList<Cliente> listaClientes = cliente.getListaClientes();

        //Libros
        Libro libro = new Libro(0,0.0,"",0,"","",0,"","",0);
        libro.cargaInicial();
        final  ArrayList<Libro> listaLibros = libro.getListaLibro();


        //Proveedor
        Proveedor prov = new Proveedor(0,"");
        prov.cargaInicial();
        final  ArrayList<Proveedor> listaProveedores = prov.getProveedores();

        //Segmento
        Segmento segmento = new Segmento('\u0000',"",0.0);
        segmento.cargaInicial();
        final ArrayList<Segmento> listaSegmentos = segmento.getListaSegmentos();

        //TiendaEcommerce
        TiendaEcommerce tiendaEcommerce = new TiendaEcommerce(0,"","","",0,"",0.0);
        tiendaEcommerce.cargaInicial();
        final ArrayList<TiendaEcommerce> listaTiendaEcommerce1 = tiendaEcommerce.getListaTiendaEcommerce();

        //TiendaFisica
        TiendaFisica tiendaFisica = new TiendaFisica(0,"","","",0,0,"","",0.0);
        tiendaFisica.cargaInicial();
        final ArrayList<TiendaFisica> listaTiendaFisica1 = tiendaFisica.getListaTiendaFisica();

        //Pedidos
        Pedido pedido = new Pedido(0,0,0,"",0,0,0,0);
        pedido.cargaInicial();
        final ArrayList<Pedido> listapedidos = pedido.getListaPedidos();
        JMenu menu = new JMenu(nombre);
        // Creación de los elementos del menú
        itemRegistrar = new JMenuItem("Registrar");
        itemModificar = new JMenuItem("Modificar");
        itemEliminar = new JMenuItem("Eliminar");
        itemActualizar = new JMenuItem("Listar");

        masivoRFM = new JMenuItem("Proceso Masivo : Actualización Score RFM");
        masivoSegmento= new JMenuItem("Proceso Masivo : Asignación Segmentos de clientes");

        // Configuración de los eventos de los elementos del menú
        itemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Aqui si alguien quiere le puede meter un case pa darle estilo
                if(nombre=="Categoría"){
                    RegistraCategoria registraCategoria = new RegistraCategoria(cat);
                }
                if(nombre=="Cliente"){
                    RegistraCliente registraCliente = new RegistraCliente(cliente);
                }

                if(nombre=="Libro"){
                    RegistraLibro registraLibro = new RegistraLibro(libro);
                }
                if(nombre=="Pedido"){
                    RegistraPedido registraPedido = new RegistraPedido(pedido);
                }
                if(nombre=="Proveedor"){
                    RegistraProveedor registraProveedor = new RegistraProveedor(prov);
                }
                if(nombre=="Segmento"){
                    RegistraSegmento registraSegmento = new RegistraSegmento(segmento);
                }
                if(nombre=="Tienda Ecomerce"){
                    RegistraTiendaEcommerce registraTiendaEcommerce = new RegistraTiendaEcommerce(tiendaEcommerce);
                }
                if(nombre=="Tienda Fisica"){
                    RegistraTiendaFisica registraTiendaFisica = new RegistraTiendaFisica();
                }
                if(nombre=="Usuario"){
                    RegistraUsuarioSistema registraUsuarioSistema = new RegistraUsuarioSistema(user);
                }
            }
        });
        itemModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nombre=="Categoría"){
                    UpdListCategoria updListCategoria = new UpdListCategoria(cat);
                }
                if(nombre=="Cliente"){
                    UpdListCliente updListCliente = new UpdListCliente(cliente);
                }
                if(nombre=="Libro"){
                    UpdListProducto updListProducto = new UpdListProducto(libro);
                }
                if(nombre=="Pedido"){
                    UpdListPedido updListPedido = new UpdListPedido(pedido);
                }
                if(nombre=="Proveedor"){
                    UpdListProveedor updListProveedor = new UpdListProveedor(prov);
                }
                if(nombre=="Segmento"){
                    UpdListSegmento updListSegmento = new UpdListSegmento(segmento);
                }
                if(nombre=="Tienda Ecomerce"){
                    UpdListTiendaVirtual updListTiendaVirtual = new UpdListTiendaVirtual(tiendaEcommerce);
                }
                if(nombre=="Tienda Fisica"){
                    UpdListTiendaFisica updListTiendaFisica = new UpdListTiendaFisica(tiendaFisica);
                }
                if(nombre=="Usuario"){
                    UpdListUsuario updListUsuario = new UpdListUsuario(user);
                }
            }
        });
        itemEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nombre=="Categoría"){
                    DelCategoria delCategoria = new DelCategoria(cat);
                }
                if(nombre=="Cliente"){
                    DelCliente delCliente = new DelCliente(cliente);
                }
                if(nombre=="Libro"){
                    DelLibro delLibro = new DelLibro(libro);
                }
                if(nombre=="Pedido"){
                    DelPedido delPedido = new DelPedido(pedido);
                }
                if(nombre=="Proveedor"){
                    DelProveedor delProveedor = new DelProveedor(prov);
                }
                if(nombre=="Segmento"){
                    DelSegmento delSegmento = new DelSegmento(segmento);
                }
                if(nombre=="Tienda Ecomerce"){
                    DelTiendaVirtual delTiendaVirtual = new DelTiendaVirtual(tiendaEcommerce);
                }
                if(nombre=="Tienda Fisica"){
                    DelTiendaFisica delTiendaFisica = new DelTiendaFisica(tiendaFisica);
                }
                if(nombre=="Usuario"){
                    DelUsuario delUsuario = new DelUsuario(user);
                }
            }
        });



            itemActualizar.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    if(nombre=="Categoría"){
                        ListaCategoria listaCategoria = new ListaCategoria(listaCategorias);
                    }
                    if(nombre=="Cliente"){
                        ListaCliente listaCliente = new ListaCliente(listaClientes);
                    }
                    if(nombre=="Libro"){
                        ListaLibro listaLibro = new ListaLibro(listaLibros);
                    }
                    if(nombre=="Pedido"){
                        ListaPedido listaPedido = new ListaPedido(listapedidos,listaClientes);
                    }
                    if(nombre=="Proveedor"){
                        ListaProveedor listaProveedor = new ListaProveedor(listaProveedores);
                    }
                    if(nombre=="Segmento"){
                        ListaSegmento listaSegmento = new ListaSegmento(listaSegmentos);
                    }
                    if(nombre=="Tienda Ecomerce"){
                        ListaTiendaEcommerce listaTiendaEcommerce = new ListaTiendaEcommerce(listaTiendaEcommerce1);
                    }
                    if(nombre=="Tienda Fisica"){
                        ListaTiendaFisica listaTiendaFisica = new ListaTiendaFisica(listaTiendaFisica1);
                    }
                    if(nombre=="Usuario"){
                        ListaUsuarioSistema listaUsuario = new ListaUsuarioSistema(luser);
                    }


                }


            });


        // Agregar los elementos al menú
        menu.add(itemRegistrar);
        menu.add(itemModificar);
        menu.add(itemEliminar);
        menu.add(itemActualizar);
        if(nombre=="Cliente"){
            menu.add(masivoRFM);
            menu.add(masivoSegmento);
        }
        return menu;
    }

    //Cuando creemos el Main solo instanciamos la clase
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                //Apertura Formulario maestro
                MenuCrisol menuCrisol = new MenuCrisol();
                menuCrisol.setVisible(true);
            }
        });
    }
}


