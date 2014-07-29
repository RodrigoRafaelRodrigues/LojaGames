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
	
	private Usuario usuario;
	private UsuarioVO vo;
	
	public UsuarioControle() {
		usuario = new Usuario();
		vo = new UsuarioVO();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioVO getVo() {
		return vo;
	}

	public void setVo(UsuarioVO vo) {
		this.vo = vo;
	}

	public void cadastrarUsuario(ActionEvent event) {
		System.out.println("TEsteeeeeeeeeeeeeeeee");
		try {
			usuario.save(vo);
			vo = new UsuarioVO();
			FacesContext.getCurrentInstance().addMessage("frmCadastro",
					new FacesMessage("Usu�rio Cadstrado com sucesso!"));
		} catch (UsuarioVOException e) {
			FacesContext.getCurrentInstance().addMessage("formCadastro",
					new FacesMessage(e.getMessage()));
		}
	}

	public void excluirProduto() {
		usuario.delete(vo);
	}

}
