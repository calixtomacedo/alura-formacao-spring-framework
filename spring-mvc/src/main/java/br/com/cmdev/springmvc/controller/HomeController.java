package br.com.cmdev.springmvc.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.cmdev.springmvc.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 10");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61bD+2ZxGyS._AC_SL1500_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Xiaomi-Redmi-Note-Vers%C3%A3o-global/dp/B08YFLGZB4/ref=sr_1_12?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2BJN3JOZJTKGK&dchild=1&keywords=celular+xiaomi&qid=1627423855&sprefix=ce%2Caps%2C295&sr=8-12&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
		pedido.setDescricao("Principais características: Tela Super AMOLED de 6,43 polegadas com resolução FHD+ Display com furo Processador Snapdragon 678 4 GB de RAM 64 GB de armazenamento interno Memória expansível com cartão MicroSD Câmera frontal de 13 MP Quatro câmeras traseiras: Sensor principal de 48 MP (f/1.79) Sensor grande-angular de 8 MP (118º) Sensor macro de 2 MP (f/2.2) Sensor de profundidade de 2 MP (f/2.4) Leitor de digitais na lateral, som estéreo, porta P2, 4G e WiFi de banda dupla Bateria de 5.000 mAh com carregamento rápido de 33W Android 11 rodando sob a interface MIUI 12");
		pedido.setDataDaEntrega(LocalDate.of(2021, 01, 9));
		//pedido.setValorNegociado(new BigDecimal("R$ 1.395,00"));
		
		List<Pedido> pedidos = Arrays.asList(pedido, pedido, pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
}
