package tp.link.ordenes.deCompra.Controller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import tp.link.ordenes.deCompra.Model.Usuario;

public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer>{
	
	Page<Usuario> findAll(Pageable page);
	
}
