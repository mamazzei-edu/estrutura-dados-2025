public class Main {
    public static void main(String[] args) {
        Secao secao1 = new Secao(1, "Bebidas");
        Prateleira prateleiraR = new Prateleira(1, "R");

        Produto produto1 = new Produto(1, "Coca-Cola", "Bebida", secao1, 0.30, prateleiraR);

        Secao secao2 = new Secao(2, "Biscoitos");
        Prateleira prateleiraC = new Prateleira(2, "C");

        Produto produto2 = new Produto(2, "Água e Sal", "Biscoito", secao2, 0.90, prateleiraC);

        ArvoreBinaria<Produto> arvoreProdutos = new ArvoreBinaria<>();
        arvoreProdutos.inserir(produto1);
        arvoreProdutos.inserir(produto2);

    }
}
