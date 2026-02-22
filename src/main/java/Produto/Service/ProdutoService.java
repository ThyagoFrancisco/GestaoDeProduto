package Produto.Service;
import Produto.Entity.Produto;
import Produto.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto salvar(Produto produto){
        if(produto.getNome().equalsIgnoreCase("Teste")) {
            throw new RuntimeException("Nome do produto inválido");
        }
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
