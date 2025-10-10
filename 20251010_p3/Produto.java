public class Produto implements Comparable<Produto> {
    private int idProduto;
    private String nome;
    private String tipoProduto;
    private Secao secao;
    private double margin;
    private Prateleira prateleira;

    public Produto(int idProduto, String nome, String tipoProduto, Secao secao, double margin, Prateleira prateleira) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.secao = secao;
        this.margin = margin;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", secao=" + secao.getNome() +
                ", margin=" + margin +
                ", prateleira=" + prateleira.getLetra() +
                '}';
    }

    @Override
    public int compareTo(Produto o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
