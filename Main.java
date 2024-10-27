import controller.LoginController;
import util.DataStore;

public class Main {
    public static void main(String[] args) {
        // Inicializa los datos necesarios para el funcionamiento de la aplicación
        DataStore.inicializarDatos();
        // Crea una instancia de LoginController para manejar el proceso de inicio de
        // sesión
        LoginController loginController = new LoginController();
        // Inicia el proceso de inicio de sesión
        loginController.iniciar();
    }
}
