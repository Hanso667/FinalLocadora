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
import model.Produto;
import model.Genero;
import java.util.Date;

public class ProdutoController {

    public List<Genero> listarGeneros(int produto) {
        //Guarda o sql
        String sql = "select * from produto_genero as pdtg "
                   + "left join generos as gen on gen.id_genero = pdtg.id_genero "
                   + "where pdtg.id_produto = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários vazia
        List<Genero> listaGeneros = new ArrayList<>();

        try {
            //Preparo do comando sql
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);

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
            Logger.getLogger(ProdutorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return listaGeneros;
    }

    public Produto consultar(int id) {

        String sql = "SELECT * FROM produtos "
                   + "where id_produto = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        Produto produto = new Produto();

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);
            
            resultado = comando.executeQuery();

            
            
            if (resultado.next()) {

                produto.setId(resultado.getInt("id_produto"));
                produto.setTitulo(resultado.getString("titulo"));
                produto.setAno(resultado.getInt("ano_lancamento"));
                produto.setEditora(resultado.getString("id_editora"));
                produto.setProdutor(resultado.getString("id_produtor"));
                produto.setDuracao(resultado.getInt("duracao"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setQuantidade(resultado.getInt("estoque"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return produto;
    }

    public List<Produto> listar() {
        //Guarda o sql
        String sql = "SELECT p.*, edt.nome, pdtr.nome  ,"
                + "GROUP_CONCAT(g.nome SEPARATOR ', ') AS generos "
                + "FROM produtos p "
                + "left JOIN produto_genero pg ON p.id_produto = pg.id_produto "
                + "left JOIN generos g ON g.id_genero = pg.id_genero "
                + "left join editoras as edt on edt.id_editora = p.id_editora "
                + "left join produtores as pdtr on pdtr.id_produtor = p.id_produtor "
                + "GROUP BY p.id_produto";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários vazia
        List<Produto> listaProdutos = new ArrayList<>();

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
                Produto produto = new Produto();

                //Leio as informações da variável resultado e guardo no usuário
                produto.setId(resultado.getInt("p.id_produto"));
                produto.setTitulo(resultado.getString("p.titulo"));
                produto.setAno(resultado.getInt("p.ano_lancamento"));
                produto.setEditora(resultado.getString("edt.nome"));
                produto.setProdutor(resultado.getString("pdtr.nome"));
                produto.setDuracao(resultado.getInt("p.duracao"));
                produto.setPreco(resultado.getDouble("p.preco"));
                produto.setQuantidade(resultado.getInt("p.estoque"));
                produto.setGeneros(resultado.getString("generos"));

                //adiciono o usuário na lista
                listaProdutos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return listaProdutos;
    }

    public boolean inserirProduto(Produto prod) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO produtos(titulo,ano_lancamento,duracao,id_editora,id_produtor,preco,estoque) "
                + " VALUES (?,?,?,?,?,?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, prod.getTitulo());
            comando.setInt(2, prod.getAno());
            comando.setInt(3, prod.getDuracao());
            comando.setString(4, prod.getEditora());
            comando.setString(5, prod.getProdutor());
            comando.setInt(6, prod.getQuantidade());
            comando.setDouble(7, prod.getPreco());

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean inserirProduto(int produto, int genero) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO produto_genero(id_produto,id_genero) "
                + " VALUES (?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);
            comando.setInt(2, genero);

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterarProduto(Produto prod, int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE produtos "
                + "set titulo = ?, ano_lancamento = ?, duracao = ? , id_editora = ?, id_produtor = ?, estoque = ?, preco = ?"
                + "where id_produto = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, prod.getTitulo());
            comando.setInt(2, prod.getAno());
            comando.setInt(3, prod.getDuracao());
            comando.setString(4, prod.getEditora());
            comando.setString(5, prod.getProdutor());
            comando.setInt(6, prod.getQuantidade());
            comando.setDouble(7, prod.getPreco());
            comando.setInt(8, id);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerProduto(int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from produtos"
                + " where id_produto = ?";

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
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerGenero(int produto, int genero) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from produto_genero"
                + " where id_produto = ? and id_genero = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);
            comando.setInt(2, genero);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

}
