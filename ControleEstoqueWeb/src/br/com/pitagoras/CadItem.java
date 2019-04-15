package br.com.pitagoras;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.pitagoras.dao.ItemDao;
import br.com.pitagoras.entity.*;

public class CadItem extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod;
		ItemDao dao = new ItemDao();
		Item item = new Item();
		
		cod = dao.geraCodigo();
		String codigo = request.getParameter(Integer.toString(cod));
		String descricao = request.getParameter("txtDescricao");
		String fornecedor = request.getParameter("txtFornecedor");
		String quantidade = request.getParameter("txtQuantidade");
		
		item.setCodigo(codigo);
		item.setDescricao(descricao);
		item.setFornecedor(fornecedor);
		item.setQuantidade(quantidade);
		
		dao.insertItem(item);		
	}
}