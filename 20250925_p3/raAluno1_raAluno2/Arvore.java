public interface Arvore<T> {

    public NodoArvore<T> pesquisa (T objeto);
    public void inserir (T objeto);
    public void remover (T objeto);
    public void imprimePreFixado ();
}
