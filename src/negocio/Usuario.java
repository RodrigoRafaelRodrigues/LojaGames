package negocio;

import java.util.List;

import vo.UsuarioVO;
import vo.excecao.UsuarioVOException;
import dao.UsuarioDAO;

public class Usuario {

	public void save(UsuarioVO vo) throws UsuarioVOException {
		if (vo.getNome()==null || vo.getNome().trim().equals(""))
			throw new UsuarioVOException(UsuarioVOException.NOMEOBRIGATORIO);
		if (vo.getSenha()==null || vo.getSenha().trim().equals(""))
			throw new UsuarioVOException(UsuarioVOException.SENHAOBRIGATORIO);
		if (vo.getEmail()==null || vo.getEmail().trim().equals(""))
			throw new UsuarioVOException(UsuarioVOException.EMAILOBRIGATORIO);
		if (vo.getEmail()==null || vo.getEmail().trim().equals(""))
			throw new UsuarioVOException(UsuarioVOException.EMAILINVALIDO);
		UsuarioDAO.getInstance().save(vo);
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
