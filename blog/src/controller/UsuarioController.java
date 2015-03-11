package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UsuarioService;

@Controller
@RequestMapping("/usuario/*")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	//@Autowired private UsuarioSession usuarioSession;
	
	
	@RequestMapping("autenticar")
	public String autenticar(@RequestParam String nombreUsuario,
			@RequestParam String clave,
			HttpSession session,
			Model model) {
		
		List<String> errores = new ArrayList<String>();
		Usuario u = null;
		
		try {
			u = usuarioService.autenticar(nombreUsuario, clave);
		} catch (Exception e) {
			e.printStackTrace();
			errores.add("Error autenticando el usuario");
		}

		if (u == null)
			errores.add("Usuario o contraseña inválido");
		else {
//			usuarioSession.setUsuario(u);
			session.setAttribute("usuario", u);
		}
			
		if (errores.size() > 0) {
			model.addAttribute("errores", errores);
			return "/WEB-INF/jsp/usuario/index.jsp";
		} else
			return "redirect:/action/admin/";
	}
	
	@RequestMapping("")
	public String index() {
		return "/WEB-INF/jsp/usuario/index.jsp";
	}
	
	@RequestMapping("sesion/cerrar")
	public String sesionCerrar(HttpSession session) {
		session.invalidate();
		
		return "redirect:/usuario/admin/";
	}
	
}