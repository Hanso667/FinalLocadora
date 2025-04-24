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
import model.Venda;
import java.util.Date;
import model.ItemVenda;

public class VendaController {

    public Venda consultarVenda(int id) {
    String sqlV = "SELECT * FROM vendas WHERE id_venda = ?";
    String sqlIv = "SELECT * FROM itens_venda";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comandoV = null;
    PreparedStatement comandoIv = null;
    ResultSet resultadoV = null;
    ResultSet resultadoIv = null;

    Venda venda = new Venda();

    try {
        // Consulta da venda
        comandoV = gerenciador.prepararComando(sqlV);
        comandoV.setInt(1, id);
        resultadoV = comandoV.executeQuery();

        if (resultadoV.next()) {
            venda.setId(id);
            venda.setClienteId(resultadoV.getInt("id_cliente"));
            venda.setUsuarioId(resultadoV.getInt("id_usuario"));
            venda.setVencimento(resultadoV.getDate("data_vencimento"));
            venda.setStatus(resultadoV.getString("status"));
            venda.setTotal(resultadoV.getDouble("total"));
        }

    } catch (SQLException ex) {
        Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        gerenciador.fecharConexao(comandoV, resultadoV);
        gerenciador.fecharConexao(comandoIv, resultadoIv);
    }

    return venda;
}
    
    public Venda consultar(int id) {

        String sql = "SELECT * FROM vendas";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        Produto Produto = new Produto();

        Venda venda = new Venda();

        try {

            comando = gerenciador.prepararComando(sql);

            resultado = comando.executeQuery();

            if (resultado.next()) {

                venda.setId(resultado.getInt("id_venda"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return venda;
    }

    public List<Venda> listar() {
        //Guarda o sql
        String sql = "select * from vendas as ven "
                + "left join usuarios as usu on usu.id_usuario = ven.id_usuario "
                + "left join clientes as cli on cli.id_cliente = ven.id_cliente";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários vazia
        List<Venda> listaVendas = new ArrayList<>();

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
                Venda venda = new Venda();

                //Leio as informações da variável resultado e guardo no usuário
                venda.setId(resultado.getInt("ven.id_venda"));
                venda.setCliente(resultado.getString("cli.nome"));
                venda.setUsuario(resultado.getString("usu.nome"));
                venda.setVencimento(resultado.getDate("ven.data_vencimento"));
                venda.setStatus(resultado.getString("ven.status"));
                venda.setTotal(resultado.getDouble("ven.total"));

                //adiciono o usuário na lista
                listaVendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutorController.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        //retorno a lista de usuários
        return listaVendas;
    }

    public boolean inserirVenda(Venda ven) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO vendas(id_cliente,id_usuario,data_vencimento,total) "
                + " VALUES (?,?,?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, ven.getClienteId());
            comando.setInt(2, ven.getUsuarioId());
            comando.setDate(3, ven.getVencimento());
            comando.setDouble(4, ven.getTotal());

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao inserir a venda: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean inserirProduto(int produto, int venda, int quantidade, double preco) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO itens_venda(id_produto,id_venda, quantidade, preco_unitario) "
                + " VALUES (?,?,?,?) ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);
            comando.setInt(2, venda);
            comando.setInt(3, quantidade);
            comando.setDouble(4, preco);

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
    
    public boolean alterarProduto(int produto, int venda, int quantidade, double preco) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "update itens_venda "
                   + "set id_produto = ? ,  quantidade = ? , preco_unitario = ? "
                   + "where id_produto = ? and id_venda = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);
            comando.setInt(2, quantidade);
            comando.setDouble(3, preco);
            comando.setInt(4, produto);
            comando.setInt(5, venda);

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

    public boolean RemoverProduto(int produto, int venda) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "remove from itens_venda(id_produto,id_venda) "
                + " where id_produto = ? and id_venda = ? ";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, produto);
            comando.setInt(2, venda);

            //define o valor de cada variável(?) pela posição em que aparece no sql
            //Executa o insert
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean alterarVenda(Venda ven, int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE vendas "
                + "set id_cliente = ?, id_usuario = ?, data_vencimento = ? , status = ?, total = ?"
                + "where id_venda = ?";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, ven.getClienteId());
            comando.setInt(2, ven.getUsuarioId());
            comando.setDate(3, ven.getVencimento());
            comando.setString(4, ven.getStatus());
            comando.setDouble(5, ven.getTotal());
            comando.setDouble(6, id);

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a venda: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean removerVenda(int id) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "delete from vendas"
                + " where id_venda = ?";

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
            JOptionPane.showMessageDialog(null, "Erro ao remover a venda: " + e.getMessage());//exibe popup com o erro
        } finally {//depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}
