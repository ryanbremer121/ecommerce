package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFornecedor;

    @NonNull
    private String nomeFornecedor;

    @NonNull
    private String CNPJFornecedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduto")
    private Produto produto;



}
