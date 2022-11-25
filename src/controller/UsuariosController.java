package controller;

import model.FicheiroUsuarios;
import model.Usuario;
import view.Login;
import view.NovoUsuario;

/**
 *
 * @author Grácio Macuácua
 */
public final class UsuariosController {

    
    public UsuariosController(){
        FicheiroUsuarios controller = new FicheiroUsuarios();
        controller.CaminhoPrincipal();

        if (!FicheiroUsuarios.lista().isEmpty())
            new Login().setVisible(true);
        else
            new NovoUsuario().setVisible(true);        
    }
    /**
     * Efectua o registro de um usuário na base de dados.
     * @param user o usuário a ser registado
     * @return {@code true} se o usuário tiver sido salvo com sucesso, 
     * {@code false} caso contrário
     */
    public static final boolean guardarUsuario(Usuario user) {
        return FicheiroUsuarios.create(user);
    }

    /**
     * Efectua a autenticação de usuários para entrada no sistema.
     * @param nome o nome do usuário a ser autenticado
     * @param senha a senha do usuário a ser autenticado
     * @return {@code true} se os dados corresponderem ao usuário informado, 
     * {@code false} caso contrário.
     */
    public static final boolean autenticarUsuario(String nome, String senha) {
        for (Usuario u : FicheiroUsuarios.lista())
            if (nome.equals(u.getNome()) && senha.equals(u.getSenha()))
                return true;
        
        return false;
    }
}
