package TrabajoFinal.GUI;

import TrabajoFinal.Categoria;
import TrabajoFinal.UsuarioSistema;

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
        UsuarioSistema user = new UsuarioSistema("","","","","");
        user.cargaInicial();
        final ArrayList<UsuarioSistema> luser  = user.getLuser();
        Categoria cat = new Categoria(0,"");
        cat.cargaInicial();
        final ArrayList<Categoria> listaCategorias = cat.getListaCategorias();
        JMenu menu = new JMenu(nombre);

        // Creación de los elementos del menú
        itemRegistrar = new JMenuItem("Registrar");
        itemModificar = new JMenuItem("Modificar");
        itemEliminar = new JMenuItem("Eliminar");
        itemActualizar = new JMenuItem("Listar");

        // Configuración de los eventos de los elementos del menú
        itemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Aqui si alguien quiere le puede meter un case pa darle estilo
                if(nombre=="Categoría"){
                    RegistraCategoria registraCategoria = new RegistraCategoria(cat);
                }
                if(nombre=="Cliente"){
                    RegistraCliente registraCliente = new RegistraCliente();
                }

                if(nombre=="Libro"){
                    RegistraLibro registraLibro = new RegistraLibro();
                }
                if(nombre=="Pedido"){
                    RegistraPedido registraPedido = new RegistraPedido();
                }
                if(nombre=="Proveedor"){
                    RegistraProveedor registraProveedor = new RegistraProveedor();
                }
                if(nombre=="Segmento"){
                    RegistraSegmento registraSegmento = new RegistraSegmento();
                }
                if(nombre=="Tienda Ecomerce"){
                    RegistraTiendaEcommerce registraTiendaEcommerce = new RegistraTiendaEcommerce();
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
                    UpdListCliente updListCliente = new UpdListCliente();
                }
                if(nombre=="Libro"){
                    UpdListProducto updListProducto = new UpdListProducto();
                }
                if(nombre=="Pedido"){
                    UpdListPedido updListPedido = new UpdListPedido();
                }
                if(nombre=="Proveedor"){
                    UpdListProveedor updListProveedor = new UpdListProveedor();
                }
                if(nombre=="Segmento"){
                    UpdListSegmento updListSegmento = new UpdListSegmento();
                }
                if(nombre=="Tienda Ecomerce"){
                    UpdListTiendaVirtual updListTiendaVirtual = new UpdListTiendaVirtual();
                }
                if(nombre=="Tienda Fisica"){
                    UpdListTiendaFisica updListTiendaFisica = new UpdListTiendaFisica();
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
                    DelCliente delCliente = new DelCliente();
                }
                if(nombre=="Libro"){
                    DelLibro delLibro = new DelLibro();
                }
                if(nombre=="Pedido"){
                    DelPedido delPedido = new DelPedido();
                }
                if(nombre=="Proveedor"){
                    DelProveedor delProveedor = new DelProveedor();
                }
                if(nombre=="Segmento"){
                    DelSegmento delSegmento = new DelSegmento();
                }
                if(nombre=="Tienda Ecomerce"){
                    DelTiendaVirtual delTiendaVirtual = new DelTiendaVirtual();
                }
                if(nombre=="Tienda Fisica"){
                    DelTiendaFisica delTiendaFisica = new DelTiendaFisica();
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
                        ListaCliente listaCliente = new ListaCliente();
                    }
                    if(nombre=="Libro"){
                        ListaLibro listaLibro = new ListaLibro();
                    }
                    if(nombre=="Pedido"){
                        ListaPedido listaPedido = new ListaPedido();
                    }
                    if(nombre=="Proveedor"){
                        ListaProveedor listaProveedor = new ListaProveedor();
                    }
                    if(nombre=="Segmento"){
                        ListaSegmento listaSegmento = new ListaSegmento();
                    }
                    if(nombre=="Tienda Ecomerce"){
                        ListaTiendaEcommerce listaTiendaEcommerce = new ListaTiendaEcommerce();
                    }
                    if(nombre=="Tienda Fisica"){
                        ListaTiendaFisica listaTiendaFisica = new ListaTiendaFisica();
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


