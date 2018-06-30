/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho;

import Conexao.ProdutoDAO;

/**
 *
 * @author Vitor Reis
 */
public class AlterarProduto {
    public void alterar(int iD, String nome, double preco){
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.alterar(iD, nome, preco);
    }
}
