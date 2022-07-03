package tp.link.ordenes.deCompra.Repos;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import tp.link.ordenes.deCompra.Model.Cliente;

public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer>{
	
	Page<Cliente> findAll(Pageable page);
	
	Cliente findByMail(String mail);
	
}
