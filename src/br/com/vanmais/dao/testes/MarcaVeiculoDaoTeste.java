package br.com.vanmais.dao.testes;

import junit.framework.Assert;

import org.hibernate.Session;
import org.junit.Test;

import br.com.vanmais.bancodedados.dao.MarcaVeiculoDAO;
import br.com.vanmais.bancodedados.entidade.MarcaVeiculoEntidade;
import br.com.vanmais.bancodedados.util.HibernateUtil;
/**
 * @author fassilva
 *
 */
public class MarcaVeiculoDaoTeste{
	
	public static Session sessao;
	 
	
	public MarcaVeiculoDaoTeste() {
	}
	@Test
	public void teste(){
		sessao = HibernateUtil.getSession(sessao);
		sessao.beginTransaction();
		MarcaVeiculoDAO mvDao = new MarcaVeiculoDAO(sessao);
		MarcaVeiculoEntidade mv = new MarcaVeiculoEntidade();
		mv.setId(null);
		mv.setDescMarca("Jac Motors");
		Long codigo = mvDao.salvar(mv);
		System.out.println("\n\nTESTE\n\n\tCodigo = "+codigo+"\n\nFIM TESTE");
		MarcaVeiculoEntidade mve = mvDao.buscarPeloId(codigo);
		sessao.getTransaction().commit();
		sessao.close();
		System.out.println("\n\nTESTE\n\n\tMarca = "+mve.getDescMarca()+
				"n\tCodigo Marca = "+mve.getId()+"\n\nFIM TESTE");
		
		
		Assert.assertNotNull(mve);
		
	}
	
}