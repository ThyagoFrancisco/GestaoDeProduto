package Produto.Controller;

import Produto.Entity.Produto;
import Produto.Repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto){
        return ResponseEntity.ok(produtoRepository.save(produto));
    }
}
