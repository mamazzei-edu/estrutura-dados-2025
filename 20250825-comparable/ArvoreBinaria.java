/**
 * Implementação de uma Árvore Binária de Busca.
 * Foco em operações recursivas para inserção, busca e remoção.
 * * @author Equipe da Disciplina
 * @version 2025.08.14
 */
public class ArvoreBinaria implements Arvore {


    /**
     * Construtor da árvore. Inicia uma árvore vazia.
     */
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // --- MÉTODO DE INSERÇÃO ---

    /**
     * Método público para inserir um novo valor na árvore.
     * Ele chama o método auxiliar recursivo para encontrar a posição correta. [cite: 7]
     *
     * @param valor O valor inteiro a ser inserido.
     */
    @Override
    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    /**
     * Método auxiliar recursivo para inserir um novo nó.
     * A lógica segue o pseudocódigo "função insere". 
     * Se a subárvore atual é nula, o novo nó é inserido aqui.
     * Caso contrário, a busca continua recursivamente pela subárvore
     * esquerda ou direita. [cite: 1, 7]
     *
     * @param noAtual O nó raiz da subárvore atual.
     * @param valor O valor a ser inserido.
     * @return O nó raiz da subárvore modificada.
     */
    private NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
        // Caso base: se a árvore (ou subárvore) estiver vazia, cria o novo nó.
        if (noAtual == null) {
            return new NodoArvore(valor);
        }

        // Caso recursivo: desce na árvore
        if (valor < noAtual.chave) {
            noAtual.filhoEsquerdo = inserirRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireito = inserirRecursivo(noAtual.filhoDireito, valor);
        }
        
        // Se o valor já existe, não faz nada e retorna o nó como está.
        return noAtual;
    }
    
    // --- MÉTODO DE PESQUISA ---
    
    /**
     * Método público para pesquisar um valor na árvore.
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou null se não for encontrado.
     */
    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    /**
     * Método auxiliar recursivo para buscar um valor. [cite: 7]
     * Compara o valor com o nó atual e decide se continua a busca
     * na subárvore esquerda ou direita. [cite: 1, 7]
     *
     * @param noAtual O nó raiz da subárvore de busca.
     * @param valor O valor a ser procurado.
     * @return O nó encontrado ou null.
     */
    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }

        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerdo, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireito, valor);
        }
    }
    
    // --- MÉTODO DE IMPRESSÃO (CAMINHAMENTO) ---
    
    /**
     * Imprime os elementos da árvore usando o caminhamento pré-fixado. [cite: 7]
     * Raiz -> Esquerda -> Direita. 
     */
    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePreFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }
    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimeEmOrdemRecursivo(NodoArvore no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.chave + " ");
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }
    public void imprimePosFixado() {
        imprimePosFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePosFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            imprimePosFixadoRecursivo(no.filhoEsquerda);
            imprimePosFixadoRecursivo(no.filhoDireita);
            System.out.print(no.chave + " ");
        }
    }