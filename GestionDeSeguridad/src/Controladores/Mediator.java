package Controladores;

import Controladores.PestanasConPaneles.Calendario;
import Vistas.Login;
import Vistas.Menu;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    Login login;
    Menu menu;
    Escritura escritura;
    Calendario calendario;
    Vistas.Perfil perfil;
    
    public Mediator(){
        escritura = new Escritura();
        login  = new Login();
        perfil = new Vistas.Perfil();
        login.setMediator(this);
        login.show();
    }
    
    public void autenticar(String login, String password){
        if(escritura.autenticar(login,password)){
            menu = new Menu();
            menu.setMediator(this);
            calendario = new Calendario(this);
            this.login.setVisible(false);
            escritura.leerDatos();
            menu.setCalendario(calendario.prepararCalendario());
            menu.show();
        } else {
            this.login.errorDeAuten();
        }
    }
    
    public void changePanel(JPanel panel){
        menu.setCalendario(panel);
    }
    
    public void mostrarPerfil(Object obj){
        /*
         * Itzco, tu sabes tu chamba... este método es para todos tus compañeritos (riesgo, control, rol, Activo, etc etc).
         * Mostrar en perfil...
         * * TIENES QUE CHECAR PRIVILEGIOS POR SI LA PETICION NO ES DEL CALENDARIO
         */
        perfil.show();
    }
    
    public void cambiaPestana(int pestana){
        /*
         * ya sabes aquí... y al final el panel.
         * 
         * 
         */
    }
    
}
