package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import negocio.Usuario;
import vo.UsuarioVO;
import vo.excecao.UsuarioVOException;

@ManagedBean
@SessionScoped
public class UsuarioControle {
	
	private UsuarioVO vo = new UsuarioVO();
	private Usuario usuario = new Usuario();
	
	public void novo(ActionEvent evt){
		vo = new UsuarioVO();
		}

	public UsuarioVO getVo() {
		return vo;
	}

	public void setVo(UsuarioVO vo) {
		this.vo = vo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void cadastrarUsuario(ActionEvent event){  
		try {
			usuario.save(vo);
			vo = new UsuarioVO();
			FacesContext.getCurrentInstance().addMessage("formCadastro", new FacesMessage("Usuário cadastrado com Sucesso!"));
		} catch (UsuarioVOException e) {
		    FacesContext.getCurrentInstance().addMessage("formCadastro", new FacesMessage(e.getMessage()));
		}
		
	}
	

}
