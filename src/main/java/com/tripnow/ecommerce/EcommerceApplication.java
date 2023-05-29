package com.tripnow.ecommerce;
import com.tripnow.ecommerce.models.Cliente;
import com.tripnow.ecommerce.models.Orden;
import com.tripnow.ecommerce.repositories.ClienteRepositorio;
import com.tripnow.ecommerce.repositories.OrdenPaqueteRepositorio;
import com.tripnow.ecommerce.repositories.OrdenRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class EcommerceApplication {

/*	@Autowired
	private PasswordEncoder passwordEncoder;*/
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, OrdenRepositorio ordenRepositorio, OrdenPaqueteRepositorio ordenPaqueteRepositorio) {
		return (args) -> {


			Cliente cliente1 = new Cliente("Melba", "Morel", "X12455888", "Lomas de Zamora 222", "011-41216666", "melba@mindhub.com", "123456", new Date(56/06/06));
			Cliente cliente2 = new Cliente("Lucia", "Lopez", "X33134665", "Los Paraisos 556", "0351-4224455", "lucia@mindhub.com", "555666", new Date(87/11/06) );
			Cliente cliente3 = new Cliente("Ines", "Garcia", "X40111666", "Tintines 22", "0344-4258899", "ines@mindhub.com", "111555", new Date(90/10/10));

			clienteRepositorio.save(cliente1);
			clienteRepositorio.save(cliente2);
			clienteRepositorio.save(cliente3);

			Orden orden1 = new Orden(LocalDateTime.now(), true, 2, 5000, false);
			Orden orden2 = new Orden(LocalDateTime.now(), true, 3, 6000, false);
			Orden orden3 = new Orden(LocalDateTime.now(), true, 4, 7000, false);

			ordenRepositorio.save(orden1);
			ordenRepositorio.save(orden2);
			ordenRepositorio.save(orden3);
		};
	}
}
