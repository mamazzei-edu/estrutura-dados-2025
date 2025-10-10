public class NodoArvore<T> {
    public NodoArvore<T> filhoEsquerda;
    public T objeto;
    public NodoArvore<T> filhoDireita;

    public NodoArvore(T objeto) {
        this.objeto = objeto;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }

    // @Override
    // public String toString() {
    //     return objeto.toString();
    // }
    
}
