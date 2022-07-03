package tp.link.ordenes.deCompra;
import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import tp.link.ordenes.deCompra.Model.*;
import tp.link.ordenes.deCompra.Repos.*;

public class InitData implements CommandLineRunner {
	
	@Autowired
	RepoCliente repoCli;
	@Autowired
	RepoProducto repoProd;
	@Autowired
	RepoVendedor repoVen;
	@Autowired
	RepoPromo repoPromo;
	@Autowired
	RepositoryRestConfiguration config;
	
	protected CarritoDeCompra carrito = new CarritoDeCompra(List.of(), 0, null);
	protected Tarjeta tarjeta = new Tarjeta("bbvaGold", 44258893, 200000, true);
	protected Collection<Integer> cupones= List.of();
	protected Collection<Producto> prodCacho = List.of();
	protected Collection<OrdenDeCompra> ordenesCacho = List.of();
	protected PromoMedioDePago promoBbva = new PromoMedioDePago("promoBBVa", "bbvaGold", 10);
	protected PromoMiembro promoMiembro = new PromoMiembro("promoMiembro", 5);
	protected Collection<Promocion> promosCacho = List.of(promoBbva, promoMiembro);
	protected Cliente mauro = new Cliente("maurodemarco999@gmail.com", "123", 42145629,
			carrito, true, tarjeta, cupones);
	protected Vendedor cacho = new Vendedor("cachito@gmail.com", "321", 35688021, prodCacho, promosCacho, 
			ordenesCacho, 0, "loDeCacho");
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Cliente.class,CarritoDeCompra.class, Tarjeta.class);
		if(repoCli.count() == 0) {
			repoCli.save(mauro);
		}
		if(repoPromo.count() == 0) {
			promosCacho.stream().forEach(promo -> {
				repoPromo.save(promo);
			});	
		}
		if(repoVen.count() == 0) {
			repoVen.save(cacho);
		}
	}
}
