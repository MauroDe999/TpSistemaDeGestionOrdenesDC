package tp.link.ordenes.deCompra.Repos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import tp.link.ordenes.deCompra.Model.*;

public interface RepoCupon extends PagingAndSortingRepository<Cupon, Integer>{
	
    Page<Cupon> findAll(Pageable page);
	
    Cupon findByNombre(String nombre);
}
