package com.crunion.gui;

import com.crunion.dominio.Cliente;
import com.crunion.logica.Conversion;
import com.crunion.logica.Conversion_Nueva;
import com.crunion.dominio.Equivalencia;
import com.crunion.dominio.Transaccion;
import com.crunion.logica.ServicioCliente;
import com.crunion.logica.ServicioTransaccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;

/**
 * Clase principal y GUI del convertidor de monedas de CRUnion.
 * 
 * @author Mayarling Martinez
 */
public class CRUnion extends JFrame implements ActionListener {
    
    /**
     * Aquí agregamos los atributos que se usaran en esta clase
     */
    private JLabel titulo;
    private JLabel etiquetaIdCliente;
    private JLabel etiquetaOrigen;
    private JLabel etiquetaDestino;
    private JLabel etiquetaMonto;
    private JLabel etiquetaMontoDolares;
    private JLabel etiquetaMontoDestino;
    private JLabel etiquetaNombreCliente;
    private JLabel nombreCliente;
    private JLabel montoDolares;
    private JLabel montodestino;
    private JLabel origenCompra;
    private JLabel destinoCompra;
    private JLabel etiquetaTotalDolaresComprados;
    private JLabel etiquetaTotalDolaresVendidos;
    private JComboBox equivalenciasOrigen;
    private JComboBox equivalenciasDestino;
    private JTextField monto;
    private JTextField campoIdCliente;
    private JButton botonConvertir;
    
    private JMenuBar barraDeMenu;
    
    private JMenu opcionesDeMenu;
    private JMenuItem opcionReporteConversionesPorCliente;
    private JMenuItem opcionReporteConversionPorMoneda;
    private JMenuItem opcionSalir;
    
    private JMenu monedas;
    private JMenuItem opcionAgregarMoneda;
    private JMenuItem opcionEditarMoneda;
    
    private JMenu opcionCliente;
    private JMenuItem opcionAgregarCliente;
    private JMenuItem opcionEditarCliente;
    private JMenuItem opcionBorrarCliente;
    
    private Conversion convertidor;
    private ServicioCliente servicioCliente;
    private ServicioTransaccion servicioTransaccion;
    private double totalDolaresComprados;
    private double totalDolaresVendidos;
    
