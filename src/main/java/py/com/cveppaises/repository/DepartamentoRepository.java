package py.com.cveppaises.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.cveppaises.model.entity.Departamento;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
