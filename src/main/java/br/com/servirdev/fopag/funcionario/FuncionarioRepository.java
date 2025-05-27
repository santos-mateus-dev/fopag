package br.com.servirdev.fopag.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    Page<Funcionario> findAllByAtivoTrue(Pageable paginacao);
}
