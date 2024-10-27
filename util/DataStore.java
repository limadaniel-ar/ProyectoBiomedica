package util;

import java.util.*;
import java.util.stream.Collectors;

import model.*;

public class DataStore {
    // Listas para almacenar todos los objetos del sistema
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Rol> roles = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static List<OrdenProduccion> ordenesProduccion = new ArrayList<>();
    private static List<Area> areas = new ArrayList<>();
    private static List<Etapa> etapas = new ArrayList<>();
    private static List<CategoriaParada> categoriasParada = new ArrayList<>();
    private static List<Costo> costos = new ArrayList<>();
    private static List<OperarioEnOrden> operariosEnOrden = new ArrayList<>();
    private static List<Parada> paradas = new ArrayList<>();
    private static List<Unidad> unidades = new ArrayList<>();

    // Contadores para IDs
    private static int nextUsuarioId = 1;
    private static int nextProductoId = 1;
    private static int nextOrdenId = 100000;
    private static int nextAreaId = 1;
    private static int nextEtapaId = 1;
    private static int nextCategoriaParadaId = 1;
    private static int nextCostoId = 1;
    private static int nextOperarioEnOrdenId = 1;
    private static int nextParadaId = 1;
    private static int nextUnidadId = 1;
    public static Object getOperariosEnOrden;

    // Método para inicializar datos de prueba
    public static void inicializarDatos() {
        // Inicializar roles
        roles.add(new Rol(roles.size() + 1, "Director"));
        roles.add(new Rol(roles.size() + 1, "Jefe de Produccion"));
        roles.add(new Rol(roles.size() + 1, "Jefe de Planificacion"));
        roles.add(new Rol(roles.size() + 1, "Operario"));

        // Inicializar usuarios de prueba
        usuarios.add(new Usuario(nextUsuarioId++, 28134756, "Juan", "Perez", "2589", roles.get(0)));
        usuarios.add(new Usuario(nextUsuarioId++, 29345871, "Maria", "Gomez", "3691", roles.get(1)));
        usuarios.add(new Usuario(nextUsuarioId++, 30781245, "Carlos", "Lopez", "4813", roles.get(2)));
        usuarios.add(new Usuario(nextUsuarioId++, 32814567, "Ana", "Rodriguez", "5924", roles.get(3)));

        // Inicializar áreas
        areas.add(new Area(nextAreaId++, "Granulación Vía Húmeda"));
        areas.add(new Area(nextAreaId++, "Granulación Vía Seca"));
        areas.add(new Area(nextAreaId++, "Compresión 1"));
        areas.add(new Area(nextAreaId++, "Compresión 2"));
        areas.add(new Area(nextAreaId++, "Recubrimiento"));
        areas.add(new Area(nextAreaId++, "Encapsulado"));

        // Inicializar etapas
        etapas.add(new Etapa(nextEtapaId++, "Preparación"));
        etapas.add(new Etapa(nextEtapaId++, "Proceso"));
        etapas.add(new Etapa(nextEtapaId++, "Finalización"));

        // Inicializar categorías de parada
        categoriasParada.add(new CategoriaParada(nextCategoriaParadaId++, "Corte de electricidad"));
        categoriasParada.add(new CategoriaParada(nextCategoriaParadaId++, "Problemas de temperatura y presión"));
        categoriasParada.add(new CategoriaParada(nextCategoriaParadaId++, "Comprimidos defectuosos"));
        categoriasParada.add(new CategoriaParada(nextCategoriaParadaId++, "Capsulas rotas"));
        categoriasParada.add(new CategoriaParada(nextCategoriaParadaId++, "Problema en motor"));

        // Inicializar unidades de cantidad
        unidades.add(new Unidad(nextUnidadId++, "Kg"));
        unidades.add(new Unidad(nextUnidadId++, "Comprimidos"));
        unidades.add(new Unidad(nextUnidadId++, "Nucleos"));
        unidades.add(new Unidad(nextUnidadId++, "Comprimidos Recubiertos"));
        unidades.add(new Unidad(nextUnidadId++, "Capsulas"));

        // Inicializar productos
        productos.add(new Producto(nextProductoId++, "Granulado de Paracetamol", 200, unidades.get(0)));
        productos.add(new Producto(nextProductoId++, "Paracetamol 500mg", 400000, unidades.get(1)));
        productos.add(new Producto(nextProductoId++, "Ibuprofeno", 200, unidades.get(0)));
        productos.add(new Producto(nextProductoId++, "Ibuprofeno 500mg Nucleos", 350000, unidades.get(2)));
        productos.add(new Producto(nextProductoId++, "Ibuprofeno 500mg Comp Recub", 350000, unidades.get(3)));
        productos.add(new Producto(nextProductoId++, "Omeprazol 20mg", 1200000, unidades.get(4)));

        ordenesProduccion.add(new OrdenProduccion(nextOrdenId++, 125, productos.get(0), areas.get(0)));
        ordenesProduccion.add(new OrdenProduccion(nextOrdenId++, 35, productos.get(5), areas.get(5)));
        ordenesProduccion.add(new OrdenProduccion(nextOrdenId++, 125, productos.get(3), areas.get(2)));

        costos.add(new Costo(1, 6, 2024, 1023456, usuarios.get(0)));
        costos.add(new Costo(2, 7, 2024, 2046813, usuarios.get(0)));
    }

    // Getters para las listas
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static List<Rol> getRoles() {
        return roles;
    }

