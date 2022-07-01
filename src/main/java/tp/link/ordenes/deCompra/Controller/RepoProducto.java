package tp.link.ordenes.deCompra.Controller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import tp.link.ordenes.deCompra.Model.Producto;

public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer>{
	
	Page<Producto> findAll(Pageable page);
	
}
