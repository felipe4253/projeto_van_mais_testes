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
		MarcaVeiculoDAO mvDao = new MarcaVeiculoDAO(sessao);
		MarcaVeiculoEntidade mv = new MarcaVeiculoEntidade();
		mv.setId(0L);
		mv.setDescMarca("Fiat");
		mvDao.salvar(mv);
		
		MarcaVeiculoEntidade mve = mvDao.buscarPeloId(0L);
		Assert.assertNotNull(mve);
	}
	
	
	
}