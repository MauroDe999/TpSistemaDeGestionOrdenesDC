package tp.link.ordenes.deCompra.Repos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import tp.link.ordenes.deCompra.Model.Vendedor;


public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer>{
	
    Page<Vendedor> findAll(Pageable page);
    
    Vendedor findByNombre(String nombreV);
}
