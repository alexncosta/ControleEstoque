package br.com.pitagoras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.pitagoras.dao.ItemDao;
import br.com.pitagoras.entity.*;

@WebServlet("/cadItem")
public class CadItem extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod;
		ItemDao dao = new ItemDao();
		Item item = new Item();
		
		cod = dao.geraCodigo();
		String codigo = Integer.toString(cod);
		String descricao = request.getParameter("txtDescricao");
		String fornecedor = request.getParameter("txtFornecedor");
		String quantidade = request.getParameter("txtQuantidade");
		String marca = request.getParameter("txtMarca");
		String dataVencimento = request.getParameter("txtDataVencimento");
		
		item.setCodigo(codigo);
		item.setDescricao(descricao);
		item.setFornecedor(fornecedor);
		item.setQuantidade(quantidade);
		item.setMarca(marca);
		item.setDataVencimento(dataVencimento);
		
		dao.insertItem(item);		
	}
}
