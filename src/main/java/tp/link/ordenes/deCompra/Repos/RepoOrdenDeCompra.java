package tp.link.ordenes.deCompra.Repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import tp.link.ordenes.deCompra.Model.*;

public interface RepoOrdenDeCompra extends PagingAndSortingRepository<OrdenDeCompra, Integer> {
	
	Page<OrdenDeCompra> findAll(Pageable page);
}