    public static List<Unidad> getUnidades() {
        return unidades;
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static List<OrdenProduccion> getOrdenesProduccion() {
        return ordenesProduccion;
    }

    public static List<Area> getAreas() {
        return areas;
    }

    public static List<Etapa> getEtapas() {
        return etapas;
    }

    public static List<CategoriaParada> getCategoriasParada() {
        return categoriasParada;
    }

    public static List<Costo> getCostos() {
        return costos;
    }

    public static List<OperarioEnOrden> getOperariosEnOrden() {
        return operariosEnOrden;
    }

    public static List<Parada> getParadas() {
        return paradas;
    }

    // Métodos para agregar nuevos elementos
    public static void agregarUsuario(Usuario usuario) {
        usuario.setLegajo(nextUsuarioId++);
        usuarios.add(usuario);
    }

    public static void agregarProducto(Producto producto) {
        producto.setId(nextProductoId++);
        productos.add(producto);
    }

    public static void agregarOrdenProduccion(OrdenProduccion orden) {
        orden.setId(nextOrdenId++);
        ordenesProduccion.add(orden);
    }

    public static void agregarArea(Area area) {
        area.setId(nextAreaId++);
        areas.add(area);
    }

    public static void agregarEtapa(Etapa etapa) {
        etapa.setId(nextEtapaId++);
        etapas.add(etapa);
    }

    public static void agregarCategoriaParada(CategoriaParada categoria) {
        categoria.setId(nextCategoriaParadaId++);
        categoriasParada.add(categoria);
    }

    public static void agregarCosto(Costo costo) {
        costo.setId(nextCostoId++);
        costos.add(costo);
    }

    public static void agregarOperarioEnOrden(OperarioEnOrden operarioEnOrden) {
        operarioEnOrden.setId(nextOperarioEnOrdenId++);
        operariosEnOrden.add(operarioEnOrden);
    }

    public static void agregarParada(Parada parada) {
        parada.setId(nextParadaId++);
        paradas.add(parada);
    }

    // Métodos para eliminar elementos
    public static boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getLegajo() == id);
    }

    public static boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }

    // Métodos de búsqueda
    public static Usuario buscarUsuarioPorLegajo(int legajo) {
        return usuarios.stream()
                .filter(u -> u.getLegajo() == legajo)
                .findFirst()
                .orElse(null);
    }

    public static OrdenProduccion buscarOrdenProduccion(int id) {
        return ordenesProduccion.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static Producto buscarProducto(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static CategoriaParada buscarCategoriaParada(int id) {
        return categoriasParada.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para obtener órdenes en proceso
    public static List<OrdenProduccion> getOrdenesEnProceso() {
        return ordenesProduccion.stream()
                .filter(o -> o.isIniciado() && !o.isTerminado())
                .collect(Collectors.toList());
    }

    // Método para obtener órdenes disponibles
    public static List<OrdenProduccion> getOrdenesDisponibles() {
        return ordenesProduccion.stream()
                .filter(o -> !o.isIniciado())
                .collect(Collectors.toList());
    }

    // Método para modificar datos de usuario
    public static void actualizarUsuario(Usuario usuarioModificado) {
        // Validar que el usuario existe
        if (usuarioModificado == null || usuarioModificado.getLegajo() <= 0) {
            throw new IllegalArgumentException("Usuario inválido");
        }

        // Buscar el índice del usuario en la lista
        int index = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getLegajo() == usuarioModificado.getLegajo()) {
                index = i;
                break;
            }
        }

        // Si no se encuentra el usuario, lanzar excepción
        if (index == -1) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        // Validar datos del usuario modificado
        validarDatosUsuario(usuarioModificado);

        // Actualizar el usuario en la lista
        usuarios.set(index, usuarioModificado);
    }

    // Método para modificar datos del producto
    public static void actualizarProducto(Producto productoModificado) {
        // Validar que el producto existe
        if (productoModificado == null || productoModificado.getId() <= 0) {
            throw new IllegalArgumentException("Producto inválido");
        }

        // Buscar el índice del producto en la lista
        int index = -1;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == productoModificado.getId()) {
                index = i;
                break;
            }
        }

        // Si no se encuentra el producto, lanzar excepción
        if (index == -1) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        // Validar datos del producto modificado
        validarDatosProducto(productoModificado);

        // Actualizar el producto en la lista
        productos.set(index, productoModificado);

    }

    // Método para modificar datos de la categoría de parada
    public static void actualizarCategoriaParada(CategoriaParada categoriaModificada) {
        // Validar que la categoria existe
        if (categoriaModificada == null || categoriaModificada.getId() <= 0) {
            throw new IllegalArgumentException("Categoría inválida");
        }

        // Buscar el índice de la categoría en la lista
        int index = -1;
        for (int i = 0; i < categoriasParada.size(); i++) {
            if (categoriasParada.get(i).getId() == categoriaModificada.getId()) {
                index = i;
                break;
            }
        }

        // Si no se encuentra el producto, lanzar excepeción
        if (index == -1) {
            throw new IllegalArgumentException("Categoría no encontrada");
        }

        // Validar datos de la categoría
        validarDatosCategoria(categoriaModificada);

        // Actualizar el producto en la lista
        categoriasParada.set(index, categoriaModificada);
    }

    // Método que valida que los datos de un usuario no se encuentren nulos
    private static void validarDatosUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (usuario.getApellido() == null || usuario.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (usuario.getRol() == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo");
        }
    }

    // Método que valida que los datos de un producto no se encuentren nulos
    private static void validarDatosProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (producto.getCantidad() == 0) {
            throw new IllegalArgumentException("La cantidad no puede ser 0");
        }
        if (producto.getUnidad() == null) {
            throw new IllegalArgumentException("La unidad no puede ser nulo");
        }
    }

    // Método que valida que los datos de una categoría no se encuentren nulos
    private static void validarDatosCategoria(CategoriaParada categoria) {
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
}
