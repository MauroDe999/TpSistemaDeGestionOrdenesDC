package tp.link.ordenes.deCompra.Repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import tp.link.ordenes.deCompra.Model.Promocion;

public interface RepoPromo extends PagingAndSortingRepository<Promocion, Integer> {
	
	Page<Promocion> findAll(Pageable page);
	
	Promocion findByNombre(String nombre);
	
}