    /**
     * Con este constructor se inicializa la ventana del sistema
     */
    public CRUnion (){
        // Configuramos la ventana
        setTitle("CRUnion");
        setLayout(null);
        convertidor = new Conversion_Nueva();
        iniciarGUI();
        cargarEquivalencias();
        this.servicioCliente = new ServicioCliente();
        this.servicioTransaccion = new ServicioTransaccion();
    }
    /**
     * Método para iniciar los componentes del GUI.
     */
    private void iniciarGUI(){
        // configuramos la equita del titulo
        titulo = new JLabel("Conversor de monedas");
        titulo.setBounds(100,10,200,30);
        add(titulo);
        
        // Iniciamos las opciones de menú.
        this.barraDeMenu = new JMenuBar();
        
        // Menú opciones que contiene la opciones de reporte de la conversiones por cliente
        // y la del reporte de conversiones por moneda.
        this.opcionesDeMenu = new JMenu("Opciones");
        this.barraDeMenu.add(this.opcionesDeMenu);
        
        // Menú monedas que tiene las opcines agregar y editar moneda.
        this.monedas = new JMenu("Monedas");
        this.barraDeMenu.add(this.monedas);
        
        // Menú para agregar y editar datos de un cliente.
        this.opcionCliente = new JMenu("Cliente");
        this.barraDeMenu.add(this.opcionCliente);
        
        // Se crea cada opcion del menu y se agrega el actionListener para cada opción.
        this.opcionReporteConversionesPorCliente = new JMenuItem("Reporte de conversiones por cliente");
        this.opcionReporteConversionesPorCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaReportePorCliente();
            }
        });
        this.opcionesDeMenu.add(this.opcionReporteConversionesPorCliente);
        
        this.opcionReporteConversionPorMoneda = new JMenuItem("Reporte de conversiones por moneda");
        this.opcionReporteConversionPorMoneda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaReporteMoneda();
            }
        });
        this.opcionesDeMenu.add(this.opcionReporteConversionPorMoneda);
        
        this.opcionSalir = new JMenuItem("Salir");
        this.opcionSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        this.opcionesDeMenu.add(this.opcionSalir);
        
        this.opcionAgregarMoneda = new JMenuItem("Agregar Moneda");
        this.opcionAgregarMoneda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaAgregarMoneda();
            }
        });
        this.monedas.add(this.opcionAgregarMoneda);
        
        this.opcionEditarMoneda = new JMenuItem("Editar moneda existente.");
        this.opcionEditarMoneda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaModificarMoneda();
            }
        });
        this.monedas.add(this.opcionEditarMoneda);
        
        this.opcionAgregarCliente = new JMenuItem("Agregar nuevo cliente");
        this.opcionAgregarCliente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evento){
                mostrarVentanaCliente();
            }
        });
        this.opcionCliente.add(this.opcionAgregarCliente);
        
        this.opcionEditarCliente = new JMenuItem("Editar datos del cliente");
        this.opcionEditarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaEditarCliente();
            }    
        });
        this.opcionCliente.add(this.opcionEditarCliente);
        
        this.opcionBorrarCliente = new JMenuItem("Borrar cliente");
        this.opcionBorrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                mostrarVentanaBorrarCliente();
            }    
        });
        this.opcionCliente.add(this.opcionBorrarCliente);
        
        this.setJMenuBar(this.barraDeMenu);
        
        // Configuramos la etiqueta del id del cliente.
        etiquetaIdCliente = new JLabel("ID del cliente: ");
        etiquetaIdCliente.setBounds(25,50,100,30);
        add(etiquetaIdCliente);
        
        // Configuramos la equita de la moneda de origen
        etiquetaOrigen = new JLabel("Moneda Origen: ");
        etiquetaOrigen.setBounds(25,80,100,30);
        add(etiquetaOrigen);
        
        //configuramos la equita de moneda destino
        etiquetaDestino = new JLabel("Moneda Destino: ");
        etiquetaDestino.setBounds(25,110,100,30);
        add(etiquetaDestino);
        
        //configuramos la etiqueta del monto
        etiquetaMonto = new JLabel("Monto: ");
        etiquetaMonto.setBounds(25,140,100,30);
        add(etiquetaMonto);
        
        //Configuramos la etiqueta del nombre del cliente.
        etiquetaNombreCliente = new JLabel("Nombre del cliente: ");
        etiquetaNombreCliente.setBounds(25,170,150,30);
        add(etiquetaNombreCliente);
        
        // Configuracion de la etiqueta del monto en dolares.
        etiquetaMontoDolares = new JLabel("Monto en Dólares: ");
        etiquetaMontoDolares.setBounds(25,200,150,30);
        add(etiquetaMontoDolares);
        
        //configuracion de la etiqueta monto destino
        etiquetaMontoDestino = new JLabel("Monto Destino: ");
        etiquetaMontoDestino.setBounds(25,230,100,30);
        add(etiquetaMontoDestino);
        
         //configuracion de la etiqueta que muestra el precio de compra y venta de la moenda de origen.
        origenCompra = new JLabel("Origen Compra: 1.00 | Venta: 1.00");
        origenCompra.setBounds(25,260,250,30);
        add(origenCompra);
        
         //configuracion de la etiqueta que muestra el precio de compra y venta de la moenda de destino.
        destinoCompra = new JLabel("Origen Compra: 1.00 | Venta: 1.00");
        destinoCompra.setBounds(25,290,250,30);
        add(destinoCompra);
        
        //Configuramos la etiqueta con el nombre del cliente.
        nombreCliente = new JLabel("");
        nombreCliente.setBounds(160,170,150,30);
        add(nombreCliente);
        
        //configuracion de la etiqueta con el monto en dolares.
        montoDolares = new JLabel("USD 0");
        montoDolares.setBounds(160,200,150,30);
        add(montoDolares);
        
        // configuracion de la etiqueta con el monto final.
        montodestino = new JLabel("CRC 0");
        montodestino.setBounds(160,230,150,30);
        add(montodestino);
     
        // Configuracion del combo de equivalencia de origen.
        equivalenciasOrigen = new JComboBox();
        equivalenciasOrigen.setBounds(160,80,175,20);
        add(equivalenciasOrigen);
        
        // Configuracion del combo de equivalencia de destino
        equivalenciasDestino = new JComboBox();
        equivalenciasDestino.setBounds(160,110,175,20);
        add(equivalenciasDestino);
        
        //configuracion de la etiqueta que acomula la cantidad de dolares comprados en una ejecuación de la aplicación
        etiquetaTotalDolaresComprados = new JLabel("Total de dolares comprados: 0.00");
        etiquetaTotalDolaresComprados.setBounds(25,360,250,30);
        add(etiquetaTotalDolaresComprados);
        
        //configuracion de la etiqueta que acomula la cantidad de dolares vendidos en una ejecuación de la aplicación
        etiquetaTotalDolaresVendidos = new JLabel("Total de dolares vendidos: 0.00");
        etiquetaTotalDolaresVendidos.setBounds(25,330,250,30);
        add(etiquetaTotalDolaresVendidos);
        
        // Configuracion del textfield para la etiqueta del monto
        monto = new JTextField();
        monto.setBounds(160,140,100,20);
        add(monto);
        
        // Configuración del textField para la etiqueta ID del cliente.
        campoIdCliente = new JTextField();
        campoIdCliente.setBounds(160,50,100,20);
        add(campoIdCliente);
        
        // Configuracion del boton.
        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(100,400,150, 30);
        botonConvertir.addActionListener(this);
        add(botonConvertir);
    }
    
    /**
     * Cargamos las equivalencias de origen y destino
     */
    public void cargarEquivalencias(){
        equivalenciasOrigen.removeAllItems();
        for(int i = 0; i < Equivalencia.equivalencias.size(); i++){
            Equivalencia equivalencia = Equivalencia.equivalencias.get(i);
            equivalenciasOrigen.addItem(equivalencia.toString());
        }
        equivalenciasDestino.removeAllItems();
        for(int i = 0; i < Equivalencia.equivalencias.size(); i++){
            Equivalencia equivalencia = Equivalencia.equivalencias.get(i);
            equivalenciasDestino.addItem(equivalencia.toString());
        }
    }
    
    /**
     * Aquí se captura la acción del click en el botón.
     * @param e El evento.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botonConvertir){
            //verificar que el usuario haya digitado algo.
            boolean datosValidos = true;
            int idCliente = 0;
            double monto = 0;
            
            String textoIdCliente = this.campoIdCliente.getText();
            if(textoIdCliente == null || textoIdCliente.trim().equals("")){
                JOptionPane.showMessageDialog(this, "El ID del cliente es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            } else {
                //Verificar que el ID digitado sea numerico.
                try {
                    idCliente = Integer.parseInt(textoIdCliente);
                    if(idCliente <= 0 || idCliente > 999999999) {
                        JOptionPane.showMessageDialog(this, "El ID del cliente debe ser mayor a cero y menor que 999999999.", "Error", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    } else {
                        //Verificar que el ID digitado corresponda con un ID valido.
                        if(!this.servicioCliente.existeCliente(idCliente)){
                            JOptionPane.showMessageDialog(this, "El ID digitado no corresponde a un cliente registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                            datosValidos = false;
                        }
                    }
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "El ID del cliente debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            }
            
            try{
                monto = Double.parseDouble(this.monto.getText());
                if(monto <= 0){
                    JOptionPane.showMessageDialog(this, "El monto debe ser un número mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
            if(datosValidos){
                Cliente clienteTransaccion = this.servicioCliente.obtenerCliente(idCliente);
                this.nombreCliente.setText(clienteTransaccion.getNombreCompleto());
                this.nombreCliente.setToolTipText(clienteTransaccion.getNombreCompleto());
                DecimalFormat formateador = new DecimalFormat("#,##0.00");
                Equivalencia origen = Equivalencia.equivalencias.get(this.equivalenciasOrigen.getSelectedIndex());
                Equivalencia destino = Equivalencia.equivalencias.get(this.equivalenciasDestino.getSelectedIndex());
                
                double montoEnDolares = 0;
                if(origen.getCodigo().equals("USD")){
                    montoEnDolares = monto;
                } else{
                    montoEnDolares = convertidor.VentaDolares(origen.getDescripcionMoneda(), monto);
                    this.totalDolaresVendidos += montoEnDolares;
                }

                double montoConvertido = 0;
                if (destino.getCodigo().equals("USD")){
                    montoConvertido = montoEnDolares;
                } else {
                    this.totalDolaresComprados += montoEnDolares;
                    montoConvertido = convertidor.CompraDolares(destino.getDescripcionMoneda(), montoEnDolares);
                }
                this.montoDolares.setText("USD "+formateador.format(montoEnDolares));
                this.montodestino.setText(destino.getCodigo()+ " "+formateador.format(montoConvertido));
                this.origenCompra.setText("Origen Compra: "+ formateador.format(origen.getPrecioCompra()) 
                        +" | Venta: "+ formateador.format(origen.getPrecioVenta()));
                this.destinoCompra.setText("Destino compra: "+ formateador.format(destino.getPrecioCompra())
                        +" | Venta: "+ formateador.format(destino.getPrecioVenta()));
                this.etiquetaTotalDolaresComprados.setText("Total de dolares comprados: "+ formateador.format(this.totalDolaresComprados));
                this.etiquetaTotalDolaresVendidos.setText("Total de dolares vendidos: "+ formateador.format(this.totalDolaresVendidos));
                int opcionElegida = JOptionPane.showConfirmDialog(this, "¿Desea aceptar la transacción para el cliente?", "IMPORTANTE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcionElegida == JOptionPane.YES_OPTION) {
                    Transaccion transaccion = new Transaccion(origen, monto, destino, montoConvertido);
                    try{
                        this.servicioTransaccion.agregarTransaccion(clienteTransaccion, transaccion);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    
    /**
     * Metodo para mostrar la ventana de agregar equivalencia.
     */
    private void mostrarVentanaAgregarMoneda(){
        AgregarEquivalencia ventanaAgregarEquivalencia = new AgregarEquivalencia(this);
        ventanaAgregarEquivalencia.setLocationRelativeTo(this);
        ventanaAgregarEquivalencia.setVisible(true);
    }
    
    /**
     * Metodo para mostrar la ventana de modificar equivalencia.
     */
    private void mostrarVentanaModificarMoneda(){
        ActualizarEquivalencia ventanaActualizarEquivalencia = new ActualizarEquivalencia(this);
        ventanaActualizarEquivalencia.setLocationRelativeTo(this);
        ventanaActualizarEquivalencia.setVisible(true);
    }
    
    /**
     * Método para mostrar la ventana que agrega un cliente nuevo.
     */
    private void mostrarVentanaCliente(){
        PantallaCliente pantallaCliente = new PantallaCliente(this.servicioCliente);
        pantallaCliente.setLocationRelativeTo(this);
        pantallaCliente.setVisible(true);
    }
    
    /**
     * Método para mostrar la ventana para editar los datos del cliente exisistente.
     */
    private void mostrarVentanaEditarCliente(){
        PantallaEditarCliente pantallaEditarCliente = new PantallaEditarCliente(this.servicioCliente, this.servicioTransaccion);
        pantallaEditarCliente.setLocationRelativeTo(this);
        pantallaEditarCliente.setVisible(true);
    }
    
    /**
     * Método para mostrar la venta para borrar un cliente.
     */
    private void mostrarVentanaBorrarCliente(){
        PantallaBorrarCliente pantallaBorrarCliente = new PantallaBorrarCliente(this.servicioCliente, this.servicioTransaccion);
        pantallaBorrarCliente.setLocationRelativeTo(this);
        pantallaBorrarCliente.setVisible(true);
    }
    
    /**
     * Método para mostrar la venta para el reporte de conversiones por moneda.
     */
    private void mostrarVentanaReporteMoneda(){
        PantallaConversionesPorMoneda pantallaConversionesPorMoneda = new PantallaConversionesPorMoneda(this.servicioTransaccion);
        pantallaConversionesPorMoneda.setLocationRelativeTo(this);
        pantallaConversionesPorMoneda.setVisible(true);
    }
    
    /**
     * Método para mostrar la venta para el reporte de conversiones por cliente.
     */
    private void mostrarVentanaReportePorCliente(){
        PantallaConversionesPorCliente pantallaConversionesPorCliente = new PantallaConversionesPorCliente(this.servicioTransaccion, this.servicioCliente);
        pantallaConversionesPorCliente.setLocationRelativeTo(this);
        pantallaConversionesPorCliente.setVisible(true);
    }
}
