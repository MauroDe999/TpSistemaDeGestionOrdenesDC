package tp.link.ordenes.deCompra.Controller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import tp.link.ordenes.deCompra.Model.Promocion;

public interface RepoPromos extends PagingAndSortingRepository<Promocion, Integer>{
	
	Page<Promocion> findAll(Pageable page);
	
	Promocion findByDni(int dni);
	
}
