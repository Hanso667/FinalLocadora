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
import model.Produtor;
import java.util.Date;

public class ProdutoController {
    
    public List<Produtor> listar() {
    //Guarda o sql
    String sql = "SELECT * FROM produtores";
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Crio a lista de usuários vazia
    List<Produtor> listaProdutores = new ArrayList<>();
    
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
        Produtor produtor = new Produtor();

        //Leio as informações da variável resultado e guardo no usuário
        produtor.setId(resultado.getInt("id_produtor"));
        produtor.setNome(resultado.getString("nome"));
        produtor.setNascimento(resultado.getDate("data_nascimento"));
        produtor.setNacionalidade(resultado.getString("nacionalidade"));

        //adiciono o usuário na lista
        listaProdutores.add(produtor);
      }

    } catch (SQLException ex) {
      Logger.getLogger(ProdutorController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }

    //retorno a lista de usuários
    return listaProdutores;
  }
    
    public boolean inserirProduto(Produtor prod) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO produtores(nome,data_nascimento,nacionalidade) "
                + " VALUES (?,?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);
            
            comando.setString(1, prod.getNome());
            comando.setDate(2, prod.getNascimento());
            comando.setString(3, prod.getNacionalidade());

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        }catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produtor: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterarProduto(Produtor prod, int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE produtores "
                   + "set nome = ?, data_nascimento = ?, nacionalidade = ? "
                   + "where id_editora = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, prod.getNome());
            comando.setDate(2, prod.getNascimento());
            comando.setString(3, prod.getNacionalidade());
            comando.setInt(4, id);

            
            comando.executeUpdate();
            

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o produtor: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerProduto(int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from produtores"
                   + " where id_produtor = ?";

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
            JOptionPane.showMessageDialog(null, "Erro ao remover o produtor: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
    


}
