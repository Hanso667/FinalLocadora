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
import model.Cliente;
import model.Editora;

public class EditoraController {
    
    public Editora consultarEditora(int id) {
    //Guarda o sql
    String sql = "SELECT * FROM editoras "
            + "where id_editora = ?";
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Crio a lista de usuários vazia
    Editora editora = new Editora();
    
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
          editora.setId(resultado.getInt("id_editora"));
          editora.setNome(resultado.getString("nome"));
          editora.setPais(resultado.getString("pais"));
      }

    } catch (SQLException ex) {
      Logger.getLogger(ClienteController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }

    //retorno a lista de usuários
    return editora;
  }
    
    public List<Editora> listar() {
    //Guarda o sql
    String sql = "SELECT * FROM editoras";
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Crio a lista de usuários vazia
    List<Editora> listaEditoras = new ArrayList<>();
    
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
        Editora editora = new Editora();

        //Leio as informações da variável resultado e guardo no usuário
        editora.setId(resultado.getInt("id_editora"));
        editora.setNome(resultado.getString("nome"));
        editora.setPais(resultado.getString("pais"));

        //adiciono o usuário na lista
        listaEditoras.add(editora);
      }

    } catch (SQLException ex) {
      Logger.getLogger(EditoraController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }

    //retorno a lista de usuários
    return listaEditoras;
  }
    
    public boolean inserirEditora(Editora edi) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO editoras(nome,pais) "
                + " VALUES (?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);
            
            comando.setString(1, edi.getNome());
            comando.setString(2, edi.getPais());

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        }catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir a Editora: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterarEditora(Editora edi, int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE editoras "
                   + "set nome = ?, pais = ? "
                   + "where id_editora = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, edi.getNome());
            comando.setString(2, edi.getPais());
            comando.setInt(3, id);

            
            comando.executeUpdate();
            

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a editora: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerEditora(int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from editoras"
                   + " where id_editora = ?";

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
            JOptionPane.showMessageDialog(null, "Erro ao remover a editora: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
    


}
