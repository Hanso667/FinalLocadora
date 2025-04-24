package controller;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Genero;

public class GeneroController {

    public Genero consultarGenero(int id) {
    //Guarda o sql
    String sql = "SELECT * FROM generos "
            + "where id_genero = ?";
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Crio a lista de usuários vazia
    Genero genero = new Genero();
    
    try {
      //Preparo do comando sql
      comando = gerenciador.prepararComando(sql);
      
      comando.setInt(1,id);

      //Como não há parâmetros já executo direto
      resultado = comando.executeQuery();

      //Irá percorrer os registros do resultado do sql
      //A cada next() a variavel resultado aponta para o próximo registro 
      //enquanto next() == true quer dizer que tem registros
      while (resultado.next()) {
          genero.setId(resultado.getInt("id_genero"));
          genero.setNome(resultado.getString("nome"));

      }

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }

    //retorno a lista de usuários
    return genero;
  }
    
    public List<Genero> consultar() {
        //Guarda o sql
        String sql = "select gen.nome from produto_genero as pdtg "
                + "left join generos as gen on gen.id_genero = pdtg.id_genero "
                + "where pdtg.id_produto = ?";

        //Cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        List<Genero> listaGeneros = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {

                Genero genero = new Genero();

                genero.setNome(resultado.getString("nome"));

                listaGeneros.add(genero);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditoraController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return listaGeneros;
    }

    public List<Genero> listar() {
        //Guarda o sql
        String sql = "SELECT * FROM generos";

        //Cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários vazia
        List<Genero> listaGeneros = new ArrayList<>();

        try {
            //Preparo do comando sql
            comando = gerenciador.prepararComando(sql);

            //Como não há parâmetros já executo direto
            resultado = comando.executeQuery();

            //Irá percorrer os registros do resultado do sql
            //A cada next() a variavel resultado aponta para o próximo registro 
            //enquanto next() == true quer dizer que tem registros
            while (resultado.next()) {

                //Crio um novo usuário vazio
                Genero genero = new Genero();

                //Leio as informações da variável resultado e guardo no usuário
                genero.setId(resultado.getInt("id_genero"));
                genero.setNome(resultado.getString("nome"));

                //adiciono o usuário na lista
                listaGeneros.add(genero);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditoraController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return listaGeneros;
    }

    public boolean inserirGenero(Genero edi) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO generos(nome) "
                + " VALUES (?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, edi.getNome());

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir o Genero: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterarGenero(Genero edi, int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE generos "
                + "set nome = ?"
                + "where id_genero = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, edi.getNome());
            comando.setInt(2, id);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a Genero: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerGenero(int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from generos"
                + " where id_genero = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao remover o Genero: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

}
