package negocio;

import java.util.List;

<<<<<<< HEAD
=======
import dao.UsuarioDAO;
import util.EncripitarSenha;
>>>>>>> refs/remotes/upstream/master
import vo.UsuarioVO;
import vo.excecao.UsuarioVOException;
import dao.UsuarioDAO;


public class Usuario {

	public void save(UsuarioVO vo) throws UsuarioVOException {

		if(vo.getNome() == null && vo.getNome().isEmpty())
			throw new UsuarioVOException(UsuarioVOException.NOMEOBRIGATORIO);
		if(vo.getLogin() == null && vo.getLogin().isEmpty())
			throw new UsuarioVOException(UsuarioVOException.LOGINOBRIGATORIO);
		if(vo.getEmail() == null && vo.getEmail().isEmpty())
			throw new UsuarioVOException(UsuarioVOException.EMAILOBRIGATORIO);
		if(vo.getSenha() == null && vo.getSenha().isEmpty())
			throw new UsuarioVOException(UsuarioVOException.SENHAOBRIGATORIO);
		if(!vo.validarEmail(vo.getEmail()))
			throw new UsuarioVOException(UsuarioVOException.EMAILINVALIDO);
<<<<<<< HEAD

=======
		
		vo.setSenha(EncripitarSenha.encriptar(vo.getSenha()));
		
>>>>>>> refs/remotes/upstream/master
		UsuarioDAO.getInstance().save(vo);
	}
	
	public UsuarioVO getByLoginSenha(String login, String senha) throws UsuarioVOException {
		if(login == null && login.isEmpty())
			throw new UsuarioVOException(UsuarioVOException.LOGINOBRIGATORIO);
		if(senha == null && senha.isEmpty())
			throw new UsuarioVOException(UsuarioVOException.SENHAOBRIGATORIO);
		
		UsuarioVO vo = UsuarioDAO.getInstance().getByLoginSenha(login, senha);
		
		if(vo == null)
			throw new UsuarioVOException(UsuarioVOException.LOGINFAIL);
		
		return vo;
	}
	
	public void delete(UsuarioVO vo) {
		UsuarioDAO.getInstance().delete(vo);
	}
	
	public UsuarioVO getById(long id) {
		UsuarioVO vo = UsuarioDAO.getInstance().getById(id);
		
		return vo;
	}
	
	public List<UsuarioVO> getAll() {
		return UsuarioDAO.getInstance().getAll();
	}
}
